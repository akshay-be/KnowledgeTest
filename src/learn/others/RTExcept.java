package learn.others;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileLockInterruptionException;


public class RTExcept {
	public static void throwit () 
    {
        System.out.print("throwit ");
        //throw new RuntimeException();
        //throw new FileNotFoundException();
    }
    public static void main(String [] args) 
    {
        try 
        {
            System.out.print("hello ");
            throwit();
        }
        catch (Exception re ) 
        {
            System.out.print("caught ");
        }
        finally 
        {
            System.out.print("finally ");
        }
        System.out.println("after ");
    }
}
