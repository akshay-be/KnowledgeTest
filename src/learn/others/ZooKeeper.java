package learn.others;


class Mammal{
	String name="furry";
	String makeNoise(){
		return "generic noise";
	}
}
class zeebra extends Mammal{
	String name="Stripes";
	String makeNoise(){
		return "bray";
	}
}
public class ZooKeeper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ZooKeeper().go();
		
	}
	void go(){
		Mammal m = new zeebra();
		System.out.println(m.name+""+ m.makeNoise());
	}

}
