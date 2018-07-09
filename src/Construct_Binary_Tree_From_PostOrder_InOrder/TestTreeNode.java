package Construct_Binary_Tree_From_PostOrder_InOrder;

/**
 * This class Tree node will have all of the characteristics of a binary tree
 */
public class TestTreeNode {
   private int value;
   TestTreeNode left;
   TestTreeNode right;

   /**
    * This basic constructor will initiate the value of the node
    * @param value      Integer value of the node
    */
   public TestTreeNode(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
   }

   /**
    * Returning the value of the node
    * @return integerValue of node
    */
   public int getValue() {
      return value;
   }
}
