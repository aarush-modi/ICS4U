//Author: Aarush Modi
//Date: September 24, 2021
//Purpose: To test methods which calculate information abour prime numbers, numerical integration, and reccursion
import java.awt.*;
import hsa.Console;

public class Methods
{ // Open Class

    static Console c;           // The output console

    //Author: Aarush Modi
    //Date: September 24, 2021
    //Purpose: To calculate if a given integer is prime or not.
    //Input: Given integer(x)
    //Output: True if integer is a prime, False if integer is not prime
    static boolean isPrime (int x)
    { // Open isPrime
	boolean prime = true;
	if (x <= 1 || x % 2 == 0)
	{
	    prime = false;
	}
	else if (x == 2 || x == 3)
	{
	    prime = true;
	}
	else
	{
	    int count = 3;
	    while (count <= Math.sqrt (x))
	    {
		if (x % count == 0)
		{
		    prime = false;
		}
		count = count + 2;
	    }
	}
	if (x == 2)
	{
	    prime = true;
	}

	return prime;
    } // Close isPrime


    //Author: Aarush Modi
    //Date: October 3, 2021
    //Purpose: To calculate the number of prime numbers between two numbers.
    //Input: Given two integers(x,y)
    //Output: The number as integer of the number of prime numbers
    //Needs: isPrime(int x)
    static int calcNumberOfPrimes (int x, int y)
    { // Open calcNumberOfPrimes
	int numberPrimes = 0;
	if (x > y)
	{
	    int hold = x;
	    x = y;
	    y = hold;
	}
	for (int i = x ; i <= y ; i++)
	{
	    if (isPrime (i) == true)
	    {
		numberPrimes++;
	    }
	}
	return numberPrimes;
    } // Close calcNumberOfPrimes


    //Author: Aarush Modi
    //Date: October 3, 2021
    //Purpose: To print the prime numbers between two numbers.
    //Input: Given two integers(x,y)
    //Output: Prints all primes between two given integers
    //Needs: isPrime(int x)
    static void printPrimes (int x, int y)
    { // Open printPrimes
	if (x > y)
	{
	    int hold = x;
	    x = y;
	    y = hold;
	}
	for (int i = x ; i <= y ; i++)
	{
	    if (isPrime (i) == true)
	    {
		c.print (i + "; ");
	    }
	}
	c.println();
    } // Close printPrimes


    //Author: Aarush Modi
    //Date: October 4, 2021
    //Purpose: To find the first two prime numbers with a gap of a given int.
    //Input: Given integer(x)
    //Output: returns a object with the two prime numbers with a given gap.
    //Needs: isPrime(int x)
    static Polar findTwoPrimeGap (int x)
    { // Open findTwoPrimeGap
	//CODE
	Polar output = new Polar ();
	output.first = 0;
	output.second = 0;
	long first = 0;
	long second = 0;
	for (int i = 0 ; i < 500000 ; i++)
	{
	    if (isPrime (i) == true)
	    {
		first = second;
		second = i;
	    }
	    if (second - first == x)
	    {
		output.first = first;
		output.second = second;
		i = 500000;
	    }
	}

	return output;
    } // Close findTwoPrimeGap


    /****************************************
    *****************************************
    *****************************************
    END OF PRIME NUMBERS
    START OF NUMERICAL INTERGRATION
    */


    //Author: Aarush Modi
    //Date: October 3, 2021
    //Purpose: To calculate the height of f(x).
    //Input: Given two doubles(x,r)
    //Output: Height as double
    static double findHeight (double x, double r)
    { // Open findHeight
	double value = 0.0;
	value = Math.sqrt (r * r - (x - r) * (x - r));
	return value;
    } // Close findHeight


