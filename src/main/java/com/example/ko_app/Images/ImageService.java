package com.example.ko_app.Images;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Products.Product;
import com.example.ko_app.Products.ProductRepository;
import com.example.ko_app.validation.ObjectValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
//    public ImageResponse createImage(ImageRequest request) {
//        Product product = productRepository.findById(request.getProductId())
//                .orElseThrow(() -> new RuntimeException("Product not found"));
//
//        validator.validate(request);
//
//        Image image = new Image();
//        image.setName(request.getImageName());
//        image.setPath(request.getImagePath());
//        image.setProduct(product);
//
//        imageRepository.save(image);
//        return mapToResponse(image);
//    }
    public ImageResponse createImage(MultipartFile file, ImageRequest request) {

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        try {
            // تحديد مجلد الحفظ
            String uploadDir = "uploads/";
            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);

            // إنشاء المجلد إذا ما كان موجود
            Files.createDirectories(filePath.getParent());

            // حفظ الملف
            Files.write(filePath, file.getBytes());

            // حفظ معلومات الصورة بقاعدة البيانات
            Image image = new Image();
            image.setName(fileName);
            image.setPath(filePath.toString());
            image.setProduct(product);

            imageRepository.save(image);

            return mapToResponse(image);

        } catch (IOException e) {
            throw new RuntimeException("Error while saving image", e);
        }
    }


    // updateImage
//    public ImageResponse updateImage(Integer id, ImageRequest request) {
//        Image image = imageRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Image not found"));
//        validator.validate(request);
//
//        image.setName(request.getImageName());
//        image.setPath(request.getImagePath());
//        image = imageRepository.save(image);
//        return mapToResponse(image);
//    }
    public ImageResponse updateImage(Integer id, MultipartFile file, ImageRequest request) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        try {
            // حذف الصورة القديمة من السيرفر (اختياري)
            if (image.getPath() != null) {
                Files.deleteIfExists(Paths.get(image.getPath()));
            }

            // رفع الصورة الجديدة
            String uploadDir = "uploads/";
            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());

            // تحديث البيانات
            image.setName(fileName);
            image.setPath(filePath.toString());
            image.setProduct(product);

            imageRepository.save(image);

            return mapToResponse(image);

        } catch (IOException e) {
            throw new RuntimeException("Error while updating image", e);
        }
    }



    // deleteImage
//    public ResponseEntity<?> deleteImage(Integer id) throws NotFoundInDatabaseException {
//        Image image = imageRepository.findById(id)
//                .orElseThrow(() -> new NotFoundInDatabaseException("Image not found"));
//
//        imageRepository.delete(image); // Ensure the customer is actually deleted
//        return ResponseEntity.status(HttpStatus.OK).body("Image deleted successfully");
//    }

    public void deleteImage(Integer id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));

        try {
            if (image.getPath() != null) {
                Files.deleteIfExists(Paths.get(image.getPath()));
            }
        } catch (IOException e) {
            // تجاهل الخطأ أو احفظه في لوج
        }

        imageRepository.delete(image);
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
