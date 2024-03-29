package threads;

public class Multithreading01 {
    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        //TASK: 1 den 10 a kadar 2 defa sayma yapalim
        Counter counter1=new Counter("Hakan");
        Counter counter2=new Counter("Ahmet");
        counter1.count();
        counter2.count();

        long finish=System.currentTimeMillis();
        System.out.println("mainthraed "+(finish-start));

        System.out.println("-------------------------- multithrading ---------------------");

        long start1=System.currentTimeMillis();

        Thread thread1=new CounterThread("Selim");
        Thread thread2=new CounterThread("Fatma");
        Thread thread3=new CounterThread("Sefa");
        thread1.start();
        thread2.start();
        thread3.start();

        //main thread thread1 ve thread2 isini bitirene kadar bekleeli
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finish1=System.currentTimeMillis();
        System.out.println("multi-thraed "+(finish1-start1));





    }
}
class Counter{

    public String name;

    //param const

    public Counter(String name) {
        this.name = name;
    }

    //1 den 10 kadar yazdiralim
    public void count(){

        for(int i=1;i<11;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i+"  -  "+this.name);
        }
    }
}


//ayni task i multithreading ile yapalim
class CounterThread extends Thread{

    public String name;

    public CounterThread(String name) {
        this.name = name;
    }

    public void count(){

        for(int i=1;i<11;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i+"  -  "+this.name);
        }
    }

    @Override
    public void run() {
        count();
    }
}