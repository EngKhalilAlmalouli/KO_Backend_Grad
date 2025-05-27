package com.example.ko_app.Images;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Report.ReportRequest;
import com.example.ko_app.Report.ReportResponse;
import com.example.ko_app.Report.ReportService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;


import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping("/api/images")
public class ImageController {
    private final ImageService imageService;

    // Constructor for dependency injection

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public ResponseEntity<List<?>> getAllImage() {
        return ResponseEntity.ok(imageService.getAllImage());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ImageResponse> getImageById(@PathVariable Integer id) {
        return ResponseEntity.ok(imageService.getImageById(id));
    }
//
//    @PostMapping
//    public ImageResponse createImage(@RequestBody ImageRequest request) {
//        return imageService.createImage(request);
//    }
//@PostMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//public ResponseEntity<ImageResponse> updateImage(
//        @PathVariable Integer id,
//        @RequestParam("file") MultipartFile file,
//        @RequestParam("productId") Integer productId
//) {
//    ImageRequest request = new ImageRequest();
//    request.setProductId(productId);
//
//    return ResponseEntity.ok(imageService.updateImage(id, file, request));
//}
@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<ImageResponse> createImage(
        @RequestParam("file") MultipartFile file,
        @RequestParam("productId") Integer productId) {

    ImageRequest request = new ImageRequest();
    request.setProductId(productId);
    ImageResponse response = imageService.createImage(file, request);
    return ResponseEntity.ok(response);
}

//    @PutMapping("/{id}")
//    public ImageResponse updateImage(@PathVariable Integer id, @RequestBody ImageRequest request) {
//        return imageService.updateImage(id, request);
//    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ImageResponse> updateImage(@PathVariable Integer id, @RequestParam("file") MultipartFile file) {
        ImageRequest request = new ImageRequest();
        request.setProductId(id);

    ImageResponse updatedimage = imageService.updateImage(id, file, request);
    return ResponseEntity.ok(updatedimage);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable Integer id) {
        imageService.deleteImage(id);
        return ResponseEntity.ok("Image deleted successfully");
    }

}
