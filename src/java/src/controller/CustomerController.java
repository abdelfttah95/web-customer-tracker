package src.controller;

import src.entity.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import src.service.CustomerService;

/**
 *
 * @author abdel
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    // injecting customer service
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String listCustomers(Model theModel) {
        // get customers from the DAo
        List<Customer> thCustomers = customerService.getCustomers();
        // add the customers to the model
        theModel.addAttribute("customers", thCustomers);
        return "list-customers";
    }

    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind model data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @RequestMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@ModelAttribute("customerId") int theId,
            Model theModel) {
        // get the customer from service 
        Customer theCustomer = customerService.getCustomers(theId);

        // set customer as model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);
        
        // send over to the form
        return "customer-form";
    }
    
    @RequestMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){
        
        // delete customer 
        customerService.deleteCustomer(theId);
        
        return "redirect:/customer/list";
    }
}
