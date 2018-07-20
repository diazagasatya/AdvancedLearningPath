package Arrays_and_Strings;


import java.util.HashSet;
import java.util.Set;

public class Permutation {

   public Permutation() {}

   /**
    * Wrapper method that will initiate prefix and call the recursive permutation method.
    * @param pString
    * @return
    */
   public HashSet<String> permutation(String pString) {
      if(pString.length() == 0 && pString == null) {
         System.out.println("Please insert a valid string");
         throw new NullPointerException();
      }

      HashSet<String> permutations = new HashSet<>();
      permutation("", pString, permutations);

      return permutations;
   }

   /**
    * Private recursive function where it returns all permutation of given string
    * @param prefix           Partial string from a given full string
    * @param remaining        Full String
    * @param permutations     Set of permutations
    */
   private void permutation(String prefix, String remaining, HashSet<String> permutations) {
      if(remaining.length() == 0) {
         permutations.add(prefix);
      }
      for(int i = 0; i < remaining.length(); i++) {
         permutation(prefix + remaining.charAt(i), remaining.substring(0,i) + remaining.substring(i+1,remaining.length()), permutations);
      }

   }

   /**
    * Test the Recursive permutation method to get all unique permutations
    * @param args
    */
   public static void main(String[] args) {
      // Print all of the permutation of this string
      String permutationString = "abcdef";
      Set<String> permutations = new HashSet<>();
      Permutation permutationObject = new Permutation();
      permutations = permutationObject.permutation(permutationString);
      // Print the permutations in for each loop
      for(String perm : permutations) {
         System.out.println(perm);
      }
   }

}
