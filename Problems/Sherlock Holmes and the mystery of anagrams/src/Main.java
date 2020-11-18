class Main {
    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);
        System.out.println(
                java.util.Arrays.equals(
                        scanner.nextLine().toLowerCase().chars().sorted().toArray(),
                        scanner.nextLine().toLowerCase().chars().sorted().toArray()
                ) ? "yes" : "no");
    }
}