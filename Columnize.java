//Author: Aarush Modi
//Date: November 8, 2021
//Purpose: Make a text file into 2 balanced and fully justifyed columns
import java.awt.*;
import hsa.*;
import java.util.*;
import java.io.*;
public class Columnize
{
    static Console c;
    public static void main (String[] args) throws IOException
    { //Open MAIN
	c = new Console ();
	Compile test1 = new Compile ("butter.txt");
	test1.format ();
	c.println("Three text files have been created: ");
	c.println("LeftJustify has created a left justified file");
	c.println("FullyJustify has created a fully justified file");
	c.println("FinalOutput has formated the file into columns");
    } //Close MAIN
} // Columnize class

//Author: Aarush Modi
//Date: November 15, 2021
//Purpose: Encrypt/Decrypt files
//Data Fields: string Input, Array Input, TextInputFile of input
/*Methods: Compile(Constructor)
leftJustify(Left Justify file)
fullyJustify(Fully Justify file)
format(Collumize a file into two partitions)*/

class Compile
{ //Open Compile Class
    public TextInputFile txtInput;
    public String strInput = "";
    String[] arrInput;
    /****************************************/
    //Author: Aarush Modi
    //Date: November 8, 2021
    //Purpose: Constructor
    //Inputs: Text File
    //Outputs: N/A
    //Requires: N/A
    public Compile ()
    { //Open Constructor
	txtInput = new TextInputFile ("butter.txt");
	while (!txtInput.eof ())
	{
	    strInput = strInput + txtInput.readLine ();
	}
	StringTokenizer words = new StringTokenizer (strInput);
	int numberOfTokens = words.countTokens ();
	arrInput = new String [numberOfTokens];
	int i = 0;
	while (words.hasMoreTokens ())
	{
	    arrInput [i] = words.nextToken ();
	    i++;
	}
    } //Close Constructor


    /****************************************/
    //Author: Aarush Modi
    //Date: December 06, 2021
    //Purpose: Constructor
    //Inputs: Text File
    //Outputs: N/A
    //Requires: N/A
    public Compile (String textFile)
    { //Open Constructor
	txtInput = new TextInputFile (textFile);
	while (!txtInput.eof ())
	{
	    strInput = strInput + txtInput.readLine ();
	}
	StringTokenizer words = new StringTokenizer (strInput);
	int numberOfTokens = words.countTokens ();
	arrInput = new String [numberOfTokens];
	int i = 0;
	while (words.hasMoreTokens ())
	{
	    arrInput [i] = words.nextToken ();
	    i++;
	}
    } //Close Constructor


    /****************************************/
    //Author: Aarush Modi
    //Date: November 8, 2021
    //Purpose: Left Justify file
    //Inputs: N/A
    //Outputs: N/A
    //Requires: N/A
    public void leftJustify ()
    { //Open leftJustify
	TextOutputFile txtOutput = new TextOutputFile ("leftJustify.txt");
	String placeHolder = "";
	int counter = arrInput.length;
	for (int i = 0 ; i < counter ; i++)
	{
	    if (placeHolder.equals (""))
	    {
		placeHolder = arrInput [i];
	    }
	    else if (placeHolder.length () + arrInput [i].length () + 1 <= 35)
	    {
		placeHolder = placeHolder + " " + arrInput [i];
	    }
	    else
	    {
		txtOutput.println (placeHolder + " ");
		placeHolder = arrInput [i];
	    }
	}
	if (!placeHolder.equals (""))
	{
	    txtOutput.println (placeHolder);
	}
	txtOutput.close ();
    } //Close leftJustify