    //Author: Aarush Modi
    //Date: October 3, 2021
    //Purpose: To calculate the area under a semi-circle given a radius.
    //Input: Given double(r)
    //Output: The number as double of the area
    //Needs: findHeight(double x, double r)
    static double findArea (double r)
    { // Open findArea
	double area = 0.0;
	int n = 50;
	double areaDifference = 1.0;
	while (areaDifference > 0.00005)
	{
	    double width = (2 * r) / n;
	    double semiCircleArea = 0.0;
	    for (double x = 0 ; x <= (n - 1) * width ; x = x + width)
	    {
		double height = findHeight (x, r);
		double firstArea = height * width;
		semiCircleArea = semiCircleArea + firstArea;
	    }
	    areaDifference = (semiCircleArea - area);
	    area = semiCircleArea;
	    n = n * 2;
	}
	return area;
    } // Close findArea


    /****************************************
    *****************************************
    *****************************************
    END OF NUMERICAL INTERGRATION
    START OF RECURSION GCD
    */
    
    
    //Author: Aarush Modi
    //Date: October 4, 2021
    //Purpose: To calculate the gcd given two long values.
    //Input: Given two longs(m,n)
    //Output: GCD as long
    static long calcGCD (long m, long n)
    { // Open calcGCD
	long gcd = 0;
	if (m == 0)
	{
	    gcd = n;
	}
	else if (n == 0)
	{
	    gcd = m;
	}
	else if (n == m)
	{
	    gcd = n;
	}
	else if (m > n)
	{
	    gcd = calcGCD(m-n, n);
	}
	else
	{
	    gcd = calcGCD(m, n-m);
	}
	
	return gcd;
    } // Close calcGCD


    /****************************************
    *****************************************
    *****************************************
    END OF RECURSION GCD
    START OF RECURSION COUNTDOWN
    */
    
    
    //Author: Aarush Modi
    //Date: October 4, 2021
    //Purpose: To print numbers betweeen n to 1 reccursively
    //Input: Given integer (n)
    //Output: prints countdown
    static void displayCountdown (int n)
    { // Open displayCountdown
	if (n == 1)
	{
	    c.print(n+";");
	}
	else
	{
	    c.print(n+";");
	    displayCountdown(n-1);
	}
    } // Close displayCountdown
    
    
    // MAIN
    public static void main (String[] args)
    {
	c = new Console ();

	int x = 0;
	int y = 0;
	boolean bound = true;
	//Primes in between and calc number of primes
	while (bound)
	{
	    c.println ("Enter two positive integers to find all prime numbers between");
	    c.println ("First number: ");
	    x = c.readInt ();
	    c.println ("Second number: ");
	    y = c.readInt ();
	    if (x > 0 && y > 0)
	    {
		bound = false;
	    }
	}
	c.println("There are " + calcNumberOfPrimes(x,y) + " in your given range" );
	c.println("These are: ");
	printPrimes(x,y);
	bound = true;
	
	//Two Prime Gap
	while (bound)
	{
	    c.println ("Enter a positive integer to find the first two prime numbers with that gap: ");
	    x = c.readInt ();
	    if (x > 0)
	    {
		bound = false;
	    }
	}
	Polar output = findTwoPrimeGap(x);
	c.println ("First prime number: " + output.first + " Second prime number: " + output.second);
	bound = true;

	
	//Area
	while (bound)
	{
	    c.println ("Enter a positive integer for radius to find the area of a ");
	    c.println("semi-circle using nuerical integration: ");
	    x = c.readInt ();
	    if (x > 0)
	    {
		bound = false;
	    }
	}
	c.println("Area: " + findArea(x) + " units squared");
	bound = true;
	
	//GCD
	while (bound)
	{
	    c.println ("Enter two positive integers to find the GCD");
	    c.println ("First number: ");
	    x = c.readInt ();
	    c.println ("Second number: ");
	    y = c.readInt ();
	    if (x > 0 && y > 0)
	    {
		bound = false;
	    }
	}
	c.println("GCD: " + calcGCD(x,y));
	bound = true;
	    
	//Countdown
	while (bound)
	{
	    c.println ("Enter a positive integer to countdown from: ");
	    x = c.readInt ();
	    if (x > 0)
	    {
		bound = false;
	    }
	}
	displayCountdown(x);
	c.println();
	bound = true;
    } // MAIN method closing
} // Methods class closing


class Polar
{//Polar class open
    public long first = 0;
    public long second = 0;
}//Polar class closing
