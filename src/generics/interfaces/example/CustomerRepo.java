package generics.interfaces.example;
// Customer in database islemleri
public class CustomerRepo implements Repo<Customer> {
    @Override
    public void save(Customer obj) {

    }

    @Override
    public Customer find(Customer obj) {
        return null;
    }
}
