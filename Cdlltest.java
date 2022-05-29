// Author: Aarush Modi
// Date: Jan 25, 2022
// Purpose: Circular double linked list class
import java.awt.*;
import java.text.*;
import hsa.Console;

public class Cdlltest
{
    static Console c;
    public static void main (String[] args)
    {
	c = new Console ();
	c.println ("Enter the size of the list");
	int numberOfElements = c.readInt();
	CircularList test = new CircularList (numberOfElements);
	c.println(test.toStringLeft());
	c.println("Enter the location of the node you want to insert to");
	int intInsert = c.readInt();
	c.println("Enter the value of the node you want to insert");
	int intValue = c.readInt();
	test.insertLeft(intInsert,intValue);
	c.println(test.toStringLeft());
	c.println("Enter value you would like to delete");
	int intDelete = c.readInt();
	test.delete(intDelete);
	c.println(test.toStringLeft());
    } // MAIN method
} // Cdlltest class

// Author: Aarush Modi
// Date: Jan 25, 2022
// Purpose: Node class for linked list
// Elements: int data, Node next, Node prev
class Node
{
    int data;
    Node next;
    Node prev;
    
    public Node(int inpt)
    {
	this.data = inpt;
    }
}

// Author: Aarush Modi
// Date: Jan 25, 2022
// Purpose: Linked list class double circle
// Elements: Node header
// Methods: delete(inpt), insertLeft(inpt, value), toStringLeft(), toStringRight()
class CircularList
{
    Node header;
    
    public CircularList(int inpt)
    {
	Node currNode = null;
	this.header = new Node (inpt);
	header.prev = header;
	header.next = header;
	if(inpt > 0)
	{
	    header.next = new Node ((int) (Math.random () * inpt));
	    header.next.prev = header;
	    header.next.next = header;
	    header.prev = header.next;
	    currNode = header.next;
	    for (int i = 1 ; i < inpt ; i++)
	    {
		currNode.next = new Node ((int) (Math.random () * inpt + 1));
		currNode.next.prev = currNode;
		currNode.next.next = header;
		header.prev = currNode.next;
		currNode = currNode.next;
	    }
	}
    }
    
    // Author: Aarush Modi
    // Date: Jan 25, 2022
    // Purpose: Delete a node
    // Input: int(inpt)
    // Output: N/A 
    public void delete(int inpt)
    {
	Node currNode = header;
	for(int i = 0; i < header.data; i++)
	{
	    currNode = currNode.next;
	    if(currNode.data == inpt)
	    {
		currNode.next.prev = currNode.prev;
		currNode.prev.next = currNode.next;
		header.data = header.data -1;
		i = header.data;
	    }
	}
    }
    
    // Author: Aarush Modi
    // Date: Jan 25, 2022
    // Purpose: insert to the left of a node
    // Input: int(inpt), int(value)
    // Output: N/A 
    public void insertLeft(int inpt, int value)
    {
	boolean done = false;
	Node currNode = header.next;
	for(int i = 0; i < header.data; i++)
	{
	    currNode = currNode.next;
	    if(currNode.data == inpt)
	    {
		currNode.prev.next = new Node (value);
		currNode.prev.next.prev = currNode.prev;
		currNode.prev.next.next = currNode;
		currNode.prev = currNode.prev.next;
		header.data++;
		done = true; 
		i = header.data;
	    }
	}
	if(done == false)
	{   
	    header.prev.next = new Node (value);
	    header.prev.next.prev = currNode.prev;
	    header.prev.next.next = currNode;
	    header.prev = currNode.prev.next;
	    header.data++;
	}
    }
    
    // Author: Aarush Modi
    // Date: Jan 25, 2022
    // Purpose: Creates a string of the list values going left
    // Input: N/A
    // Output: N/A 
    public String toStringLeft ()
    {
	String oupt = "[" + header.prev.data;
	Node currNode = header.prev;
	for (int i = 1 ; i < header.data ; i++)
	{
	    currNode = currNode.prev;
	    oupt = oupt + ",";
	    oupt = oupt + currNode.data;
	}
	oupt = oupt + "]";
	oupt = oupt + "(" + header.data + ")";
	return oupt;
    }
    
    // Author: Aarush Modi
    // Date: Jan 25, 2022
    // Purpose: Creates a string of the list values going right
    // Input: N/A
    // Output: N/A 
    public String toStringRight ()
    {
	String oupt = "[" + header.next.data;
	Node currNode = header.next;
	for (int i = 1 ; i < header.data ; i++)
	{
	    currNode = currNode.next;
	    oupt = oupt + ",";
	    oupt = oupt + currNode.data;
	}
	oupt = oupt + "]";
	oupt = oupt + "(" + header.data + ")";
	return oupt;
    }
}

