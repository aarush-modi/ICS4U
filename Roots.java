//Author: Aarush Modi
//Date: October 29, 2021
//Purpose: Find the roots of a polynomial
import java.awt.*;
import java.io.*;
import hsa.Console;

public class Poly
{
    static Console c;
    public static void main (String[] args)
    {
	c = new Console ();
	
	Roots root1 = new Roots();
	root1.get(c);
	c.println("Polynomial: ");
	c.println(root1.toString());
	c.println("Enter an integer value to use as value of x to solve: ");
	int val = c.readInt();
	c.println("Calculated value: ");
	c.println(root1.value(val));
	double[] arr;
	arr = new double [root1.degree];
	arr = root1.derivative();
	c.println("Derivative: ");
	for(int i = root1.degree; i> 0; i--)
	{
	    c.print(arr[i-1]);
	    int count = i-1;
	    c.println(", degree: "+ count);
	}
	
    } // main method
} // Poly class

/*********************************************************************/


//Author: Aarush Modi
//Date: October 29, 2021
//Purpose: Find roots of a ppolynomial
//Methods: Constructor with no parameters, Constructor with degree perameter, toString, get, value, derevitive
//Data elements: Array of doubles (coeff), integer degree of polynomial (degree)
public class Roots
{//Open Roots Class
    public int degree;
    public double[] coeff;
    /******************************************/
    // Author: Aarush Modi
    // Date: October 29, 2021
    // Purpose: Constructor
    // Inputs: N/A
    // Outputs: N/A
    // Requires: N/A
    public Roots ()
    { //Open Constructor
	this.degree = 0;
	this.coeff = new double[degree + 1];
    } //Close Constructor
    
    /******************************************/
    // Author: Aarush Modi
    // Date: October 29, 2021
    // Purpose: Constructor
    // Inputs: N/A
    // Outputs: N/A
    // Requires: N/A
    public Roots (int deg)
    { //Open Constructor
	this.degree = deg;
	this.coeff = new double[deg];
    } //Close Constructor
    
    /******************************************/
    // Author: Aarush Modi
    // Date: October 29, 2021
    // Purpose: Turns a polynomial to  string
    // Inputs: N/A
    // Outputs: String of polynomial
    // Requires: N/A
    public String toString()
    { //Open toString
	String poly = "";
	for (int i = degree; i >= 0; i--)
	{
	    String temp = Double.toString(coeff[i]);
	    if (Double.parseDouble(temp) >= 0)
	    {
		temp = "+" + temp;
	    }
	    if (i != 0 && i != 1)
	    {
		if (Double.parseDouble(temp) == 1.0)
		{
		    poly = poly + "x^ " + i;
		}
		else if (Double.parseDouble(temp) != 0.0)
		{
		    poly = poly + temp + "x^" + i;
		}
	    }
	    else if (i == 1)
	    {
		if (Double.parseDouble(temp) == 1.0)
		{
		    poly = poly + "x ";
		}
		else if (Double.parseDouble(temp) != 0.0)
		{
		    poly = poly + temp + "x ";
		}
	    }
	    else
	    {
		poly = poly + temp;
	    }
	}
	return poly;
    } //Close toString
    
    /******************************************/
    // Author: Aarush Modi
    // Date: October 29, 2021
    // Purpose: Gets values from user
    // Inputs: HSA Console
    // Outputs: N/A
    // Requires: hsa.console
    public void get(Console c)
    { //Open get
	boolean bound = true;
	String coefficient = "";
	while (bound == true)
	{
	    c.println("Enter the positive degree of the polynomial:");
	    this.degree = c.readInt();
	    if (this.degree >= 0)
	    {
		bound = false;
	    }
	}
	int count = 0;
	this.coeff = new double [this.degree + 1];
	while (count <= this.degree)
	{
	    c.println("Enter the value of a coefficient for the term with an exponent of: "+ count);
	    coefficient = c.readString();
	    double temp = 0;
	    temp = Double.parseDouble(coefficient);
	    this.coeff[count] = temp;
	    count ++;
	    
	}
    } //Close get
    
    /******************************************/
    // Author: Aarush Modi
    // Date: October 29, 2021
    // Purpose: Values polynomial
    // Inputs: Variable value
    // Outputs: Polynomial value
    // Requires: N/A
    public double value(int value)
    { //Open value
	double[] poly = new double [this.degree + 1];
	int n = this.degree + 1;
	for (int i = 0; i <= this.degree; i++)
	{
	    poly[n-1] = this.coeff[i];
	    n--;
	}
	double result = poly[0];
	int length = poly.length;
	for (int i=1; i<length; i++)
	{
	    result = result*value + poly[i];
	}
	return result;
    } //Close value
    
    /******************************************/
    // Author: Aarush Modi
    // Date: October 29, 2021
    // Purpose: Calculates derivative of the polynomial
    // Inputs: N/A
    // Outputs: Derivative of polynomial as array
    // Requires: N/A
    public double[] derivative()
    { //Open derivative
	double[] poly = new double [this.degree + 1];
	
	for (int i = 0; i <= this.degree; i++)
	{
	    if (i != 0)
	    {
		poly[i-1] = i * this.coeff[i];
	    }
	}
	return poly;
	
	
    } //Close derivative    
}//Close Roots Class
