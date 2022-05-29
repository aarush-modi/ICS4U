//Author: Aarush Modi
//Date: December 31, 2021
//Purpose: To test various sorting methods
import java.awt.*;
import hsa.Console;
import java.util.*;
import javax.swing.*;
public class Sort
{ //Open Main
    static Console c;
    public static void main (String[] args)
    {
	c = new Console ();
	int size = 100;
	String[] columnNames = {"Size", "Insertion", "Bubble", "Selection", "Quick"};
	String[] [] rowData = new String [10] [5];

	for (int i = 0 ; i < 10 ; i++)
	{
	    for (int j = 0 ; j < 5 ; j++)
	    {

		if (j == 0)
		{
		    rowData [i] [j] = Integer.toString (size);
		    size = size * 2;

		}
		else if (j == 1)
		{
		    long start, stop, timeTaken;
		    start = System.currentTimeMillis ();
		    SortMethods test = new SortMethods (size);
		    test.reset ();
		    test.insertionSort ();
		    stop = System.currentTimeMillis ();
		    timeTaken = stop - start;
		    rowData [i] [j] = Long.toString (timeTaken);
		}
		else if (j == 2)
		{
		    long start, stop, timeTaken;
		    start = System.currentTimeMillis ();
		    SortMethods test = new SortMethods (size);
		    test.reset ();
		    test.bubbleSort ();
		    stop = System.currentTimeMillis ();
		    timeTaken = stop - start;
		    rowData [i] [j] = Long.toString (timeTaken);
		}
		else if (j == 3)
		{
		    long start, stop, timeTaken;
		    start = System.currentTimeMillis ();
		    SortMethods test = new SortMethods (size);
		    test.reset ();
		    test.selectionSort ();
		    stop = System.currentTimeMillis ();
		    timeTaken = stop - start;
		    rowData [i] [j] = Long.toString (timeTaken);
		}


		else if (j == 4)
		{
		    long start, stop, timeTaken;
		    start = System.currentTimeMillis ();
		    SortMethods test = new SortMethods (size);
		    test.reset ();
		    test.quickSort (test.aClone, 0, size - 1);
		    stop = System.currentTimeMillis ();
		    timeTaken = stop - start;
		    rowData [i] [j] = Long.toString (timeTaken);
		}
	    }
	}
	final JFrame frame = new JFrame ("JTable Demo");

	JTable table = new JTable (rowData, columnNames);
	JScrollPane scrollPane = new JScrollPane (table);
	JLabel lblHeading = new JLabel ("Algorithm Runtime in MS");
	lblHeading.setFont (new Font ("Arial", Font.TRUETYPE_FONT, 24));

	frame.getContentPane ().setLayout (new BorderLayout ());

	frame.getContentPane ().add (lblHeading, BorderLayout.PAGE_START);
	frame.getContentPane ().add (scrollPane, BorderLayout.CENTER);

	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	frame.setSize (550, 200);
	frame.setVisible (true);

    } //Close Main
} // Sort class

//Author: Aarush Modi
//Date: December 15, 2021
//Purpose: To test various sorting methods
//Data fields: int[] original(holds the original array of random integers), int[] aClone(clone of orignial that sorting methods use), int size(size of original)
/*Methods: constructors()
reset() -clones original[] and puts it into aClone[]
resetWorst() -will initailize aClone[] to an inverted sorted array
toString() -Prints aClone[] into console
sorted() - returns true if aClone[] is sorted
bubbleSort() -bubble sorts aClone[]
selectionSort() -selection sorts aClone[]
insertionSort() -insertion sorts aClone[]
quickSort() -quick sorts aClone[]
partition() -partitions an array for quickSort() to reccurse*/

class SortMethods
{ //Open SortMethods
    public int[] original;
    public int[] aClone;
    public int size;

    public SortMethods (int size)
    { //Open Constructor
	this.size = size;
	this.original = new int [this.size];
	int randomNum = 0;
	for (int i = 0 ; i < this.size ; i++)
	{
	    randomNum = (int) (Math.random () * (this.size));
	    this.original [i] = randomNum;
	}
	aClone = new int [size];
    } //Close Constructor


    public SortMethods ()
    { //Open Constructor
	this (10);
    } //Close Constructor

    //Author: Aarush Modi
    //Date: December 31, 2021
    //Purpose: clones original[] and puts it into aClone[]
    //Input: N/A
    //Output: N/A
    public void reset ()
    { //Open reset
	for (int i = 0 ; i < size ; i++)
	{
	    aClone [i] = original [i];
	}
    } //Close reset

