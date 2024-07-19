import org.hibernate.SessionFactory;

import controller.CategoryController;
import controller.CustomerController;
import controller.CustomerInfoController;
import controller.CustomerPriceController;
import controller.MainController;
import controller.ProductController;
import repository.CategoryRepository;
import repository.CustomerInfoRepository;
import repository.CustomerPriceRepository;
import repository.CustomerRepository;
import repository.ProductRepository;
import service.CategoryService;
import service.CustomerInfoService;
import service.CustomerPriceService;
import service.CustomerService;
import service.ProductService;
import util.HibernateConfig;

public class MainApp {

    public static void main(String[] args) {
    	SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        CustomerRepository customerRepository = new CustomerRepository(sessionFactory);
        ProductRepository productRepository = new ProductRepository(sessionFactory);
        CategoryRepository categoryRepository = new CategoryRepository(sessionFactory);
        CustomerInfoRepository customerInfoRepository = new CustomerInfoRepository(sessionFactory);
        CustomerPriceRepository customerPriceRepository = new CustomerPriceRepository(sessionFactory); 
        
        CustomerService customerService = new CustomerService(customerRepository);
        ProductService productService = new ProductService(productRepository);
        CategoryService categoryService = new CategoryService(categoryRepository);
        CustomerInfoService customerInfoService = new CustomerInfoService(customerInfoRepository);
        CustomerPriceService customerPriceService = new CustomerPriceService(customerPriceRepository);

       
        CustomerController customerController = new CustomerController(customerService);
        ProductController productController = new ProductController(productService);
        CategoryController categoryController = new CategoryController(categoryService);
        CustomerInfoController customerInfoController = new CustomerInfoController(customerInfoService);
        CustomerPriceController customerPriceController = new CustomerPriceController(customerPriceService);

        
        MainController mainController = new MainController(
                customerController,
                productController,
                categoryController,
                customerInfoController,
                customerPriceController
        );

        mainController.start();
    }
}
