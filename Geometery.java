//Author: Aarush Modi
//Date: December 15, 2021
//Purpose: Create and manage shapes
import java.awt.*;
import java.lang.*;
import java.text.DecimalFormat;
import java.awt.*;
import hsa.Console;

public class Geometery
{ //Open Geometry Class
    static Console c;
    public static void main (String[] args)
    { //Open MAIN
	c = new Console ();
	boolean reRun = true;
	int numberOfShapes = 1;
	while (reRun)

	{
	    c.println ("How many shapes would you like to create?");
	    try
	    {
		numberOfShapes = Integer.parseInt (c.readString ());
		reRun = false;
	    }
	    catch (NumberFormatException e)
	    {
		c.println ("Input is not a valid integer");
		reRun = true;
	    }
	}
	ShapeObj[] shape = new ShapeObj [numberOfShapes];
	c.println ("For each object: ");
	for (int i = 0 ; i < numberOfShapes ; i++)
	{
	    int shapeFormat = 0;
	    c.println ("Enter '2' for a 2D shape, Enter '3' for a 3D shape");
	    try
	    {
		shapeFormat = Integer.parseInt (c.readString ());
	    }
	    catch (NumberFormatException e)
	    {
		c.println ("Input is not a valid integer");
	    }
	    if (shapeFormat == 1)
	    {
		c.println ("Enter '0' for a circle,  Enter '3' for a triangle, Enter '4' for a rectangle, Enter '5' for a pentagon");
		try
		{
		    shapeFormat = Integer.parseInt (c.readString ());
		}
		catch (NumberFormatException e)
		{
		    c.println ("Input is not a valid integer");
		}
		if (shapeFormat == 0)
		{
		    Circle createdShape = new Circle ();
		    shape [i] = createdShape;
		}
		else if (shapeFormat == 3)
		{
		    RectangleObj createdShape = new RectangleObj ();
		    shape [i] = createdShape;
		}
		else if (shapeFormat == 4)
		{
		    Triangle createdShape = new Triangle ();
		    shape [i] = createdShape;
		}
		else if (shapeFormat == 5)
		{
		    Pentagon createdShape = new Pentagon ();
		    shape [i] = createdShape;
		}
		else
		    c.println ("Input is not a valid integer");
	    }
	    else if (shapeFormat == 2)
	    {
		c.println ("Enter '0' for a sphere, Enter '3' for a tetrahedron,  Enter '4' for a cube");
		try
		{
		    shapeFormat = Integer.parseInt (c.readString ());
		}
		catch (NumberFormatException e)
		{
		    c.println ("Input is not a valid integer");
		}
		if (shapeFormat == 0)
		{
		    Sphere createdShape = new Sphere ();
		    shape [i] = createdShape;
		}
		else if (shapeFormat == 3)
		{
		    Tetrahedron createdShape = new Tetrahedron ();
		    shape [i] = createdShape;
		}
		else if (shapeFormat == 4)
		{
		    Cube createdShape = new Cube ();
		    shape [i] = createdShape;
		}
		else
		    c.println ("Input is not a valid integer");
	    }
	    else
	    {
		c.println ("Input is not a valid integer, a blue cube will be created for you");
		Cube createdShape = new Cube (1, 1, 1, "blue");
		shape [i] = createdShape;
	    }
	    shape [i].get (c);
	}
	for (int i = 0 ; i < numberOfShapes ; i++)
	{
	    c.println (shape [i].stats ());
	}
    } // Close MAIN
} // Close Geometery Class

//Author: Aarush Modi
//Date: December 15, 2021
//Purpose: Create and manage shapes
//Data Fields: size(size), x(x location), y(y location), colour(colour)
//Methods: stats(print Information of shape), get(receive input)
abstract class ShapeObj
{
    int size;
    int x;
    int y;
    String colour;

    public ShapeObj (int size, int x, int y, String colour)
    {
	this.size = size;
	this.x = x;
	this.y = y;
	this.colour = colour;
    }


