////package com.example.ko_app.ImagesFile;
////
////import org.junit.jupiter.api.Tag;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////import org.springframework.web.multipart.MultipartFile;
////
////@RestController
////@RequestMapping("/api/files")
//////@Tag("File")
////public class ImageFileController {
////
////    private final ImageFileService imageFileService;
////
////    public ImageFileController(ImageFileService imageFileService) {
////        this.imageFileService = imageFileService;
////    }
////
////    @PostMapping("/upload")
//////    @Operation(
//////            description = "This endpoint saves a file resource in the system",
//////            summary = "Upload a file",
//////            responses = {
//////                    @ApiResponse(
//////                            description = "Saved successfully",
//////                            responseCode = "200"
//////                    )
//////            }
//////    )
////    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
////        try {
////            ImageFile imageFile = imageFileService.saveFile(file);
////            return ResponseEntity.status(HttpStatus.OK)
////                    .body("File uploaded successfully: " + imageFile.getFilePath());
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
////                    .body("Could not upload the file: " + e.getMessage());
////        }
////    }
////
////    @GetMapping("/{id}")
//////    @Operation(
//////            description = "This endpoint retrieves a file by its ID",
//////            summary = "Get file by ID",
//////            responses = {
//////                    @ApiResponse(
//////                            description = "Retrieved successfully",
//////                            responseCode = "200"
//////                    )
//////            }
//////    )
////    public ResponseEntity<?> getFile(@PathVariable Integer id) {
////        ImageFile imageFile = imageFileService.getFile(id);
////        if (imageFile != null) {
////            return ResponseEntity.ok(imageFile);
////        } else {
////            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found");
////        }
////    }
////}
//
//package com.example.ko_app.ImagesFile;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/api/files")
//public class ImageFileController {
//
//    private final ImageFileService imageFileService;
//
//    public ImageFileController(ImageFileService imageFileService) {
//        this.imageFileService = imageFileService;
//    }
//
//    // POST: Upload file
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        try {
//            ImageFile imageFile = imageFileService.saveFile(file);
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body("File uploaded successfully: " + imageFile.getFilePath());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Could not upload the file: " + e.getMessage());
//        }
//    }
//
//    // GET: Retrieve file information by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<ImageFileResponse> getFileInfo(@PathVariable Integer id) {
//        try {
//            ImageFile imageFile = imageFileService.getFile(id);
//            ImageFileResponse response = new ImageFileResponse(
//                    imageFile.getId(),
//                    imageFile.getFileName(),
//                    imageFile.getFilePath(),
//                    imageFile.getFileType(),
//                    imageFile.getFileSize()
//
//            );
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
//
//    // GET: Retrieve actual image by ID
//    @GetMapping("/image/{id}")
//    public ResponseEntity<byte[]> getImage(@PathVariable Integer id) {
//        try {
//            byte[] imageBytes = imageFileService.getFileBytes(id);
//            ImageFile imageFile = imageFileService.getFile(id);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.set("Content-Type", imageFile.getFileType());  // Content-Type (e.g. image/png)
//
//            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
//
////    @GetMapping("/uploads/{id}")
////    public ResponseEntity<?> downloadPhotoById(@PathVariable Integer id) {
////        return ImageFileService.(id);
////    }
//}
