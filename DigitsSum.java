//Author: Aarush Modi
//Date: September 20, 2021
//Purpose: To calculate the sum of the digits of an integer until the sum is an integer between 1 and 9 inclusive
//IMPORTS:
import java.awt.*;
import hsa.Console;

public class DigitsSum
{  // Open Class DigitsSum
    static Console c;
    //Author: Aarush Modi
    //Date: September 20, 2021
    //Purpose: To calculate the sum of digits
    //Input: Given integer(inpt)
    //Output: The sum of the digits between 1-9 inclusive
    static int calcDigitSum(int inpt)
    { // Open Method CalcDigitSum
	int sum = 0;

	while (inpt > 0 || sum > 9)
	{
	    if (inpt == 0) 
	    {
		inpt = sum;
		sum = 0;
	    }
	    sum += inpt % 10;
	    inpt /= 10;
	}
	return sum;
    } // Close Method CalcDigitSum
	    
    // MAIN
    public static void main (String[] args)
    { // Open MAIN
	c = new Console ();
	int inpt = 0;
	boolean reRun = true;
	boolean bound = true;
	while (reRun)
	{
		//TAKE INPUT
		while (bound)
		{
		    c.print("Enter a positive integer value to calculate the digit sum of: "); 
		    inpt = c.readInt();
		    if (inpt > 0 )
		    {
			bound = false;
		    }
		}
		//CALL METHOD AND OUTPUT
		c.println("The digits sum is: ");
		c.println(calcDigitSum(inpt));
		//QUIT PROGRAM CODE
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
    } // Close MAIN
} // Close Class DigitsSum
