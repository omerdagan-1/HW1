public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;
        boolean add = true;
        for (double i = 1; i < (Integer.parseInt(args[0])*2); i = i + 2) {
            if (add) {
                approxPi += (1 / i);
                add = false;
            }
            else {
                approxPi -= (1 / i);
                add = true;
            }
        }
        approxPi *= 4;
        System.out.println(approxPi + " " + actualPi);
    }
}