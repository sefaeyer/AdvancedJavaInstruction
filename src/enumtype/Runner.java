package enumtype;

public class Runner {
    public static void main(String[] args) {

        printPasswordStrengthConstant("LOW");
        printPasswordStrengthConstant("MEDIUM");
        printPasswordStrengthConstant("GOOD");
        printPasswordStrengthConstant("PERFECT"); // CTE, RTE yok, fakat istenen islev gerceklesmiyor
        printPasswordStrengthConstant("HIGH");

        //COZUM: sabit ve sinirli sayida degiskeni sadece parametre olarak
        //vermek: ENUM TYPE


    }


    //password un gucu: LOW - MEDIUM - HIGH
    public static void printPasswordStrengthConstant(String strength){

        if(strength.equals(PasswordStrengthConstant.LOW)){
            System.out.println("password gucu dusuk");

        }else if(strength.equals(PasswordStrengthConstant.MEDIUM)){
            System.out.println("password gucu orta");

        }else if(strength.equals(PasswordStrengthConstant.HIGH)){
            System.out.println("Tebrikler, password gucu yuksek");
        }else {
            System.out.println("hata!!");
        }

        System.out.println();

    }


}



