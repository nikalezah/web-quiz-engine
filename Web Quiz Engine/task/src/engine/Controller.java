package engine;

import engine.models.Completion;
import engine.models.Quiz;
import engine.models.User;
import engine.repositories.CompletionRepository;
import engine.repositories.QuizRepository;
import engine.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired private QuizRepository quizRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private CompletionRepository completionRepository;

    @PostMapping("register")
    public void registerUser(@Valid @RequestBody User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    @PostMapping("quizzes")
    public Quiz createQuiz(@Valid @RequestBody Quiz quiz,
                           @AuthenticationPrincipal User user) {
        quiz.setUser(user);
        return quizRepository.save(quiz);
    }

    @GetMapping("quizzes/{id}")
    public Quiz getQuiz(@PathVariable int id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("quizzes")
    public Page<Quiz> getQuizzes(@RequestParam int page) {
        return quizRepository.findAll(PageRequest.of(page, 10, Sort.unsorted()));
    }

    @GetMapping("quizzes/completed")
    public Page<Completion> getCompletions(@RequestParam int page,
                                           @AuthenticationPrincipal User user) {
        return completionRepository
                .findByUser(user, PageRequest.of(page, 10, Sort.by("completedAt").descending()));
    }

    @PostMapping("quizzes/{id}/solve")
    public String solveQuiz(@PathVariable int id,
                            @RequestBody Map<String, int[]> answer,
                            @AuthenticationPrincipal User user) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        int[] quizAnswer = quiz.getAnswer();
        if (quizAnswer == null) {
            quizAnswer = new int[]{};
        }
        if (Arrays.equals(answer.get("answer"), quizAnswer)) {
            completionRepository.save(new Completion(user, quiz, new Date()));
            return "{\"success\":true,\"feedback\":\"Congratulations, you're right!\"}";
        } else {
            return "{\"success\":false,\"feedback\":\"Wrong answer! Please, try again.\"}";
        }
    }

    @DeleteMapping("quizzes/{id}")
    public ResponseEntity<?> deleteQuiz(@PathVariable int id,
                                        @AuthenticationPrincipal User user) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (quiz.getUser().getId() == user.getId()) {
            quizRepository.delete(quiz);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }
}
