//Author: Aarush Modi
//Date: November 2, 2021
//Purpose: To store large integer values in arrays
import java.awt.*;
import hsa.Console;

public class BigIntTest
{
    static Console c;

    public static void main (String[] args)
    {
	c = new Console ();
	BigPositiveInt arr1;
	BigPositiveInt arr2;
	BigPositiveInt sum;
	arr1 = new BigPositiveInt (1, 1);
	arr2 = new BigPositiveInt (1, 1);
	sum = new BigPositiveInt (1);
	boolean bound = true;
	while (bound)
	{
	    c.println ("Enter the value of the first BigPositiveInt");
	    arr1.get (c);
	    c.println ("Enter the value of the second BigPositiveInt");
	    arr2.get (c);
	    c.println ();
	    c.println ("First: " + arr1.toString ());
	    c.println ("Second: " + arr2.toString ());
	    sum = arr1.add (arr2);
	    c.println ("Sum: " + sum.toString ());
	    c.getChar ();
	}
    } // main method
} // BigInt class


/*********************************************************************************************************/
//Author: Aarush Modi
//Date: October 29, 2021
//Purpose: To store large integer values in arrays
//Methods: Constructors, toString, get, addDigitBack, addDigitFront, add(int), add(obj)
//Data elements: Array of doubles (coeff), integer degree of polynomial (degree)
class BigPositiveInt
{ //Open Class
    public int[] digits;
    public int size;
    public String sign;

    /******************************************/
    //Author: Aarush Modi
    //Date: November 2, 2021
    //Purpose: Constructor
    //Input: int numberOfDigits and int value
    //Output: N/A
    //Requires: N/A
    public BigPositiveInt (int numberOfDigits, int value)
    { //Open Constructor
	this.size = numberOfDigits;
	digits = new int [this.size];
	for (int i = 0 ; i < numberOfDigits ; i++)
	{
	    digits [i] = value;
	}
    } //Close Constructor


    /******************************************/
    //Author: Aarush Modi
    //Date: November 2, 2021
    //Purpose: Constructor calls first constructor
    //Input: int size
    //Output: N/A
    //Requires: N/A
    public BigPositiveInt (int size)
    { //Open Constructor
	this (size, 0);
    } //Close Constructor


    /******************************************/
    //Author: Don Smith
    //Date: Unknown
    //Purpose: Remove leading zeros
    //Input: N/A
    //Output: N/A
    //Requires: N/A
    public void removeLeadingZeros ()
    { //Open removeLeadingZeros
	int[] old;
	while ((this.digits [this.size - 1] == 0) && (size > 1))
	    this.size--;
	old = this.digits;
	this.digits = new int [this.size];
	for (int a = 0 ; a < this.size ; a++)
	    this.digits [a] = old [a];
    } //Close removeLeadingZeros


    /******************************************/
    //Author: Aarush Modi
    //Date: November 2, 2021
    //Purpose: Converts array to string
    //Input: N/A
    //Output: Integer as string
    //Requires: N/A
    public String toString ()
    { //Open toString
	String integer = "";
	for (int i = this.size - 1 ; i >= 0 ; i--)
	{
	    integer = integer + Integer.toString (digits [i]);
	}
	return integer;
    } //Close toString


    /******************************************/
    //Author: Don Smith
    //Date: Unknown
    //Purpose: Get value and length input
    //Input: N/A
    //Output: N/A
    //Requires: HSA Console, addDigitFront(int added), removeLeadingZeros()
    public void get (Console c)
    { //Open get
	String a;
	a = c.readString ();
	this.size = a.length ();
	this.digits = new int [this.size];
	for (int i = 0 ; i < a.length () ; i++)
	    this.addDigitFront (a.charAt (i) - '0');
	this.removeLeadingZeros ();
    } //Close get


    /******************************************/
    //Author: Don Smith
    //Date: Unknown
    //Purpose: Add digits to the front
    //Input: N/A
    //Output: N/A
    //Requires: N/A
    public void addDigitFront (int added)
    { //Open addDigitFront
	int[] oldDigit;
	oldDigit = this.digits;
	this.size++;
	this.digits = new int [this.size];
	for (int i = 1 ; i < this.size ; i++)
	    this.digits [i] = oldDigit [i - 1];
	this.digits [0] = added;
    } //Close addDigitFront




    /******************************************/
    //Author: Don Smith
    //Date: Unknown
    //Purpose: Add digits to the back
    //Input: N/A
    //Output: N/A
    //Requires: N/A
    public void addDigitBack (int added)
    { //Open addDigitBack
	int[] oldDigit;
	oldDigit = this.digits;
	this.size++;
	this.digits = new int [this.size];
	for (int i = 0 ; i < this.size - 1 ; i++)
	    this.digits [i] = oldDigit [i];
	this.digits [this.size - 1] = added;
    } //Close addDigitBack


    /******************************************/
    //Author: Aarush Modi
    //Date: November 2, 2021
    //Purpose: Add integer to the array
    //Input: int numberOfDigits and int value
    //Output: N/A
    //Requires: removeLeadingZeros() and addDigitBack()
    public void add (int add)
    {
	String adding = Integer.toString (add);
	int length = adding.length ();
	char temp;
	int sum;
	for (int i = 0 ; i < length ; i++)
	{
	    int test = i - 1;
	    temp = adding.charAt (length - test);
	    sum = digits [i] + (int) temp - '0';
	    digits [i] = sum;
	}
	this.addDigitBack (0);
	for (int i = 0 ; i < size ; i++)
	{
	    while (digits [i] >= 10)
	    {
		digits [i] = digits [i] - 10;
		digits [i + 1]++;
	    }
	}
	this.removeLeadingZeros ();
    }


    /******************************************/
    //Author: Aarush Modi
    //Date: November 2, 2021
    //Purpose: Add array to the array (overloading)
    //Input: BigPositiveInt Object
    //Output: N/A
    //Requires: removeLeadingZeros() and addDigitBack()
    public BigPositiveInt add (BigPositiveInt obj)
    {
	BigPositiveInt temp;
	if (size <= obj.size)
	{
	    temp = new BigPositiveInt (obj.size + 1);
	    for (int i = 0 ; i <= size - 1 ; i++)
	    {
		temp.digits [i] = obj.digits [i] + digits [i];
		if (size < obj.size)
		{
		    addDigitBack (0);
		}
		else if (size > obj.size)
		{
		    obj.addDigitBack (0);
		}
	    }
	}
	else
	{
	    temp = new BigPositiveInt (size + 1);
	    for (int i = 0 ; i <= obj.size - 1 ; i++)
	    {
		temp.digits [i] = obj.digits [i] + digits [i];
		if (size < obj.size)
		{
		    addDigitBack (0);
		}
		else if (size > obj.size)
		{
		    obj.addDigitBack (0);
		}
	    }
	}
	temp.removeLeadingZeros ();
	temp.addDigitBack (0);
	for (int i = 0 ; i < temp.size - 1 ; i++)
	{
	    while (temp.digits [i] >= 10)
	    {
		temp.digits [i] = temp.digits [i] - 10;
		temp.digits [i + 1] = temp.digits [i + 1] + 1;
	    }
	}
	temp.removeLeadingZeros ();
	return temp;
    }
} //Close Class
