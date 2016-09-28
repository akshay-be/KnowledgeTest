package geeksforgeeks.bit;

public class BinaryConsecutive {

	public static void main(String[] args) {
		System.out.println(countStrings(0));

	}

	
	public static int countStrings(int n)
	{
	    int a[] = new int[n];
	    int b[] = new int[n];
	    a[0] = b[0] = 1;
	    for (int i = 1; i < n; i++)
	    {
	        a[i] = a[i-1] + b[i-1];
	        b[i] = a[i-1];
	    }
	    
	    //System.out.println(a[n-1]);
	   // System.out.println(b[n-1]);
	    return a[n-1] + b[n-1];
	}
}
