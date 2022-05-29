//Author: Aarush Modi
//Date: October 15, 2021
//Purpose: To create a scrabble enviorment
import java.awt.*;
import hsa.Console;

public class Scrabble
{
    static Console c;
    public static void main (String[] args)
    {
	c = new Console ();
	boolean loop = true;
	while (loop == true)
	{
	    ScrabbleHand hand = new ScrabbleHand ();
	    hand.print (c, 50, 50);
	    Font u = new Font ("Arial", Font.PLAIN, 30);
	    c.setFont (u);
	    c.drawString ("Press any key to continue",50,170 );
	    c.getChar();
	    c.clear();
	}

    }
}

// Author: Aarush Modi
// Date: October 9, 2021
// Purpose: To create scrabble tiles
// Data Fields: Letter(char)
// Methods: value, toString, print
class Tile
{// Open Tile Class
    public char letter;
    // Author: Aarush Modi
    // Date: October 15, 2021
    // Purpose: Constructor
    // Inputs: N/A
    // Outputs: N/A
    // Requires: N/A
    public Tile(String x)
    {
	if(x.length() == 1)
	{
	    this.letter = Character.toUpperCase(x.charAt(0));
	}
    }
    /*****************************************************/
    // Author: Aarush Modi
    // Date: October 15, 2021
    // Purpose: Constructor
    // Inputs: N/A
    // Outputs: N/A
    // Requires: N/A
    public Tile()
    {
	int random = (int)(Math.random()*26+65);
	this.letter = (char)random;
    }
    /*****************************************************/
    // Author: Aarush Modi
    // Date: October 15, 2021
    // Purpose: To find the value of the letter
    // Inputs: N/A
    // Outputs: Value of letter
    // Requires: N/A
    public int value()
    {
	int value = 0;
	if (Character.toLowerCase (letter) == 'a')
	{
	    value = 1;
	}
	else if (Character.toLowerCase (letter) == 'b')
	{
	    value = 3;
	}
	else if (Character.toLowerCase (letter) == 'c')
	{
	    value = 3;
	}
	else if (Character.toLowerCase (letter) == 'd')
	{
	    value = 2;
	}
	else if (Character.toLowerCase (letter) == 'e')
	{
	    value = 1;
	}
	else if (Character.toLowerCase (letter) == 'f')
	{
	    value = 4;
	}
	else if (Character.toLowerCase (letter) == 'g')
	{
	    value = 2;
	}
	else if (Character.toLowerCase (letter) == 'h')
	{
	    value = 4;
	}
	else if (Character.toLowerCase (letter) == 'i')
	{
	    value = 1;
	}
	else if (Character.toLowerCase (letter) == 'j')
	{
	    value = 8;
	}
	else if (Character.toLowerCase (letter) == 'k')
	{
	    value = 5;
	}
	else if (Character.toLowerCase (letter) == 'l')
	{
	    value = 1;
	}
	else if (Character.toLowerCase (letter) == 'm')
	{
	    value = 3;
	}
	else if (Character.toLowerCase (letter) == 'n')
	{
	    value = 1;
	}
	else if (Character.toLowerCase (letter) == 'o')
	{
	    value = 1;
	}
	else if (Character.toLowerCase (letter) == 'p')
	{
	    value = 3;
	}
	else if (Character.toLowerCase (letter) == 'q')
	{
	    value = 10;
	}
	else if (Character.toLowerCase (letter) == 'r')
	{
	    value = 1;
	}
	else if (Character.toLowerCase (letter) == 's')
	{
	    value = 1;
	}
	else if (Character.toLowerCase (letter) == 't')
	{
	    value = 1;
	}
	else if (Character.toLowerCase (letter) == 'u')
	{
	    value = 1;
	}
	else if (Character.toLowerCase (letter) == 'v')
	{
	    value = 4;
	}
	else if (Character.toLowerCase (letter) == 'w')
	{
	    value = 4;
	}
	else if (Character.toLowerCase (letter) == 'x')
	{
	    value = 8;
	}
	else if (Character.toLowerCase (letter) == 'y')
	{
	    value = 4;
	}
	else if (Character.toLowerCase (letter) == 'z')
	{
	    value = 10;
	}
	return value;
    }
    /*****************************************************/
    // Author: Aarush Modi
    // Date: October 15, 2021
    // Purpose: To create a string of the letter
    // Inputs: N/A
    // Outputs: N/A
    // Requires: N/A
    public String toString()
    {
	String lttr = Character.toString(letter);
	return lttr;
    }
    /*****************************************************/
    // Author: Aarush Modi
    // Date: October 15, 2021
    // Purpose: To print a tile
    // Inputs: x and y coordinates
    // Outputs: N/A
    // Requires: toString(), value()
    public void print(Console c, int x, int y)
    {
	c.setPaintMode();
	c.setColor(Color.yellow);
	c.fill3DRect(x,y,75,75,true);
	c.setColor(Color.black);
	Font f = new Font ("Arial", Font.PLAIN, 50);
	c.setFont(f);
	c.drawString(toString(), x + 15, y + 50);
	f = new Font("Arial", Font.BOLD, 12);
	c.setFont(f);
	c.drawString(Integer.toString(value()), x + 50, y + 60);
    }
}// Close Tile Class


