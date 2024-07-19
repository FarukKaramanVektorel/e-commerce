package controller;

import java.util.List;
import java.util.Scanner;

import lombok.RequiredArgsConstructor;
import model.Customer;
import service.CustomerService;

@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final Scanner scanner = new Scanner(System.in);

    public void musteriOlustur() {
        System.out.println("Kullanıcı adı girin:");
        String username = scanner.nextLine();
        System.out.println("Şifre girin:");
        String password = scanner.nextLine();
        System.out.println("Adres girin:");
        String address = scanner.nextLine();

        customerService.registerCustomer(username, password, address);
        System.out.println("Müşteri başarıyla oluşturuldu!");
    }

    public void musteriGetirById() {
        System.out.println("Müşteri ID girin:");
        Long id = Long.parseLong(scanner.nextLine());
        Customer customer = customerService.getCustomerById(id);
        System.out.println(customer);
    }

    public void tumMusterileriGetir() {
        List<Customer> customers = customerService.getAllCustomers();
        customers.forEach(System.out::println);
    }

    public void musteriGuncelle() {
        System.out.println("Müşteri ID girin:");
        Long id = Long.parseLong(scanner.nextLine());
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            System.out.println("Yeni kullanıcı adı girin:");
            customer.setUsername(scanner.nextLine());
            System.out.println("Yeni şifre girin:");
            customer.setPassword(scanner.nextLine());
            System.out.println("Yeni adres girin:");
            customer.getCustomerInfo().setAddress(scanner.nextLine());

            customerService.updateCustomer(customer);
            System.out.println("Müşteri başarıyla güncellendi!");
        } else {
            System.out.println("Müşteri bulunamadı.");
        }
    }

    public void musteriSil() {
        System.out.println("Müşteri ID girin:");
        Long id = Long.parseLong(scanner.nextLine());
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            customerService.deleteCustomer(customer);
            System.out.println("Müşteri başarıyla silindi!");
        } else {
            System.out.println("Müşteri bulunamadı.");
        }
    }
}
