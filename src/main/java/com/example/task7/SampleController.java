package com.example.task7;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
public class SampleController {

    @GetMapping("/names")
    public CreateForm createForm(@RequestParam(value = "name", defaultValue = "name") String name, @RequestParam(value = "birthday", defaultValue = "0000") String birthday) {
        return new CreateForm(String.format(name), String.format(birthday));
    }

    @PostMapping("/names")
    public ResponseEntity<Map<String, String>> create(@RequestBody @Validated UriComponentsBuilder uriBuilder) {
        URI url = uriBuilder.path("/names/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "name successfully created"));
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
