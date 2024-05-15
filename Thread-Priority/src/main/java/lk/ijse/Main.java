package lk.ijse;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread( () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread One");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread Two");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.setName("Thread One");
        t2.setName("Thread Two");

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());

        System.out.println(t1.getName());
        System.out.println(t2.getName());

        t2.start();
        t1.join();
        t2.join();
        System.out.println("Bye");
    }
}