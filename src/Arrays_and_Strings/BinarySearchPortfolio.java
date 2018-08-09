package Arrays_and_Strings;

import java.util.*;

public class BinarySearchPortfolio {

   private HashMap<Integer, Node> portfolio;
   private int[] arrayOfStocks;

   /**
    * Public constructor to initialize portfolio
    */
   public BinarySearchPortfolio() {
      portfolio = new HashMap<>();
      // For this example we generate random stocks for the portfolio
      generateRandomStocks();
   }

   /**
    * This method will generate random stocks to the portfolio
    */
   private void generateRandomStocks() {
      String[] randomStockNames = {"nike", "adidas", "apple", "tesla", "linkedin", "microsoft",
                                   "google", "bmw", "hermes", "gucci"};
      double[] randomPrices = {241,214.5,392183.3,123,589,637,382.25,3267,472,10.5};
      double[] randomCashFlow = {312321.4,125,8765,382,321,7489,3289,32,10,9};

      // Pick randomly for prices and cash-flow
      Random rndInt = new Random();
      // Make 10 random stocks and insert to the portfolio
      for(int i = 0; i < randomStockNames.length; i++) {
         Node newStock = new Node(randomStockNames[i],
               randomPrices[rndInt.nextInt(10)],
               randomCashFlow[rndInt.nextInt(10)]);
         portfolio.put(i + 1,newStock);
      }
   }

   /**
    * Public sort method that will call a private mergeSort in the class
    */
   public void sort() {
      // Initialize all of the stocks in an array - inserting just the ID
      arrayOfStocks = portfolioToArray();
      mergeSort(arrayOfStocks,0,arrayOfStocks.length - 1);
   }

   /**
    * Recursive method to divide the elements to one by one
    */
   private void mergeSort(int[] array, int left, int right) {
      if(left < right) {
         // Get the middle
         int middle = (left + right) / 2;
         // Recursively divide the elements of the array until you get one by one
         mergeSort(array,left,middle);
         mergeSort(array,middle + 1, right);
         merge(array,left,middle,right);
      }
   }

   /**
    * This method will print the node within the requested range of yield
    * @param minYield   Minimum Percentage Yield
    * @param maxYield   Maximum Percentage Yield
    */
   public void binarySearchYield(double minYield, double maxYield) {
      if(minYield > maxYield) {
         return;
      }
      try {
         Node node = binarySearchYield(minYield, maxYield, arrayOfStocks, 0, arrayOfStocks.length - 1);
         node.printNode();
      } catch (NullPointerException e) {
         System.out.println("\nThere's no investment within the requested range");
      }
   }

   /**
    * This private method will return the stock within the requested yield
    * @param minYield         Min Yield of stock
    * @param maxYield         Max Yield of stock
    * @param arrayOfStocks    Arrays of stock products
    * @return Node
    */
   private Node binarySearchYield(double minYield, double maxYield, int[] arrayOfStocks, int left, int right) {
      // Check validation first
      if(left < right) {
         // Get the middle of the current divided array
         int mid = (right + left) / 2;
         double currentYield = getYield(arrayOfStocks[mid]);
         // If found then return the node
         if((currentYield >= minYield) && (currentYield <= maxYield)) {
            return portfolio.get(arrayOfStocks[mid]);
         }
         Node node;
         // Check if current mid has bigger or smaller yield and divide array to the appropriate length
         if(currentYield < minYield) {
            node = binarySearchYield(minYield,maxYield,arrayOfStocks,mid,right);
         } else {
            node = binarySearchYield(minYield,maxYield,arrayOfStocks,left,mid);
         }
         return node;
      } else {
         // If not found
         return null;
      }
   }

   /**
    * This method will get the yield from given stock ID
    * @param stockId    Stock porfolio id
    * @return Yield
    */
   private double getYield(int stockId) {
      return portfolio.get(stockId).yield;
   }

