# CS313-Arrignment-2
Assignment 2 given in CS313: Data Structures

Mazes Assignment
Overview
Imagine it's the first day of classes and you're trying to find your way around the science building to SB 100. 
You're trying to make it to lecture on time so that your absolutely terrifying professor doesn't humiliate you in 
front of the entire class for being late. But you're lost! Corridors double back on themselves. The third floor of 
Remsen connects to the second floor of the science building. You decide to follow the corridor and it somehow leads 
you to the floor above, though you have no memory of climbing stairs. You're running out of food and water. If only 
you knew how to get to the science building cafe! In this totally plausible scenario, what do you do? You could 
strike out in random directions, bouncing off walls until you're lucky enough to get out and see your family again. 
Or you could be strategic. Pick a path, follow it until it either doubles back or reaches your destination. Do this 
with every possible path and, maybe by the end of the semester, you'll know a path to your lecture! Alternatively, 
you could use a computer to solve the maze for you, and have it show you the path to take.

======================================
Design

1. You will write a Maze data type that can read in .maze files, and print them out in the same format. A graph can 
represent a maze and there are many different ways to represent a graph in a computer program. You’ll use a simple 
data structure that works well when there are relatively few edges in the graph. You’ll store the vertices in an array 
rooms[], and refer to them by their index in the array. So vertex i means the vertex stored at rooms[i].

2. You will write a Vertex class. Each Vertex object stores a linked list of the edges leaving it. It also stores two 
ints, x and y, to indicate the position of the vertex/room in the maze and a string name for referring to it. The 
purpose of name is strictly descriptive. For example, this would be where you would store the name of a lecture hall.
Download the file Vertex.java for the framework for the Vertex class. You will write the code for all the methods. 
The code for the constructor, setter, and getter methods are straightforward. The method addEdge adds the edge to the 
end of the linked list edges. The method getEdgesIterator just returns an iterator for the linked list edges. You 
cannot add additional methods or any nested classes to the Vertex class.

3. You will write an Edge class. The data member edges of the Vertex class is a linked list of outgoing edges from 
that particular vertex. Each value in the linked list is an instance of the Edge class. Each Edge object in edges 
defines an outgoing edge from that particular vertex. Since we're storing the vertices in an array (rooms[]), an Edge 
object defining an edge only needs to contain the index of the vertex to which it is pointing in order to define an 
edge. Remember, this is a directed graph. You can make the corridors in your maze two-way by adding edges in each 
direction. If the edge is A to B, the Edge object defining this edge will be in the linked list of A and its target 
will be the index of B. Another way of thinking about this is that edges is just the list of vertices/rooms that can 
be reached directly from a vertex/room without going through any other vertex/room.
Download the file Edge.java for the framework for the Edge class. You will write the code for all the methods. The 
code for the constructor, setter, and getter methods are straightforward. You cannot add additional methods or any 
nested classes to the Edge class.

4. Download the files List.java and DoublyLinkedList.java for the doubly linked list class. You cannot modify any of 
the code for these two files. You cannot add additional methods or any nested classes to the DoublyLinkedList class.

5. You will write a Maze class. Download the file Maze.java for the framework for the Maze class. You will write the code 
for all the methods. It’s recommended implementing and testing the methods in the order they are described in the 
paragraphs below. If needed, you can write additional methods to help in your implementation of these three methods 
but they must be defined as private. Definitely make your implementation of the Maze class as modular as possible, not 
placing all or most of your code in any one method. Methods should be reasonably small following the guidance that "A 
function should do one thing, and do it well."
The constructor will read in a .maze file and use the information contained within it to construct and store a graph in 
the private data member rooms[]. A .maze file is basically a text file containing all the information needed to construct 
the maze.

- The first line of the file contains an integer (n) which is the number of rooms/vertices in the graph.

- The next n lines each contain the name of a room (String) and its x and y coordinates (integers) in that order. 
The name of the room is 1 or more characters. DO NOT assume the name is only 1 character in length. The name, x and y 
coordinates are separated by one or more spaces. DO NOT assume the three values are only separated by only 1 space.

- After the list of vertices are the edges/corridors. Each edge is listed as two integers, room1 and room2, the indices 
of its start and end vertices. The room1 and room2 indices are separated by one or more spaces. DO NOT assume the two 
values are only separated by only 1 space. Store each valid edge by adding an Edge object with the target room2 to room1's 
list of edges.

- The .maze file will end with a line containing -1 -1.

- You may assume that the input file is correctly formatted, except that some edges may point to non-existent vertices. 
You should ignore any invalid edges, keep going without adding them to your graph.

- You can test your code with the following files, which does not include any invalid edges: sample.maze, secrets.maze, 
seas.maze, and bigmaze.maze. You should create your own test cases to test for invalid edges and other special cases.
The getRooms method just returns the array of vertices.
The toString method produces a string representation of the maze in the exact format of a .maze file. 
It does not need to look identical to the .maze file from which it was read; but, it should have the same vertices in 
the same order, and the same edges (not including invalid edges, nor necessarily in the same order.) The newline character
represented with the special code \n (the \ character is above the Enter key on US keyboards) in a string provides the 
needed line breaks within the maze string returned by the toString method. A string literal containing only a newline 
character is written "\n".

6. Create a driver class and make the name of the driver class Assignment1 and it should only contain only one method:
public static void main(String args[]).
The main method will receive the name of the maze file via a command line argument. For example, the command to run the 
program to process the maze file sample.maze is:
java Assignment1 sample.maze
The main method will create an instance of a Maze object passing the filename into the Maze object’s constructor. 
Then, the main method will print out the Maze via use of the Maze object’s toString method.

7. Do NOT use your own packages in your program. If you see the keyword package on the top line of any of your .java 
files then you created a package. Create every .java file in the src folder of your Eclipse project.

8. Do NOT use any graphical user interface code in your program!

9. Document and comment your code thoroughly.

======================================
Grading Criteria

The total project is worth 15 points, broken down as follows:
If the program does not compile successfully then the grade for the assignment is zero.
If the program compiles successfully then the grade is computed as follows:
Proper submission instructions (each item is worth 1 point):
1. Was the file submitted a zip file.
2. The zip file has the correct filename.
3. The contents of the zip file are in the correct format.
Follow all coding instructions (each item is worth 2 point):
4. The driver file has the correct filename, Assignment1.java?
5. The driver file contains the method main performing the exact tasks as described in the assignment description?
6. The program contains the class Vertex performing the exact tasks as described in the assignment description?
7. The program contains the class Edge performing the exact tasks as described in the assignment description?
8. The program contains the class Maze performing the exact tasks as described in the assignment description?
Program execution (each item is worth 1 point):
9. The program executes without any errors?
10. The program produces the correct output?
Late submission penalty: assignments submitted after the due date are subjected to a 1.5 point deduction for each day late.
