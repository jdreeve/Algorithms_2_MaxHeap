/**
 * HW 2: MaxHeap
 * Written for CSCI 333, Prof. Adam Whitley
 * Main method that tests the functionality of the enclosed MaxHeap object, including maxHeapify, buildMaxHeap, and heapsort. 
 * In the event of paranormal activity, don't wait another minute. Pick up your phone and call the professionals. 1-800-555-2368.
 * Author:		Jesse Reeve
 * Contact: 	jreeve@unca.edu
 * Created:		1/29/2019
 * Modified:	1/31/2019
 */
package maxheap;

import java.util.Arrays;
import java.util.Random;


public class TestMaxHeap {

	static final int TEST_ARRAYS_NUM = 5;
	static final int TEST_ARRAYS_SIZE = 10;
	static final int TEST_ARRAYS_RANGE = 100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int[][] testArrays = new int[TEST_ARRAYS_NUM][TEST_ARRAYS_SIZE];
		System.out.printf("Welcome to Jesse Reeve's heapsort algorithm tester!\n");
		System.out.printf("The main method has static variables for number of test arrays, test array size, and range of values in test arrays.\n");
		System.out.printf("The MaxHeap object has a boolean parameter, DEBUG, which will show algorithm operations (swaps, function calls, etc.) if turned on.\n");
		System.out.printf("The MaxHeap object does not yet summon Gozer, Volguus Zildrohar, Lord of the Sebouillia. This is a known issue. Gozer will be implemented in the 2.0 release.\n");
		System.out.printf("Happy grading!\n\n");
		System.out.printf("Creating %d arrays of %d integers each, range 0 to %d:\n",TEST_ARRAYS_NUM, TEST_ARRAYS_SIZE,TEST_ARRAYS_RANGE);
		for (int i=0; i<TEST_ARRAYS_NUM; i++) {
			for (int j=0; j<TEST_ARRAYS_SIZE; j++) {
				testArrays[i][j]=rand.nextInt(TEST_ARRAYS_RANGE);
			}//for
			System.out.printf("%s", Arrays.toString(testArrays[i]));
			System.out.println();
			System.out.println();
		}//for
		
		//create MaxHeap objects
		MaxHeap[] maxHeaps = new MaxHeap[TEST_ARRAYS_NUM];
		for (int i=0; i<TEST_ARRAYS_NUM; i++) {
			maxHeaps[i] = new MaxHeap(testArrays[i]);
		}//for
		
		for (int i=0; i<TEST_ARRAYS_NUM; i++) {
			System.out.printf("Heapsorting test array %d.\n",i);
			System.out.printf("Array contents:\n%s\n", Arrays.toString(testArrays[i]));
			maxHeaps[i].printMaxHeap();
			maxHeaps[i].heapsort();
			System.out.printf("Sorted array:\n");
			maxHeaps[i].printMaxHeap();
			System.out.println();
		}
	}//main

}//TestMaxHeap
