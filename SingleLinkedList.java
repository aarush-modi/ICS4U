// // Author: Aarush Modi
// // Date: Jan 21,2022
// // Purpose: Singly Linked List class to handle a non-sorted single linked list of Strings
import java.awt.*;
import java.io.*;
import hsa.Console;

public class SingleLinkedList
{
    static Console c;
    public static void main (String[] args) throws CloneNotSupportedException
    {
	c = new Console ();
	//Intergrated to work with a list of names in which one is jason, and last one is nicolette
	SinglyLinkedList test = new SinglyLinkedList ();
	test.createUserList (c);
	test.selfOrganizingSearch("jason"));
	c.println (test.toString);
	test.printOdd(c));
    } // main method
} // SingleLinkedList class

// Author: Aarush Modi
// Date: Jan 25, 2022
// Purpose: Singly Linked List Class
// Elements: Node head, int numberOfStrings
// Methods: createUserList(Console c), isEmpty(), clone(), toString(), find(String strFind), insert(String insert, String before), delete(strFind), printOdd(Console c), selfOrganizingSearch (String strFind), concatenate(SinglyLinkedList inpt)
class SinglyLinkedList
{
    Node head;
    int numberOfStrings;

    public SinglyLinkedList ()
    {
	head = null;
    }

    // Author: Aarush Modi
    // Date: Jan 25, 2022
    // Purpose: Create list with user Input
    // Input: Console c
    // Output: N/A
    public void createUserList (Console c)
    {
	String temp = "";

	c.println ("How many strings would you like to handle?");
	numberOfStrings = c.readInt ();
	Node currNode = null;
	for (int i = 0 ; i < numberOfStrings ; i++)
	{
	    c.println ("Enter string number " + (i + 1) + ":");
	    temp = c.readString ();
	    if (i == 0)
	    {
		head = new Node (temp);
		currNode = head;
	    }
	    else
	    {
		currNode.next = new Node (temp);
		currNode = currNode.next;
	    }

	}
    }
    
    // Author: Aarush Modi
    // Date: Jan 25, 2022
    // Purpose: check if list is null
    // Input: N/A
    // Output: Boolean if it is empty
    public boolean isEmpty ()
    {
	boolean empty = false;
	if (head == null)
	{
	    empty = true;
	}
	return empty;
    }
    
    // Author: Aarush Modi
    // Date: Jan 25, 2022
    // Purpose: deep clone list
    // Input: N/A
    // Output: Object deep clone
    public Object clone () throws CloneNotSupportedException
    {
	SinglyLinkedList newObject = (SinglyLinkedList) super.clone ();
	if (head != null)
	    newObject.head = (Node) head.clone ();
	else
	    newObject.head = null;
	return newObject;
    }
    
    // Author: Aarush Modi
    // Date: Jan 25, 2022
    // Purpose: Strig the list
    // Input: N/A
    // Output: String of list
    public String toString ()
    {
	String s = head.toString();
	return s;
    }
    
    // Author: Aarush Modi
    // Date: Jan 25, 2022
    // Purpose: find node given string
    // Input: N/A
    // Output: Node object mentioned above^^
    public Node find(String strFind)
    {
	Node currNode = head;
	if (numberOfStrings <= 1)
	{
	    return null;
	}
	else
	{
	    while (currNode.next != null && strFind.compareTo (currNode.next.data) > 0)
		currNode = currNode.next;
	}
	return currNode;
    }
    
    // Author: Aarush Modi
    // Date: Jan 25, 2022
    // Purpose: insert node given location and value
    // Input: String strInsert, String strBefore
    // Output: N/A
    public void insert (String strInsert, String strBefore) throws CloneNotSupportedException
    {
	Node currNode = find (strBefore);
	Node newNode = new Node (strInsert);
	if (currNode == null)
	{
	    Node temp = new Node("");
	    temp = head;
	    while(temp.next != null)
		temp = temp.next;
	    temp.next = newNode;
	}
	else
	{
	    newNode.next = currNode.next;
	    currNode.next = newNode;
	}
    }
}

    // Author: Aarush Modi
    // Date: Jan 25, 2022
    // Purpose: Delete a node given a string
    // Input: String strFind
    // Output: Boolean if it was deleated or not
    public boolean delete (String strFind)
    {
	Node currNode = find (strFind);
	boolean deleted = false;
	if (isEmpty ())
	    deleted = false;
	else if (info == head.data)
	{
	    head = head.next;
	    deleted = true;
	}
	else if (currNode != null && currNode.next != null && strFind == currNode.next.data)
	{
	    currNode.next = currNode.next.next;
	    deleted = true;
	}
	return deleted;
    }

    // Author: Aarush Modi
    // Date: Jan 25, 2022
    // Purpose: Print the odd numbers of the list
    // Input: Console c
    // Output: N/A
    public String printOdd (Console c)
    {
	Node currNode = head;
	for (int i = 0 ; i < numberOfStrings ; i = i + 2)
       {
	    if (i % 2 == 0)
	    {
		c.print (currNode.data + ", ");
	    }
	    if (currNode.next != null)
	    {
		currNode = currNode.next;
	    }
	 
    }
    
    // Author: Aarush Modi
    // Date: Jan 25, 2022
    // Purpose: Search for an element and move it to the front given the data
    // Input: String strFind
    // Output: The Node that was searched for
    public Node selfOrganizingSearch (String strFind)
    {
	Node currNode = find (strFind).next;
	if (currNode != null)
	{
	    find (strFind).next = find (strFind).next.next;
	    currNode.next = head;
	    head = currNode;
	}

	return currNode;
    }
    
    // Author: Aarush Modi
    // Date: Jan 25, 2022
    // Purpose: concatonate two lists
    // Input: SinglyLinkedList inpt
    // Output: The new list that was created    
    public SinglyLinkedList concatenate(SinglyLinkedList inpt) throws CloneNotSupportedException
    {
	SinglyLinkedList oupt = new SinglyLinkedList();
	oupt.head = (Node) head.clone();
	Node currNode = inpt.head;
	for(int i = 0; i < inpt.numberOfStrings; i++)
	{
	    oupt.insert(currNode.data, "nicolette");
	    currNode = currNode.next;
	}
	return oupt;
    }
}

class Node implements Cloneable
{
    public String data;
    public Node next;
    public Node (String info)
    {
	data = info;
	next = null;
    }


    public Object clone ()
	throws CloneNotSupportedException
    {
	Node newObject = (Node) super.clone ();
	if (next == null)
	    newObject.next = null;
	else
	    newObject.next = (Node) next.clone ();
	return newObject;
    }


    public String toString ()
    {
	String s = "";
	s = s + data + " ";
	if (next != null)
	    s = s + next.toString ();
	return s;
    }
}

