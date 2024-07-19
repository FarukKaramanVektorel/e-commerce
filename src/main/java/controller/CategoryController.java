package controller;

import java.util.List;
import java.util.Scanner;

import lombok.RequiredArgsConstructor;
import model.Category;
import service.CategoryService;

@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final Scanner scanner = new Scanner(System.in);

    public void kategoriEkle() {
        System.out.println("Kategori adı girin:");
        String name = scanner.nextLine();

        categoryService.addCategory(name);
        System.out.println("Kategori başarıyla eklendi!");
    }

    public void kategoriGetirById() {
        System.out.println("Kategori ID girin:");
        Long id = Long.parseLong(scanner.nextLine());
        Category category = categoryService.getCategoryById(id);
        System.out.println(category);
    }

    public void tumKategorileriGetir() {
        List<Category> categories = categoryService.getAllCategories();
        categories.forEach(System.out::println);
    }

    public void kategoriGuncelle() {
        System.out.println("Kategori ID girin:");
        Long id = Long.parseLong(scanner.nextLine());
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            System.out.println("Yeni kategori adı girin:");
            category.setName(scanner.nextLine());

            categoryService.updateCategory(category);
            System.out.println("Kategori başarıyla güncellendi!");
        } else {
            System.out.println("Kategori bulunamadı.");
        }
    }

    public void kategoriSil() {
        System.out.println("Kategori ID girin:");
        Long id = Long.parseLong(scanner.nextLine());
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            categoryService.deleteCategory(category);
            System.out.println("Kategori başarıyla silindi!");
        } else {
            System.out.println("Kategori bulunamadı.");
        }
    }
}

