package threads;
/*
    Bazi threadlerin main thread ve diger threadlrin once calismasini ve isini tamamladiktan sonra diger threadlerin
    kaldigi yerden devam etmesini istedigimizde
    CountDownLatch classinin methodlari ile oncelik vermek istedgimiz threadlerin(worker threads)
    sayisi kadar bir sayac baslatip sayac 0 olana kadar diger threadler bekletilebilir.
 */

import java.util.concurrent.CountDownLatch;

public class CountDownLatch01 {
    public static void main(String[] args) {

        //task: worker threadler işini tammamlayana kadar main thread ve thread-0 beklensin

        System.out.println("Burada main thread calismaya basladi");

        CountDownLatch latch=new CountDownLatch(3);

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" calismaya basladi...");
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" calismaya devam ediyor...");
                System.out.println(Thread.currentThread().getName()+" isini tamamladi...");
            }
        });
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" calismaya basladi...");
                System.out.println(Thread.currentThread().getName()+" calismaya devam ediyor...");
                System.out.println(Thread.currentThread().getName()+" isini tamamladi...");
            }
        });
        thread2.start();

        WorkerThreads worker1=new WorkerThreads("A",5000,latch);
        WorkerThreads worker2=new WorkerThreads("B",7000,latch);
        WorkerThreads worker3=new WorkerThreads("C",3000,latch);

        worker1.start();
        worker2.start();
        worker3.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Burada main thread calismaya devam ediyor");
    }


}

class WorkerThreads extends Thread{

    public int duration;

    public CountDownLatch latch;

    //param const

    public WorkerThreads(String name, int duration, CountDownLatch latch) {
        super(name);
        this.duration = duration;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" calismaya basladi...");
        //burada bazi islemler var kabul edelim
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" isini bitirdi");
        latch.countDown();//sayaci bir azaltir
        System.out.println(latch.getCount());
    }
}









