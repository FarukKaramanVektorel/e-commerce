package service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import model.Customer;
import model.CustomerInfo;
import repository.CustomerInfoRepository;
@RequiredArgsConstructor
public class CustomerInfoService {

    private final CustomerInfoRepository customerInfoRepository;

   

    public void addCustomerInfo(String address, Customer customer) {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setAddress(address);
        customerInfo.setCustomer(customer);

        customerInfoRepository.save(customerInfo);
    }

    public CustomerInfo getCustomerInfoById(Long id) {
        return customerInfoRepository.findById(id);
    }

    public List<CustomerInfo> getAllCustomerInfos() {
        return customerInfoRepository.findAll();
    }

    public void updateCustomerInfo(CustomerInfo customerInfo) {
        customerInfoRepository.update(customerInfo);
    }

    public void deleteCustomerInfo(CustomerInfo customerInfo) {
        customerInfoRepository.delete(customerInfo);
    }
}
