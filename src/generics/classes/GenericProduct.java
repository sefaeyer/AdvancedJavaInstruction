package generics.classes;
//amacimiz: farkli data tipindeki urun kodlarini tutabilmek icin
//ayri ayri class lar olusturmadan (book, laptop, phone,...)
//tek bir class ile urun objelerini olusturmak

//cozum  : generic bir product class

    /*
      !!!!! - generic olarak sadece NON_PRIMITIVE data tipleri kullanilabilir!

      E --> Element, collection gibi yapılarda kullanılır
      K --> Key
      V --> Value
      N --> Number
      T --> Type
      S,U,V , vb --> 2., 3. ve 4. tipler için

    */

public class GenericProduct <T> {

    private T code; // T : her hangi bir NON-PRIMITIVE data tipi

    //GETTER SETTER

    public T getCode() {
        return code;
    }

    public void setCode(T code) {
        this.code = code;
    }

}
