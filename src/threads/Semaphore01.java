package threads;

        /*
        Semaphore, n tane (2,3,4,...) ayni anda ortak bir kaynaga erismesine izin vermemizi saglar

        Syncronized, ayni anda ortak bir kaynaga(blok, method) sadece 1 threadin erismesine izin verir

         */

import java.util.concurrent.Semaphore;

public class Semaphore01 {
    public static void main(String[] args) {

        Semaphore semaphore=new Semaphore(5);

        Car car1=new Car("Audi",5000,semaphore);
        Car car2=new Car("BMW",8000,semaphore);
        Car car3=new Car("Honda",2000,semaphore);
        Car car4=new Car("Toyota",3000,semaphore);
        Car car5=new Car("Porche",6000,semaphore);
        Car car6=new Car("Fiat",4000,semaphore);
        Car car7=new Car("Volvo",2000,semaphore);
        Car car8=new Car("Ford",2000,semaphore);

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start();
        car8.start();// canli 8 tane thread var, ama ortak kaynagi ayni anda 5 thread erisebilir


    }

}

class Car extends Thread{

    public String carName;

    public int duration;

    public Semaphore semaphore;

    //param const


    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println(this.carName+" park etmek istiyor...");
        try {
            semaphore.acquire();// ortak kaynaga erisim iznini kontrol ediyor.
            //ortak kaynagin baslangici...
            System.out.println("--> "+this.carName+" park alanina girdi...");
            System.out.println(this.carName+" park alaninda bekliyor...");
            Thread.sleep(duration);
            System.out.println("<-- "+this.carName+" park alanindan ayrildi.");
            //ortak kaynagin bitisi.
            semaphore.release();//izin belgesi serbest birakilir, yani kapasite sayisi artirilir

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}























