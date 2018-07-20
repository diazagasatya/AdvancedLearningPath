package Trees_And_Graphs.DFS_and_BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * This class is a graph that will hold all nodes inside a HashMap.
 */
public class Graphs {

   // Holds all of the nodes inside a HashMap for fast access
   HashMap<Character,Node> graph;
   // Holds a list of paths it took
   ArrayList<String> paths;

   /**
    * Default constructor that will intialize the hash map
    */
   public Graphs() {
      graph = new HashMap<>();
   }

   /**
    * Add the node to the graph
    * @param charId        Key
    * @param node          Value
    */
   public void addNode(Character charId, Node node) {
      graph.put(charId, node);
   }

   /**
    * Add the destination node to the graph, and children to source
    * @param sourceId       Source Node
    * @param destinationId  Destination Node
    */
   public void addEdge(Character sourceId, Character destinationId) {
      Node sourceNode = getNode(sourceId);
      Node destinationNode = getNode(destinationId);
      sourceNode.adjacent.add(destinationNode);
   }

   /**
    * Return the node of the whole graph
    * @param charId     Key
    * @return Node
    */
   public Node getNode(Character charId) {
      return graph.get(charId);
   }

   /**
    * This wrapper function will do safety check and initialize nodes & visited set
    * @param sourceId            Source ID
    * @param destinationId       Destination ID
    * @return paths
    */
   public ArrayList<String> depthFirstSearch(Character sourceId, Character destinationId) {
      // Safety check first if the hashmap contains the key
      if(!graph.containsKey(sourceId) || !graph.containsKey(destinationId)) {
         throw new NullPointerException("The graph does not contain the source or the destination node ID");
      }

      // Initialize empty array list of paths
      paths = new ArrayList<>();

      // Get the node from the graph
      Node sourceNode = getNode(sourceId);
      Node destinationNode = getNode(destinationId);
      // Mark the visited nodes in a HashSet so that it will not re-visit
      HashSet<Character> visited = new HashSet<>();

      depthFirstSearch(sourceNode, destinationNode, "", visited);

      // Call the private recursive function
      return paths;
   }

   /**
    * Private function that will note of the paths it traversed through the graph and add it to paths list
    * @param sourceNode       Source ID
    * @param destinationNode  Destination ID
    * @param path             Path of Graph
    * @param visited          Visited Nodes
    */
   private void depthFirstSearch(Node sourceNode, Node destinationNode, String path, HashSet<Character> visited) {
      // Base condition is that if the node is looping then return
      if(visited.contains(sourceNode.charId)) {
         return;
      }

      // Mark the sourceNode as visited
      visited.add(sourceNode.charId);
      String newPath = sourceNode.charId.toString();
      path += "->" + newPath;

      // If the source node reached destination or the node has no children
      if(sourceNode == destinationNode || sourceNode.adjacent.isEmpty()) {
         paths.add(path);
         return;
      }

      // Search all of it's children's children until reach destination
      for(Node children : sourceNode.adjacent) {
         depthFirstSearch(children, destinationNode, path, visited);
      }
   }


   /**
    * This wrapper function will initialize the visited, path lists and do safety check before private method
    * @param sourceId         Source ID
    * @param destinationId    Destination ID
    * @return paths
    */
   public ArrayList<String> breadthFirstSearch(Character sourceId, Character destinationId) {
      if(!graph.containsKey(sourceId) || !graph.containsKey(destinationId)) {
         throw new NullPointerException("The graph does not contain the source or the destination node ID");
      }
      // Initialize the list of paths & visited set
      paths = new ArrayList<>();
      HashSet<Character> visited = new HashSet<>();
      // Get the nodes from the map
      Node sourceNode = getNode(sourceId);
      Node destinationNode = getNode(destinationId);
      // Call the private method
      breadthFirstSearch(sourceNode, destinationNode, "", visited);
      // Return the paths found
      return paths;
   }

   /**
    * This function will traverse the graph level by level until it reached the destination
    * @param sourceNode          Source Code
    * @param destinationNode     Destination Code
    * @param path                Path Visited
    * @param visited             Visited Nodes
    */
   private void breadthFirstSearch(Node sourceNode, Node destinationNode, String path, HashSet<Character> visited) {
      // Create a list of nodes to visit (children of nodes)
      LinkedList<Node> nextToVisit = new LinkedList<>();
      // Add the first node to the list
      nextToVisit.add(sourceNode);

      // Traverse level by level by traversing to all of its children first
      while(!nextToVisit.isEmpty()) {
         Node node = nextToVisit.remove();
         // If its visited already, continue to the next child
         if(visited.contains(node.charId)) {
            continue;
         }
         // Mark the node as visited
         path += "->" + node.charId;
         visited.add(node.charId);
         // If destination is reached
         if(node == destinationNode) {
            paths.add(path);
            return;
         }
         // Add all of its children to the next node to visit
         for(Node children : node.adjacent) {
            nextToVisit.add(children);
         }
      }

   }


   /**
    * This inner class Node will have the characteristics of a Node
    * with adjacent children to its edges.
    */
   public static class Node {

      // Node will have character ID and a LinkedList of its childrens
      Character charId;
      LinkedList<Node> adjacent = new LinkedList<>();

      /**
       * Constructor that will initialize node's id
       * @param charId     Character Id
       */
      public Node(Character charId) {
         this.charId = charId;
      }

   }

   /**
    * Test the Graph class
    * @param args
    */
   public static void main(String[] args) {

      /*
       * Given below directed graph, show the DFS and BFS traversal and print the paths
       * it took throughout the traversal of the graph
       *
       *        (D)--(F)
       *       /
       *     (B)--(E)
       *    /
       * (A)
       *    \
       *     (C)--(G)
       *
       * Do Breadth First Search and Depth First Search, conclude on the trade offs
       * between the two traversal
       */

      // Initialize the graph here and its edges
      Graphs graph = new Graphs();
      graph.addNode('A', new Node('A'));
      graph.addNode('B', new Node('B'));
      graph.addNode('C', new Node('C'));
      graph.addNode('D', new Node('D'));
      graph.addNode('E', new Node('E'));
      graph.addNode('F', new Node('F'));
      graph.addNode('G', new Node('G'));

      graph.addEdge('A','B');
      graph.addEdge('B','D');
      graph.addEdge('D','F');
      graph.addEdge('B','E');
      graph.addEdge('A','C');
      graph.addEdge('C','G');

      // Initialize the list of paths
      ArrayList<String> traversedNodes;
      // Do a DFS on the graph
      traversedNodes = graph.depthFirstSearch('A','G');
      System.out.println("Traversal in DFS:");
      // Print all of the paths
      for(String path : traversedNodes) {
         System.out.println(path);
      }

      // Do a BFS on the graph
      traversedNodes = graph.breadthFirstSearch('A','G');
      System.out.println("\nTraversal in BFS:");
      // Print all of the paths
      for(String path : traversedNodes) {
         System.out.println(path);
      }

   }
}
