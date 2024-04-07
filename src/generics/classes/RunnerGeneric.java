package generics.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class RunnerGeneric {
    public static void main(String[] args) {

        //generic yapilari kullanirken data tipine karar verilir
        //2 farkli nesne: laptop, book

        GenericProduct<String> book=new GenericProduct<>();
        book.setCode("advjava");

        GenericProduct<Integer> laptop=new GenericProduct<>();
        laptop.setCode(123456);
        //laptop.setCode("laptop");// sadece Integer girilebilir

        String str = book.getCode();// CAST problemi yok

        //  String str2=laptop.getCode();//ClassCastExc. alma riski çözüldü

        Integer code = laptop.getCode();


        //-----------------------------------------
        //----------------------------------------


        ArrayList<String> list = new ArrayList<>();

        HashMap<String,Double> hashMap=new HashMap<>();
        hashMap.put("AdvJava",99.9);
        //hashMap.put(12,23);--> cte aliriz


        //--------------- COK PARAMETRELI GENERIC CLASS ----------------

        //S:String , U:Integer
        GenericClassTwoParam<String,Integer> obje=new GenericClassTwoParam<>("generic",12);

        //S:String , U:String
        GenericClassTwoParam<String,String> obje2=new GenericClassTwoParam<>("generics","harika");

        //S:Double , U:Boolean
        GenericClassTwoParam<Double,Boolean> obje3=new GenericClassTwoParam<>(11.11,Boolean.TRUE);




    }
}
