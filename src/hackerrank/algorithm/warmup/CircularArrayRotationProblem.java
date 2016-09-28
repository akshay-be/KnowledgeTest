package hackerrank.algorithm.warmup;

import java.util.Scanner;

public class CircularArrayRotationProblem {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		String line1 = sc.nextLine();
		// String line1 = "3 2 3";
		String[] arrLine1 = line1.split(" ");
		String line2 = sc.nextLine();
		// String line2 = "1 2 3";

		Integer n = Integer.parseInt(arrLine1[0]);
		Integer k = Integer.parseInt(arrLine1[1]);
		Integer p = Integer.parseInt(arrLine1[2]);

		String[] arrLine2 = line2.split(" ");
		int[] data = new int[n];
		int[] modifiedData = new int[n];
		int j = 0;

		for (String ind : arrLine2) {
			data[j++] = Integer.parseInt(ind);
		}

		int[] qureis = new int[p];
		for (int i = 0; i < p; i++) {
			qureis[i] = sc.nextInt();
		}
		// int[] qureis = {0,1,2};

		System.out.println("K : " + k);
		for (int z = 0; z < n; z++) {
			// System.out.println("z : "+z);
			int index = z + k;
			// System.out.println("ind : "+index);
			if (index >= n) {
				index = index - n;
			}
			// System.out.println("Index : "+index);
			modifiedData[index] = data[z];
		}

		for (int y = 0; y < p; y++) {
			System.out.println(modifiedData[qureis[y]]);
		}

	}
	
	
	void perfectSolution()
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		int Q = in.nextInt();
		int rot = K % N;
		int[] arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = in.nextInt();

		for (int i = 0; i < Q; i++) {
			int idx = in.nextInt();
			if (idx - rot >= 0)
				System.out.println(arr[idx - rot]);
			else
				System.out.println(arr[idx - rot + arr.length]);
		}
		in.close();
	}

}
