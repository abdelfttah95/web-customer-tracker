package src.dao;

import src.entity.Customer;
import java.util.List;

/**
 *
 * @author abdel
 */
public interface CustomerDAo {
    
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomers(int theId);

    public void deleteCustomer(int theId);
}
