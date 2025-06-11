////package com.example.ko_app.ImagesFile;
////
////import com.example.ko_app.Configruration.RequestNotValidException;
////import jakarta.annotation.PostConstruct;
////import lombok.RequiredArgsConstructor;
////import org.springframework.stereotype.Service;
////import org.springframework.web.multipart.MultipartFile;
////
////import java.io.IOException;
////import java.nio.file.Files;
////import java.nio.file.Path;
////import java.nio.file.Paths;
////
////@Service
////public class ImageFileService {
////
////    private final ImageFileRepository imageFileRepository;
////
////    private final String uploadDir = "uploads/";
////
////
////    public ImageFileService(ImageFileRepository imageFileRepository) {
////        this.imageFileRepository = imageFileRepository;
////    }
////    @PostConstruct
////    public void init() {
////        try {
////            Files.createDirectories(Paths.get(uploadDir));
////        } catch (IOException e) {
////            throw new RuntimeException("Could not create upload directory!");
////        }
////    }
////
////    public ImageFile saveFile(MultipartFile file) {
////        try {
////            Path path = Paths.get(uploadDir + file.getOriginalFilename());
////            Files.write(path, file.getBytes());
////
////            String fileName = file.getOriginalFilename();
////
////            ImageFile imageFile = new ImageFile();
////            imageFile.setFileName(fileName);
////            imageFile.setFilePath(path.toString());
////            imageFile.setFileType(file.getContentType());
////            imageFile.setFileSize((int) file.getSize());
////
////            return imageFileRepository.save(imageFile);
////        } catch (IOException e) {
////            throw new RuntimeException("Could not save file. Error: " + e.getMessage());
////        }
////    }
////
////    public ImageFile getFile(Integer id) {
////        return imageFileRepository.findById(id)
////                .orElseThrow(() -> new RequestNotValidException("File not found"));
////    }
////
////    public ImageFile update(ImageFile imageFile, ResourceType resourceType, Integer relationId) {
////        ImageFile file = imageFileRepository.findById(imageFile.getId())
////                .orElseThrow(() -> new RequestNotValidException("File not found"));
////
////        file.setRelationType(resourceType);
////        file.setRelationId(relationId);
////
////        return imageFileRepository.save(file);
////    }
////}
//package com.example.ko_app.ImagesFile;
//
//import com.example.ko_app.Configruration.RequestNotValidException;
//import jakarta.annotation.PostConstruct;
//import lombok.Value;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.core.io.UrlResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;
//
//@Service
//public class ImageFileService {
//
//    private final ImageFileRepository imageFileRepository;
//    private final ResourceLoader resourceLoader;
//  final String filePath = "C:\\Users\\UsEr\\IdeaProjects\\grad-pro\\ko_app\\ko_app\\uploads";
//
//    public ImageFileService(ImageFileRepository imageFileRepository, ResourceLoader resourceLoader) {
//        this.imageFileRepository = imageFileRepository;
//        this.resourceLoader = resourceLoader;
//    }
//
//    // إنشاء مجلد التحميلات إذا لم يكن موجودًا
//    @PostConstruct
//    public void init() {
//
//    }
//
//    // حفظ الملف
//    public ImageFile saveFile(MultipartFile file) {
//        try {
//            // كتابة البيانات إلى الملف
//            Files.write(Path.of(path), file.getBytes());
//
//            String fileName = file.getOriginalFilename();
//
//            // إنشاء كائن من الـ ImageFile وحفظ البيانات في قاعدة البيانات
//            ImageFile imageFile = new ImageFile();
//            imageFile.setFileName(fileName);
//            imageFile.setFilePath(path.toString()); // مسار الملف الكامل
//            imageFile.setFileType(file.getContentType());
//            imageFile.setFileSize((int) file.getSize());
//
//            // حفظ الكائن في قاعدة البيانات
//            return imageFileRepository.save(imageFile);
//        } catch (IOException e) {
//            throw new RuntimeException("Could not save file. Error: " + e.getMessage());
//        }
//    }
//
//    // استرجاع البيانات الخاصة بالصورة باستخدام الـ ID
//    public ImageFile getFile(Integer id) {
//        return imageFileRepository.findById(id)
//                .orElseThrow(() -> new RequestNotValidException("File not found"));
//    }
//
//    // استرجاع الصورة الفعلية كـ byte[]
//    public byte[] getFileBytes(Integer id) {
//        ImageFile imageFile = imageFileRepository.findById(id)
//                .orElseThrow(() -> new RequestNotValidException("File not found"));
//
//        Path path = Paths.get(imageFile.getFilePath());
//        try {
//            // قراءة الصورة من المسار
//            return Files.readAllBytes(path);
//        } catch (IOException e) {
//            throw new RuntimeException("Could not read the file. Error: " + e.getMessage());
//        }
//    }
//
//    // تحديث بيانات الصورة في حال الحاجة (مثلاً إضافة ربط بين الصورة وموارد أخرى)
//    public ImageFile update(ImageFile imageFile) {
//        ImageFile file = imageFileRepository.findById(imageFile.getId())
//                .orElseThrow(() -> new RequestNotValidException("File not found"));
//        return imageFileRepository.save(file);
//    }
//
//    public ResponseEntity<?> loadFileAsResponseEntityById(Integer id) {
//
//        try {
//            ImageFile imageFile = imageFileRepository.findById(id).orElseThrow(()->new RequestNotValidException("Photo not found"));
//            Resource resource = new UrlResource("C:\\Users\\UsEr\\IdeaProjects\\grad-pro\\ko_app\\ko_app\\uploads".toString());
//
//            if (resource.exists() || resource.isReadable()) {
//                String contentType = "application/octet-stream";
//                contentType = "C:\\Users\\UsEr\\IdeaProjects\\grad-pro\\ko_app\\ko_app\\uploads".toString();
//
//                return ResponseEntity.ok()
//                        .contentType(MediaType.parseMediaType(contentType))
//                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                        .body(resource);
//            } else {
//                throw new RequestNotValidException("Could not find file: " + imageFile.getFileName());
//            }
//        } catch (IOException ex) {
//            throw new RequestNotValidException("Error: " + ex.getMessage());
//        }
//    }
//}
