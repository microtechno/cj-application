package com.cjayawardana.customerservice.controller;

import com.cjayawardana.customerservice.model.Customer;
import com.cjayawardana.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> list(){
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable("id") long id) {
        return customerRepository.getOne(id);

    }

    @PostMapping
    public Customer create(@RequestBody Customer user){
        return customerRepository.saveAndFlush(user);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable long id, @RequestBody Customer customer ){
        if (!customerRepository.existsById(id)) {
            return null;
        }
        return customerRepository.saveAndFlush(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id ){
        if (!customerRepository.existsById(id)) {
            return;
        }

        Customer customer = customerRepository.getOne(id);
        customerRepository.delete(customer);
    }

}
