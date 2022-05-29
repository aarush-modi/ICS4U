//Author: Aarush Modi
//Date: November 29, 2021
//Purpose: To undestand the fundementals of 2-D arrays using matrices
import java.awt.*;
import hsa.Console;

public class Matrices
{ //Open Class
    static Console c;
    public static void main (String[] args)
    { //Open MAIN
	c = new Console ();
	Matrix obj1 = new Matrix ();
	Matrix obj2 = new Matrix ();
	c.println("For the first Matrix: ");
	obj1.get (c);
	c.println("For the second Matrix: ");
	obj2.get(c);
	c.println("Press any key to continue");
	c.getChar()        ;
	c.clear ();
	c.println("For the first Matrix: ");
	obj1.print (c, 200, 100);
	c.getChar();        
	c.clear ();        
	c.println("For the second Matrix: ");
	obj2.print (c, 200, 100);
	c.println("Press any key to continue");
	c.getChar();        
	c.clear ();
	Matrix trans = obj1.transpose();
	c.println("The first matrix has been transposed!");
	c.println("For the transposed Matrix: ");
	trans.print (c, 200, 100);
	c.println("Press any key to continue");
	c.getChar();        
	c.clear ();
	c.print ("Discriminant of transposed matrix: ");
	c.println (trans.determinant ());
    } //Close MAIN
} //Close Class




//Author: Aarush Modi
//Date: November 29, 2021
//Purpose: A matrix manipulation program
//Data Fields: Element(2-D array[doubles]), rows(int), cols(int)
/*Methods: Constructors
clone(Clones the data elements)
get(Gets input from the user)
print(Prints the matrix)
getFromFile(read rows, cols, and elements from the file)
columnAverage(Calculate the avrages of each coloumn)
sameSize(Check if two matricies are of equal size)
square(Check if matrix is a square or not)
add(Add two matricies)
subtract(Add two matricies)
minor(Find minor of matrix)
transpose(Transpose the matrix)
determinant(Calculate the determinant)*/

class Matrix
{ //Open Class
    double[] [] element;
    int rows;
    int cols;


    //*********************************************************
    //Author: Aarush Modi
    //Date: December 1, 2021
    //Purpose: Constructor
    //Inputs: N/A
    //Outputs: N/A
    //Requires: N/A
    public Matrix ()
    { //Open Constructor
	this.rows = 1;
	this.cols = 1;
	element = new double [1] [1];
    } //Close Constructor


    //*********************************************************
    //Author: Aarush Modi
    //Date: December 1, 2021
    //Purpose: Constructor
    //Inputs: int rows, int cols
    //Outputs: N/A
    //Requires: N/A
    public Matrix (int rows, int cols)
    { //Open Constructor
	this.rows = rows;
	this.cols = cols;
	element = new double [rows] [cols];
    } //Close Constructor


    //*********************************************************
    //Author: Aarush Modi
    //Date: December 2, 2021
    //Purpose: Deep clone the data elements
    //Inputs: N/A
    //Outputs: N/A
    //Requires: N/A
    public Object Clone () throws CloneNotSupportedException
    { //Open Clone
	Matrix clone = (Matrix) super.clone ();
	clone.element = new double [rows] [cols];
	for (int i = 0 ; i < rows ; i++)
	{
	    for (int j = 0 ; j < element [i].length ; j++)
	    {
		clone.element [i] [j] = element [i] [j];
	    }
	}
	return clone;
    } //Close Clone


    //*********************************************************
    //Author: Aarush Modi
    //Date: December 2, 2021
    //Purpose: Gets Input from user
    //Inputs: N/A
    //Outputs: N/A
    //Requires: Console c
    public void get (Console c)
    { //Open get
	c.println ("Number of rows: ");
	rows = c.readInt ();
	c.println ("Number of columns: ");
	cols = c.readInt ();
	element = new double [rows] [cols];
	for (int i = 0 ; i < rows ; i++)
	{
	    for (int j = 0 ; j < cols ; j++)
	    {
		c.println ("Input the value for the value at this position (row,coloumn): (" + (i + 1) + "," + (j + 1) + ")");
		element [i] [j] = c.readDouble ();
	    }
	}
    } //Close get


    //*********************************************************
    //Author: Aarush Modi
    //Date: December 4, 2021
    //Purpose: Prints the matrix
    //Inputs: x and y coordinate, Console c
    //Outputs: N/A
    //Requires: Console c
    public void print (Console c, int x, int y)
    { //Open print
	String output = "";
	Font newFont = new Font ("Arial", Font.PLAIN, 20);
	c.setFont (newFont);
	for (int i = 0 ; i < rows ; i++)
	{
	    for (int j = 0 ; j < cols ; j++)
	    {
		output = output + element [i] [j] + "           ";

	    }
	    c.drawString (output, x, y);
	    y = y + 80;
	    output = "";
	}
    } //Close print


    //*********************************************************
    //Author: Aarush Modi
    //Date: December 5, 2021
    //Purpose: Calculate the avrages of each coloumn
    //Inputs: N/A
    //Outputs: Matrix Object
    //Requires: Matrix (int, int)
    public Matrix columnAvrage ()
    { //Open columnAvrage
	Matrix avraged = new Matrix (1, rows);
	double avg = 0;
	for (int i = 0 ; i < rows ; i++)
	{
	    for (int j = 0 ; j < cols ; j++)
	    {
		avg = avg + element [i] [j];
	    }
	    avg = avg / cols;
	    avraged.element [i] [0] = avg;
	    avg = 0;
	}
	return avraged;
    } //Close columnAvrage


