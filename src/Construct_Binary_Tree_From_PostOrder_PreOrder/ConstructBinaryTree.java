package Construct_Binary_Tree_From_PostOrder_PreOrder;

import java.util.ArrayList;

public class ConstructBinaryTree {

   // Initialize global variables here
   private int rootIndex;
   private ArrayList<Integer> inOrderElements;
   private ArrayList<Integer> postOrderElements;

   /**
    * A default constructor for using the class methods
    */
   public ConstructBinaryTree() {}

   /**
    * This method will create a Binary Tree from given inOrder & postOrder
    * @param inOrder          In-Order
    * @param postOrder        Post-Order
    * @return
    */
   public TestTreeNode postAndInOrderTreeConstruction(int[] inOrder, int[] postOrder) {
      // Initialize the master root of the node which is always the last element in postOrder
      rootIndex = postOrder.length - 1;

      // Call the protected recursive method here initializing the starting & ending index
      return postAndInOrderTreeConstruction(inOrder, postOrder, 0, postOrder. length-1);
   }

   /**
    * This is the protected recursive method that will construct the Binary Tree
    * @param inOrder          In-Order
    * @param postOrder        Post-Order
    * @param startingIndex    Starting index of left/right child of current recursive node
    * @param endIndex         Ending index of left/right child of current recursive code
    * @return  masterRoot with all of the children connected
    */
   protected TestTreeNode postAndInOrderTreeConstruction(int[] inOrder, int[] postOrder,
                                                         int startingIndex, int endIndex) {
      // Base Condition
      if(startingIndex > endIndex) {
         return null;
      }
      // If there's no more left/right child of the root node
      if(startingIndex == endIndex) {
         // Return the correct element in the inOrder array
         return new TestTreeNode(postOrder[rootIndex--]);
      }
      // Instantiate a new root node
      TestTreeNode node = new TestTreeNode(postOrder[rootIndex--]);
      // Get the index of the root node in the inOrder array
      int nodeIndex = search(node.getValue(), inOrder, startingIndex, endIndex);
      // Connect the node with its left & right nodes
      node.right = postAndInOrderTreeConstruction(inOrder, postOrder, nodeIndex + 1, endIndex);
      node.left = postAndInOrderTreeConstruction(inOrder, postOrder, startingIndex, nodeIndex - 1);
      // Return the node to be connected from the previous root
      return node;
   }

   /**
    * Search the index of the node element in the inOrder array
    * @param value
    * @param inOrder
    * @return
    */
   public int search(int value, int[] inOrder, int sIndex, int eIndex) {
      for(int i = sIndex; i <= eIndex; i++) {
         if(inOrder[i] == value) {
            return i;
         }
      }
      // Return -1 if there's no such value in the array
      return -1;
   }

   /**
    * This method will do an in-order traversal of tree
    * @param node       Root Node
    * @return arrayOfNodes
    */
   public int[] inOrder(TestTreeNode node) {
      // Initialize the elements in a list
      inOrderElements = new ArrayList<>();

      // Call the recursive in-order traversal
      inOrderTraversal(node);

      // Convert the array-list to integer array
      return inOrderElements.stream().mapToInt(x -> x).toArray();
   }

   /**
    * This method will do an post-order traversal of tree
    * @param node       Root Node
    * @return arrayOfNodes
    */
   public int[] postOrder(TestTreeNode node) {
      // Initialize the elements in a list
      postOrderElements = new ArrayList<>();

      // Call the recursive post-order traversal
      postOrderTraversal(node);

      // Convert the array-list to int[] array
      return postOrderElements.stream().mapToInt(x -> x).toArray();
   }

   /**
    * This is the recursive method for post-order traversal of tree
    * @param node       Root node
    * @return list
    */
   private void postOrderTraversal(TestTreeNode node) {
      //Base Condition
      if(node == null) {
         return;
      }
      // Traverse to the left and right of node
      postOrderTraversal(node.left);
      postOrderTraversal(node.right);

      // Insert the node value to the list
      postOrderElements.add(node.getValue());
   }

   /**
    * This is the recursive method for in-order traversal of tree
    * @param node       Root node
    * @return list
    */
   protected void inOrderTraversal(TestTreeNode node) {
      // Base Condition
      if(node == null) {
         return;
      }
      // Traverse to the left of the root node
      inOrderTraversal(node.left);
      // Insert the value of the node to the arrayList
      inOrderElements.add(node.getValue());
      // Traverse to the right of the root node
      inOrderTraversal(node.right);
   }
}
