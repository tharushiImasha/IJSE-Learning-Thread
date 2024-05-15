package lk.ijse;

class Calculation{
    int num;

    public synchronized void increment(){
        num++;
    }

}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Calculation calculation = new Calculation();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                calculation.increment();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                calculation.increment();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(calculation.num);
    }
}