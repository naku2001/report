package com.example.report.controller;

import com.example.report.model.*;
import com.example.report.repo.FaultRepo;
import com.example.report.repo.ImageRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.Lob;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileRestController {
//    private final FileService fileService;
    private final ImageRepo fileRepository;
    private final FaultRepo faultRepo;


    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiResponse(responseCode = "200", description = "File uploaded successfully")
    @Operation(summary = "Upload file")
    public ResponseEntity uploadFile(ReportRequest request) {
        String uploadRootPath = new java.io.File(SystemConstants.pictureFolderUrl).getAbsolutePath();
        java.io.File uploadRootDir = new java.io.File(uploadRootPath);
        Image savedFile = new Image();
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        if (Objects.nonNull(request.getImage())) {
            try {

                String nm = request.getImage().getOriginalFilename()
                        .replace(" ", "")
                        .replace("-", "");
                String filename = generateRandomString(10).concat(nm);
                String tempUrl = SystemConstants.pictureFolderUrl.concat(filename);
                java.io.File serverFile = new java.io.File(uploadRootDir.getPath() +
                        java.io.File.separator + filename);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(request.getImage().getBytes());
                stream.close();
                savedFile = fileRepository.save(Image.builder()
                        .location(tempUrl)
                        .fileName(filename)
                        .build());
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }
        Fault fault = new Fault();
        fault.setStatus(Status.RECEIVED);
        fault.setFaultCategories(request.getFaultCategories());
        fault.setDetails(request.getDetails());
        fault.setDateTime(LocalDateTime.now());
        fault.setImage(savedFile.getLocation());
        fault.setLocation(request.getLocation());
        fault.setRecipient(request.getRecipient());
        Fault postedFault = faultRepo.save(fault);
        return ResponseEntity.ok().body(postedFault);


    }
    public String generateRandomString(int length) {

        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                + "lmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();

    }

}
