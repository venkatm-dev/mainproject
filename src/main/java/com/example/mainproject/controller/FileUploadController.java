package com.example.mainproject.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.subproject.service.S3FileUploadService;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    private S3FileUploadService s3FileUploadService;

    @PostMapping("/s3")
    public ResponseEntity<String> uploadToS3(@RequestParam("file") MultipartFile file) {
        try {
            String url = s3FileUploadService.uploadFile("my-venkat-bucket-2025", file);
            return ResponseEntity.ok("Uploaded successfully: " + url);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed");
        }
    }
    
    
    
    @GetMapping("/dowload")
    public  ResponseEntity<String> downLoadFile(@RequestParam("downloadPath") String downloadPath) throws IOException {
    	   try {
               String url = s3FileUploadService.downLoadFile("my-venkat-bucket-2025", downloadPath);
               return ResponseEntity.ok("Uploaded successfully: " + url);
           } catch (IOException e) {
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed");
           }
    }
    
    
    @PostMapping("/update")
    public ResponseEntity<String> updateFile(@RequestParam("file") MultipartFile file) {
        try {
            String key = s3FileUploadService.updateFile("my-venkat-bucket-2025", file);
            return ResponseEntity.ok("File updated in S3: " + key);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Update failed: " + e.getMessage());
        }
    }

    
    
    
    
    @PostMapping("/notification")
    public ResponseEntity<String> sendNotification(@RequestParam String subject, @RequestParam String message) {
        String messageId = s3FileUploadService.sendNotification(subject, message);
        return ResponseEntity.ok("Notification sent! Message ID: " + messageId);
    }
    
    
    
    
}

