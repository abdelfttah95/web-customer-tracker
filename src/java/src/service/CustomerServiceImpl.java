package src.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import src.dao.CustomerDAo;
import src.entity.Customer;

/**
 *
 * @author abdel
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    
    // inject customer dao
    @Autowired
    private CustomerDAo customerDAo;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAo.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        
        customerDAo.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomers(int theId) {
        return customerDAo.getCustomers(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerDAo.deleteCustomer(theId);
    }
    
}
