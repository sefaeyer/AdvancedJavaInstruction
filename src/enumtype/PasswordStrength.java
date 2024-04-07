package enumtype;

public enum PasswordStrength {

    LOW(10),
    MEDIUM(50),
    HIGH(100);

    private final int level; // final yazinca deger atamak zorundayiz

    PasswordStrength(int level){
        this.level=level;
    }//default : private

    public int getLevel(){
        return this.level;

    }

}
