public class Tester 
{
	public static void main(String[] args)
	   {
	      //int[] a = new int[] { 1, 4, 1, 9, 2, 6 };
	      //int largest = Arrays.getLargest(a);
	      //System.out.println(largest);
	      //int smallest = Arrays.getSmallest(a);
	      //System.out.println(smallest);
	      //int position1 = Arrays.getLargestPosition(a);
	      //System.out.println(position1);
	      //int position2 = Arrays.getSmallestPosition(a);
	      //System.out.println(position2);	 
		
		int[] a = new int[] { 5, 4, 1, 9, 2, 6 };
	      Arrays.swapLargestAndSmallest(a);
	      System.out.println(java.util.Arrays.toString(a));
	      System.out.println("Expected: [5, 4, 9, 1, 2, 6]");
	      a = new int[] {1, 4, 1, 9, 2, 6};
	      Arrays.swapLargestAndSmallest(a);
	      System.out.println(java.util.Arrays.toString(a));
	      System.out.println("Expected: [9, 4, 1, 1, 2, 6]");
	      a = new int[] {1, 4, 2, 9, 9, 6};
	      Arrays.swapLargestAndSmallest(a);
	      System.out.println(java.util.Arrays.toString(a));
	      System.out.println("Expected: [9, 4, 2, 1, 9, 6]");
	      a = new int[] {1};
	      Arrays.swapLargestAndSmallest(a);
	      System.out.println(java.util.Arrays.toString(a));
	      System.out.println("Expected: [1]");      
	   }
}
