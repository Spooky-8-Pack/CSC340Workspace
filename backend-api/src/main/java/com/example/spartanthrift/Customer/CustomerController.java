package com.example.spartanthrift.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //get all students
    @GetMapping("/customers")
    public Object getAllCustomers(){
        return customerService.getAllCustomers();
    }

    //get customer by id
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable long id){
        return customerService.getCustomerById(id);
    }

    //get customer by name
    @GetMapping("/customers/name")
    public Object getCustomersByName(@RequestParam String key){
        if(key != null){
            return customerService.getCustomerByName(key);
        }
        else{
            return customerService.getAllCustomers();
        }
    }

    //get customer by email
    @GetMapping("/customers/email")
    public Object getCustomerByEmail(@RequestParam String key){
        if(key != null){
            return customerService.getCustomerByEmail(key);
        }
        else{
            return customerService.getAllCustomers();
        }
    }

    //add new customer
    @PostMapping("/customers")
    public Object addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    //update a customer
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
        return customerService.getCustomerById(id);
    }

    //delete a customer
    @DeleteMapping("/customers/{id}")
        public Object deleteCustomer(@PathVariable Long id){
            customerService.deleteCustomer(id);
            return customerService.getAllCustomers();
        }
    }

