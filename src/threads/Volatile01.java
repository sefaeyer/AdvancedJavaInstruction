package threads;

public class Volatile01 {

    public static volatile int flag =0;//cache aliniyor

    public static void main(String[] args) {

        Thread thread1=new Thread(new Runnable() { //1. cekirdek
            @Override
            public void run() {

                while (flag ==0){
                    System.out.println("bu sadece bi risk");
                }

            }
        });
        thread1.start();

        Thread thread2=new Thread(new Runnable() { //2. cekirdek
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                flag =1;
                System.out.println("flag=1 oldu, dongu duracak");

            }
        });
        thread2.start();

    }
}
