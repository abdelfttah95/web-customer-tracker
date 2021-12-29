package src.service;

import java.util.List;
import src.entity.Customer;

/**
 *
 * @author abdel
 */
public interface CustomerService {

    public void saveCustomer(Customer theCustomer);
    
    public List<Customer> getCustomers();

    public Customer getCustomers(int theId);

    public void deleteCustomer(int theId);
    
}
