import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);
        var m1 = scanner.nextLine().toLowerCase().chars().boxed()
                .collect(Collectors.toMap(i -> i, i -> 1, Integer::sum));
        var m2 = scanner.nextLine().toLowerCase().chars().boxed()
                .collect(Collectors.toMap(i -> i, i -> 1, Integer::sum));
        var keys = new java.util.HashSet<>(m1.keySet());
        keys.addAll(m2.keySet());
        int count = 0;

        for (Integer k : keys) {
            count += Math.abs(m1.getOrDefault(k, 0) - m2.getOrDefault(k, 0));
        }
        System.out.println(count);
    }
}