package src.dao;

import src.entity.Customer;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abdel
 */
@Repository
public class CustomerDAOImpl implements CustomerDAo {

    // injecting session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // get current hibernate session 
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query theQuery = currentSession.createQuery("from Customer order by lastName");

        // execute the query and get result list 
        List<Customer> customers = theQuery.list();

        // return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {

        // get current hibernate session 
        Session currentSession = sessionFactory.getCurrentSession();

        // save the customer
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomers(int theId) {
        // get current hibernate session 
        Session currentSession = sessionFactory.getCurrentSession();

        // retrieve / read from the db using primary key
        Customer theCustomer = (Customer) currentSession.get(Customer.class, theId);

        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {

        // get current session 
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery
                = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);

        theQuery.executeUpdate();
    }

}
