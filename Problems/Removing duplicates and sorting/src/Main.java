import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt() + 1;
        Set<String> set = new TreeSet<>();

        for (int i = 0; i < lines; i++) {
            set.add(scanner.nextLine());
        }
        set.forEach(System.out::println);
    }
}