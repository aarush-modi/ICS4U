//Author: Aarush Modi
//Date: October 9, 2021
//Purpose: To manipulate monomials
import java.awt.*;
import hsa.Console;

// Author: Aarush Modi
// Date: October 9, 2021
// Purpose: To manipulate monomials
// Data Fields: Coefficient(double), Exponent(int)
// Methods: Constructors, simplify, get, toString, canAdd, canDivide, add, subtract, multiply, divide, value, pow, equal
public class Monomial
{ // Open Monomial
    public int exponent;
    public char variable;
    public double coefficient;
    static Console c;
    /******************************************/
    // Author: Aarush Modi
    // Date: October 9, 2021
    // Purpose: Constructor
    // Inputs: N/A
    // Outputs: N/A
    // Requires: Simplify()
    public Monomial ()
    { //Open Constructor
	this.coefficient = 0;
	this.variable = 'x';
	Simplify ();
    } //Close Constructor


    /******************************************/
    // Author: Aarush Modi
    // Date: October 9, 2021
    // Purpose: Constructor
    // Inputs: N/A
    // Outputs: N/A
    // Requires: Simplify()
    public Monomial (double coefficient, int exponent, char variable)
    { //Open Constructor
	this.coefficient = coefficient;
	this.exponent = exponent;
	this.variable = variable;
	Simplify ();
    } //Close Constructor


    /******************************************/
    // Author: Aarush Modi
    // Date: October 9, 2021
    // Purpose: Simplify the monomial
    // Inputs: N/A
    // Outputs: N/A
    // Requires: N/A
    public void Simplify ()
    { //Open Simplify
	if (coefficient == 0)
	{
	    exponent = 0;
	}
    } //Close Simplify


    /******************************************/
    // Author: Aarush Modi
    // Date: October 9, 2021
    // Purpose: Get user input for Monomial
    // Inputs: N/A
    // Outputs: N/A
    // Requires: Simplify()
    public void get ()
    { //Open Get
	int exponent = 2;
	char variable = 'x';
	c.println ("Enter a value for the coefficient of the monomial: ");
	double coefficient = c.readDouble ();
	boolean bound = true;
	while (bound)
	{
	    c.println ("Enter a positive integer value for the exponent of the monomial: ");
	    exponent = c.readInt ();
	    c.println ("Enter a character value for the variable of the monomial: ");
	    variable = c.getChar ();
	    if (exponent >= 0)
	    {
		bound = false;
	    }
	}
	this.coefficient = coefficient;
	this.exponent = exponent;
	this.variable = variable;
	Simplify ();
    } //Close Get


    /******************************************/
    // Author: Aarush Modi
    // Date: October 9, 2021
    // Purpose: Turn the monomial into a string
    // Inputs: N/A
    // Outputs: String of monomial
    // Requires: N/A
    public String toString ()
    { //Open toString
	String coe = new String ("");
	String exp = new String ("");
	String mon = new String ("");
	if (coefficient == 0)
	{
	    mon = "0";
	}
	else if (coefficient == 1)
	{
	    coe = "";
	}
	else if (coefficient == -1)
	{
	    coe = "-";
	}
	else
	{
	    coe = Double.toString (coefficient);
	}
	if (exponent == 1)
	{
	    exp = Double.toString (variable);
	}
	else if (exponent == 0)
	{
	    exp = "";
	}
	else
	{
	    exp = (variable + "^" + Integer.toString (exponent));
	}
	if (mon != "0")
	{
	    mon = (coe + exp);
	}
	return mon;

    } //Close toString


    /******************************************/
    // Author: Aarush Modi
    // Date: October 15, 2021
    // Purpose: Find if the monomials can be added to form another monomial
    // Inputs: Monomial Object
    // Outputs: T or F if the monomials can be added
    // Requires: N/A
    public boolean canAdd (Monomial mono)
    { //Open canAdd
	boolean canAdd = false;
	if (exponent == mono.exponent && variable == mono.variable)
	{
	    canAdd = true;
	}
	return canAdd;
    } //Close canAdd


    /******************************************/
    // Author: Aarush Modi
    // Date: October 15, 2021
    // Purpose: Find if the monomials can be divided perfectly
    // Inputs: Monomial Object
    // Outputs: T or F if the monomials can be added
    // Requires: N/A
    public boolean canDivide (Monomial mono)
    { //Open canDivide
	boolean canDivide = false;
	if (coefficient % mono.coefficient == 0 && variable == mono.variable && coefficient != 0 && mono.coefficient != 0)
	{
	    canDivide = true;
	}
	return canDivide;
    } //Close canDivide


    /******************************************/
    // Author: Aarush Modi
    // Date: October 17, 2021
    // Purpose: Add two monomials
    // Inputs: Monomial Object
    // Outputs: String of monomials added
    // Requires: Simplify(), toString()
    public Monomial add (Monomial mono)
    { //Open add
	Monomial mono3 = new Monomial();
	if (canAdd (mono) == true)
	{
	    mono3.coefficient = coefficient + mono.coefficient;
	    mono3.variable = variable;
	    mono3.exponent = exponent;
	    mono3.Simplify ();
	}
	return mono3;
    } //Close add


