package Construct_Binary_Tree_From_PostOrder_PreOrder;

import java.util.Arrays;

public class testBinaryTreeConstruction {

   /**
    * This main class will test the construction of Binary Trees given
    * an array of preOrder and postOrder traversal array.
    * @param args
    */
   public static void main(String[] args) {

      // Initiate the number of successful solutions
      int numberOfSuccess = 0;

      /*
       * Construct this Binary Tree from the given post & pre-order
       * traversal array. Print out the traversal of the newly constructed
       * tree and make sure that it matches the given post & pre-order array
       * ========= First Case ==========
       * ==========Binary Tree===========
       *                 9
       *               /   \
       *              8     17
       *                   /  \
       *                  10   20
       * ================================
       */

      // Expected inOrder and postOrder traversal of first case
      int[] firstCaseInOrder = {8, 9, 10, 17, 20};
      int[] firstCasePostOrder = {8, 10, 20, 17, 9};

      ConstructBinaryTree binaryTreeConstruct = new ConstructBinaryTree();
      // Construct the tree here
      TestTreeNode binaryTree = binaryTreeConstruct
            .postAndInOrderTreeConstruction(firstCaseInOrder, firstCasePostOrder);

      // Traverse the tree
      int[] inOrderResultOne = binaryTreeConstruct.inOrder(binaryTree);
      int[] postOrderResultTwo = binaryTreeConstruct.postOrder(binaryTree);

      // Print out the solution and expected result for debugging
      for(int element : inOrderResultOne) {
         System.out.print(element + " ");
      }
      System.out.println();
      for(int element : firstCaseInOrder) {
         System.out.print(element + " ");
      }
      System.out.println("\n");

      // Check if the newly constructed tree is correct
      if(Arrays.equals(inOrderResultOne,firstCaseInOrder) && Arrays.equals(postOrderResultTwo,firstCasePostOrder)) {
         numberOfSuccess++;
      }

      /*
       * ========= Second Case ==========
       * ==========Binary Tree===========
       *                 9
       *              /    \
       *            8       17
       *          /  \     /  \
       *         3    7   10   20
       *        / \    \      /  \
       *       2   4    8    19   24
       * ================================
       */

      // Check the number of successful runs
      if(numberOfSuccess == 1) {
         System.out.println("Congratulations! You Algorithm works for all of the test cases!");
      } else {
         System.out.println("Unsuccessful runs, Please check your algorithm again!");
      }

   }
}
