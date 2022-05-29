//Author: Aarush Modi
//Date: September 22, 2021
//Purpose: To find all consecutive seriese that have a sum of a given number
//IMPORTS:
import java.awt.*;
import hsa.Console;
import java.io.*;
public class Consecutive
{//Class Consecutive Open
    static Console c;
    static void findConsecutive(int inpt)
    {
	// Note that we don't
	// ever have to sum
	// numbers > ceil(inpt/2)
	int start = 1;
	int count = 0;
	int end = (inpt + 1) / 2;
	 // Repeat the loop
	// from bottom to half
	while (start < end)
	{
	    // Check if there exist
	    // any sequence from
	    // bottom to half which
	    // adds up to inpt
	    int sum = 0;
	    for (int i = start; i <= end; i++)
	    {
		sum = sum + i;
		// Found consecutive integers:
		if (sum == inpt)
		{    
		    count++;
		    c.print(start + "-" + i + "; ");
		}
		// The sum is greater than input so the series will not work
	    }
	    sum = 0;
	    start++;

	}
	c.print("{" + count + "}");
    }//Close Function
    public static void main (String[] args)
    {// Open MAIN
	c = new Console ();
	
	int inpt1 = 0;
	int inpt2 = 0;
	boolean reRun = true;
	boolean bound = true;
	while (reRun)
	{
		//TAKE INPUT
		while (bound)
		{
		    c.print("Enter a positive integer value to find all consecutive series sum of: "); 
		    inpt1 = c.readInt();
		    if (inpt1 > 0 )
		    {
			bound = false;
		    }
		    c.print("Enter another positive integer value to find all consecutive series sum of: "); 
		    inpt2 = c.readInt();
		    if (inpt2 > 0 )
		    {
			bound = false;
		    }
		    if (inpt1 > inpt2)
		    {
			int fill = 0;
			fill = inpt1;
			inpt1 = inpt2;
			inpt2 = fill;
		    }
		}
		c.println("Your range is between " + inpt1 + " and " + inpt2);
		//CALL METHOD AND OUTPUT
		for (int i = inpt1; i <= inpt2; i++)
		{
		    c.println();
		    c.print("All consecutive series for " + i + ": ");
		    findConsecutive(i);

		}
		//QUIT PROGRAM CODE
		c.println();
		c.println("If you would like to quit the program, enter the word QUIT");
		c.println("otherwise enter anything:");                
		String exit = c.readString();
		bound = true;
		if (exit.equals("quit") || exit.equals("QUIT"))
		{
		    reRun = false;
		}
		else
		{
		    reRun = true;
		}
	    }
    } // MAIN Closing
} // Consecutive Class Closing
