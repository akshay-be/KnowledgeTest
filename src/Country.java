
import java.text.Collator;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.Comparator;
    import java.util.List;
    import java.util.Locale;

    public class Country  {
    	public static void main(String[] args) {
    		Country c1 = new Country();
    		c1.getCountries();
		}

    public void getCountries(){
    List<Country1> countries = new ArrayList<Country1>();

    Locale[] locales = Locale.getAvailableLocales();
    for (Locale locale : locales) {
      String iso = locale.getISO3Country();
      String code = locale.getCountry();
      String name = locale.getDisplayCountry();

      if (!"".equals(iso) && !"".equals(code) && !"".equals(name)) {
        countries.add(new Country1(iso, code, name));
      }
    }

    Collections.sort(countries, new CountryComparator());
    for (Country1 country : countries) {
      System.out.println(country);
    }
  }
}

class CountryComparator implements Comparator<Country1> {
  private Comparator comparator;

  CountryComparator() {
    comparator = Collator.getInstance();
  }

  public int compare(Country1 o1, Country1 o2) {
    return comparator.compare(o1.name, o2.name);
  }
}

class Country1 {
  private String iso;

  private String code;

  public String name;

  Country1(String iso, String code, String name) {
    this.iso = iso;
    this.code = code;
    this.name = name;
  }

  public String toString() {
    return iso + " - " + code + " - " + name.toUpperCase();
  }
}