import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);
        var l1 = scanner.nextLine().chars().boxed().collect(Collectors.toList());
        var l2 = scanner.nextLine().chars().boxed().collect(Collectors.toList());
        System.out.println(l1.containsAll(l2) && l1.size() > l2.size() ? "You get money" : "You are busted");
    }
}