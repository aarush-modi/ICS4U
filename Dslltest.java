// Author: Aarush Modi
// Date: January 25, 2022
// Purpose: Create a double sorted linked list class
import java.awt.*;
import java.lang.*;
import hsa.Console;

public class Dslltest
{
    static Console c;
    public static void main (String[] args)
    {
	c = new Console ();
	DoubleSortedLinkedList test = new DoubleSortedLinkedList ();
	int number = 0;
	String string = "";
	char inpt = 'z';
	while (inpt != 'q')
	{
	    c.println ("If you would like to add to the linked list press 'a'");
	    c.println ("If you would like to find an integer from the linked list press 'i'");
	    c.println ("If you would like to find a string from the linked list press 's'");
	    c.println ("If you would like to quit the program press 'q'");
	    inpt = c.readChar();
	    if (inpt == 'a')
	    {
		c.println("What string would you like to add?");
		string = c.readLine();
		c.println("What integer would you like to add?");
		number = c.readInt();
		test.insert(string, number);
	    }
	    else if (inpt == 'i')
	    {
		c.println("What integer would you like to find?");
		number = c.readInt();
		if(test.find(number) != null)
		{
		    c.println("The string is: " + test.find(number).name + " and the number is: " + test.find(number).number);
		}
		else
		{
		    c.println("Number not found");
		}
	    }
	    else if (inpt == 's')
	    {
		c.println("What string would you like to find?");
		string = c.readLine();
		if(test.find(string) != null)
		{
		    c.println("The string is: " + test.find(string).name + " and the number is: " + test.find(string).number);
		}
		else
		{
		    c.println("String not found");
		}
	    }
	}
    } // main method
} // Dslltest class

// Author: Aarush Modi
// Date: Jan 26, 2022
// Purpose: Nodes for linked list class
// Elements: String name, int number, Node nextName, Node nestNumber
// Methods: byName(), byNumber()
class Node
{
    String name;
    int number;
    Node nextName;
    Node nextNumber;
    
    public Node(String string, int digit)
    {
	this.name = string;
	this.number = digit;
	nextName = null;
	nextNumber = null;
    }
    
    // Author: Aarush Modi
    // Date: Jan 26, 2022
    // Purpose: return a string created with the current name and number + the next Names's byName(or Number)
    // Input: N/A
    // Output: String mentioned above^^
    public String byName()
    {
	String oupt = "";
	oupt = oupt + name + " " + number + " ;";
	if (nextName != null)
	{
	    oupt = oupt + nextName.byName ();
	}
	return oupt;
    }   
    
    // Author: Aarush Modi
    // Date: Jan 26, 2022
    // Purpose: return a string created with the current name and number + the next Names's byName(or Number)
    // Input: N/A
    // Output: String mentioned above^^ 
    public String byNumber()
    {
	String oupt = "";
	oupt = oupt + name + " " + number + " ;";
	if (nextNumber != null)
	{
	    oupt = oupt + nextNumber.byNumber ();
	}
	return oupt;
    }  
}

// Author: Aarush Modi
// Date: Jan 26, 2022
// Purpose: linked list class sorted double
// Elements: Node listName, Node listNumber
// Methods: byName(), byNumber(),findBefore(String before), findBefore(int before), insert(String string, int digit), find(String find), find(int find)
class DoubleSortedLinkedList
{
    Node listName;
    Node listNumber;
    
    public DoubleSortedLinkedList()
    {
	listName = null;
	listNumber = null;
    }
    
    // Author: Aarush Modi
    // Date: Jan 26, 2022
    // Purpose: Give listName through name
    // Input: N/A
    // Output: String mentioned aboved^^
    String byName()
    {
	String oupt = listName.byName();
	return oupt;
    }
    
    // Author: Aarush Modi
    // Date: Jan 26, 2022
    // Purpose: Give listName through number
    // Input: N/A
    // Output: String mentioned aboved^^
    String byNumber()
    {
	String oupt = listName.byNumber();
	return oupt;
    }
    
    // Author: Aarush Modi
    // Date: Jan 26, 2022
    // Purpose: find node before given string
    // Input: String before
    // Output: Node mentioned aboved^^
    public Node findBefore(String before)
    {
	Node currNode = listName;
	Node oupt = null;
	if(listName == null || before.compareTo(currNode.name) < 0)
	{
	    oupt = null;
	}
	else
	{   
	    while(currNode.nextName != null && before.compareTo(currNode.nextName.name) > 0)
	    {
		currNode = currNode.nextName;
	    }
	    oupt = currNode;
	}
	return oupt;   
    }
    
    // Author: Aarush Modi
    // Date: Jan 26, 2022
    // Purpose: find node before given int
    // Input: int before
    // Output: Node mentioned aboved^^
    public Node findBefore(int before)
    {
	Node currNode = listNumber;
	Node oupt = null;
	if(listNumber == null || before <= currNode.number)
	{
	    oupt = null;
	}
	else
	{   
	    while(currNode.nextNumber != null && before > currNode.nextNumber.number)
	    {
		currNode = currNode.nextName;
	    }
	    oupt = currNode;
	}
	return oupt;   
    }
    
    // Author: Aarush Modi
    // Date: Jan 26, 2022
    // Purpose: insert a node
    // Input: String string, int digit
    // Output: N/A
    public void insert(String string, int digit)
    {
	Node currentNumber = findBefore (digit);
	Node currentName = findBefore (string);
	Node insert = new Node (string, digit);
	if(currentName == null)
	{
	    insert.nextName = listName;
	    listName = insert;
	}
	else
	{
	    insert.nextName = currentName.nextName;
	    currentName.nextName = insert;
	}
	if(currentNumber == null)
	{
	    insert.nextNumber = listNumber;
	    listNumber = insert;
	}
	else
	{
	    insert.nextNumber = currentName.nextNumber;
	    currentNumber.nextNumber = insert;
	}
    }
    
    // Author: Aarush Modi
    // Date: Jan 26, 2022
    // Purpose: find node given string
    // Input: String find
    // Output: Node mentioned aboved^^
    public Node find(String find)
    {
	Node currNode = findBefore(find);
	Node found = null;
	if (listName == null)
	{
	    found = null;
	}
	else if(find.equals(listName.name))
	{
	    found = listName;
	}
	else if (currNode != null && currNode.nextName != null && find.equals(currNode.nextName.name))
	{
	    found = currNode.nextNumber;
	}
	return found;
    }
    
    // Author: Aarush Modi
    // Date: Jan 26, 2022
    // Purpose: find node before given int
    // Input: int find
    // Output: Node mentioned aboved^^
    public Node find(int find)
    {
	Node currNode = findBefore(find);
	Node found = null;
	if (listName == null)
	{
	    found = null;
	}
	else if (find == listName.number)
	{
	    found = listName;
	}
	else if(currNode != null && currNode.nextNumber != null && find == currNode.nextNumber.number)
	{
	    found = currNode.nextNumber;
	}
	return found;
    }
}































