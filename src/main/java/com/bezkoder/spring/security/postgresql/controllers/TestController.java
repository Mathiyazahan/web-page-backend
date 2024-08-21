package com.bezkoder.spring.security.postgresql.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  @CrossOrigin(origins = "*", allowedHeaders="*")
  public ResponseEntity<String> allAccess() {
	HttpHeaders headers = new HttpHeaders();
    return ResponseEntity.ok().headers(headers).body("Public Content");
  }

  @GetMapping("/user")
  @CrossOrigin(origins = "*", allowedHeaders="*")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public ResponseEntity<String> userAccess() {
    return ResponseEntity.ok("User Content.");
  }

  @GetMapping("/mod")
  @CrossOrigin(origins = "*", allowedHeaders="*")
  @PreAuthorize("hasRole('MODERATOR')")
  public ResponseEntity<String> moderatorAccess() {
    return ResponseEntity.ok("Moderator Board.");
  }

  @GetMapping("/admin")
  @CrossOrigin(origins = "*", allowedHeaders="*")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<String> adminAccess() {
    return ResponseEntity.ok("Admin Board.");
  }
}
