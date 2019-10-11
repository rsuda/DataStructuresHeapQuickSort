import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Tests 
{
	int[] array = {21,57,35,44,51,14,6,28,39,15};
	HeapSort test = new HeapSort();

	@Test
	void test() 
	{
		test.heapsorts(array, 20, 51);
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}

}
