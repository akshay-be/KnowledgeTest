/**

 */
import java.io.*;
import java.util.*;

class ListFilesinDir 
{
	ListFilesinDir(String strFilePath) 
	{
		File fileFolder = new File(strFilePath);
		if (fileFolder.exists())
			listFiles(fileFolder);
		else 
		{
			System.out.println("File not found");
		}
	}

	void listFiles(File fileFolder) 
	{
		if (fileFolder.isDirectory()) 
		{
			File[] files = fileFolder.listFiles();
			for (File file : files) 
			{
				if (file.isDirectory()) 
				{
					System.out.println(file.getName() + " is a directory in "
							+ file.getParent());
					listFiles(file);
				} else 
				{
					System.out.println(file.getName() + " is a file in "
							+ file.getParent());
				}
			}
		}
	}

	public static void main(String args[]) {
		if (args.length != 0) {
			ListFilesinDir obj = new ListFilesinDir(args[0]);
		} else
			System.out.println("Please enter file path");
	}
}