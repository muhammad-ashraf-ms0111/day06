

//import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMain {

    public static void main(String[] args) {

        List<Integer> numList = new LinkedList<>();
        ExecutorService threadpool = Executors.newFixedThreadPool(2);

        for (Integer i = 0; i < 3; i++) {
            // Create a thread
            RandomNumber thr = new RandomNumber("thr-%d".formatted(i), 100, numList);
            // this is just a method call
            //thr.run();
            // Schedule a thread to the Runnable
            threadpool.submit(thr);
        }

        System.out.println("All done");
        while (true) {
            System.out.println("\n>>>> numList: " + numList + ", size: " + numList.size());
            try {
                // Sleep for 15 sec
                Thread.sleep(1 * 1000);
            } catch (InterruptedException ex) { }
        }
    }
}


//main program (execute Thread pool)
//determine how many thread pool
//create thread and schedule a thread to the runnable
//main thread is considered 1 thread 
//inter living - threads run concurrently
//program doesnt end due to running thread pool
//end by cmd+c