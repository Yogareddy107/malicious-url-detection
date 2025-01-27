package com.example.maliciousurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class MaliciousUrlDetectionApplication {
    public static void main(String[] args) {
        SpringApplication.run(MaliciousUrlDetectionApplication.class, args);
    }
}

@Controller
class UrlController {

    @GetMapping("/")
    public String home(Model model) {
        return "index";  // Thymeleaf template (index.html)
    }

    @PostMapping("/check-url")
    public String checkUrl(@RequestParam String url, Model model) {
        // Logic to detect malicious URL
        boolean isMalicious = checkMaliciousUrl(url);
        model.addAttribute("url", url);
        model.addAttribute("isMalicious", isMalicious);
        return "result";  // A result page showing whether the URL is malicious or not
    }

    private boolean checkMaliciousUrl(String url) {
        // Your URL detection logic here
        return false;  // Example: Replace with actual logic
    }
}
