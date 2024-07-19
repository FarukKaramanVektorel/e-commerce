package service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import model.Customer;
import model.CustomerInfo;
import repository.CustomerRepository;
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;   

    public void registerCustomer(String username, String password, String address) {
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setAddress(address);
        customer.setCustomerInfo(customerInfo);
        customerInfo.setCustomer(customer);

        customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void updateCustomer(Customer customer) {
        customerRepository.update(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
}

