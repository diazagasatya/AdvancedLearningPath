package Arrays_and_Strings;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures. (Hint - Recursion)
 * Time Complexity = O(n)     n being the number of characters need to be checked
 * Space Complexity = O(n)    n being the number of substrings and stack used
 */
public class IsUnique {

   /*
    * Check with the interviewer:
    * 1) Is it all ASCII characters (128 alphabet characters)
    * 2) Or is it a Unicode characters (256 characters)
    */

   /**
    * This function will recursively call to check if the next char contains
    * the selected character after deleted.
    * @param stringUnique     String argument
    * @return boolean
    */
   public static boolean uniqueAlgorithm(String stringUnique) {
      if(stringUnique.length() == 0 || stringUnique == null || stringUnique.length() > 128) {
         return false;
      }
      return stringUnique.length() == 1 ? true : uniqueAlgorithmHelper(stringUnique);
   }

   /**
    * This protected recursive algorithm will take the first character and check if the
    * rest of the string contains the first character taken
    * @param stringUnique     String argument
    * @return
    */
   private static boolean uniqueAlgorithmHelper(String stringUnique) {
      // Base Condition
      if(stringUnique.length() == 1) {
         return true;
      } else if(stringUnique.length() > 1) {
         // Get the first character of the string
         CharSequence charSequence = stringUnique.substring(0,1);
         // Get the rest of the string
         String newStringUnique = stringUnique.substring(1,stringUnique.length() - 1);
         // If the rest of the string contains the character stop recursion else recurse
         return newStringUnique.contains(charSequence) ? false : uniqueAlgorithmHelper(newStringUnique);
      }
      // If characters are unique till the end return true
      return true;
   }

   /**
    * This main will test the IsUnique algorihtm
    * @param args
    */
   public static void main(String[] args) {
      String testOne = "qwertyuiopasdfghjklzxcvbnm";
      String testTwo = "-098765434567890opolkc,axa'p9d210px;a.s,mvnk";
      String testThree = "saokdjcknahiuwidkmqlx";

      System.out.println(IsUnique.uniqueAlgorithm(testOne));
      System.out.println(IsUnique.uniqueAlgorithm(testTwo));
      System.out.println(IsUnique.uniqueAlgorithm(testThree));
   }

}
