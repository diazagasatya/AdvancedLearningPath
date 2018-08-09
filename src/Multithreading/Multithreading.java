package Multithreading;

public class Multithreading {

   /**
    * Multiply all of the elements of the array by 2,000,000
    * @param args
    */
   public static void main(String[] args) {
      SharedResources sharedResources = new SharedResources();
      new Producer(sharedResources);
      new Consumer(sharedResources);
      new Client(sharedResources);
   }
}

class Client implements Runnable {
   SharedResources sharedResources;
   public Client(SharedResources resources) {
      sharedResources = resources;
      Thread thread = new Thread(this, "Client");
      thread.start();
   }

   /**
    * This method will purchase 75 stock for every .5 seconds
    */
   public void run() {
      while(true) {
         try {
            System.out.println(Thread.currentThread().getName());
            sharedResources.purchase(10);
            Thread.sleep(500);
         } catch(InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}

class Consumer implements Runnable {
   SharedResources sharedResources;
   public Consumer(SharedResources resources) {
      sharedResources = resources;
      Thread thread = new Thread(this, "Consumer");
      thread.start();
   }

   /**
    * This method will purchase 75 stock for every 2 seconds
    */
   public void run() {
      while(true) {
         try {
            System.out.println(Thread.currentThread().getName());
            sharedResources.purchase(75);
            Thread.sleep(2000);
         } catch(InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}

class Producer implements Runnable {
   SharedResources sharedResources;
   public Producer(SharedResources resources) {
      sharedResources = resources;
      Thread thread = new Thread(this, "Producer");
      thread.start();
   }

   /**
    * This method will produce 1000 quantity for every 5 seconds
    */
   public void run() {
      while(true) {
         try {
            System.out.println(Thread.currentThread().getName());
            sharedResources.produce(1000);
            Thread.sleep(5000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}

/**
 * This shared resources can only be accessed by one thread only
 */
class SharedResources {

   int stockAvailability;

   public void produce(int quantity) {
      // Only one thread can run this
      synchronized(this) {
         stockAvailability += quantity;
         System.out.println("Current available stock are : " + stockAvailability);
      }
   }

   public void purchase(int quantity) {
      // Only one thread can run this
      synchronized(this) {
         stockAvailability -= quantity;
         System.out.println("Current available stock after purchase : " + stockAvailability);
      }
   }


}

