package com.example.ko_app.Images;

import com.example.ko_app.Categories.Category;
import com.example.ko_app.Categories.CategoryRepository;
import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Customer.Customer;
import com.example.ko_app.Customer.CustomerRepository;
import com.example.ko_app.Products.Product;
import com.example.ko_app.Products.ProductRepository;
import com.example.ko_app.Products.ProductRequest;
import com.example.ko_app.Products.ProductResponse;
import com.example.ko_app.Report.Report;
import com.example.ko_app.Report.ReportRepository;
import com.example.ko_app.Report.ReportRequest;
import com.example.ko_app.Report.ReportResponse;
import com.example.ko_app.validation.ObjectValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageService {
    private final ImageRepository imageRepository;
    private final ProductRepository productRepository;

    private final ObjectValidator<ImageRequest> validator;

    // Constructor for dependency injection
    public ImageService(ImageRepository imageRepository, ProductRepository productRepository, ObjectValidator<ImageRequest> validator) {
        this.imageRepository = imageRepository;
        this.productRepository = productRepository;
        this.validator = validator;
    }


    public List<?> getAllImage() {
        return imageRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    // getImageByID
    public ImageResponse getImageById(Integer id) {
        return imageRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Image not found"));
    }


    // createImage
    public ImageResponse createImage(ImageRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        validator.validate(request);

        Image image = new Image();
        image.setName(request.getImageName());
        image.setPath(request.getImagePath());
        image.setProduct(product);
        return mapToResponse(image);
    }

    // updateImage
    public ImageResponse updateImage(Integer id, ImageRequest request) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));
        validator.validate(request);

        image.setName(request.getImageName());
        image.setPath(request.getImagePath());
        image = imageRepository.save(image);
        return mapToResponse(image);
    }

    // deleteImage
    public ResponseEntity<?> deleteImage(Integer id) throws NotFoundInDatabaseException {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("Image not found"));

        imageRepository.delete(image); // Ensure the customer is actually deleted
        return ResponseEntity.status(HttpStatus.OK).body("Image deleted successfully");
    }

    // mapToResponse
    private ImageResponse mapToResponse(Image image) {
        List<Integer> imageIds = new ArrayList<>();
        ImageResponse response = new ImageResponse();
        response.setImageId(image.getId());
        response.setImageName(image.getName());
        response.setImagePath(image.getPath());
        response.setProductId(image.getProduct().getId());
        return response;
    }
}
