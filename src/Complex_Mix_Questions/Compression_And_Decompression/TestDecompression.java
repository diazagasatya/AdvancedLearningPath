package Complex_Mix_Questions.Compression_And_Decompression;

/**
 * Coding Challenge based upon Google's Tech Dev Guide
 * https://techdevguide.withgoogle.com/paths/advanced/compress-decompression#code-challenge
 * This class will test the Decompression class & Includes 5 test cases.
 * @author Diaz Agasatya        June 29th 2018
 */
public class TestDecompression {

   /**
    * Main Test for Class Decompression is tested here
    * @param args
    */
   public static void main(String[] args) {

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
      // Create an instance of class Decompression
      Decompression decompression = new Decompression();

      // Success tests
      int numberOfSuccess = 0;

      // Test 1
      String testOne = "3[ab]";
      String expectedResult = "ababab";
      String testOneSolution = decompression.decompress(testOne);

      // Test 1 Validation
      if(testOneSolution.equals(expectedResult)) {
         numberOfSuccess++;
      } else {
         System.out.println("Test 1 Unsuccessful");
      }

      // Test 2
      String testTwo = "2[3[ats]b]";
      String expectedResultTwo = "atsatsatsbatsatsatsb";
      String testTwoSolution = decompression.decompress(testTwo);

      // Test 2 Validation
      if(testTwoSolution.equals(expectedResultTwo)) {
         numberOfSuccess++;
      } else {
         System.out.println("Test 2 Unsuccessful");
      }

      // Test 3
      String testThree = "10[uvk]";
      String expectedResultThree = "uvkuvkuvkuvkuvkuvkuvkuvkuvkuvk";
      String testThreeSolution = decompression.decompress(testThree);

      // Test 3 Validation
      if(testThreeSolution.equals(expectedResultThree)) {
         numberOfSuccess++;
      } else {
         System.out.println("Test 3 Unsuccessful");
      }

      // Test 4
      String testFour = "2[7[3[ab]c]d]";
      String expectedResultFour = "abababcabababcabababcabababcabababcabababcabababcd" +
            "abababcabababcabababcabababcabababcabababcabababcd";
      String testFourSolution = decompression.decompress(testFour);

      if(testFourSolution.equals(expectedResultFour)) {
         numberOfSuccess++;
      } else {
         System.out.println("Test 4 Unsuccessful");
      }

      // Test 5
      String testFive = "1[6[3[2[5[io]d]asd]qwy]rwq]";
      String expectedResultFive = "ioioioioiodioioioioiodasdioioioioiodioioioioiodasdioioioioiodioioioioiodasdqwy" +
            "ioioioioiodioioioioiodasdioioioioiodioioioioiodasdioioioioiodioioioioiodasdqwy" +
            "ioioioioiodioioioioiodasdioioioioiodioioioioiodasdioioioioiodioioioioiodasdqwy" +
            "ioioioioiodioioioioiodasdioioioioiodioioioioiodasdioioioioiodioioioioiodasdqwy" +
            "ioioioioiodioioioioiodasdioioioioiodioioioioiodasdioioioioiodioioioioiodasdqwy" +
            "ioioioioiodioioioioiodasdioioioioiodioioioioiodasdioioioioiodioioioioiodasdqwyrwq";
      String testFiveSolution = decompression.decompress(testFive);

      if(testFiveSolution.equals(expectedResultFive)) {
         numberOfSuccess++;
      } else {
         System.out.println("Test 5 Unsuccessful");
      }

      // =============================EDGE TEST CASES HERE===================================
      String edgeCaseOne = "a[]b";
      String expectedResultCaseOne = "Please insert valid compressed string (i.e 3[ab]c, 3[6[4[aew]d]r])";
      String edgeCaseTestOne = decompression.decompress(edgeCaseOne);

      if(edgeCaseTestOne.equals(expectedResultCaseOne)) {
         numberOfSuccess++;
      } else {
         System.out.println("Edge Case One Failed!");
      }

      String edgeCaseTwo = "0[abc]";
      String expectedResultCaseTwo = "Please insert valid compressed string (i.e 3[ab]c, 3[6[4[aew]d]r])";
      String edgeCaseTestTwo = decompression.decompress(edgeCaseTwo);

      if(edgeCaseTestTwo.equals(expectedResultCaseTwo)) {
         numberOfSuccess++;
      } else {
         System.out.println("Edge Case Two Failed!");
      }

      // ===============================Success Run(s)===================================
      if(numberOfSuccess == 7) {
         System.out.println("Compression & Decompression Test is Successful!");
      } else {
         System.out.println("Compression & Decompression Test is NOT successful" +
               ", please check your algorithm");
      }
   }
}
