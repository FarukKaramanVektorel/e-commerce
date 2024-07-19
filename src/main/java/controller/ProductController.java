package controller;

import java.util.List;
import java.util.Scanner;

import lombok.RequiredArgsConstructor;
import model.Category;
import model.Product;
import service.ProductService;

@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final Scanner scanner = new Scanner(System.in);

    public void urunEkle() {
        System.out.println("Ürün adı girin:");
        String name = scanner.nextLine();
        System.out.println("Ürün fiyatı girin:");
        Double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Stok adedi girin:");
        Integer stock = Integer.parseInt(scanner.nextLine());
        System.out.println("Kategori ID'si girin:");
        Long categoryId = Long.parseLong(scanner.nextLine());
        Category category = new Category(); // Kategori bilgisi alınarak atanmalı
        category.setId(categoryId);

        productService.addProduct(name, price, stock, category);
        System.out.println("Ürün başarıyla eklendi!");
    }

    public void urunGetirById() {
        System.out.println("Ürün ID girin:");
        Long id = Long.parseLong(scanner.nextLine());
        Product product = productService.getProductById(id);
        System.out.println(product);
    }

    public void tumUrunleriGetir() {
        List<Product> products = productService.getAllProducts();
        products.forEach(System.out::println);
    }

    public void urunGuncelle() {
        System.out.println("Ürün ID girin:");
        Long id = Long.parseLong(scanner.nextLine());
        Product product = productService.getProductById(id);
        if (product != null) {
            System.out.println("Yeni ürün adı girin:");
            product.setName(scanner.nextLine());
            System.out.println("Yeni fiyat girin:");
            product.setPrice(Double.parseDouble(scanner.nextLine()));
            System.out.println("Yeni stok adedi girin:");
            product.setStock(Integer.parseInt(scanner.nextLine()));
            System.out.println("Yeni kategori ID'si girin:");
            Long categoryId = Long.parseLong(scanner.nextLine());
            Category category = new Category(); // Kategori bilgisi alınarak atanmalı
            category.setId(categoryId);
            product.setCategory(category);

            productService.updateProduct(product);
            System.out.println("Ürün başarıyla güncellendi!");
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }

    public void urunSil() {
        System.out.println("Ürün ID girin:");
        Long id = Long.parseLong(scanner.nextLine());
        Product product = productService.getProductById(id);
        if (product != null) {
            productService.deleteProduct(product);
            System.out.println("Ürün başarıyla silindi!");
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }
}

