package Complex_Mix_Questions.Construct_Binary_Tree_From_PostOrder_InOrder;

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
       *         3    6   10   20
       *        / \    \      /  \
       *       2   4    7    19   24
       * ================================
       */

      // Expected inOrder and postOrder Traversal of second case
      int[] secondCaseInOrder = {2,3,4,8,6,7,9,10,17,19,20,24};
      int[] secondCasePostOrder = {2,4,3,7,6,8,10,19,24,20,17,9};

      // Construct the tree here
      ConstructBinaryTree binaryTreeTwo = new ConstructBinaryTree();
      TestTreeNode testTwoNode = binaryTreeTwo.postAndInOrderTreeConstruction(secondCaseInOrder,secondCasePostOrder);

      // Traverse the tree
      int[] inOrderSecondCase = binaryTreeTwo.inOrder(testTwoNode);
      int[] postOrderSecondCase = binaryTreeTwo.postOrder(testTwoNode);

      // Print the results
      for(int element : inOrderSecondCase) {
         System.out.print(element + " ");
      }
      System.out.println();
      for(int element : secondCaseInOrder) {
         System.out.print(element + " ");
      }

      // Check if both are equal
      if(Arrays.equals(inOrderSecondCase,secondCaseInOrder)
            && Arrays.equals(postOrderSecondCase,secondCasePostOrder)) {
         numberOfSuccess++;
      }

      // Check the number of successful runs
      if(numberOfSuccess == 2) {
         System.out.println("\n\nwCongratulations! You Algorithm works for all of the test cases!");
      } else {
         System.out.println("Unsuccessful runs, Please check your algorithm again!");
      }

   }
}
