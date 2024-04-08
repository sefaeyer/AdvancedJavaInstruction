package threads;

public class ThreadCreationWays {
    public static void main(String[] args) {

        // her java programinda default olarak bir tane thread baslatilir: main thread
        System.out.println("Mevcut thread: "+Thread.currentThread().getName());

        //1.YOL:
        Thread thread1=new MyTread();
        //thread1.run();//----!!!!!! Thread baslatilmaz
        thread1.start();//Threadi baslatir, run methodunu cagirarak
        thread1.setName("threadcik");



        //2. YOL
        Runnable runnable=new MyRunnable();
        Thread thread2=new Thread(runnable);
        thread2.start();


        //2.Yol. b) anonymous class: isimsiz bir class
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Calisan Thread: "+Thread.currentThread().getName());
                System.out.println("Anonim thread uyuyacak :)))");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Anonim thread uyandi :)))");
                System.out.println("Anonymous class ile tanimlanan thread tamamlandi");
            }
        });
        thread3.setName("anonim");
        thread3.start();

        //2. Yol.c) Lambda exp ile
        Thread thread4=new Thread(()->{
            //run methodunun body
            System.out.println("Calisan Thread: "+Thread.currentThread().getName());
            System.out.println("Lambda exp ile olusturuldu");
        });
        thread4.start();

        //main thread i bir sure bekletmem lazim
        try {
            Thread.sleep(2000); // hangi thread cagirirsa bu threadi bekletir
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main metodu burada tamamlandi");

    }


}
//thread olusturmanin SADECE 2 tane yolu var
//1. YOL: Thread clasini extend ederek

class MyTread extends Thread{

    @Override
    public void run() {
        //thread e yaptirmak istedigimiz islemleri
        System.out.println("Calisan Thread: "+Thread.currentThread().getName());
        System.out.println("Mythread threadi calisyor. Harika!");
    }
}


//2. YOL: Runnable Interface ini(functional) implemente ederek
class MyRunnable implements Runnable{

    @Override
    public void run() {
        //threade yaptirmak istedigimiz islemleri
        System.out.println("Calisan thread: "+Thread.currentThread().getName());
        System.out.println("Runnable ile hazirlanan thread calisti");
    }
}