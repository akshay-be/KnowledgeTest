import java.util.Scanner;


public class UniqueCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
        System.out.print("Enter a string:");
        String str = inp.nextLine();               // input from user
        String res="";
        for (int i=0;i<str.length();i++){
            int count=0;
            for(int j=0;j<res.length();j++){
                if(str.charAt(i)==res.charAt(j)){
                    count++;
                }
            }
            if(count==0){
                res = res+str.charAt(i);
            }
        }
        System.out.println("Output string with only unique characters:"+res);


	}

}



