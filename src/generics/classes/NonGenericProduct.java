package generics.classes;
//amacimiz: farkli data tipindeki urun kodlarini tutabilmek icin
//ayri ayri class lar olusturmadan (book, laptop, phone,...)
//tek bir class ile urun objelerini olusturmak
public class NonGenericProduct {

    private Object code;// code field inin data tipi object oldugu icin olusturulan
                        // nesnelerin code ozelliginde tum data tipleri kullanilabilir


    //getter setter

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }
}
