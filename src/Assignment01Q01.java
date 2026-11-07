public class Assignment01Q01 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if ((int) args[i].charAt(0) % 5 == 0) {
                System.out.println(args[i].charAt(0));
            }
        }
    }
}
