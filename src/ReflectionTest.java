import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectionTest {

	public static void main(String[] args) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
		
		Method lengthMethod =  String.class.getMethod("length") ;
		Object ob = lengthMethod.invoke("abcdefg");
		System.out.println(ob);

		
		Constructor constructor  = TestPrivate.class.getDeclaredConstructor(null);
		constructor.setAccessible(true);
		Object instance = constructor.newInstance(null);
		
		Class.forName("TestPrivate");
		
		Class c = null;
		//c.getClassLoader()
	}
}

class TestPrivate {
	private TestPrivate(){
		System.out.println("Ï am private");
	}
}
