import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        // Return unchanged for an empty array, zero shift, or an invalid direction.
        // Handle an empty array before modulo to avoid division by zero
        if (array.length == 0 || move == 0 || (direction != 'R' && direction != 'L')) {
            return array;
        }
        move = move % array.length;
        // Skip allocation and copying when the shift amounts to full rotations
        if (move == 0) {
            return array;
        }
        int[] tempArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
                tempArray[i] = array[i];
            }
        if ((move > 0 && direction == 'R') || (move < 0 && direction == 'L')) {
            move = Math.abs(move);
            // Right shift: read from move positions earlier, wrapping around if needed
            for (int i = 0; i < array.length; i++) {
                if(i - move >= 0) {
                    array[i] = tempArray[i-move];
                }
                else {
                    array[i] = tempArray[i-move+array.length];
                }
            }
        }
        else {
            move = Math.abs(move);
            // Left shift: read from move positions later, wrapping around if needed.
            for (int i = 0; i < array.length; i++) {
                if(i + move < array.length) {
                    array[i] = tempArray[i+move];
                }
                else {
                    array[i] = tempArray[i+move-array.length];
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}