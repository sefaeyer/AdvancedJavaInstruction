package generics.methods;

import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {


        Integer[] intArr={2,3,8,99,55};
        Double[] doubleArr={1.3,35.6,99.9,0.5};
        String[] stringArr={"Java","generics","hayatımızı","kolaylaştırır"};


        System.out.println(" printArray methodu ile yazdirma");
        printArray(intArr);
        printArray(doubleArr);
        printArray(stringArr);

        System.out.println("Generic printArray methodu ile yazdirma");
        printArrayGenereic(intArr);
        printArrayGenereic(doubleArr);
        printArrayGenereic(stringArr);

        System.out.println("Generic getFirst methodu");
        System.out.println(getFirst(intArr));
        System.out.println(getFirst(doubleArr));
        System.out.println(getFirst(stringArr));

        Integer first=getFirst(intArr);
        System.out.println("first = " + first);

        System.out.println("----------- coklu parametreli generic method -----------");
        printArrAndElement(intArr,"generic");//S:Integer , U:String
        printArrAndElement(intArr,12);       //S:Integer , U:Integer


    }

    //arraylari yazdirmak icin bir method tanimlayalim
    //ayni methodu farkli param ile ne yapmaliyim
    public static void printArray(Integer[] arr){

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }


    public static void printArray(Double[] arr){

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }


    public static void printArray(String[] arr){

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }


    //keske generic bir methodumuz olsaydi
    public static <T> void printArrayGenereic(T[] arr){

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    //keske generic methodumuz geriye generic bir data tipi dondurse
    //NOT: geriye donus data tipi T olmak zorunda degil
    public static <T> T getFirst(T[] arr){

        T first=arr[0];

        return first;
    }

    //  ***   birden fazla data tipi ile generic method   ***
    public static <S,U> void printArrAndElement(S[] arr, U element){

        //arr[0]=element; --> farkli data tipleri!!!

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println(element);

    }


}