    //Author: Aarush Modi
    //Date: December 31, 2021
    //Purpose: will initailize aClone[] to an inverted sorted array
    //Input: N/A
    //Output: N/A
    public void resetWorst ()
    { //Open resetWorst
	insertionSort ();
	int[] temp = new int [size];
	int j = size;
	for (int i = 0 ; i < size ; i++)
	{
	    temp [j - 1] = aClone [i];
	    j = j - 1;
	}
    } //Close resetWorst

    //Author: Aarush Modi
    //Date: December 31, 2021
    //Purpose: Prints aClone[] into console
    //Input: Console c
    //Output: N/A
    public void toString (Console c)
    { //Open toString
	for (int i = 0 ; i < size ; i++)
	{
	    c.print (aClone [i] + "; ");
	}
    } //Close toString

    //Author: Aarush Modi
    //Date: December 31, 2021
    //Purpose: Returns true if aClone[] is sorted
    //Input: N/A
    //Output: Boolean if array is sorted
    public boolean sorted ()
    { //Open sorted
	boolean isSorted = false;
	for (int i = 0 ; i < size ; i++)
	{
	    if (aClone [i] < aClone [i + 1])
	    {
		isSorted = true;
		i = size;
	    }
	}
	return isSorted;
    } //Close sorted

    //Author: Aarush Modi
    //Date: December 31, 2021
    //Purpose: bubble sorts aClone[]
    //Input: N/A
    //Output: N/A
    public void bubbleSort ()
    { //Open bubbleSort
	int temp = 0;
	for (int i = 0 ; i < size - 1 ; i++)
	{
	    for (int j = 0 ; j < size - i - 1 ; j++)
	    {
		if (aClone [j] > aClone [j + 1])
		{
		    temp = aClone [j];
		    aClone [j] = aClone [j + 1];
		    aClone [j + 1] = temp;
		}
	    }
	}
    } //Close bubbleSort

    //Author: Aarush Modi
    //Date: December 31, 2021
    //Purpose: selection sorts aClone[]
    //Input: N/A
    //Output: N/A
    public void selectionSort ()
    { //Open selectionSort
	int minIndex = 0;
	int temp = 0;
	for (int i = 0 ; i < size - 1 ; i++)
	{
	    minIndex = i;
	    for (int j = i + 1 ; j < size ; j++)
	    {
		if (aClone [j] < aClone [minIndex])
		{
		    minIndex = j;
		}
	    }
	    temp = aClone [minIndex];
	    aClone [minIndex] = aClone [i];
	    aClone [i] = temp;
	}
    } //Close selectionSort

    //Author: Aarush Modi
    //Date: December 31, 2021
    //Purpose: insertion sorts aClone[]
    //Input: N/A
    //Output: N/A
    public void insertionSort ()
    { //Open insetionSort
	int key = 0;
	int temp = 0;
	for (int i = 1 ; i < size ; ++i)
	{
	    key = aClone [i];
	    temp = i - 1;
	    while (temp >= 0 && aClone [temp] > key)
	    {
		aClone [temp + 1] = aClone [temp];
		temp = temp - 1;
	    }
	    aClone [temp + 1] = key;
	}
    } //Close insetionSort

    //Author: Aarush Modi
    //Date: December 31, 2021
    //Purpose: quick sorts aClone[]
    //Input: N/A
    //Output: N/A
    public void quickSort (int arr[], int begin, int end)
    { //Open quickSort
	if (begin < end)
	{
	    int partitionIndex = partition (arr, begin, end);

	    quickSort (arr, begin, partitionIndex - 1);
	    quickSort (arr, partitionIndex + 1, end);
	}
    } //Close quickSort

    //Author: Aarush Modi
    //Date: December 31, 2021
    //Purpose: partitions an array for quickSort() to reccurse
    //Input: N/A
    //Output: N/A
    private int partition (int arr[], int begin, int end)
    { //Open partition
	int pivot = arr [end];
	int i = (begin - 1);

	for (int j = begin ; j < end ; j++)
	{
	    if (arr [j] <= pivot)
	    {
		i++;

		int swapTemp = arr [i];
		arr [i] = arr [j];
		arr [j] = swapTemp;
	    }
	}

	int swapTemp = arr [i + 1];
	arr [i + 1] = arr [end];
	arr [end] = swapTemp;

	return i + 1;
    } //Close Partition
} //Close SortMethods


