package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(5); // canli olan 5 thread var

        Thread kurye1=new ThreadCreator("A",2000);
        Thread kurye2=new ThreadCreator("B",8000);
        Thread kurye3=new ThreadCreator("C",5000);
        Thread kurye4=new ThreadCreator("D",3000);
        Thread kurye5=new ThreadCreator("E",4000);
        Thread kurye6=new ThreadCreator("F",9000);
        Thread kurye7=new ThreadCreator("G",6000);
        Thread kurye8=new ThreadCreator("H",2000);

//        kurye1.start();
//        kurye2.start();
//        kurye3.start();
//        kurye4.start();
//        kurye5.start();
//        kurye6.start();
//        kurye7.start();
//        kurye8.start();

        service.execute(kurye1);
        service.execute(kurye2);
        service.execute(kurye3);
        service.execute(kurye4);
        service.execute(kurye5);
        service.execute(kurye6);
        service.execute(kurye7);
        service.execute(kurye8);

        service.shutdown();//havuzu sonlandirir, aksi halde threadler havuzda belemeye devam eder


    }

}




class ThreadCreator extends Thread{

    public String task;

    public int duration;

    //param const


    public ThreadCreator(String task, int duration) {
        this.task = task;
        this.duration = duration;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" ise basladi. Gorev : "+this.task);
        System.out.println();
        //threadlerimiz islerini farkli surelerde tamamliyor
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" isini tamamlandi.");
        System.out.println();
    }
}
