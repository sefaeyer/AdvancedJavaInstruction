package generics.interfaces.example;
// Uygulamadaki tum repolar icin standart
public interface Repo <T> {

    void save(T obj);
    T find(T obj);

}
