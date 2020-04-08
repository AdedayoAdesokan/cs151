public class Arrays {
    /**
     * Gets the largest integer in the array.
     * 
     * @param a the array of integers.
     * @return the largest integer in the array.
     */
    public static int getLargest(int[] a) {
        int largest = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > largest) {
                largest = a[i];
            }
        }
        return largest;
    }

    /**
     * Gets the position of the largest integer.
     * 
     * @param a the array of integers.
     * @return the position of the largest integer in the array.
     */
    public static int getLargestPosition(int[] a) {
        int largest = a[0];
        int position = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > largest) {
                largest = a[i];
                position = i;
            }
        }
        return position;
    }

    /**
     * Gets the smallest integer in the array.
     * 
     * @param a the array of integers.
     * @return the smallest integer in the array.
     */
    public static int getSmallest(int[] a) {
        int smallest = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < smallest) {
                smallest = a[i];
            }
        }
        return smallest;
    }

    /**
     * Gets the position of the smallest integer.
     * 
     * @param a the array of integers.
     * @return the position of the smallest integer.
     */
    public static int getSmallestPosition(int[] a) {
        int smallest = a[0];
        int position = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < smallest) {
                smallest = a[i];
                position = i;
            }
        }
        return position;
    }

    /**
     * Swaps the position of the largest and smallest integers.
     * 
     * @param a the array of integers.
     * @return the modified array a with the position of the largest and smallest
     *         integers swapped.
     */
    public static int[] swapLargestAndSmallest(int[] a) {
        int largest = getLargest(a);
        int smallest = getSmallest(a);
        int largestPosition = getLargestPosition(a);
        int smallestPosition = getSmallestPosition(a);
        a[largestPosition] = smallest;
        a[smallestPosition] = largest;
        return a;
    }

    /**
     * Swaps the position of the largest and smallest integers.
     * 
     * @param a the array of integers.
     * @return the modified array a with the position of the largest and smallest
     *         integers swapped.
     */
    public static int[] swapLargestAndSmallest2(int[] a) {
        int largest = a[0];
        int largestPosition = 0;
        int smallest = a[0];
        int smallestPosition = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > largest) {
                largest = a[i];
                largestPosition = i;
            }
            if (a[i] < smallest) {
                smallest = a[i];
                smallestPosition = i;
            }
        }
        a[largestPosition] = smallest;
        a[smallestPosition] = largest;
        return a;
    }
}