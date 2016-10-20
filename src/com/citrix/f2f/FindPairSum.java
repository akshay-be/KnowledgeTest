package com.citrix.f2f;

import java.util.Arrays;

/**
 * write a program to find the possible pair of numbers wch sum is K.
 * Time complexity should not Square of N.
 * 
 * Approach : 1. Sort the elements first using Merge sort. Time is n*logn
 * 			 2. Using 2 pointer loop one time is n
 * 			 3. total Time Complexity n+(nLogn)
 * 
 * @author AkshayB1
 *
 */
public class FindPairSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] inPutArray = { 10, 2, 13, 9, 8, 5, 4, 3, 2, 1, 6, 7 };

		System.out.println(Arrays.toString(inPutArray));

		mergeSort(inPutArray);

		System.out.println(Arrays.toString(inPutArray));

		int low = 0;
		int high = inPutArray.length - 1;
		int k = 9;
		while (low <= high) {
			int sum = inPutArray[low] + inPutArray[high];
			//System.out.println(low+" "+high+" , "+sum);
			if (sum == k) {
				System.out.println("Pair : " + inPutArray[low] + ", "+ inPutArray[high]);
				low++;
				high--;
			}
			if (sum < k) {
				low++;
			}
			if (sum > k) {
				high--;
			}
		}

	}

	public static void mergeSort(int[] inPutArray) {
		int[] outPutArray = new int[inPutArray.length];
		mergeSort(inPutArray, outPutArray, 0, inPutArray.length - 1);
	}

	public static void mergeSort(int[] inPutArray, int[] outPutArray, int low,
			int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(inPutArray, outPutArray, low, mid);
			mergeSort(inPutArray, outPutArray, mid + 1, high);
			merge(inPutArray, outPutArray, low, mid + 1, high);
		}
	}

	private static void merge(int[] inPutArray, int[] outPutArray, int low,
			int mid, int high) {

		int leftEnd = mid - 1;
		int k = low;
		int num = high - low + 1;
		while (low <= leftEnd && mid <= high) {
			// System.out.println(inPutArray[low]+" "+inPutArray[mid]);
			if (inPutArray[low] < inPutArray[mid]) {
				outPutArray[k++] = inPutArray[low++];
			} else {
				outPutArray[k++] = inPutArray[mid++];
			}
		}

		while (low <= leftEnd) {
			outPutArray[k++] = inPutArray[low++];
		}

		while (mid <= high) {
			// System.out.println("Mid : "+mid);
			outPutArray[k++] = inPutArray[mid++];
		}

		for (int i = 0; i < num; i++, high--)
			inPutArray[high] = outPutArray[high];
	}

}
