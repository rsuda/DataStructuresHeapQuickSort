import java.util.Scanner;

/**
 * Implements the heapsort on an array.
 * @author robin
 *
 */
public class HeapSort 
{ 
	/**
	 * Sorts the array using heap sort.
	 * @param arr the array to sort.
	 * @return new array that is sorted.
	 */
    public int[] sort(int arr[]) 
    { 
        int n = arr.length; 
  
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
  
        // One by one extract an element from heap 
        for (int i = n - 1; i >= 0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        } 
        return arr;
    } 
  
    /**
     *  To heapify a subtree rooted with node i which is 
     *  an index in arr[]. n is size of heap 
     * @param arr the array to sort.
     * @param n
     * @param i
     */
    void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = (2 * i) + 1; // left = 2*i + 1 
        int r = (2 * i) + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    } 
  
    /**
     * Print the heap array.
     * @param arr the array.
     */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
    
    /**
     * Changes all numbers outside the range to -1.
     * @param a the array to change.
     * @param low lower bound of the range.
     * @param high higher bound of the range.
     * @return the same array but with -1 replacing numbers outside the range.
     */
    public static int[] changeOldArray(int[] a, int low, int high)
    {
    	for (int i = 0; i < a.length; i++)
    	{
    		if(a[i] > low && a[i] < high)
    		{
    			a[i] = -1;
    		}
    	}
    	return a;
    }
    
    /**
     * Creates an array from another array of all the numbers outside the range.
     * @param a array.
     * @param low lower bound of the range.
     * @param high higher bound of the range.
     * @return an array with all elements outside the range.
     */
    public static int[] createNewArray(int[] a, int low, int high)
    {
    	int count = 0;
    	for (int i = 0; i < a.length; i++)
    	{
    		if(a[i] > low && a[i] < high)
    		{
    			count++;
    		}
    	}
    	int[] newArray = new int[count];
    	int newArrayCount = 0;
    	for (int i = 0; i < a.length; i++)
    	{
    		if(a[i] > low && a[i] < high)
    		{
    			newArray[newArrayCount] = a[i];
    			newArrayCount++;
    		}
    	}
    	return newArray;
    }
    
    /**
     * Merges the array with -1 as placeholders for numbers outside the range, and
     * the array with the sort elements that were inside the range.
     * @param a array with -1 as placeholders.
     * @param b array that is heapsorted.
     * @return the new merged array.
     */
    public static int[] mergeNewAndOld(int[] a, int[] b)
    {
       	int bCount = 0;
    	for (int i = 0; i < a.length; i++)
    	{
    		if (a[i] == -1)
    		{
    			a[i] = b[bCount];
    			bCount++;
    		}
    	}
    	return a;
    }
  
    /**
     * Method to take input from the user.
     * @param args
     */
    public static void main(String args[]) 
    { 
    	Scanner in = new Scanner(System.in);
    	int[] array = new int[30];
    	int low = 0;
    	int high = 100;
		int counter = 0;
		System.out.println("Input 30 or less integers to build the heap. (Seperate by comma)");
		System.out.print("\nInput: ");
		String build = in.next();
		System.out.print("Choose lower bound: ");
		low = in.nextInt();
		System.out.print("Choose upper bound: ");
		high = in.nextInt();
		Scanner record = new Scanner(build);
        record.useDelimiter(",");
        while (record.hasNextInt()) 
        {
        	array[counter] = record.nextInt();
        	counter++;
        }
        int[] heapSort = new int[counter];
        for (int i = 0; i < counter; i++)
        {
        	heapSort[i] = array[i];
        }
        record.close();
        HeapSort test = new HeapSort();
        printArray(heapSort);
        int[] heapSortArray = test.createNewArray(heapSort, low, high);
        heapSort = test.changeOldArray(heapSort, low, high);
        test.sort(heapSortArray);
        int[] finalheapArray = test.mergeNewAndOld(heapSort, heapSortArray);
		System.out.print("\n");
		printArray(finalheapArray);
    	/**
        int arr[] = {21, 57, 35, 44, 51, 14, 6, 28, 39, 15}; 
        int n = arr.length; 
  
        HeapSort test = new HeapSort();
        
        System.out.print("Test Unsorted: ");
        printArray(arr);
        int newArr[] = test.createNewArray(arr, 20, 51);
        arr = test.changeOldArray(arr, 20, 51);
        
        test.sort(newArr);
  
        System.out.print("Test Sorted  : ");
        int[] finalArr = test.mergeNewAndOld(arr, newArr);
        printArray(finalArr);
        
        System.out.println("");
        //
        //
        int arrA[] = {42,57,98,65,32,99,23,56,95,17,22,24,67,78,9}; 
        int aSize = arr.length; 
  
        HeapSort testA = new HeapSort();
  
        System.out.print("1A Unsorted: ");
        printArray(arrA);
        int newArrA[] = testA.createNewArray(arrA, 23, 100);
        arrA = testA.changeOldArray(arrA, 23, 100);
        
        testA.sort(newArrA);
  
        System.out.print("1A Sorted  : ");
        int[] finalArrA = testA.mergeNewAndOld(arrA, newArrA);
        printArray(finalArrA);
        
        //
        //
        int arrB[] = {42,57,98,65,32,99,23,56,95,17,22,24,67,78,9}; 
        int BSize = arr.length; 
  
        HeapSort testB = new HeapSort();
  
        System.out.print("1B Unsorted: ");
        printArray(arrB);
        int newArrB[] = testB.createNewArray(arrB, 44, 90);
        arrB = testB.changeOldArray(arrB, 44, 90);
        
        testB.sort(newArrB);
  
        System.out.print("1B Sorted  : ");
        int[] finalArrB = testB.mergeNewAndOld(arrB, newArrB);
        printArray(finalArrB);
        
        //
        //
        int arrC[] = {42,57,98,65,32,99,23,56,95,17,22,24,67,78,9}; 
        int CSize = arr.length; 
  
        HeapSort testC = new HeapSort();
  
        System.out.print("1C Unsorted: ");
        printArray(arrC);
        int newArrC[] = testC.createNewArray(arrB, 0, 100);
        arrC = testC.changeOldArray(arrB, 0, 100);
        
        testC.sort(newArrC);
  
        System.out.print("1C Sorted  : ");
        int[] finalArrC = testC.mergeNewAndOld(arrC, newArrC);
        printArray(finalArrC);
        
        System.out.println("");
        //
        //
        int arr2A[] = {27,62,54,76,87,59,24,77,89,5,23,61,16,14}; 
        int a2Size = arr.length; 
  
        HeapSort testA2 = new HeapSort();
  
        System.out.print("2A Unsorted: ");
        printArray(arr2A);
        int newArr2A[] = testA2.createNewArray(arr2A, 5, 76);
        arr2A = testA2.changeOldArray(arr2A, 5, 76);
        
        testA.sort(newArr2A);
  
        System.out.print("2A Sorted  : ");
        int[] finalArr2A = testA2.mergeNewAndOld(arr2A, newArr2A);
        printArray(finalArr2A);
        
        //
        //
        int arr2B[] = {27,62,54,76,87,59,24,77,89,5,23,61,16,14}; 
        int B2Size = arr.length; 
  
        HeapSort test2B = new HeapSort();  
  
        System.out.print("2B Unsorted: ");
        printArray(arr2B);
        int newArr2B[] = test2B.createNewArray(arr2B, 34, 88);
        arr2B = test2B.changeOldArray(arr2B, 34, 88);
        
        test2B.sort(newArr2B);
  
        System.out.print("2B Sorted  : ");
        int[] finalArr2B = test2B.mergeNewAndOld(arr2B, newArr2B);
        printArray(finalArr2B);
        
        //
        //
        int arr2C[] = {27,62,54,76,87,59,24,77,89,5,23,61,16,14}; 
        int C2Size = arr.length; 
  
        HeapSort test2C = new HeapSort();
  
        System.out.print("2C Unsorted: ");
        printArray(arr2C);
        int newArr2C[] = test2C.createNewArray(arr2B, 0, 100);
        arr2C = test2C.changeOldArray(arr2B, 0, 100);
        
        test2C.sort(newArr2C);
  
        System.out.print("2C Sorted  : ");
        int[] finalArr2C = test2C.mergeNewAndOld(arr2C, newArr2C);
        printArray(finalArr2C);
        */
    } 
}