package enumtype;

public enum PasswordStrength {

    FAIL(0),   //0
    LOW(10),   //0 -> 1
    MEDIUM(50), //1 -> 2
    HIGH(100); //2 -> 3

    private final int level; // final yazinca deger atamak zorundayiz


    //param const
    PasswordStrength(int level){
        this.level=level;
    }//default : private

    public int getLevel(){
        return this.level;

    }

}
