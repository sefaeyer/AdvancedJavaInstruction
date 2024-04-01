package threads;

//wait-notify : thread arasında iletişimi sağlar.
//üretici(producer)-tüketici(consumer)
/*Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
        Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
        Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.*/
public class WaitNotify {

    public static int balance=0;



    //paar yatirma islemi
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName()+" para yatirmak istiyor. ");
        this.balance+=amount;
        System.out.println("Para yatirma islemi basarili, mevcut bakiye: "+this.balance);
        notify();//wait ile bekleyen thread e bildirim gonderilir
        // notifyAll(); // wait ile bekleyen tum thread lere bildirim gonderir
    }

    //para cekme islemi
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para cekmek istiyor. ");
        //bakiye yetersiz ise
        if(balance==0 || balance<amount){
            System.out.println("Bakiye yetersiz!  Mevcut bakiye: "+ this.balance);
            System.out.println("Bakiyenin guncellenmesi bekleniyor...");
            try {
                wait();// monitoe edilen objeyi gecici olarak serbest birakiyor
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //kaldigi yerden isine devam eder
        //bakiye yeterli ise
        if(balance>=amount){
            this.balance-=amount;
            System.out.println("Para cekme islemi basarili. Mevcut bakiye: "+this.balance);
        }else {
            System.out.println("Bakiyeniz yetersiz! Mevcut bakiye:  "+this.balance);
            System.out.println("Daha sonra tekrar dene");
        }



    }

    public static void main(String[] args) {

        WaitNotify obj = new WaitNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(1000);
            }
        });
        thread1.setName("Alican");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);
            }
        });
        thread2.setName("Veli");
        thread2.start();


    }

}

