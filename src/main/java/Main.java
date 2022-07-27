import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // create an executor
        ExecutorService executor;
        executor = Executors.newFixedThreadPool(3);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            // submit tasks to your executor

            PrimeLogger primeLogger = new PrimeLogger(num);
            executor.execute(primeLogger);
        }
        executor.shutdown();

    }
}

// Allows me to create a new threads
class PrimeLogger implements Runnable {
    private final int num;

    public PrimeLogger(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        // print num if it is prime
        if(num >= 2){
            Boolean isPrime = true;
            // Check from 2 to n-1
            for (int i = 2; i < num; i++)
                if (num % i == 0)
                    isPrime = false;
            if(isPrime){
                System.out.println("The number " + num + " is a prime number");
            } else {
                System.out.println("NOT A PRIME NUMBER");
            }
        } else {
            System.out.println("NOT A PRIME NUMBER");
        }


    }
}