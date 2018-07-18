package Arrays_and_Strings;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation
 * of the other. (Hint - Create all permutation of string one & check if
 * string two contain the permutation)
 * Time Complexity - (2N (2Log N))  Twice sorting first argument and second
 * Space Complexity - (2N)          N being the size of the string
 */
public class CheckPermutation {

   /*
    * Things to ask to interviewer:
    * 1) is it case-sensitive?
    * 2) what about white-spaces?
    */

   /**
    * Will sort the first and second string, if both equal this means that
    * string one is a permutation of string two.
    * @param argument      String one
    * @param answer        String two
    * @return boolean
    */
   public static boolean checkPermutation(String argument, String answer) {
      // Check if the length of the first and second string is the same
      if(argument.length() != answer.length()) {
         return false;
      }
      // Sort two string and if both equal means permutation to one another
      char[] argumentToChar = argument.toCharArray();
      char[] answerToChar = answer.toCharArray();
      Arrays.sort(argumentToChar);
      Arrays.sort(answerToChar);

      return Arrays.equals(argumentToChar,answerToChar);
   }

   /**
    * Main class that will test class CheckPermutation
    */
   public static void main(String[] args) {
      String stringOne = "abcd";
      String stringTwo = "cabd";

      String stringThree = "qwertypoiuy";
      String stringFour = "poiuyqwerti";

      System.out.println(CheckPermutation.checkPermutation(stringOne,stringTwo));
      System.out.println(CheckPermutation.checkPermutation(stringThree,stringFour));

   }
}
