import java.util.Scanner;

public class QuickSort 
{
	/**
	 * Return true if x is less than y, false vice versa.
	 * @param x parameter to compare to y.
	 * @param y parameter to compare to x.
	 * @return true if less than, false if more than.
	 */
	private static boolean lesser(int x, int y)
	{
		if (x < y)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Swaps to elements in an array.
	 * @param array The array the elements are both located in.
	 * @param x element to swap with y.
	 * @param y element to swap with x.
	 */
	private static void swap(int [] array, int x, int y)
	{
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	
	/**
	 * QuickSort helper method that sets the low to 0 and high to array length.
	 * @param array the array to sort.
	 */
	public static void threeWayQuickSort(int[] array)
	{
		threeWayQuickSort(array, 0, array.length - 1);
	}
	
	/**
	 * Algorithm to sort the array using three way quicksort partitioning.
	 * Basically divides the array into three parts:
	 * Elements greater than pivot.
	 * Elements less than pivot.
	 * Elements equal to pivot.
	 * 
	 * Then cycles through and sorts accordingly.
	 * @param oneArray The array to sort.
	 * @param low rest of the array to the left.
	 * @param high rest of the array to the right.
	 */
	private static void threeWayQuickSort(int[] oneArray, int low, int high)
	{
		if (high <= low)
		{
			return;
		}
		
		int lesser = low; 
		int greater = high;
		int x = oneArray[low];
		int i = low;
		
		while (i <= greater)
		{
			
			if (oneArray[i] < x)
			{
				swap(oneArray, lesser++, i++);
			}
			else if(oneArray[i] > x)
			{
				swap(oneArray, i, greater--);
			}
			else
			{
				i++;
			}
		}
		threeWayQuickSort(oneArray, low, lesser - 1);
		threeWayQuickSort(oneArray, greater + 1, high);
	}
	
	/**
	 * Prints the array.
	 * @param array the array to print.
	 */
	public static void printArray(int [] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.printf("%d ", array[i]);
		}
	}
	
	/**
	 * Method to take input from the user to create quicksorted array.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int[] array = new int[30];
		int counter = 0;
		System.out.println("\n\n\tInput 30 or less integers to build array. (Seperate by space)");
		System.out.print("\nInput: ");
		String build = in.next();
		Scanner record = new Scanner(build);
        record.useDelimiter(",");
        while (record.hasNextInt()) 
        {
        	array[counter] = record.nextInt();
        	counter++;
        }
        int[] quickSortArray = new int[counter];
        for (int i = 0; i < counter; i++)
        {
        	quickSortArray[i] = array[i];
        }
        record.close();
        System.out.print("Original array: ");
        printArray(quickSortArray);
        threeWayQuickSort(quickSortArray);
		System.out.print("\n");
		printArray(quickSortArray);
		
		/**
		int input[] = new int[] {5,5,12,20,7,32,5,11,23,5,7,10,20,11,15,32,33,5};
		System.out.print("The unsorted array1: ");
		printArray(input);
		System.out.println("");
		threeWayQuickSort(input);
		System.out.print("The sorted array1  : ");
		printArray(input);
		
		System.out.println("");
		System.out.println("");
		
		int input2[] = new int[] {12,57,14,57,12,17,17,17,32,17,32,17,34,35,6,18,9,15,4};
		System.out.print("The unsorted array2: ");
		printArray(input);
		System.out.println("");
		threeWayQuickSort(input2);
		System.out.print("The sorted array2  : ");
		printArray(input2);
		*/
	}

}
