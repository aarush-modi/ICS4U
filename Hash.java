//Author: Aarush Modi
//Date: January 10, 2022
//Purpose: To create a Hash function for a database of records
import java.awt.*;
import hsa.*;
import java.util.*;
import java.io.*;

public class Hash
{
    static Console c;

    public static void main (String[] args)
    {
	c = new Console ();
	c.println ("Enter size: ");
	int size = c.readInt ();
	HashDataBase test = new HashDataBase (5, c);
	boolean reRun = true;
	while (reRun)
	{
	    c.println ("If you would like to peek, press p; if you would like to add press a, if you would like to find press f, if you would like to quit press q");
	    char inpt = c.getChar ();
	    if (inpt == 'q')
	    {
		reRun = false;
	    }
	    else if (inpt == 'p')
	    {
		test.peek (c);
	    }
	    else if (inpt == 'a')
	    {
		test.add (c);
	    }
	    else if (inpt == 'f')
	    {
		c.println ("Enter id you want to find: ");
		int id = c.readInt ();
		test.find (c, id);
	    }

	}
    } // MAIN method
} // Hash class

class HashDataBase
{
    TextInputFile textInput;
    DBRecord[] dataBase;
    int physicalSize;
    int logicalSize;

    //Author: Aarush Modi
    //Date: January 10, 2022
    //Purpose: Constructor
    //Inputs: Text File, size as int, Console c
    //Outputs: N/A
    //Requires: N/A
    public HashDataBase (int size, Console c)
    {
	textInput = new TextInputFile ("videodb.txt");

	if (!isPrime (size))
	{
	    size++;
	    for (int i = 2 ; i < size ; i++)
	    {
		if (size % i == 0)
		{
		    size++;
		    i = 2;
		}
	    }
	    c.println ("Since the size you gave was not a prime number, the size has been increased to the next prime number:" + size);
	}
	this.physicalSize = size;
	this.logicalSize = 0;
	dataBase = new DBRecord [size];
    }


    //Author: Aarush Modi
    //Date: January 10, 2022
    //Purpose: To check if a given int is prime
    //Inputs: size as int
    //Outputs: Boolean if the int was prime or not
    //Requires: N/A
    public boolean isPrime (int size)
    {
	boolean prime = true;
	if (size <= 1)
	{
	    prime = false;
	}
	for (int i = 2 ; i <= size / 2 ; ++i)
	{
	    if (size % i == 0)
	    {
		prime = false;
		i = size;
	    }
	}
	return prime;
    }


    //Author: Aarush Modi
    //Date: January 10, 2022
    //Purpose: To check if array is full
    //Inputs: N/A
    //Outputs: Boolean if the logicalSize / physicalSize > 70%
    //Requires: N/A
    public boolean isFull (Console c)
    {
	boolean isFull = false;
	//c.println(logicalSize);
	c.println (physicalSize);
	if (((double) (logicalSize / physicalSize) * 100) > 70)
	{
	    isFull = true;
	}
	return isFull;
    }


    //Author: Aarush Modi
    //Date: January 10, 2022
    //Purpose: To check if array is full
    //Inputs: N/A
    //Outputs: N/A
    //Requires: isPrime()
    public void rehash (Console c)
    {
	double pSize = physicalSize * 1.2;
	if (!isPrime ((int) pSize))
	{
	    pSize++;
	    for (int i = 2 ; i < pSize ; i++)
	    {
		if (pSize % i == 0)
		{
		    pSize++;
		    i = 2;
		}
	    }
	}
	DBRecord[] rehash = new DBRecord [(int) pSize];
	for (int i = 0 ; i < physicalSize ; i++)
	{
	    if (dataBase [i] != null)
	    {
		insert (c, dataBase [i]);
	    }
	}
	dataBase = rehash;
	physicalSize = (int) pSize;
    }


    //Author: Aarush Modi
    //Date: January 10, 2022
    //Purpose: Peek the hash table through console
    //Inputs: N/A
    //Outputs: N/A
    //Requires: Console c
    public void peek (Console c)
    {
	for (int i = 0 ; i < physicalSize ; i++)
	{
	    if (dataBase [i] != null)
	    {
		c.println ("ID of partition # " + (i + 1) + ": " + dataBase [i].id);
	    }
	    else
	    {
		c.println ("Partition # " + (i + 1) + " is null");
	    }
	}
    }


