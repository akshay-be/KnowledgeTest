package geeksforgeeks.bit;

public class PrintRepeatingEven {

	public static void main(String[] args) {
		int arr[] = { 9, 12, 23, 10, 12, 12, 15, 23,  14, 12, 15 };
		int n = arr.length;
		printRepeatingEven(arr,n);

	}

	static void printRepeatingEven(int arr[], int n)
	{
	    long  _xor = 0L;
	    long  pos;
	 
	    // do for each element of array
	    for( int i = 0; i < n; ++i)
	    {
	    	 
	        // right pos 1 by value of current element
	        pos = 1 << arr[i];
	 
	        System.out.println("Pos : "+pos);
	        
	        System.out.println("xor Before : "+_xor);
	        // Toggle the bit everytime element gets repeated
	        _xor ^= pos;
	        System.out.println("xor After : "+_xor);
	    }
	 
	   /* // Traverse array again and use _xor to find even
	    // occuring elements
	    for (int i = 0; i < n; ++i)
	    {
	        // right shift 1 by value of current element
	        pos = 1 << arr[i];
	 
	        // Each 0 in _xor represents an even occurrence
	        if (!(pos & _xor))
	        {
	            // print the even occurring numbers
	            cout << arr[i] << " ";
	 
	            // set bit as 1 to avoid printing duplicates
	            _xor ^= pos;
	        }
	    }*/
	}
}
