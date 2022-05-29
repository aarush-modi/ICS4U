//Author: Aarush Modi
//Date: November 15, 2021
//Purpose: Encrypt a File

import java.awt.*;
import java.io.*;
import java.util.*;
import hsa.Console;
import hsa.*;

class Cryptography
{ //Open Class
    static Console c;
    public static void main (String[] args)
    {
	c = new Console ();
	c.println("Enter a key: ");
	String key = c.readLine();
	Crypt obj1 = new Crypt (key);
	obj1.encrypt ("butter.txt");
	c.println("The encryped file has been created: encryped.cyp");
	obj1.decrypt ("encryped.cyp");
	c.println("The decryped file has been created: decrypted.pln");
    }
} //Close Class

//Author: Aarush Modi
//Date: November 15, 2021
//Purpose: Encrypt/Decrypt files
//Data Fields: key(Used to decrypt)
/*Methods: CalcNewLetterUp(encryts letter) 
CalcNewLetterDown(decrypts letter)
encrypt(encrypts entire file) 
decrypt(decrypt entire file)*/
class Crypt
{ //Open Class
    String key;
    //Author: Aarush Modi
    //Date: November 15, 2021
    //Purpose: Constructor
    //Input: N/A
    //Output: N/A
    //Requires: N/A
    public Crypt (String key)
    { //Open Constructor
	this.key = key;
    } //Close Constructor

    /**********************************************************/
    //Author: Aarush Modi
    //Date: November 15, 2021
    //Purpose: Constructor
    //Input: N/A
    //Output: N/A
    //Requires: Crypt(key)
    public Crypt ()
    {
	this.key = "ics4u";
    }

    /**********************************************************/
    //Author: Aarush Modi
    //Date: November 15, 2021
    //Purpose: encrypts letter
    //Input: Two chars
    //Output: N/A
    //Requires: N/A
    public char calcNewLetterUp (char letter, char key)
    { //Open calcNewLetterUp
	int offset = (int) (letter) - 32;
	int returns = offset + (int) (key);
	if (returns > 126)
	{
	    returns = returns - 95;
	}
	char encryLetter = (char) returns;
	return encryLetter;
    } //Close calcNewLetterUp

    /**********************************************************/
    //Author: Aarush Modi
    //Date: November 15, 2021
    //Purpose: decrypts letter
    //Input: Two chars
    //Output: N/A
    //Requires: N/A
    public char calcNewLetterDown (char letter, char encryLetter)
    { //Open calcNewLetterDown
	int offset = (int) (encryLetter) - 32;
	int returns = (int) (letter) - offset;
	if (returns < 32)
	{
	    returns = returns + 95;
	}
	encryLetter = (char) returns;
	return encryLetter;
    } //Close calcNewLetterDown

    /**********************************************************/
    //Author: Aarush Modi
    //Date: November 15, 2021
    //Purpose: encrypts entire file
    //Input: File name as string
    //Output: N/A
    //Requires: calcNewLetterUp()
    public void encrypt (String file)
    { //Open encrypt
	int counter = 0;
	int numberOfLines = 0;
	int lock = 0;
	String currentLine = "";
	String cryptLine = "";
	String[] lines;
	TextInputFile txtInput = new TextInputFile (file);
	TextOutputFile txtOutput = new TextOutputFile ("encryped.cyp");
	while (!txtInput.eof ())
	{
	    txtInput.readLine ();
	    numberOfLines++;
	}
	txtInput.close ();
	lines = new String [numberOfLines];
	txtInput = new TextInputFile (file);
	while (!txtInput.eof ())
	{
	    currentLine = txtInput.readLine ();
	    lines [counter] = currentLine;
	    counter++;
	}
	txtInput.close ();
	for (int i = 0 ; i < numberOfLines ; i++)
	{
	    currentLine = lines [i];
	    for (int j = 0 ; j < currentLine.length () ; j++)
	    {
		cryptLine = cryptLine + calcNewLetterUp (currentLine.charAt (j), key.charAt (lock));
		lock++;
		if (lock == key.length ())
		{
		    lock = 0;
		}
	    }
	    txtOutput.println (cryptLine);
	    cryptLine = "";
	}
	txtOutput.close ();
    } //Close encrypt

    /**********************************************************/
    //Author: Aarush Modi
    //Date: November 15, 2021
    //Purpose: decrypts entire file
    //Input: File as string
    //Output: N/A
    //Requires: calcNewLetterDown()
    public void decrypt (String file)
    { //Open decrypt
	int counter = 0;
	int numberOfLines = 0;
	int lock = 0;
	String[] lines;
	String currentLine = "";
	String cryptLine = "";
	TextInputFile txtInput = new TextInputFile (file);
	TextOutputFile txtOutput = new TextOutputFile ("decrypted.pln");
	while (!txtInput.eof ())
	{
	    txtInput.readLine ();
	    numberOfLines++;
	}
	txtInput.close ();
	lines = new String [numberOfLines];
	txtInput = new TextInputFile (file);
	while (!txtInput.eof ())
	{
	    currentLine = txtInput.readLine ();
	    lines [counter] = currentLine;
	    counter++;
	}
	txtInput.close ();
	for (int i = 0 ; i < numberOfLines ; i++)
	{
	    currentLine = lines [i];
	    for (int j = 0 ; j < currentLine.length () ; j++)
	    {
		cryptLine = cryptLine + calcNewLetterDown (currentLine.charAt (j), key.charAt (lock));
		lock++;
		    if (lock == key.length ())
		    {
			lock = 0;
		    }
	    }
	    txtOutput.println (cryptLine);
	    cryptLine = "";
	}
	txtOutput.close ();
    }//Close decrypt
} //Close Class
