package service;

import java.time.LocalDateTime;
import java.util.List;

import lombok.RequiredArgsConstructor;
import model.Customer;
import model.CustomerPrice;
import model.Product;
import repository.CustomerPriceRepository;
@RequiredArgsConstructor
public class CustomerPriceService {

    private final CustomerPriceRepository customerPriceRepository;   

    public void addCustomerPrice(Customer customer, Product product, LocalDateTime transactionDate, Integer quantity) {
        CustomerPrice customerPrice = new CustomerPrice();
        customerPrice.setCustomer(customer);
        customerPrice.setProduct(product);
        customerPrice.setTransactionDate(transactionDate);
        customerPrice.setQuantity(quantity);

        customerPriceRepository.save(customerPrice);
    }

    public CustomerPrice getCustomerPriceById(Long id) {
        return customerPriceRepository.findById(id);
    }

    public List<CustomerPrice> getAllCustomerPrices() {
        return customerPriceRepository.findAll();
    }

    public void updateCustomerPrice(CustomerPrice customerPrice) {
        customerPriceRepository.update(customerPrice);
    }

    public void deleteCustomerPrice(CustomerPrice customerPrice) {
        customerPriceRepository.delete(customerPrice);
    }
}

