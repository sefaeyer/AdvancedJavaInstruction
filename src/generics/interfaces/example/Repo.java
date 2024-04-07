package generics.interfaces.example;
// Uygulamadaki tum repolar icin standart belirlemek
public interface Repo <T> {

    void save(T obj);
    T find();

}
