import java.io.BufferedReader;
import java.io.InputStreamReader;

class MaxXoRTest {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
        */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String element = br.readLine();
            System.out.println("Element : "+element);
        }

        System.out.println("Hello World!");
    }
}