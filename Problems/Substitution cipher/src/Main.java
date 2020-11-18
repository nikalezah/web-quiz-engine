class Main {
    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);
        String k1 = scanner.nextLine();
        String k2 = scanner.nextLine();
        String m1 = scanner.nextLine();
        String m2 = scanner.nextLine();

        m1.chars().forEach(ch -> System.out.print(k2.charAt(k1.indexOf(ch))));
        System.out.println();
        m2.chars().forEach(ch -> System.out.print(k1.charAt(k2.indexOf(ch))));
    }
}