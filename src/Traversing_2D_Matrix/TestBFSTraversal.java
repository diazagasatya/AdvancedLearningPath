package Traversing_2D_Matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Lets given a 2D array representing 0 as non-traversal path,
 * & any given integer n > 0 are the golds that can be traversed
 * As a player, you can pick any of the position inside the 2D
 * Array, and find the most optimal (maximum) number of golds
 * that could be taken in a single path.
 */
public class TestBFSTraversal {

   public static void main(String[] args) {
      /*
       * Constraints:
       * - You cannot traverse to the same spot
       * - You can start at any point
       * - All of the gold values are > 0
       * - This algorithm will calculate all possible
       *   routes from starting source and print out
       *   the routes taken & maximum possible gold it can get.
       */

      // The 2D array graph is represented like below
      int[][] graph =  {{0 , 5 , 0 , 10 ,0 },
                        {5 , 5 , 0 , 5 , 0 },
                        {10 ,0 , 5 , 7 ,50 },
                        {10,200 ,10 ,0, 150},
                        {5 , 0, 70 , 0 ,100}};

      // Put all of the total maximum values in a Map<Routes,Gold>
      HashMap<String, Integer> possibleRoutes = new HashMap<>();

      // Initialize starting source as a String which correspond to row&column
      String source = "01";   // Row 0 and Column 1
      String routes = "N/A routes";
      int maxGold = 0; // Initiate the current maxGold

      // Initiate an arraylist of entry which will hold the max route and gold
      ArrayList<Map.Entry<String, Integer>> maxRoutesGold = new ArrayList<>();

      // Calculate all possible routes from source
      // BFSMax bfsMax = new BFSMax(graph);
      // possibleRoutes = bfsMax.findMaxGold(source);

      // Return the Entry in the map that has the maximum value
      for(Map.Entry<String, Integer> entry : possibleRoutes.entrySet()) {
         if(entry.getValue() > maxGold) {
            // Insert the entry to the array-list
            maxRoutesGold.add(entry);
         }
      }
      // Print out all of the maxRoute(s) (It could have more than one)
      for(Map.Entry<String, Integer> entry : maxRoutesGold) {
         System.out.println("Route = " + entry + "Gold = " + maxRoutesGold);
      }

   }
}
