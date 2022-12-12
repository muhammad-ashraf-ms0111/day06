
  
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

public class RandomNumber implements Runnable {

    private String name;
    private Integer range;
    private List<Integer> numList;
    public RandomNumber(String name, Integer range , List<Integer> numList) { 
        this.name = name;
        this.range = range;
        this.numList = numList;
    }

    @Override
    public void run() {
        // The body of the thread
        Random rand = new SecureRandom();
        for (Integer i = 0; i < 10; i++) {
            Integer num = rand.nextInt(range);
            numList.add(num);
            System.out.printf("%d [%s] %d\n", i, name, num);
            try {
                // Sleep for 2 sec
                Thread.sleep(2 * 1000);
            } catch (InterruptedException ex) { }
        }
    }
}

//mini program to implement the runnable interface