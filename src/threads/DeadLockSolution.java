package threads;

public class DeadLockSolution {
    public static void main(String[] args) {

        String sugar="seker";
        String coffee="kahve";

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (coffee) {
                    System.out.println(Thread.currentThread().getName() + " " + coffee + " yi kullaniyor..");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + sugar + " i istiyor..");
                    synchronized (sugar){
                        System.out.println(Thread.currentThread().getName() + " " + sugar + " i kullaniyor..");
                    }//seker serbest birakildi
                }//kahve serbest birakildi
                System.out.println(Thread.currentThread().getName() + " sicak su ekledi ve kahvesini yudumluyor..");
            }
        });
        thread1.setName("Tom");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (coffee){
                    System.out.println(Thread.currentThread().getName() + " " + coffee + " i kullaniyor..");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + sugar + " yi istiyor..");
                    synchronized (sugar){
                        System.out.println(Thread.currentThread().getName() + " " + sugar + " yi kullaniyor..");
                    }//kahve serbest
                }//seker serbest
                System.out.println(Thread.currentThread().getName() + " sicak su ekledi ve kahvesini yudumluyor..");
            }
        });
        thread2.setName("Jerry");
        thread2.start();

    }
}
