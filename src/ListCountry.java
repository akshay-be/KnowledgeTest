import java.util.Locale;

public class ListCountry {

	public static void main(String[] args) {

		System.out.println("Hi");
		String[] locales = Locale.getISOCountries();

		for (String countryCode : locales) {

			Locale obj = new Locale("", countryCode);
			

			System.out.println("Country Code = " + obj.getCountry()
					+ ", Country Name = " + obj.getDisplayCountry());

		}

		System.out.println("Done");
	}

}
