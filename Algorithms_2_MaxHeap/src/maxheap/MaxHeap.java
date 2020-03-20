/**
 * HW 2: MaxHeap
 * Written for CSCI 333, Prof. Adam Whitley
 * Implements maxHeapify, buildMaxHeap, and heapsort. Definitely does not summon Zuul, Gatekeeper of Gozer the Destructor.
 * Author:		Jesse Reeve
 * Contact: 	jreeve@unca.edu
 * Created:		1/29/2019
 * Modified:	1/31/2019
 */

package maxheap;

import java.util.Arrays;

public class MaxHeap {
	int[] heap;
	int heapSize;
	final static boolean DEBUG = false;
	/**
	 * 
	 * @param intArray: an integer array to be made into a max heap
	 */
	MaxHeap(int[] intArray){
		heapSize = intArray.length;
		heap = Arrays.copyOf(intArray, heapSize);
		buildMaxHeap();
	}//constructor
	
	/**
	 * swap: exchanges the values in heap[] at indices 1 and 2
	 * @param index1		first index, to be swapped with the second
	 * @param index2		second index, to be swapped with the first
	 */
	private void swap(int index1, int index2) {
		if (DEBUG) System.out.printf("Swapping index %d: %d with index %d: %d\n",index1, heap[index1],index1,heap[index1]);
		int temp = heap[index1];
		heap[index1]=heap[index2];
		heap[index2]=temp;
		if (DEBUG) this.printMaxHeap();
	}//swap
	
	/**
	 * leftChildOf returns the index of the left child of the 'parent' parameter node.
	 * @param parent		index of the designated parent node
	 * @return				index of the left child node (-1 if invalid parent index)
	 */
	private int leftChildOf(int parent) {
		int leftChild = ((parent +1 ) *2) -1;
		if (parent < 0 || leftChild > heapSize -1) return -1;
		return leftChild;
	}//leftChildOf
	
	/**To be implemented
	 * 
	 * @param GateKeeper	Vinz Clortho
	 * @param KeyMaster		Zuul
	 * @return				Gozer
	 */
	Object summonGozer(Object GateKeeper, Object KeyMaster) {
		Object Zuul = GateKeeper;
		Object Dana = Zuul;//deprecated-- there is no Dana, only Zuul
		Object Gozer = null;
		//Gozer = GateKeeper.summonGozer(KeyMaster);//TODO
		return Gozer;
	}

	/**
	 * rightChildOf returns the index of the right child of the 'parent' parameter node.
	 * @param parent		index of the designated parent node
	 * @return				index of the right child node (-1 if invalid parent index)
	 */
	private int rightChildOf(int parent) {
		int rightChild = (parent +1 ) *2;
		if (parent < 0 || rightChild > heapSize -1) return -1;
		return rightChild;
	}//rightChildOf
	
	/**
	 * Recursively fixes broken heap properties at index parameter i. Assumes subtrees of i are correct max heaps. 
	 * @param i
	 */
	private void maxHeapify(int i){
		if (DEBUG) System.out.printf("Running maxHeapify on index %d.\n",i);
		int left = leftChildOf(i);
		int right = rightChildOf(i);
		int largest = i;
		if (left >= 0 && heap[left] > heap[i]) {
			largest = left;
		}//if
		if (right >= 0 && heap[right] > heap[largest]) {
			largest = right;
		}//if
		if (largest != i) {
			swap(i,largest);
			maxHeapify(largest);
		}//if
	}//maxHeapify
	
	/**
	 * Turns an arbitrary int array into a max heap.
	 */
	private void buildMaxHeap() {
		if (DEBUG) System.out.println("Running buildMaxHeap.");
		for (int i = (heapSize-1)/2; i >= 0; i--) {
			maxHeapify(i);
		}
	}//buildMaxHeap
	
	/**
	 * Displays heap size and contents.
	 */
	public void printMaxHeap() {
		System.out.printf("Heap size: %d\nHeap contents:\n%s\n", heapSize, (Arrays.toString(Arrays.copyOfRange(heap,0,heapSize))));
	}//printMaxHeap
	
	/**
	 * Uses a max heap to generate a sorted list.
	 */
	public void heapsort() {
		if (DEBUG) System.out.println("Running heapsort.");
		int temp = heapSize;
		for (int i = heapSize -1; i > 0; i--) {//for each element in heap
			swap(0,i);
			heapSize--;
			maxHeapify(0);
		}//for
		heapSize = temp;
	}//heapsort
	
}//MaxHeap
