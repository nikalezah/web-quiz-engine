class Main {
    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        int lines = scanner.nextInt();

        var map = new java.util.TreeMap<Integer, String>();
        while (lines-- > 0) {
            map.put(scanner.nextInt(), scanner.next());
        }
        map.subMap(from, true, to, true).forEach((k, v) -> System.out.println(k + " " + v));
    }
}