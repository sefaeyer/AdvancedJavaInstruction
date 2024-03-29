package threads;

public class Multithreading02 {

    public static volatile int sayac=0;
    public static void main(String[] args) {


        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <11 ; i++) {
                    System.out.println("su satildi");
                }
                Sayac.count();
                for (int i = 1; i <11 ; i++) {
                    System.out.println("su satildi");
                }
            }
        });
        thread1.setName("TOM");
        thread1.start();


        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <11 ; i++) {
                    System.out.println("mesrubat satildi");
                }
                Sayac.count();
                for (int i = 1; i <11 ; i++) {
                    System.out.println("mesrubat satildi");
                }
            }
        });
        thread2.setName("JERRY");
        thread2.start();


    }



}
class Sayac{

    //bu methoda thread ler sirayla ulasmali
    public static synchronized void count(){

        for(int i=1;i<=1000;i++){
            Multithreading02.sayac++;
            System.out.println(Thread.currentThread().getName()+"----> sayac : "+Multithreading02.sayac);
        }

    }

}