package interview;

import java.util.ArrayList;

public class NonReduciableFraction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 2;
		int count = 0;
		ArrayList<Double> al = new ArrayList();

		for (int x = 1; x <= num; x++) {

			for (int y = 1; y <= num; y++) {

				if (y > x) {
					double result = (double) x / y;

					if (al.contains(result)) {

					} else {
						al.add(result);
						System.out.println(x + "/" + y);

						count++;
					}

				}
			}

		}
		System.out.println(count);
	}

}
//Athenahealth 
