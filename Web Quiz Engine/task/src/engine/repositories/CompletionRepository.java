package engine.repositories;

import engine.models.Completion;
import engine.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletionRepository extends JpaRepository<Completion, Integer> {

    Page<Completion> findByUser(User user, Pageable pageable);
}
