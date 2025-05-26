package com.example.ko_app.Images;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Report.ReportRequest;
import com.example.ko_app.Report.ReportResponse;
import com.example.ko_app.Report.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @PostMapping
    public ImageResponse createImage(@RequestBody ImageRequest request) {
        return imageService.createImage(request);
    }

    @PutMapping("/{id}")
    public ImageResponse updateImage(@PathVariable Integer id, @RequestBody ImageRequest request) {
        return imageService.updateImage(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable Integer id) throws NotFoundInDatabaseException {
        return imageService.deleteImage(id);
    }
}
