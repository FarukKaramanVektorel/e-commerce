package controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import lombok.RequiredArgsConstructor;
import model.Customer;
import model.CustomerPrice;
import model.Product;
import service.CustomerPriceService;

@RequiredArgsConstructor
public class CustomerPriceController {

    private final CustomerPriceService customerPriceService;
    private final Scanner scanner = new Scanner(System.in);

    public void musteriFiyatEkle() {
        System.out.println("Müşteri ID'si girin:");
        Long customerId = Long.parseLong(scanner.nextLine());
        System.out.println("Ürün ID'si girin:");
        Long productId = Long.parseLong(scanner.nextLine());
        System.out.println("İşlem tarihi (yyyy-MM-ddTHH:mm:ss) girin:");
        LocalDateTime date = LocalDateTime.parse(scanner.nextLine());
        System.out.println("Ürün adedi girin:");
        Integer quantity = Integer.parseInt(scanner.nextLine());

        Customer customer = new Customer(); // Müşteri bilgisi alınarak atanmalı
        customer.setId(customerId);
        Product product = new Product(); // Ürün bilgisi alınarak atanmalı
        product.setId(productId);

        customerPriceService.addCustomerPrice(customer, product, date, quantity);
        System.out.println("Müşteri fiyatı başarıyla eklendi!");
    }

    public void musteriFiyatGetirById() {
        System.out.println("Müşteri fiyatı ID girin:");
        Long id = Long.parseLong(scanner.nextLine());
        CustomerPrice customerPrice = customerPriceService.getCustomerPriceById(id);
        System.out.println(customerPrice);
    }

    public void tumMusteriFiyatlariniGetir() {
        List<CustomerPrice> customerPrices = customerPriceService.getAllCustomerPrices();
        customerPrices.forEach(System.out::println);
    }

    public void musteriFiyatGuncelle() {
        System.out.println("Müşteri fiyatı ID girin:");
        Long id = Long.parseLong(scanner.nextLine());
        CustomerPrice customerPrice = customerPriceService.getCustomerPriceById(id);
        if (customerPrice != null) {
            System.out.println("Yeni müşteri ID'si girin:");
            Long customerId = Long.parseLong(scanner.nextLine());
            System.out.println("Yeni ürün ID'si girin:");
            Long productId = Long.parseLong(scanner.nextLine());
            System.out.println("Yeni işlem tarihi (yyyy-MM-ddTHH:mm:ss) girin:");
            LocalDateTime date = LocalDateTime.parse(scanner.nextLine());
            System.out.println("Yeni ürün adedi girin:");
            Integer quantity = Integer.parseInt(scanner.nextLine());

            Customer customer = new Customer(); // Müşteri bilgisi alınarak atanmalı
            customer.setId(customerId);
            Product product = new Product(); // Ürün bilgisi alınarak atanmalı
            product.setId(productId);

            customerPrice.setCustomer(customer);
            customerPrice.setProduct(product);
            customerPrice.setTransactionDate(date);
            customerPrice.setQuantity(quantity);

            customerPriceService.updateCustomerPrice(customerPrice);
            System.out.println("Müşteri fiyatı başarıyla güncellendi!");
        } else {
            System.out.println("Müşteri fiyatı bulunamadı.");
        }
    }

    public void musteriFiyatSil() {
        System.out.println("Müşteri fiyatı ID girin:");
        Long id = Long.parseLong(scanner.nextLine());
        CustomerPrice customerPrice = customerPriceService.getCustomerPriceById(id);
        if (customerPrice != null) {
            customerPriceService.deleteCustomerPrice(customerPrice);
            System.out.println("Müşteri fiyatı başarıyla silindi!");
        } else {
            System.out.println("Müşteri fiyatı bulunamadı.");
        }
    }
}
