/**
 * Mitchell Suleymanov
 * CSCI 313
 * Assignment2.java
 *
 *
 */
import java.util.Scanner; 

class Assignment2 {
    
    public static void main(String[] args) {
    	
    	Scanner reader = new Scanner(System.in);  
    	System.out.println("Enter the name of the maze file. ");
    	String fileName = reader.nextLine();
    	
		Maze m = new Maze(fileName); //constructs maze object from file name.
		//System.out.println(m.toString()); //prints out the maze's toString
		
		m.findPath();
		m.findPath();
		
		
		reader.close();
    }
}