    public ShapeObj ()
    {
	this (0, 0, 0, "");
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Print information about shape to console
    //Input: N/A
    //Output: String of stats
    public String stats ()
    {
	String stats = "";
	return stats;
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Get input
    //Input: Console c
    //Output: N/A
    public void get (Console c)
    {
	c.println ("Enter size as integer: ");
	this.size = c.readInt ();
	c.println ("Enter x value as integer: ");
	this.x = c.readInt ();
	c.println ("Enter y value as integer: ");
	this.y = c.readInt ();
	c.println ("Enter colour as string: ");
	this.colour = c.readString ();
    }
}

//Author: Aarush Modi
//Date: December 15, 2021
//Purpose: Create and manage 2D shapes
//Data Fields: ShapeObj, perimeter, area
//Methods: ShapeObj, area(abstract method), perimeter(abstract method), get(super)
abstract class D2shape extends ShapeObj
{
    double perimeter;
    double area;
    public D2shape (int size, int x, int y, String colour)
    {
	this.size = size;
	this.x = x;
	this.y = y;
	this.colour = colour;
    }


    public D2shape ()
    {
	this (0, 0, 0, "");
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Abstract area method
    //Input: N/A
    //Output: N/A
    public abstract void area ();

    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Abstract perimeter method
    //Input: N/A
    //Output: N/A
    public abstract void perimeter ();

    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Get information using super
    //Input: Console c
    //Output: N/A
    public void get (Console c)
    {
	super.get (c);
    }
}

//Author: Aarush Modi
//Date: December 15, 2021
//Purpose: Create and manage Circles
//Data Fields: D2shape
//Methods: D2shape(), area(), perimeter()
class Circle extends D2shape
{
    public Circle (int size, int x, int y, String colour)
    {
	this.size = size;
	this.x = x;
	this.y = y;
	this.colour = colour;
    }


    public Circle ()
    {
	this (1, 100, 100, "red");
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: area method
    //Input: N/A
    //Output: N/A
    public void area ()
    {
	this.area = 3.1415926535 * size * size;
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: perimeter method
    //Input: N/A
    //Output: N/A
    public void perimeter ()
    {
	this.perimeter = 3.1415926535 * size * 2;
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Get information using super
    //Input: Console c
    //Output: N/A
    public void get (Console c)
    {
	super.get (c);
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Print information of object to console
    //Input: None
    //Output: string
    public String stats ()
    {
	DecimalFormat df = new DecimalFormat ("#.###");
	perimeter ();
	area ();
	String output = "";
	output = output + "\n Circle \n";
	output = output + "Colour: " + colour + "\n";
	output = output + "Radius: " + size + "\n";
	output = output + "Coordinates: (" + x + "," + y + ")" + "\n";
	output = output + "Perimeter: " + df.format (perimeter) + "\n";
	output = output + "Area: " + df.format (area);
	return output;
    }
}

//Author: Aarush Modi
//Date: December 15, 2021
//Purpose: Create and manage Triangles
//Data Fields: D2shape, sideSize1, sideSize2
//Methods: D2shape(), area(), perimeter()
class Triangle extends D2shape
{
    int sideSize1;
    int sideSize2;
    public Triangle (int size, int sideSize1, int sideSize2, int x, int y, String colour)
    {
	this.size = size;
	this.sideSize1 = sideSize1;
	this.sideSize2 = sideSize2;
	this.x = x;
	this.y = y;
	this.colour = colour;
    }


    public Triangle ()
    {
	this (1, 1, 1, 100, 100, "red");
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: area method
    //Input: N/A
    //Output: N/A
    public void area ()
    {
	double semiP = (double) (size + sideSize1 + sideSize2) / 2.0;
	this.area = Math.sqrt (semiP * (semiP - (double) size) * (semiP - (double) sideSize1) * (semiP - (double) sideSize2));
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: perimeter method
    //Input: N/A
    //Output: N/A
    public void perimeter ()
    {
	this.perimeter = size + sideSize1 + sideSize2;
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Get information for sides
    //Input: Console c
    //Output: N/A
    public void get (Console c)
    {
	c.println ("Enter first side length as integer: ");
	this.size = c.readInt ();
	c.println ("Enter second side length as integer: ");
	this.sideSize1 = c.readInt ();
	c.println ("Enter third side length as integer: ");
	this.sideSize2 = c.readInt ();
	c.println ("Enter x value as integer: ");
	this.x = c.readInt ();
	c.println ("Enter y value as integer: ");
	this.y = c.readInt ();
	c.println ("Enter colour as string: ");
	this.colour = c.readString ();
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Print information of object to console
    //Input: None
    //Output: string
    public String stats ()
    {
	DecimalFormat df = new DecimalFormat ("#.###");
	perimeter ();
	area ();
	String output = "";
	output = output + "\n Triangle \n";
	output = output + "Colour: " + colour + "\n";
	output = output + "Side 1 length: " + size + "\n";
	output = output + "Side 2 length: " + sideSize1 + "\n";
	output = output + "Side 3 length: " + sideSize2 + "\n";
	output = output + "Coordinates: (" + x + "," + y + ")" + "\n";
	output = output + "Perimeter: " + df.format (perimeter) + "\n";
	output = output + "Area: " + df.format (area);
	return output;
    }
}

//Author: Aarush Modi
//Date: December 15, 2021
//Purpose: Create and manage Rectangles
//Data Fields: D2shape, width
//Methods: D2shape(), area(), perimeter()
class RectangleObj extends D2shape
{
    int width;
    public RectangleObj (int size, int width, int x, int y, String colour)
    {
	this.size = size;
	this.width = width;
	this.x = x;
	this.y = y;
	this.colour = colour;
    }


    public RectangleObj ()
    {
	this (1, 1, 100, 100, "red");
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: area method
    //Input: N/A
    //Output: N/A
    public void area ()
    {
	this.area = size * width;
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: perimeter method
    //Input: N/A
    //Output: N/A
    public void perimeter ()
    {
	this.perimeter = (size + width) * 2;
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Get information for sides
    //Input: Console c
    //Output: N/A
    public void get (Console c)
    {
	c.println ("Enter length as integer: ");
	this.size = c.readInt ();
	c.println ("Enter width as integer: ");
	this.width = c.readInt ();
	c.println ("Enter x value as integer: ");
	this.x = c.readInt ();
	c.println ("Enter y value as integer: ");
	this.y = c.readInt ();
	c.println ("Enter colour as string: ");
	this.colour = c.readString ();
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Print information of object to console
    //Input: None
    //Output: string
    public String stats ()
    {
	DecimalFormat df = new DecimalFormat ("#.###");
	perimeter ();
	area ();
	String output = "";
	output = output + "\n Rectangle \n";
	output = output + "Colour: " + colour + "\n";
	output = output + "Length: " + size + "\n";
	output = output + "Width: " + width + "\n";
	output = output + "Coordinates: (" + x + "," + y + ")" + "\n";
	output = output + "Perimeter: " + df.format (perimeter) + "\n";
	output = output + "Area: " + df.format (area);
	return output;
    }
}

//Author: Aarush Modi
//Date: December 15, 2021
//Purpose: Create and manage Pentagon
//Data Fields: D2shape
//Methods: D2shape(), area(), perimeter()
class Pentagon extends D2shape
{
    double apothem;
    public Pentagon (int size, int x, int y, String colour)
    {
	this.size = size;
	this.x = x;
	this.y = y;
	this.colour = colour;
    }


    public Pentagon ()
    {
	this (1, 100, 100, "red");
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: area method
    //Input: N/A
    //Output: N/A
    public void area ()
    {
	this.area = (2.5 * size * apothem);
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: perimeter method
    //Input: N/A
    //Output: N/A
    public void perimeter ()
    {
	this.perimeter = size * 5;
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Get information using super
    //Input: Console c
    //Output: N/A
    public void get (Console c)
    {
	super.get (c);
	this.apothem = size / (2 * Math.tan (36));
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Print information of object to console
    //Input: None
    //Output: string
    public String stats ()
    {
	DecimalFormat df = new DecimalFormat ("#.###");
	perimeter ();
	area ();
	String output = "";
	output = output + "\n Pentagon \n";
	output = output + "Colour: " + colour + "\n";
	output = output + "Side length: " + size + "\n";
	output = output + "Apothem length: " + apothem + "\n";
	output = output + "Coordinates: (" + x + "," + y + ")" + "\n";
	output = output + "Perimeter: " + df.format (perimeter) + "\n";
	output = output + "Area: " + df.format (area);
	return output;
    }
}

//Author: Aarush Modi
//Date: December 15, 2021
//Purpose: Create and manage 3D shapes
//Data Fields: ShapeObj, volume, sArea
//Methods: ShapeObj, sArea(abstract method), Volume(abstract method), get(super)
abstract class D3shape extends ShapeObj
{
    double volume;
    double sArea;
    public D3shape (int size, int x, int y, String colour)
    {
	this.size = size;
	this.x = x;
	this.y = y;
	this.colour = colour;
    }


    public D3shape ()
    {
	this (0, 0, 0, "");
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Abstract area method
    //Input: N/A
    //Output: N/A
    public abstract void sArea ();

    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Abstract perimeter method
    //Input: N/A
    //Output: N/A
    public abstract void volume ();

    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Get information using super
    //Input: Console c
    //Output: N/A
    public void get (Console c)
    {
	super.get (c);
    }
}

//Author: Aarush Modi
//Date: December 15, 2021
//Purpose: Create and manage 2D shapes
//Data Fields: ShapeObj, volume, sArea
//Methods: ShapeObj, sArea, Volume, get(super)
class Sphere extends D3shape
{
    public Sphere (int size, int x, int y, String colour)
    {
	this.size = size;
	this.x = x;
	this.y = y;
	this.colour = colour;
    }


    public Sphere ()
    {
	this (1, 100, 100, "red");
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: area method
    //Input: N/A
    //Output: N/A
    public void sArea()
    {
	this.sArea = size * size * 4 * 3.1415926535;
    }

    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Abstract perimeter method
    //Input: N/A
    //Output: N/A
    public void volume ()
    {
	this.volume = 3.1415926535 * (4 / 3) * size * size * size;
    }

    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Get information using super
    //Input: Console c
    //Output: N/A
    public void get (Console c)
    {
	super.get (c);
    }
    
    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Print information of object to console
    //Input: None
    //Output: string
    public String stats ()
    {
	DecimalFormat df = new DecimalFormat ("#.###");
	volume ();
	sArea ();
	String output = "";
	output = output + "\n Sphere \n";
	output = output + "Colour: " + colour + "\n";
	output = output + "Radius length: " + size + "\n";
	output = output + "Coordinates: (" + x + "," + y + ")" + "\n";
	output = output + "Volume: " + df.format (volume) + "\n";
	output = output + "Surface Area: " + df.format (sArea);
	return output;
    }
}

//Author: Aarush Modi
//Date: December 31, 2021
//Purpose: Create and manage 2D shapes
//Data Fields: ShapeObj, volume, sArea
//Methods: ShapeObj, sArea, Volume, get(super)
class Tetrahedron extends D3shape
{
    public Tetrahedron (int size, int x, int y, String colour)
    {
	this.size = size;
	this.x = x;
	this.y = y;
	this.colour = colour;
    }


    public Tetrahedron ()
    {
	this (1, 100, 100, "red");
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: area method
    //Input: N/A
    //Output: N/A
    public void sArea()
    {
	this.sArea = Math.sqrt (3.0) * size * size;
    }

    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Abstract perimeter method
    //Input: N/A
    //Output: N/A
    public void volume ()
    {
	this.volume = (size * size * size) / (6 * Math.sqrt (2));
    }

    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Get information using super
    //Input: Console c
    //Output: N/A
    public void get (Console c)
    {
	super.get (c);
    }
    
    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Print information of object to console
    //Input: None
    //Output: string
    public String stats ()
    {
	DecimalFormat df = new DecimalFormat ("#.###");
	volume ();
	sArea ();
	String output = "";
	output = output + "\n Tetrahedron \n";
	output = output + "Colour: " + colour + "\n";
	output = output + "Side length: " + size + "\n";
	output = output + "Coordinates: (" + x + "," + y + ")" + "\n";
	output = output + "Volume: " + df.format (volume) + "\n";
	output = output + "Surface Area: " + df.format (sArea);
	return output;
    }
}

//Author: Aarush Modi
//Date: December 31, 2021
//Purpose: Create and manage 2D shapes
//Data Fields: ShapeObj, volume, sArea
//Methods: ShapeObj, sArea, Volume, get(super)
class Cube extends D3shape
{
    public Cube (int size, int x, int y, String colour)
    {
	this.size = size;
	this.x = x;
	this.y = y;
	this.colour = colour;
    }


    public Cube ()
    {
	this (1, 100, 100, "red");
    }


    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: area method
    //Input: N/A
    //Output: N/A
    public void sArea()
    {
	this.sArea = size * size * 6;
    }

    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Abstract perimeter method
    //Input: N/A
    //Output: N/A
    public void volume ()
    {
	this.volume = size * size * size;
    }

    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Get information using super
    //Input: Console c
    //Output: N/A
    public void get (Console c)
    {
	super.get (c);
    }
    
    //Author: Aarush Modi
    //Date: December 15, 2021
    //Purpose: Print information of object to console
    //Input: None
    //Output: string
    public String stats ()
    {
	DecimalFormat df = new DecimalFormat ("#.###");
	volume ();
	sArea ();
	String output = "";
	output = output + "\n Sphere \n";
	output = output + "Colour: " + colour + "\n";
	output = output + "Side length: " + size + "\n";
	output = output + "Coordinates: (" + x + "," + y + ")" + "\n";
	output = output + "Volume: " + df.format (volume) + "\n";
	output = output + "Surface Area: " + df.format (sArea);
	return output;
    }
}