    //Author: Aarush Modi
    //Date: January 10, 2022
    //Purpose: add record
    //Inputs: N/A
    //Outputs: N/A
    //Requires:
    public void add (Console c)
    {
	int id = 0;
	String name = "";
	String type = "";
	double cost = 0.0;
	String dist = "";
	String date = "";
	DBRecord temp;
	if (!textInput.eof ())
	{
	    String line = textInput.readLine ();
	    StringTokenizer words = new StringTokenizer (line, ",", false);
	    id = Integer.parseInt (words.nextToken ());
	    name = words.nextToken ();
	    type = words.nextToken ();
	    cost = Double.parseDouble (words.nextToken ());
	    dist = words.nextToken ();
	    date = words.nextToken ();
	    temp = new DBRecord (id, name, type, cost, dist, date);
	    boolean isRehash = false;
	    if (isFull (c))
	    {
		rehash (c);
		isRehash = true;
	    }
	    logicalSize++;
	    c.println ("Rehashing was required: " + isRehash);
	    insert (c, temp);
	}
    }


    //Author: Aarush Modi
    //Date: January 10, 2022
    //Purpose: insert record
    //Inputs: N/A
    //Outputs: N/A
    //Requires: rehash(), isFull(), Console c
    public void insert (Console c, DBRecord temp)
    {
	int coli = 0;
	int location = 0;
	location = h (temp.id, coli);
	if (dataBase [location] != null)
	{
	    location = h2 (temp.id);
	    coli++;
	}
	dataBase [location] = temp;
	c.println ("Number of collisions: " + coli);
	c.println ("Location: " + location);
    }


    //Author: Aarush Modi
    //Date: January 10, 2022
    //Purpose: Finds and prints the record
    //Inputs: ID as int
    //Outputs: N/A
    //Requires: Console c
    public void find (Console c, int id)
    {
	int location = search (id);
	if (location == -1)
	{
	    c.println ("The record was not found");
	}


	else
	{
	    DBRecord found = dataBase [location];
	    c.println ("The ID is: " + found.id);
	    c.println ("The name is: " + found.title);
	    c.println ("The type is: " + found.type);
	    c.println ("The cost is: " + found.cost);
	    c.println ("The dist is: " + found.dist);
	    c.println ("The date is: " + found.date);
	}
    }


    //Author: Aarush Modi
    //Date: January 10, 2022
    //Purpose: Finds and prints the record
    //Inputs: ID as int
    //Outputs: N/A
    //Requires: N/A
    public int search (int id)
    {
	int location = -1;
	int temp = id % physicalSize;
	if (dataBase [temp] != null && dataBase [temp].id == id)
	{
	    location = temp;
	}


	else if (dataBase [temp] != null && dataBase [temp].id != id)
	{
	    for (int i = temp ; i < physicalSize ; i++)
	    {
		if (dataBase [i].id == id)
		{
		    location = i;
		    i = physicalSize;
		}
		else if (i == physicalSize - 1)
		{
		    i = 0;
		}
	    }
	}


	return location;
    }


    /*Method h
    Purpose:returnsthehashf()
    Parameters:id,counter
    Return:thehashfunction*/
    public int h (int k, int i)
    {
	return (k % this.physicalSize + i * h2
		(k)) % this.physicalSize;
    }


    /*Method h2
    Purpose:returns the double hashing f()
    Parameters:id
    Return:double hash function*/
    public int h2 (int k)
    {
	return (this.physicalSize - 2) - (k %
		(this.physicalSize - 2));
    }
}










/*Class DBRecord
Purpose: to create a movie record containing an
id, title, type, cost, distance, and date
Fields:
id -record id
title -record title
type -type of movie
cost -cost
dist -distance to travel
date -date of record
Methods:
constructor -creates a DBRecord given all
the information
toString -aligns information in a string
rightPad -pads a string with spaces on
the leftto a certain width
*/
class DBRecord
{
    public int id;
    protected String title;
    protected String type;
    protected double cost;
    protected String dist;
    protected String date;
    /*Constructor
    Purpose:creates a DBRecord given all the
    information
    Parameters:id,title, type, cost, dist, date
    Return:none*/
    public DBRecord (int x, String tit, String
	    typ, double cos, String dis, String dat)
    {
	id = x;
	title = tit;
	type = typ;
	cost = cos;
	dist = dis;
	date = dat;
    }


    /*Method toString
    Purpose:aligns information in a string
    Parameters:none
    Return:the string of the record's
    information*/
    public String toString ()
    {
	return (rightPad ("" + id, 8) + rightPad
		(title, 50) + rightPad (type, 10)
		+ rightPad ("" + cost, 8) +
		rightPad (dist, 6) + rightPad (date, 12));
    }


    /*Method rightPad
    Purpose:pads a string with spaces on the
    right to a certain width
    Parameters:string to pad,width
    Return: the string with a correct number of
    characters*/
    public static String rightPad (String x, int w)
    {
	String s = "" + x;
	while (s.length () < w)
	    s = s + " ";
	return s;
    }
}

