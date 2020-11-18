import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> dictionary = new HashSet<>();
        int d = scanner.nextInt();
        for (int i = 0; i < d; i++) {
            dictionary.add(scanner.next().toLowerCase());
        }
        int l = scanner.nextInt() + 1;
        Set<String> words = new HashSet<>();
        for (int i = 0; i < l; i++) {
            words.addAll(Arrays.asList(scanner.nextLine().toLowerCase().split("\\s+")));
        }
        words.removeAll(dictionary);
        words.forEach(System.out::println);
    }
}