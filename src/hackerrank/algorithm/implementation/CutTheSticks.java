package hackerrank.algorithm.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CutTheSticks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			al.add(a);
		}
		
		Collections.sort(al);
		// remove elements after reducing to zero
		for (int i = 0; i < al.size(); i++) {
			if (al.get(0) == 0) {
				al.remove(0);
				i = -1;
				continue;
			}
			System.out.println(al.size());
			int min = al.get(0);
			for (int j = 0; j < al.size(); j++) {
				al.set(j, al.get(j) - min);
			}
		}

	}

}
