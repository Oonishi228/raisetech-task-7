package com.example.task7;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class SampleController {
    @GetMapping("/names")
    public ResponseEntity<Map<String, String>> getNames(@RequestParam String name) {
        return ResponseEntity.ok(Map.of("message", name));
    }

    @PostMapping("/names")
    public ResponseEntity<String> create(@RequestBody @Validated CreateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080").path("/names/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("name successfully created");
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody @Validated UpdateForm form) {
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @DeleteMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(Map.of("message", "name successfully deleted"));
    }

}
