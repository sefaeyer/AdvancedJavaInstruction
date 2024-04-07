package generics.interfaces;

//2.SEÇENEK : Generic i,nterface i implemente ederken data tipine karar verebiliriz

public class GenericInterfaceStringImpl implements GenericInterface<String> { //T : String

    @Override
    public void print(String value) {

    }

    @Override
    public String find() {
        return null;
    }

}
