public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;
        boolean add = true; // Track whether the next term should be added or subtracted

        // Approximate pi using: pi ≈ 4 * (1 - 1/3 + 1/5 - 1/7 + ...)
        // The denominators are odd numbers, so advancing by 2 while i < 2*n gives exactly n terms
        // Using double for i ensures floating-point division in 1 / i
        for (double i = 1; i < 2*Integer.parseInt(args[0]); i = i + 2) {
            if (add) {
                approxPi += (1 / i);
                add = false;
            }
            else {
                approxPi -= (1 / i);
                add = true;
            }
        }

        approxPi *= 4; // The sum approximates pi / 4, so multiply it by 4.
        System.out.println(approxPi + " " + actualPi);
    }
}