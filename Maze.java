import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Maze
{
  private DoublyLinkedList<Vertex> pathSolution; // path solution for path finder
  private Vertex[] rooms; //array of Vertex, or rooms

  public Maze(String filename) //receives filename from main 
  {		
	  int size; //for size of array
      int edgeFROM=0, edgeTO=0;
      
      
	  File file = new File(filename); //creates File object
 	  
      try {
          	Scanner sc = new Scanner(file); //creates Scanner object to read file  
          	size = sc.nextInt(); //receives the size for the array of vertices 
              
              rooms = new Vertex[size]; //creates an array of Vertex objects 
              
              
              for(int i=0;i<size;i++)  //scans the first n lines of the file and creates n Vertex objects
              {	
              	Vertex room = new Vertex(sc.next(), sc.nextInt(), sc.nextInt()); 
              	rooms[i]=room;
              }
          
              sc.nextLine(); //skips empty line between vertices and edges
              
              edgeFROM = sc.nextInt(); //gets the integer value for the Vertex in rooms[] to have the edge
          	  edgeTO = sc.nextInt(); //gets the integer value for the Edge object
              
              while((edgeFROM !=-1) && (edgeTO!=-1)) //if both are -1, then the file has reached the end of the maze data
              {
              	Edge edge = new Edge(edgeTO); //creates a new Edge object
              	rooms[edgeFROM].addEdge(edge); //adds the Edge object to the correct Vertex object in the Vertex array 

              	edgeFROM = sc.nextInt(); //obtains next integer for the Vertex array index
              	edgeTO = sc.nextInt(); //obtains next integer for the Edge object 

              }
              
              	
          sc.close();
      } 
      catch (FileNotFoundException e) {
          e.printStackTrace();
      }
      
    
  }
  
  //returns the array of rooms
  public Vertex[] getRooms()
  {
  	return rooms;
  }

  //toString to print out the maze in a similar format to the .maze file
  public String toString()
  {
  	String mazeString = "" + rooms.length + "\n"; //mazeString will be the string returned
	
  	//adds the Vertex name, x coordinate, and y coordinate on one line per Vertex object to the mazeString
  	for(int i=0; i<rooms.length;i++)
  	{
  		mazeString+= rooms[i].getName() + " " + rooms[i].getXCoord() + " " + rooms[i].getYCoord() + "\n"; 
  	}
  	
  	mazeString+= "\n"; //adds new line to mazeString to reduce clutter between Vertices and Edges
  	
  	//Iterates through Vertex Edges, returning Edge object and then its adjacent vertex
  	for(int i=0;i<rooms.length;i++)
		{
			Iterator<Edge> it = rooms[i].getEdgesIterator();
  			
  			while(it.hasNext())
  			{ mazeString+= i + " " + it.next().getAdjacentVertex() + "\n"; }  	
		}
  	
  	return mazeString;
  	
  }
  
  //Finds the solution path of the maze file.
  public void findPath()
  {
	  //if pathSolution already has a solution, then print it.
	  if(pathSolution !=null)
	  {
		  System.out.println("Path already exists.");
		  printPath(pathSolution);
		  return;
	  }
	  
	  //if pathSolution is empty, this will get the path solution from the maze.
	  Boolean[] visited = new Boolean[rooms.length];       //declares boolean array visited
	  Arrays.fill(visited, false);                         //sets all values in visited to false
	  pathSolution = new DoublyLinkedList<Vertex>();
	  pathSolution.clear(); 
	  
	  
	  for(int i=0; i<rooms.length; i++)
	  {
		  if(!visited[i])
		  {
			 dfs(i, rooms.length-1, visited);
			  
		  }
	  }
	  
	  //Check if the path from the start to the end existed. If not, sets the path to null.
	  //For condition to be true, the X and Y coordinates of the last vertex in pathSolution and the last vertex in rooms[] must match.
	  //This is true because no two distinct vertices have the same X and Y Coordinates.
	  int i = pathSolution.size()-1;
	  if((pathSolution.get(i).getXCoord() == rooms[rooms.length-1].getXCoord()) && (pathSolution.get(i).getXCoord() == rooms[rooms.length-1].getXCoord()))
	  {
		  printPath(pathSolution);  
	  }
	  else
	  {
		  System.out.println("Path was not found. There is no solution.");
		  pathSolution.clear();
		  pathSolution= null;
	  }
	  
	  
	  
  }
  
  //Depth First Search of the maze file to find the solution. Returns the Doubly Linked List of the solution
  //Parameters are the start node, the end node, and a boolean array of nodes visited. 
  private DoublyLinkedList<Vertex> dfs(int start, int end, Boolean[] visited)
  {	
	  	int adjacentVertex;
	    
	    visited[start]=true;
	   
		//Base case. If the end is reached, then we add it.
	    if(start == end)
		   {
			   pathSolution.add(rooms[start]);
			   return pathSolution;   
		   }
	    else{
	    // Recursive Part is here
	    	for (Iterator<Edge> it = rooms[start].getEdgesIterator(); it.hasNext();) 
			{
				adjacentVertex =it.next().getAdjacentVertex(); //stores Adjacent Vertex index value 
				
				if(visited[adjacentVertex]==false)
					{   
						if( (dfs(adjacentVertex, rooms.length-1, visited)==null)&&(!it.hasNext()) ) 
								{return null;}
					}

			}
	    }
	    
	    //If a leaf node is reached, then return null
	    	Iterator<Edge> it = rooms[start].getEdgesIterator();
	    	if(!it.hasNext())
	    		{ 
	    			return null;
	    		}
	    	else
	    	{
	    		pathSolution.add(0, rooms[start]);
	    		return pathSolution;
	    	}
	    
	    
  }
 
  //prints path solution using the Doubly Linked List pathSolution
  private void printPath(DoublyLinkedList<Vertex> solution)
  {
	  Vertex v; //temp Vertex
	  
	  System.out.println("The path solution is: ");
	  for(int i=0;i<solution.size();i++)
	  {	  v=solution.get(i);	
		  System.out.println(v.getName() + " " + v.getXCoord() + " " + v.getYCoord());
	  }
  }


}


