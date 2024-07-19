package service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import model.Category;
import model.Product;
import repository.ProductRepository;

@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public void addProduct(String name, Double price, Integer stock, Category category) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setStock(stock);
		product.setCategory(category);

		productRepository.save(product);
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public void updateProduct(Product product) {
		productRepository.update(product);
	}

	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}
}
