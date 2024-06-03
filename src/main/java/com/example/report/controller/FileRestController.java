package com.example.report.controller;

import com.example.report.model.*;
import com.example.report.repo.FaultRepo;
import com.example.report.repo.ImageRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.Lob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Objects;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
@Slf4j
public class FileRestController {
//    private final FileService fileService;
    private final ImageRepo fileRepository;
    private final FaultRepo faultRepo;


    @PostMapping("/create")
    @ApiResponse(responseCode = "200", description = "File uploaded successfully")
    @Operation(summary = "Upload file")

    public ResponseEntity uploadFile(ReportRequest request) throws IOException {
log.info("Request has --------{}",request);
        Fault fault = new Fault();
        fault.setStatus(Status.RECEIVED);
        fault.setFaultCategories(request.getFaultCategories());
        fault.setDetails(request.getDetails());
        fault.setDateTime(LocalDateTime.now());
        fault.setImage(request.getImage());
        fault.setLongitude(request.getLongitude());
        fault.setLatitude(request.getLatitude());
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
    private static String getBase64StringWithPadding(byte[] bytes) {
        String base64 = Base64.getEncoder().encodeToString(bytes);
        int padding = base64.length() % 4;
        if (padding > 0) {
            base64 += "====".substring(0, 4 - padding);
        }
        return base64;
    }

}