    /****************************************/
    //Author: Aarush Modi
    //Date: November 8, 2021
    //Purpose: Fully Justify file
    //Inputs: N/A
    //Outputs: N/A
    //Requires: leftJustify
    public void fullyJustify ()
    { //Open fullyJustify
	leftJustify ();
	int numberOfLines = 0;
	int counter = 0;
	String[] lines;
	TextOutputFile txtOutput = new TextOutputFile ("fullyJustify.txt");
	txtInput = new TextInputFile ("leftJustify.txt");
	while (!txtInput.eof ())
	{
	    txtInput.readLine ();
	    numberOfLines++;
	}
	txtInput.close ();
	txtInput = new TextInputFile ("leftJustify.txt");
	lines = new String [numberOfLines];
	while (!txtInput.eof ())
	{
	    lines [counter] = txtInput.readLine ();
	    counter++;
	}
	txtInput.close ();
	String currentLine = "";
	for (int lineNumber = 0 ; lineNumber < numberOfLines ; lineNumber++)
	{
	    if (lineNumber != numberOfLines - 1)
	    {
		int temp = 0;
		int currentChars = 0;
		int spacesRequired = 0;
		int minSpaces = 0;
		int additionalSpaces = 0;
		StringTokenizer words = new StringTokenizer (lines [lineNumber]);
		int numberOfWords = words.countTokens ();
		String[] lineWords = new String [numberOfWords];
		while (words.hasMoreTokens ())
		{
		    lineWords [temp] = words.nextToken ();
		    temp++;
		}
		for (int i = 0 ; i < numberOfWords - 1 ; i++)
		{
		    currentChars = currentChars + lineWords [i].length () + 1;
		}
		currentChars = currentChars + lineWords [numberOfWords - 1].length ();
		spacesRequired = 35 - currentChars;
		if (numberOfWords == 1)
		{
		    minSpaces = 0;
		}
		else
		{
		    minSpaces = spacesRequired / (numberOfWords - 1);
		}
		additionalSpaces = spacesRequired - (minSpaces * (numberOfWords - 1));
		for (int i = 0 ; i < numberOfWords - 1 ; i++)
		{
		    for (int j = 0 ; j < minSpaces + 1 ; j++)
		    {
			lineWords [i] = lineWords [i] + " ";
		    }
		    if (additionalSpaces > i)
		    {
			lineWords [i] = lineWords [i] + " ";
		    }
		}
		for (int k = 0 ; k < numberOfWords ; k++)
		{
		    txtOutput.print (lineWords [k]);
		}
		txtOutput.print ("\n");
	    }
	    else
	    {
		txtOutput.print (lines [counter - 1]);
	    }
	}
	txtOutput.close ();
    } //Close fullyJustify


    /****************************************/
    //Author: Aarush Modi
    //Date: November 8, 2021
    //Purpose: Collumize a file into two partitions
    //Inputs: N/A
    //Outputs: N/A
    //Requires: fullyJustify()
    public void format ()
    { //Open format
	fullyJustify ();
	String[] lines;
	TextOutputFile txtOutput = new TextOutputFile ("FinalOutput.txt");
	txtInput = new TextInputFile ("fullyJustify.txt");
	int numberOfLines = 0;
	while (!txtInput.eof ())
	{
	    txtInput.readLine ();
	    numberOfLines++;
	}
	txtInput.close ();
	txtInput = new TextInputFile ("fullyJustify.txt");
	lines = new String [numberOfLines];
	int counter = 0;
	while (!txtInput.eof ())
	{
	    lines [counter] = txtInput.readLine ();
	    counter++;
	}
	txtInput.close ();
	int mid = numberOfLines / 2;
	if (numberOfLines % 2 == 1)
	{
	    for (int i = 0 ; i < mid ; i++)
	    {
		txtOutput.println (lines [i] + "     " + lines [mid + i + 1]);
	    }
	    txtOutput.println (lines [mid]);
	}
	else
	{
	    for (int i = 0 ; i < mid ; i++)
	    {
		txtOutput.println (lines [i] + "     " + lines [mid + i]);
	    }
	}
	txtOutput.close ();
    } //Close format
} //Close Compile Class

