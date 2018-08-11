import java.util.Iterator;

public class Vertex
{
  private String name; //name of the Vertex
  private int x;       //x coordinate
  private int y;       //y coordinate
  private DoublyLinkedList<Edge> edges; //Doubly Linked List of Edges the Vertex has

  //Constructor
  public Vertex(String n, int xCoord, int yCoord)
  {
  	name = n;
  	x = xCoord;
  	y = yCoord;
  	edges = new DoublyLinkedList<Edge>();
  }
  
  //set method for name
  public void setName(String n)
  {
  	name = n;
  }

  //get method for name
  public String getName()
  {
  	return name;
  }
  
  //set method for x coordinate value
  public void setXCoord(int xCoord)
  {
  	x = xCoord;
  }

  //get method for x coordinate value
  public int getXCoord()
  {
  	return x;
  }

  //set method for y coordinate value
  public void setYCoord(int yCoord)
  {
  	y = yCoord;
  }
  
  //get method for y coordinate value
  public int getYCoord()
  {
  	return y;
  }

  //adds edge to Vertex. Stores the edge in the Doubly Linked List edges
  public void addEdge(Edge e)
  {
  	edges.add(e);
  }
  
  //returns iterator object for the doubly linked list edges
  public Iterator<Edge> getEdgesIterator()
  {
  	return edges.iterator();
  }
}