//Author: Aarush Modi
//Date: October 16, 2021
//Purpose: Create a Scrabble hand class
//Data Fields: tile1, tile2, tile3, tile4, tile5
//Methods: Value, toString, print

class ScrabbleHand 
{
    static Tile tile1;
    static Tile tile2;
    static Tile tile3;
    static Tile tile4;
    static Tile tile5;
    
    //Author: Aarush Modi
    //Date: October 15, 2021
    //Purpose: Cronstructor
    //Input: N/A
    //Output: N/A
    //Requires: N/A
    public ScrabbleHand ()
    {
	this.tile1 = new Tile();
	this.tile2 = new Tile();
	this.tile3 = new Tile();
	this.tile4 = new Tile();
	this.tile5 = new Tile();
    }
    /*****************************************************/
    //Author: Aarush Modi
    //Date: October 15, 2021
    //Purpose: Constructor
    //Input: N/A
    //Output: N/A
    //Requires: N/A
    public ScrabbleHand(String strTile1, String strTile2, String strTile3, String strTile4, String strTile5)
    {
	boolean first = false;
	boolean second = false;
	boolean third = false;
	boolean fourth = false;
	boolean fifth = false;
	if (strTile1.toLowerCase() == "a" || strTile1.toLowerCase() == "b" || strTile1.toLowerCase() == "c" || strTile1.toLowerCase() == "d" || strTile1.toLowerCase() == "e" || strTile1.toLowerCase() == "f" || strTile1.toLowerCase() == "g" || strTile1.toLowerCase() == "h" || strTile1.toLowerCase() == "i" || strTile1.toLowerCase() == "j" || strTile1.toLowerCase() == "k" || strTile1.toLowerCase() == "l" || strTile1.toLowerCase() == "m" || strTile1.toLowerCase() == "n" || strTile1.toLowerCase() == "o" || strTile1.toLowerCase() == "p" || strTile1.toLowerCase() == "q" || strTile1.toLowerCase() == "r" || strTile1.toLowerCase() == "s" || strTile1.toLowerCase() == "t" || strTile1.toLowerCase() == "u" || strTile1.toLowerCase() == "v" || strTile1.toLowerCase() == "w" || strTile1.toLowerCase() == "x" || strTile1.toLowerCase() == "y" || strTile1.toLowerCase() == "z")
	{
	    first = true;
	}
	if (strTile2.toLowerCase() == "a" || strTile2.toLowerCase() == "b" || strTile2.toLowerCase() == "c" || strTile2.toLowerCase() == "d" || strTile2.toLowerCase() == "e" || strTile2.toLowerCase() == "f" || strTile2.toLowerCase() == "g" || strTile2.toLowerCase() == "h" || strTile2.toLowerCase() == "i" || strTile2.toLowerCase() == "j" || strTile2.toLowerCase() == "k" || strTile2.toLowerCase() == "l" || strTile2.toLowerCase() == "m" || strTile2.toLowerCase() == "n" || strTile2.toLowerCase() == "o" || strTile2.toLowerCase() == "p" || strTile2.toLowerCase() == "q" || strTile2.toLowerCase() == "r" || strTile2.toLowerCase() == "s" || strTile2.toLowerCase() == "t" || strTile2.toLowerCase() == "u" || strTile2.toLowerCase() == "v" || strTile2.toLowerCase() == "w" || strTile2.toLowerCase() == "x" || strTile2.toLowerCase() == "y" || strTile2.toLowerCase() == "z")
	{
	    second = true;
	}
	if (strTile3.toLowerCase() == "a" || strTile3.toLowerCase() == "b" || strTile3.toLowerCase() == "c" || strTile3.toLowerCase() == "d" || strTile3.toLowerCase() == "e" || strTile3.toLowerCase() == "f" || strTile3.toLowerCase() == "g" || strTile3.toLowerCase() == "h" || strTile3.toLowerCase() == "i" || strTile3.toLowerCase() == "j" || strTile3.toLowerCase() == "k" || strTile3.toLowerCase() == "l" || strTile3.toLowerCase() == "m" || strTile3.toLowerCase() == "n" || strTile3.toLowerCase() == "o" || strTile3.toLowerCase() == "p" || strTile3.toLowerCase() == "q" || strTile3.toLowerCase() == "r" || strTile3.toLowerCase() == "s" || strTile3.toLowerCase() == "t" || strTile3.toLowerCase() == "u" || strTile3.toLowerCase() == "v" || strTile3.toLowerCase() == "w" || strTile3.toLowerCase() == "x" || strTile3.toLowerCase() == "y" || strTile3.toLowerCase() == "z")
	{
	    third = true;
	}
	if (strTile4.toLowerCase() == "a" || strTile4.toLowerCase() == "b" || strTile4.toLowerCase() == "c" || strTile4.toLowerCase() == "d" || strTile4.toLowerCase() == "e" || strTile4.toLowerCase() == "f" || strTile4.toLowerCase() == "g" || strTile4.toLowerCase() == "h" || strTile4.toLowerCase() == "i" || strTile4.toLowerCase() == "j" || strTile4.toLowerCase() == "k" || strTile4.toLowerCase() == "l" || strTile4.toLowerCase() == "m" || strTile4.toLowerCase() == "n" || strTile4.toLowerCase() == "o" || strTile4.toLowerCase() == "p" || strTile4.toLowerCase() == "q" || strTile4.toLowerCase() == "r" || strTile4.toLowerCase() == "s" || strTile4.toLowerCase() == "t" || strTile4.toLowerCase() == "u" || strTile4.toLowerCase() == "v" || strTile4.toLowerCase() == "w" || strTile4.toLowerCase() == "x" || strTile4.toLowerCase() == "y" || strTile4.toLowerCase() == "z")
	{
	    fourth = true;
	}
	if (strTile5.toLowerCase() == "a" || strTile5.toLowerCase() == "b" || strTile5.toLowerCase() == "c" || strTile5.toLowerCase() == "d" || strTile5.toLowerCase() == "e" || strTile5.toLowerCase() == "f" || strTile5.toLowerCase() == "g" || strTile5.toLowerCase() == "h" || strTile5.toLowerCase() == "i" || strTile5.toLowerCase() == "j" || strTile5.toLowerCase() == "k" || strTile5.toLowerCase() == "l" || strTile5.toLowerCase() == "m" || strTile5.toLowerCase() == "n" || strTile5.toLowerCase() == "o" || strTile5.toLowerCase() == "p" || strTile5.toLowerCase() == "q" || strTile5.toLowerCase() == "r" || strTile5.toLowerCase() == "s" || strTile5.toLowerCase() == "t" || strTile5.toLowerCase() == "u" || strTile5.toLowerCase() == "v" || strTile5.toLowerCase() == "w" || strTile5.toLowerCase() == "x" || strTile5.toLowerCase() == "y" || strTile5.toLowerCase() == "z")
	{
	    fifth = true;
	}
	if (first == true && second == true && third == true && fourth == true && fifth == true)
	{
	    this.tile1 = new Tile(strTile1);
	    this.tile2 = new Tile(strTile2);
	    this.tile3 = new Tile(strTile3);
	    this.tile4 = new Tile(strTile4);
	    this.tile5 = new Tile(strTile5);
	}
	else
	{
	    this.tile1 = new Tile("a");
	    this.tile2 = new Tile("a");
	    this.tile3 = new Tile("a");
	    this.tile4 = new Tile("a");
	    this.tile5 = new Tile("a");
	}
    }
    
