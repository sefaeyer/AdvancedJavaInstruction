package generics.bounding;

import java.util.ArrayList;
import java.util.List;

//wildcard ne demek:  (?)  joker, bilinmeyen bir data tipi
public class GenericWithWildcard {

    public static void main(String[] args) {

        List<Integer> integers=new ArrayList<>();
        List<Double> doubles=new ArrayList<>();
        List<String> strings=new ArrayList<>();
        List<Number> numbers=new ArrayList<>();
        List<Object> objects=new ArrayList<>();



        System.out.println("--------  alttan sinirlama  -----------");
        addElements(integers);
        System.out.println(integers);
        //addElements(doubles);
        //addElements(strings);
        addElements(numbers);
        addElements(objects);


        System.out.println("===========  ustten sinirlama  ============");
        multiplyByTwo(integers);
        multiplyByTwo(doubles);
        //multiplyByTwo(strings);
        multiplyByTwo(numbers);
        //multiplyByTwo(objects);


    }

    //alttan sinirlama
    //liste 1 den 10 a kadar elemanlari ekleyen method
    //list: Integer,Number,Object
    public static void addElements(List<? super Integer> list){

        for(int i=1;i<11;i++){
            list.add(i);
        }

    }

    //generic yapiyi kullanirken ustten sinirlama
    //listedeki elemanlari 2 ile carpan method
    public static void multiplyByTwo(List<? extends Number> list){

        list.stream().map(t->2*t.doubleValue());

    }


    //?: bilinmeyen data tipt demektir
    //wildcard ile sadece okuma (read only) yazabilirsiniz
    //sadece data tipinden bagimsiz islemler yapilabilir
    public static void printElements(List<?> list){ // List<T> yapisina benzer

        //list.add(12); // degisiklik yapilacak islemlere izin vermez
        list.remove(2);

        for(Object obj:list){
            System.out.println(obj+" ");
        }


    }
// !!! NOT: List<T> ile List<?> benzer, ama tamamen ayni degil

    public static <T> void addElementsToList(List<T> list, T elemment){

        list.add(elemment);

    }



}
