import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] b1 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .sorted()
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] b2 = Arrays.stream(scanner.nextLine().split("\\s+"))
                .sorted()
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(
                b1[0] < b2[0] && b1[1] < b2[1] && b1[2] < b2[2] ? "Box 1 < Box 2" :
                b1[0] > b2[0] && b1[1] > b2[1] && b1[2] > b2[2] ? "Box 1 > Box 2" : "Incompatible");
    }
}