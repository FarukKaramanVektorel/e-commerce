package controller;

import java.util.List;
import java.util.Scanner;

import lombok.RequiredArgsConstructor;
import model.Customer;
import model.CustomerInfo;
import service.CustomerInfoService;

@RequiredArgsConstructor
public class CustomerInfoController {

    private final CustomerInfoService customerInfoService;
    private final Scanner scanner = new Scanner(System.in);

    public void musteriBilgisiEkle() {
        System.out.println("Adres girin:");
        String address = scanner.nextLine();
        System.out.println("Müşteri ID'si girin:");
        Long customerId = Long.parseLong(scanner.nextLine());
        Customer customer = new Customer(); // Müşteri bilgisi alınarak atanmalı
        customer.setId(customerId);

        customerInfoService.addCustomerInfo(address, customer);
        System.out.println("Müşteri bilgisi başarıyla eklendi!");
    }

    public void musteriBilgisiGetirById() {
        System.out.println("Müşteri bilgisi ID girin:");
        Long id = Long.parseLong(scanner.nextLine());
        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(id);
        System.out.println(customerInfo);
    }

    public void tumMusteriBilgileriniGetir() {
        List<CustomerInfo> customerInfos = customerInfoService.getAllCustomerInfos();
        customerInfos.forEach(System.out::println);
    }

    public void musteriBilgisiGuncelle() {
        System.out.println("Müşteri bilgisi ID girin:");
        Long id = Long.parseLong(scanner.nextLine());
        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(id);
        if (customerInfo != null) {
            System.out.println("Yeni adres girin:");
            customerInfo.setAddress(scanner.nextLine());

            customerInfoService.updateCustomerInfo(customerInfo);
            System.out.println("Müşteri bilgisi başarıyla güncellendi!");
        } else {
            System.out.println("Müşteri bilgisi bulunamadı.");
        }
    }

    public void musteriBilgisiSil() {
        System.out.println("Müşteri bilgisi ID girin:");
        Long id = Long.parseLong(scanner.nextLine());
        CustomerInfo customerInfo = customerInfoService.getCustomerInfoById(id);
        if (customerInfo != null) {
            customerInfoService.deleteCustomerInfo(customerInfo);
            System.out.println("Müşteri bilgisi başarıyla silindi!");
        } else {
            System.out.println("Müşteri bilgisi bulunamadı.");
        }
    }
}
