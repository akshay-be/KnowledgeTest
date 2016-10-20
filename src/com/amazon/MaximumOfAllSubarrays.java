package com.amazon;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaximumOfAllSubarrays {

	public static void main(String[] args) {
		int array[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		//Out put : 3 3 4 5 5 5 6
		//System.out.println("Input : "+array);
		//maximumOfAllSubarrays(array,3);
		System.out.println("Input : "+Arrays.toString(array));
		System.out.print("Output : ");
		maximumOfAllSubArrayUsingQueue(array,3);
		
		
		int array1[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		System.out.println("Input : "+Arrays.toString(array1));
		System.out.print("Output : ");
		//maximumOfAllSubarrays(array1,4);
		maximumOfAllSubArrayUsingQueue(array1,4);
		
	}
	
	
	public static void maximumOfAllSubarrays(int[] array,int subArrSize){
		
		for(int i=0;i<=array.length-subArrSize;i++){
			int max= array[i];
			for(int j=1;j<subArrSize;j++){
				if(array[i+j]>max){
					max = array[i+j];
				}
			}
			System.out.print(" "+max);
		}
		System.out.println();
	}

	
	public static void maximumOfAllSubArrayUsingQueue(int[] a, int k) {

		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		int i = 0;
		for (i = 0; i < k; i++)
		{
			while (!queue.isEmpty() && a[i] >= a[queue.size() - 1]) {
				int d = queue.pollLast();
				//System.out.println(" d : " + d);
			}
			// Remove from rear
			// Add new element at rear of queue
			queue.add(i);
		}

		// Process rest of the elements, i.e., from a[k] to a[n-1]

		for (; i < a.length; ++i) {
			System.out.print(a[queue.peek()] + " ");
			while (!queue.isEmpty() && queue.peek() <= i - k)
				queue.pop();

			while (!queue.isEmpty() && a[i] >= a[queue.peekLast()])
				queue.pollLast();
			// Add current element at the rear of Q
			queue.add(i);
		}
		// Print the maximum element of last window
		System.out.print(a[queue.peek()] + " ");
	
		System.out.println();
	}
}
