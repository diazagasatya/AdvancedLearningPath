package Traversing2DMatrix;

import java.util.Scanner;

/**
 * Lets given a 2D array representing 0 as non-traversal path,
 * & any given integer n > 0 are the golds that can be traversed
 * As a player, you can pick any of the position inside the 2D
 * Array, and find the most optimal (maximum) number of golds
 * that could be taken in a single path.
 */
public class TestDFSTraversal {

   public static void main(String[] args) {
      /*
       * Constraints:
       * - You cannot traverse to the same spot
       * - You can start at any point
       * - All of the gold values are > 0
       * - This algorithm will calculate all possible
       *   routes from starting source and print out
       *   the routes taken & maximum possible gold it can get.
       * - Possible routes including not moving from original position
       */

      // The 2D array graph is represented like below
      int[][] graph =  {{0 , 0 ,  50 , 10},
                        {50 , 10 , 0 , 10},
                        {1  , 2 ,  5 ,  0},
                        {0 , 10 , 200 , 0}};

      // Depth First Search this 2D graph
      DFSMax depthFirstSearch = new DFSMax();

      // Grab user input on which row and column to start
      Scanner userInput = new Scanner(System.in);
      System.out.println("Please insert the row and column you want to start your character:");
      System.out.print("Row = ");
      int row = userInput.nextInt();
      System.out.print("Column = ");
      int column = userInput.nextInt();

      try {
         depthFirstSearch.dfsMax(graph, row, column);
      } catch (Exception e) {
         System.out.println("Please insert a valid source destination");
      }
   }
}
