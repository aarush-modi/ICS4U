//Author: Aarush Modi
//Date: September 21, 2021
//Purpose: To print out diamond shapes using the asterisk character
//IMPORTS:
import java.awt.*;
import hsa.Console;

// Diamond Class
public class Diamond
{
    static Console c;
    // MAIN
    public static void main (String[] args)
    {
	c = new Console ();
	int inpt = 0;
	boolean reRun = true;
	boolean bound = true;
	while (reRun)
	{   reRun = false;
	    //TAKE INPUT
	    while (bound)
	    {
		c.println("Enter an odd positive integer value to create a diamond");
		c.println("Value must be between 1-25 inclusive:  ");
		inpt = c.readInt();
		if (inpt > 0 && inpt < 26 && inpt % 2 == 1)
		{
		    bound = false;
		}
	    } // Boundary closing
	    c.println("## PRINTING THE PATTERN ##");
	    //HAT
	    c.print(" ");
	    for(int i = 0; i < inpt; i++)
	    {
		c.print("*");
	    }
	    c.println(" ");
	    for(int i = 0; i < inpt; i++) 
	    {
		for(int j = 0; j < inpt-i*2 + 2; j++) 
		{
		    c.print("*");
		}
		c.println();
		for(int space = -1; space < i; space++) 
		{
		    c.print(" ");
		}
		
	    }
	    c.println();
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
	} // ReRun Closing
    } // MAIN Closing
} // Diamond CLASS Closing
