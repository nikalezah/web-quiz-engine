import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        new java.util.Scanner(System.in).tokens().map(String::toLowerCase)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .forEach((word, count) -> System.out.println(word + " " + count));
    }
}