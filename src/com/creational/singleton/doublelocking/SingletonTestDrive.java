package com.creational.singleton.doublelocking;

public class SingletonTestDrive {

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            AppConfig config = AppConfig.getInstance();

            System.out.println(
                    Thread.currentThread().getName()
                            + " -> Instance HashCode: "
                            + System.identityHashCode(config)
            );
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");
        Thread thread3 = new Thread(task, "Thread-3");
        Thread thread4 = new Thread(task, "Thread-4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // Wait for all threads to finish
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        // Final verification
        AppConfig config1 = AppConfig.getInstance();
        AppConfig config2 = AppConfig.getInstance();

        System.out.println("\nFinal Verification:");
        System.out.println("config1 == config2 : " + (config1 == config2));
        System.out.println("config1 hashCode   : " + System.identityHashCode(config1));
        System.out.println("config2 hashCode   : " + System.identityHashCode(config2));
    }
}