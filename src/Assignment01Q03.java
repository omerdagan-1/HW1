public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The first " + x + " Fibonacci numbers are:");
        int numOdd = 0;
        // Use long to support more Fibonacci terms, since no upper bound for x is specified
        // Values still overflow beyond the 92nd term
        long prev = 1;
        long curr = 1;
        long next = 0;
        for (int i = 0; i < x; i++) {
            System.out.print(prev);
            if (i < x - 1) {
                System.out.print(" ");
            }
            if (prev % 2 == 1) {
                numOdd++;
            }
            next = prev + curr;
            prev = curr;
            curr = next; 
        }
        System.out.println();
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
