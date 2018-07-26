package Traversing2DMatrix;

import java.util.*;

public class DFSMax {

   // Reference to the graph
   private HashMap<Integer, EdgeNode> adjacentList;
   private ArrayList<Integer> totalGoldList;

   /**
    * This constructor will initialize the graph.
    */
   public DFSMax() {
      adjacentList = new HashMap<>();
   }

   /**
    * This function will do a DFS from a given point
    * @param graph      2D Graph
    * @param row        Starting Row
    * @param column     Starting Column
    */
   public void dfsMax(int[][] graph, int row, int column) {
      // Make sure that row and column are valid
      if(!validRowColumn(row, column, graph.length)) {
         return;
      }
      // Represent the graph into an adjacency list
      adjacentListGraph(graph);
      // Add children to all of the nodes
      addChildrenToNodes();
      // Do the Depth First Search Here
      int key = Integer.parseInt(row + "" + column);
      depthFirstSearch(key);

      // Print the list of total gold can be achieved
      System.out.println("=================================================");
      System.out.println("                GOLD CAN BE ACHIEVED             ");
      System.out.println("=================================================");
      for(Integer totalGold : totalGoldList) {
         System.out.print(totalGold + ", ");
      }
      System.out.println();
   }

   /**
    * Wrapper function to call the recursive function
    * @param key
    */
   private void depthFirstSearch(int key) {
      if(!adjacentList.containsKey(key)) {
         return;
      }
      // Initialize the total amount of gold it can get
      totalGoldList = new ArrayList<>();
      // Initialize the visited set to avoid re-visit
      HashSet<Integer> visited = new HashSet<>();
      depthFirstSearch(key,visited,0);
   }

   /**
    * Private function that will recursively traverse it's child
    * @param key
    * @param visited
    */
   private void depthFirstSearch(int key, HashSet<Integer> visited, int totalGold) {
      // Base condition, that if the current traverse key is already visited return
      if(visited.contains(key)) {
         return;
      }
      // Insert the current key to the visited set
      visited.add(key);
      // Get the gold value to be added to the list
      int goldValue = adjacentList.get(key).getGold();
      totalGold += goldValue;
      // Visit all of its children one by one
      for(EdgeNode child : adjacentList.get(key).getAdjacent()) {
         depthFirstSearch(child.getKey(), visited, totalGold);
      }
      // If all of its children is visited
      totalGoldList.add(totalGold);
   }

   /**
    * Check the validation of the row column
    * @param row        Row to start character
    * @param column     Column to start character
    * @return boolean
    */
   private boolean validRowColumn(int row, int column, int max) {
      if(row < max && column < max) {
         return true;
      }
      return false;
   }

   /**
    * This function will check if the node able to move
    * up, down, left or right. If so add those nodes
    * to the adjacent (childrens list) of the node.
    */
   private void addChildrenToNodes() {
      // Iterate to all of the nodes in the adjacentList
      for(Map.Entry<Integer,EdgeNode> entry : adjacentList.entrySet()) {
         // Check you can go up - add to children
         if(adjacentList.containsKey(entry.getKey() - 10)) {
            entry.getValue().addChild(adjacentList.get(entry.getKey() - 10));
         }
         // Check if you can go right - add to children
         if(adjacentList.containsKey(entry.getKey() + 1)) {
            entry.getValue().addChild(adjacentList.get(entry.getKey() + 1));
         }
         // Check if you can go down - add to children
         if(adjacentList.containsKey(entry.getKey() + 10)) {
            entry.getValue().addChild(adjacentList.get(entry.getKey() + 10));
         }
         // Check if you can go left - add to children
         if(adjacentList.containsKey(entry.getKey() - 1)) {
            entry.getValue().addChild(adjacentList.get(entry.getKey() - 1));
         }
      }

   }

   /**
    * This private method will represent the 2D array into a
    * Adjacency List in order to to a Depth First Search Traversal
    * @param graph            2D Array Environment
    */
   private void adjacentListGraph(int[][] graph) {
      // Loop iteratively on the 2D graph and put the row and column
      // number as the Key and put the value of the graph as the Value (gold)
      for(int i = 0; i < graph.length; i++) {
         for(int j = 0; j < graph.length; j++) {
            if(graph[i][j] == 0) {
               continue;
            }
            int key = Integer.parseInt(i + "" + j);
            int value = graph[i][j];
            EdgeNode node = new EdgeNode(value, key);
            adjacentList.put(key,node);
         }
      }
   }

   /**
    * Node Class
    */
   private class EdgeNode {

      // Reference to variables
      private int gold;
      private int key;
      private LinkedList<EdgeNode> adjacent = new LinkedList();

      /**
       * Constructor with an int value to initialize the gold
       * @param value      gold value
       */
      public EdgeNode(int value, int key) {
         gold = value;
         this.key = key;
      }

      /**
       * Returns the key of the node
       * @return key
       */
      public int getKey() {
         return key;
      }

      /**
       * This will return the gold value
       * @return gold
       */
      public int getGold() {
         return gold;
      }

      /**
       * This function will return the node's childrens
       * @return childrens
       */
      public LinkedList<EdgeNode> getAdjacent() {
         return adjacent;
      }

      /**
       * Add children to the adjacent
       * @param child
       */
      public void addChild(EdgeNode child) {
         adjacent.add(child);
      }
   }
}