    /*****************************************************/
    //Author: Aarush Modi
    //Date: October 15, 2021
    //Purpose: Calculate the value of a hand
    //Input: N/A
    //Output: integer sum
    //Requires: N/A
    public static int calcValue()
    {
	int total = 0;
	total = total + tile1.value() + tile2.value() + tile3.value() + tile4.value() + tile5.value();
	return total;
    }
    /*****************************************************/
    //Author: Aarush Modi
    //Date: October 15, 2021
    //Purpose: find the string of the 5 letters
    //Input: N/A
    //Output: String of 5 letters
    //Requires: N/A
    public String toString()
    {
	String lttr;
	lttr = new String();
	lttr = (lttr + Character.toString(this.tile1.letter) + Character.toString(this.tile2.letter) + Character.toString(this.tile3.letter) + Character.toString(this.tile4.letter) + Character.toString(this.tile5.letter));
	return lttr;
    }
    /*****************************************************/
    //Author: Aarush Modi
    //Date: October 15, 2021
    //Purpose: Print the letters and total value
    //Input: x and y coordinates
    //Output: N/A
    //Requires: N/A
    public static void print (Console c, int x,int y)
    {
	tile1.print(c,x,y);
	tile2.print(c,x+65,y);
	tile3.print(c,x+135,y);
	tile4.print(c,x+200,y);
	tile5.print(c,x+270,y);
	Font f = new Font ("Arial", Font.PLAIN, 45);
	c.setFont (f);
	c.drawString("(" + Integer.toString(calcValue()) + ")", x+350,y+50);
    }
}

