package enumtype;

public class Runner {
    public static void main(String[] args) {

        printPasswordStrengthConstant("LOW");
        printPasswordStrengthConstant("MEDIUM");
        printPasswordStrengthConstant("GOOD");
        printPasswordStrengthConstant("PERFECT");
        printPasswordStrengthConstant("HIGH");



    }


    //password un gucu: LOW MEDIUM HIGH
    public static void printPasswordStrengthConstant(String strength){

        if(strength.equals(PasswordStrengthConstant.LOW)){
            System.out.println("password gucu dusuk");

        }else if(strength.equals(PasswordStrengthConstant.MEDIUM)){
            System.out.println("password gucu orta");

        }else if(strength.equals(PasswordStrengthConstant.HIGH)){
            System.out.println("Tebrikler, password gucu yuksek");
        }


    }


}



