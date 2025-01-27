package com.example.maliciousurl.controller;

import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class UrlDetectionController {

    // Method to mimic URL safety check
    private boolean isMaliciousUrl(String url) {
        String[] maliciousPatterns = {"phishing", "malicious", "virus", "spam"};
        for (String pattern : maliciousPatterns) {
            if (url.toLowerCase().contains(pattern)) {
                return false; // Not safe
            }
        }
        return true; // Safe
    }

    @PostMapping("/check_url")
    public UrlResponse checkUrl(@RequestBody UrlRequest request) {
        String url = request.getUrl();

        // Validate URL format
        String regex = "^(https?|ftp)://[^\s/$.?#].[^\s]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        if (!matcher.matches()) {
            return new UrlResponse(false);
        }

        // Check if URL is safe or not
        boolean isSafe = isMaliciousUrl(url);
        return new UrlResponse(isSafe);
    }
}
private boolean checkMaliciousUrl(String url) {
    List<String> knownMaliciousUrls = Arrays.asList("malicious.com", "evil.com");
    for (String maliciousUrl : knownMaliciousUrls) {
        if (url.contains(maliciousUrl)) {
            return true;
        }
    }
    return false;
}
