package service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import model.Category;
import repository.CategoryRepository;
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;  

    public void addCategory(String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void updateCategory(Category category) {
        categoryRepository.update(category);
    }

    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }
}

