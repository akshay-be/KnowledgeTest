package hackerrank.java;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class JavaDateTimeTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String month = in.next();
		String day = in.next();
		String year = in.next();

		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(year), Integer.parseInt(month),
				Integer.parseInt(day));

		Date date = cal.getTime();

		String dayOfWeek = String.format("%tA", date).toUpperCase();
		System.out.println(dayOfWeek);
	}
}