    //*********************************************************
    //Author: Aarush Modi
    //Date: December 7, 2021
    //Purpose: Check if two matricies are of equal size
    //Inputs: A matrix object
    //Outputs: Boolean(True or False)
    //Requires: N/A
    public boolean sameSize (Matrix secondMatrix)
    { //Open sameSize
	boolean sameSize = false;
	if (secondMatrix.rows == rows && secondMatrix.cols == cols)
	{
	    sameSize = true;
	}
	return sameSize;
    } //Close sameSize


    //*********************************************************
    //Author: Aarush Modi
    //Date: December 7, 2021
    //Purpose: Check if matrix is a square or not
    //Inputs: N/A
    //Outputs: Boolean(True or False)
    //Requires: N/A
    public boolean square ()
    { //Open square
	boolean isSquare = false;
	if (rows == cols)
	{
	    isSquare = true;
	}
	return isSquare;
    } //Close square


    //*********************************************************
    //Author: Aarush Modi
    //Date: December 7, 2021
    //Purpose: Add two matricies
    //Inputs: A matrix object
    //Outputs: Marix object with sums
    //Requires: sameSize(Matrix), Matrix(int,int), Matrix()
    public Matrix add (Matrix secondMatrix)
    { //Open add
	Matrix sum;
	if (sameSize (secondMatrix))
	{
	    sum = new Matrix (rows, cols);
	    for (int i = 0 ; i < rows ; i++)
	    {
		for (int j = 0 ; j < cols ; j++)
		{
		    sum.element [i] [j] = element [i] [j] + secondMatrix.element [i] [j];
		}
	    }
	}
	else
	{
	    sum = new Matrix ();
	}
	return sum;
    } //Close add


    //*********************************************************
    //Author: Aarush Modi
    //Date: December 7, 2021
    //Purpose: Subtract two matricies
    //Inputs: A matrix object
    //Outputs: Marix object with difference
    //Requires: sameSize(Matrix), Matrix(int,int), Matrix()
    public Matrix subtract (Matrix secondMatrix)
    { //Open subtract
	Matrix difference;
	if (sameSize (secondMatrix))
	{
	    difference = new Matrix (rows, cols);
	    for (int i = 0 ; i < rows ; i++)
	    {
		for (int j = 0 ; j < cols ; j++)
		{
		    difference.element [i] [j] = element [i] [j] + secondMatrix.element [i] [j];
		}
	    }
	}
	else
	{
	    difference = new Matrix ();
	}
	return difference;
    } //Close subtract


    //*********************************************************
    //Author: Aarush Modi
    //Date: December 7, 2021
    //Purpose: Find minor of matrix
    //Inputs: Row(int) and Col(int) of the value to find matrix of
    //Outputs: Marix object with minor
    //Requires: Matrix(int,int)
    public Matrix minor (int row, int col)
    { //Open minor
	Matrix minor = new Matrix ();

	minor = new Matrix (rows - 1, cols - 1);
	int rowValue = 0;
	int colValue = 0;
	if (rows > 0 && cols > 0)
	{
	    for (int i = 0 ; i < rows ; i++)
	    {
		if (i == row)
		{
		    i++;
		}
		for (int j = 0 ; j < cols ; j++)
		{
		    if (j != col)
		    {
			minor.element [rowValue] [colValue] = element [i] [j];
			colValue++;
		    }
		}
		colValue = 0;
		rowValue++;
	    }
	}
	minor.cols = cols - 1;
	minor.rows = rows - 1;
	return minor;
    } //Close minor


    //*********************************************************
    //Author: Aarush Modi
    //Date: December 7, 2021
    //Purpose: Transpose the matrix
    //Inputs: N/A
    //Outputs: Transposed Marix object
    //Requires: N/A
    public Matrix transpose ()
    { //Open transpose
	Matrix transpose = new Matrix (cols, rows);
	for (int i = 0 ; i < rows ; i++)
	{
	    for (int j = 0 ; j < cols ; j++)
	    {
		transpose.element [j] [i] = element [i] [j];
	    }
	}
	return transpose;
    } //Close transpose


    //*********************************************************
    //Author: Aarush Modi
    //Date: December 10, 2021
    //Purpose: Calculate the determinant
    //Inputs: N/A
    //Outputs: N/A
    //Requires: N/A
    public double determinant ()
    { //Open determinant
	double determinant = 0;
	if (square ())
	{
	    int holder[] [] = new int [rows] [cols];
	    int temp = 1;
	    int size = rows;
	    if (size == 1)
	    {
		determinant = element [0] [0];
	    }
	    else if (size == 2)
	    {
		return (element [0] [0] * element [1] [1]) - (element [0] [1] * element [1] [0]);
	    }
	    else
	    {
		for (int i = 0 ; i < size ; i++)
		{
		    determinant = determinant + temp * element [0] [i] * minor (0, i).determinant ();
		    temp = -temp;
		}
	    }
	}
	return determinant;
    } //Close determinant
} //Close Class