   /**
    * This method will merge the divided elements to its correct position
    * @param array      Array to sort
    * @param left       Left of divided array
    * @param middle     Mid of divided array
    * @param right      Right of divided array
    */
   private void merge(int[] array, int left, int middle, int right) {

      int leftSize = middle - left + 1;
      int rightSize = right - middle;
      // Create arrays for inserting the values of the left and right
      int[] leftArray = new int[leftSize];
      int[] rightArray = new int[rightSize];
      // Copy the values left of array to the newly created array
      for(int i = 0; i < leftSize; i++) {
         leftArray[i] = array[left + i];
      }
      for(int j = 0; j < rightSize; j++) {
         rightArray[j] = array[middle + j + 1];
      }
      // Initialize the pointers, i & j starts from left of both array
      // K must start from the left preference of the merge
      int i = 0;
      int j = 0;
      int k = left;
      // Swap the elements here
      while(i < leftSize && j < rightSize) {
         // Get the yield reference of the stock then swap
         double yieldLeft = portfolio.get(leftArray[i]).yield;
         double yieldRight = portfolio.get(rightArray[j]).yield;
         if(yieldLeft <= yieldRight) {
            array[k] = leftArray[i];
            i++;
         } else {
            array[k] = rightArray[j];
            j++;
         }
         k++;
      }
      // Copy the remaining of the array
      while(i < leftSize) {
         array[k] = leftArray[i];
         i++;
         k++;
      }
      while(j < rightSize) {
         array[k] = rightArray[j];
         j++;
         k++;
      }
   }

   /**
    * Print the sorted array
    */
   private void printArray() {
      for(int element : arrayOfStocks) {
         System.out.print(element + " ");
      }
   }

   /**
    * This method will return a representation of the map in an array
    * @return     Stocks represented by ID
    */
   private int[] portfolioToArray() {
      ArrayList<Integer> stockIds = new ArrayList<>();
      for(Map.Entry<Integer, Node> entry : portfolio.entrySet()) {
         stockIds.add(entry.getKey());
      }
      return Arrays.stream(stockIds.toArray()).mapToInt(x -> (int)x).toArray();
   }

   /**
    * This method will print the stock in ascending order
    */
   private void printStocksAsc() {
      for(int element : arrayOfStocks) {
         System.out.println(String.format("Name : %s, Yield : %.2f%%",
               portfolio.get(element).stockName, portfolio.get(element).yield));
      }
   }


   /**
    * This class node will hold the price, future cash flow and yield of a
    * single stock.
    */
   static class Node {
      String stockName;
      double yield, price, cashFlow;

      /**
       * This constructor will initialize the stock's yield, stock, cash flow
       * @param priceProduct     Price of Product
       * @param cashFlowProduct  Cash Flow Product
       */
      public Node(String name, double priceProduct, double cashFlowProduct) {
         stockName = name;
         yield = calculateYield(priceProduct, cashFlowProduct);
         price = priceProduct;
         cashFlow = cashFlowProduct;
      }

      /**
       * Return the yield of a stock in percentage
       * @param price      Price of Product
       * @param cashFlow   Future Cash Flow
       * @return
       */
      private double calculateYield(double price, double cashFlow) {
         return (cashFlow - price) / price * 100;
      }

      /**
       * Will print the information of node
       */
      private void printNode() {
         System.out.println(String.format("Name : %s, Yield : %.2f",stockName,yield));
      }

   }

   /**
    * This main will sort the array first using merge sort then search
    * a requested integer inside the given array
    * @param args    Arguments
    */
   public static void main(String[] args) {

      /*
       * Suggest an optimization to find yield from price and
       * future cash flows (could utilize a binary search algorithm here)
       * Yield % = (future cash flow - price) / price * 100
       *
       */

      // Initialize the portfolio and insert stocks into the portfolio
      // and generate random stocks inside the portfolio unsorted.
      BinarySearchPortfolio portfolio = new BinarySearchPortfolio();

      // Sort the portfolio in an array based upon the yield of the stocks
      portfolio.sort();

      // Print the stocks in ascending order based upon yield
      portfolio.printStocksAsc();

      // Use Binary Search to list companies and its yields if within 100 - 200% yield
      System.out.println("\n===================Company Stock 100-500% Yield===================");
      portfolio.binarySearchYield(100,2000);
      System.out.println("==================================================================");
   }




}
