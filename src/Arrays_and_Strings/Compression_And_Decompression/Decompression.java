package Arrays_and_Strings.Compression_And_Decompression;

/**
 * This class will contain methods that will help client
 * to decompress string compression in a form of frequency and
 * string representation letters.
 * i.e 2[3[a]b]
 * @author Diaz Agasatya        June 29th 2018
 */
public class Decompression {

   // Static strings that will be used throughout the recursion
   private static String decompressedString = "";
   private static String coreString = "";

   /*
       * Constraints given:
       * - Number can have more than one digit. For example, 10[a] is allowed, and just means aaaaaaaaaa
       * - One repetition can occur inside another. For example, 2[3[a]b] decompresses into aaabaaab
       * - Characters allowed as input include digits, small English letters and brackets [ ].
       * - Digits are only to represent amount of repetitions.
       * - Brackets are only part of syntax of writing repeated substring.
       * - Input is always valid, so no need to check its validity.
       * Hints (Recursion, Loops, Strings, Algorithm) will be useful for this case
       */

   /**
    * Public method decompress where it will check validation, then call the protected
    * recursion method, and return the complete decompressed String.
    * @param compressedString          Compressed String
    * @return decompressedString
    */
   public String decompress(String compressedString) {

      // Make sure that the string is not null
      // Make sure that the edge cases are tested first before calling recursion
      if(compressedString.length() == 0 || compressedString.equals(null)
            || compressedString.charAt(0) == '0' || Character.isLetter(compressedString.charAt(0))) {
         return "Please insert valid compressed string (i.e 3[ab]c, 3[6[4[aew]d]r])";
      }

      // Call the protected recursive method to decompress the string
      decompress(compressedString, 0, "", 0, compressedString.length() - 1);

      if(decompressedString.length() != 0) {
         return decompressedString;
      }

      // If decompression failed
      return "Decompression failed, please try again using valid compression patterns";
   }

   /**
    * Protected decompression called, this is a recursive call that will follow
    * the "Peel The Onion" implementation or Dividing and Conquer the inner, outer
    * and core string of compression.
    * @param cString             Compressed String
    * @param repetition          Repetition for every onion peel (recursion)
    * @param outerString         Outer String needed to be added to combination
    * @param start               Starting Index of each peel / recursion
    * @param end                 Ending Index of each peel / recursion
    */
   protected void decompress(String cString, int repetition ,
                             String outerString, int start, int end) {

      // Base Condition
      if(Character.isLetter(cString.charAt(start))) {
         return;
      }

      // Initialize variables & counters
      boolean digitValidation = false;
      int i = start;
      // ========= Get the starting digit for initializing repetition========
      while (!digitValidation && i < end) {
         if (cString.charAt(i) == '[') {
            repetition = Integer.parseInt(cString.substring(start, i));
            // System.out.println("REPEAT = " + repetition); // debugging
            start = i + 1;
            digitValidation = true;
         }
         i++;
      }

      // =====================Get the outerString============================
      boolean oStringValidation = false;
      int j = end;
      if(cString.charAt(end) == ']') {
         outerString = "";
         end--;
      } else {
         while(!oStringValidation) {
            if(cString.charAt(j) == ']') {
               outerString = cString.substring(j + 1,end + 1);
               // System.out.println("OUTERSTRING = " + outerString); (debugging)
               end = j - 1;
               oStringValidation = true;
            }
            j--;
         }
      }

      // If recursed until core compression, grab the inner and
      int k = start - 1;
      int sCoreStringIndex = 0;
      int compressionSkin = 0;
      while (compressionSkin < 2) {
         if(cString.charAt(k) == '[') {
            sCoreStringIndex = k + 1;
            compressionSkin++;
         }
         if(cString.charAt(k) == ']') {
            coreString = cString.substring(sCoreStringIndex, k);
            break;
         }
         k++;
      }

      // Recursion starts here
      decompress(cString, repetition, outerString, start, end);

      // The real combination decompression starts here
      decompressString(repetition, outerString, coreString);
   }

   /**
    * Helper method of decompress recursion to merge the combinations from each
    * peel into one big decompressed string.
    * @param repetition          Repetition of combination each peel
    * @param outerString         OuterString needed to be concatenated
    * @param innerString         InnerString needed to be repeated by n repetition
    */
   private void decompressString(int repetition, String outerString, String innerString) {
      String combination = "";
      for(int i = 0; i < repetition; i++) {
         combination += innerString;
      }
      combination += outerString;
      // System.out.println("Combination = " + combination); // debugging
      coreString = combination;
      decompressedString = combination;
   }


}
