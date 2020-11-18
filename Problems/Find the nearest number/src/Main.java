import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = scanner.nextInt();

        int minDelta = Arrays.stream(numbers)
                .map(i -> Math.abs(n - i))
                .min()
                .orElse(0);
        Arrays.stream(numbers)
                .filter(i -> Math.abs(n - i) == minDelta)
                .sorted()
                .forEach(i -> System.out.print(i + " "));
    }
}