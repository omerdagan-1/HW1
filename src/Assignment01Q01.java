public class Assignment01Q01 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args[i].length(); j++) {
                if ((int) args[i].charAt(j) % 5 == 0) {
                    System.out.println(args[i].charAt(j));
                }
            }
        }
    }
}
