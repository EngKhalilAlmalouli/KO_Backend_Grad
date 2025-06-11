package com.example.ko_app.Products;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Point.PointResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    // Constructor for dependency injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Map<String, List<Product>>> getAllPRoduct() {
        List<?> products = productService.getAllProduct();
        Map<String, List<Product>> response = new HashMap<>();
        response.put("products", (List<Product>) products);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductResponse>> getProductsByCategory(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(productService.getProductsByCategory(categoryId));
    }

//    @PostMapping
//    public ProductResponse createProduct(@RequestBody ProductRequest request) {
//        return productService.createProdact(request);
//    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request) {
        return new ResponseEntity<>(productService.createProdact(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Integer id, @RequestBody ProductRequest request) {
        return productService.updateProduct(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) throws NotFoundInDatabaseException {
        return productService.deleteProduct(id);
    }
}
