package com.example.ko_app.Products;

import com.example.ko_app.Categories.Category;
import com.example.ko_app.Categories.CategoryRepository;
import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Customer.Customer;
import com.example.ko_app.Customer.CustomerRepository;
import com.example.ko_app.Customer.CustomerRequest;
import com.example.ko_app.Customer.CustomerResponse;
import com.example.ko_app.Images.Image;
import com.example.ko_app.Images.ImageRepository;
import com.example.ko_app.validation.ObjectValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ImageRepository imageRepository;

    private final ObjectValidator<ProductRequest> validator;

    // Constructor for dependency injection
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ImageRepository imageRepository, ObjectValidator<ProductRequest> validator) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.imageRepository = imageRepository;
        this.validator = validator;
    }

    public List<?> getAllProduct() {
        return productRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    // getProductrByID
    public ProductResponse getProductById(Integer id) {
        return productRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // getProductrByCategoryID
    public List<ProductResponse> getProductsByCategory(Integer categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        return products.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    // createProduct
    public ProductResponse createProdact(ProductRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Image image = imageRepository.findById(request.getImageId())
                .orElseThrow(() -> new RuntimeException("Image not found"));

        validator.validate(request);

        Product product = new Product();
        product.setProduct_name(request.getProductName());
        product.setProduct_description(request.getProductDescription());
        product.setProduct_price(request.getProductPrice());
        product.setProduct_quantity(request.getProductQuantity());

//        product.setProduct_image(request.getProductImage());
        product.setCategory(category);
        product.setImage(image);


        productRepository.save(product);
        return mapToResponse(product);
    }

    // updateProduct //
    public ProductResponse updateProduct(Integer id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        validator.validate(request);

        product.setProduct_name(request.getProductName());
        product.setProduct_description(request.getProductDescription());
        product.setProduct_price(request.getProductPrice());
        product.setProduct_quantity(request.getProductQuantity());
//        product.setProduct_image(request.getProductImage());

        product =productRepository.save(product);
        return mapToResponse(product);
    }

    // deleteProduct
    public ResponseEntity<?> deleteProduct(Integer id) throws NotFoundInDatabaseException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("Product not found"));

        productRepository.delete(product);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }

    // mapToResponse
    private ProductResponse mapToResponse(Product product) {
        List<Integer> productIds = new ArrayList<>();
        ProductResponse response = new ProductResponse();
        response.setProductId(product.getId());
        response.setProductName(product.getProduct_name());
        response.setProductDescription(product.getProduct_description());
        response.setProductPrice(product.getProduct_price());
        response.setProductQuantity(product.getProduct_quantity());
//        response.setProductImage(product.getProduct_image());
        response.setCategoryId(product.getCategory().getId());
        if (product.getImage() != null) {
            response.setImageId(product.getImage().getId());
        } else {
            response.setImageId(null); // أو يمكنك تجاهلها إذا لم تكن مطلوبة
        }


        return response;
    }
}