    /******************************************/
    // Author: Aarush Modi
    // Date: October 17, 2021
    // Purpose: Subtract two monomials
    // Inputs: Monomial Object
    // Outputs: String of monomials subtracted
    // Requires: Simplify(), toString()
    public Monomial subtract (Monomial mono)
    { //Open subtract
	Monomial mono3 = new Monomial();
	if (canAdd (mono) == true)
	{
	    mono3.coefficient = coefficient - mono.coefficient;
	    mono3.variable = variable;
	    mono3.exponent = exponent;
	    mono3.Simplify ();
	}
	return mono3;
    } //Close subtract


    /******************************************/
    // Author: Aarush Modi
    // Date: October 17, 2021
    // Purpose: Multiply two monomials
    // Inputs: Monomial Object
    // Outputs: String of monomials multiplied
    // Requires: Simplify(), toString()
    public Monomial multiply (Monomial mono)
    { //Open multiply
	Monomial mono3 = new Monomial();
	if (canAdd (mono) == true)
	{
	    mono3.coefficient = coefficient * mono.coefficient;
	    mono3.variable = variable;
	    mono3.exponent = exponent;
	    mono3.Simplify ();
	}
	return mono3;
    } //Close multiply


    /******************************************/
    // Author: Aarush Modi
    // Date: October 17, 2021
    // Purpose: Divide two monomials
    // Inputs: Monomial Object
    // Outputs: String of monomials divided
    // Requires: Simplify(), toString()
    public Monomial divide (Monomial mono)
    { //Open divide
	Monomial mono3 = new Monomial();
	if (canDivide (mono) == true)
	{
	    mono3.coefficient = coefficient / mono.coefficient;
	    mono3.variable = variable;
	    mono3.exponent = exponent;
	    mono3.Simplify ();
	}
	return mono3;
    } //Close divide


    /******************************************/
    // Author: Aarush Modi
    // Date: October 17, 2021
    // Purpose: Calculate monomial
    // Inputs: int value
    // Outputs: Monomial with value
    // Requires: N/A
    public double value (int value)
    { //Open value
	double ans = coefficient * Math.pow (value, exponent);
	return ans;
    } //Close value


    /******************************************/
    // Author: Aarush Modi
    // Date: October 17, 2021
    // Purpose: Raise monomial to a power
    // Inputs: int power
    // Outputs: Monomial with power
    // Requires: toString()
    public Monomial pow (int pow)
    { //Open pow
	Monomial mono3 = new Monomial();
	mono3.exponent = exponent * pow;
	mono3.coefficient = Math.pow (coefficient, pow);
	mono3.variable = variable;
	return mono3;
    } //Close pow


    /******************************************/
    // Author: Aarush Modi
    // Date: October 17, 2021
    // Purpose: Find if monomials are equal
    // Inputs: Monomial Object
    // Outputs: T or F if monomials are equal
    // Requires: N/A
    public boolean equal (Monomial mono)
    { //Open equal
	boolean equal = false;
	if (coefficient == mono.coefficient && variable == mono.variable && exponent == mono.exponent)
	{
	    equal = true;
	}
	return equal;
    } //Close equal


    /******************************************/
    public static void main (String[] args)
    { //Open MAIN
	c = new Console ();
	int loop = 0;
	    while (loop == 0)
	{
	    double coefficient = 0;
	    char variable = 'x';
	    int exponent = 2;
	    Monomial mono1 = new Monomial (coefficient, exponent, variable);
	    Monomial mono2 = new Monomial (coefficient, exponent, variable);
	    c.println ("Enter information for the first monomial:");
	    mono1.get ();
	    c.println ("The first monomial: " + mono1.toString ());
	    c.println ("Enter information for the second monomial:");
	    mono2.get ();
	    c.println ("The second monomial: " + mono2.toString ());
	    c.println ("If any of the following 4 are set to 0, it is not possible: ");
	    c.println ("Sum of monomials: " + mono1.add (mono2));
	    c.println ("Product of monomials: " + mono1.multiply (mono2));
	    c.println ("Difference of monomials: " + mono1.subtract (mono2));
	    c.println ("Quotient of monomials: " + mono1.divide (mono2));
	    c.println ("Enter an int you would like to use for the variable of the new monomial: ");
	    int value = c.readInt ();
	    c.println ("Value of monomial: " + mono1.value (value));
	    boolean bound = true;
	    int pow = 2;
		while (bound)
	    {
		c.println ("Enter a positive integer value to raise the monomial to: ");
		pow = c.readInt ();
		if (pow > 0)
		{
		    bound = false;
		}
	    }
	    c.println ("New monomial raised to power: " + mono1.pow(pow));
	    c.println ("If the first monomial is equal to the second monomial: " + mono1.equal (mono2));
	    c.println ("Press any key to repeat the program");
	    c.getChar();
	}


	} // MAIN method closing
    } // Monomial class closing


