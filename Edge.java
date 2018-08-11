public class Edge
{
  private int adjacentVertex; //What vertex the edge points to
  
  //Constructor
  public Edge(int w)
  {
  	adjacentVertex = w;
  }

  //set method for edge
  public void setAdjacentVertex(int i)
  {
  	adjacentVertex = i;
  }
  
  //get method for edge
  public int getAdjacentVertex()
  {
  	return adjacentVertex;
  }
}
