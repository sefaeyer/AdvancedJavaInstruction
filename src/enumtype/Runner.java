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

        System.out.println("================================================================================");

        printPasswordStrengthEnum(PasswordStrength.LOW);
        printPasswordStrengthEnum(PasswordStrength.MEDIUM);
        printPasswordStrengthEnum(PasswordStrength.HIGH);
        //printPasswordStrengthEnum("LOW"); // --> Parametreye sadece Enum Type girilebilir



    }


    //password un gucu: LOW - MEDIUM - HIGH
    public static void printPasswordStrengthConstant(String strength){

        if(strength.equals(PasswordStrengthConstant.LOW)){
            System.out.println("password gucu dusuk");

        }else if(strength.equals(PasswordStrengthConstant.MEDIUM)){
            System.out.println("password gucu orta");

        }else if(strength.equals(PasswordStrengthConstant.HIGH)){
            System.out.println("Tebrikler, password gucu yuksek");
        }

    }


    //enum type ile ayni method
    public static void printPasswordStrengthEnum(PasswordStrength strength){
        if(strength.equals(PasswordStrength.LOW)){
            System.out.println("password gucu dusuk");
            System.out.println("Seviye: "+strength.getLevel());
        }else if(strength.equals(PasswordStrength.MEDIUM)){
            System.out.println("password gucu orta");
        }else if(strength.equals(PasswordStrength.HIGH)){
        //}else if(strength.ordinal()==2){
            System.out.println("Tebrikler, password gucu yuksek");
        }

        System.out.println("Enum sirasi: "+strength.ordinal());
        System.out.println("Enum ismi: "+strength.name());
    }


}



