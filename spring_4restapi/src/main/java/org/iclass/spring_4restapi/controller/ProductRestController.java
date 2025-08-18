package org.iclass.spring_4restapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iclass.spring_4restapi.dto.ProductDto;
import org.iclass.spring_4restapi.service.ProductService;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@Slf4j
@AllArgsConstructor
@RestController
public class ProductRestController {

    private ProductService service;

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok().body(service.allProduct());
    }

    @GetMapping("/api/products/{pcode}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable String pcode) {
        return ResponseEntity.ok().body(service.getProduct(pcode));
    }

    @GetMapping("/api/products/search")
    public ResponseEntity<List<ProductDto>> getKeywordProduct(@RequestParam String keyword) {
        return ResponseEntity.ok(service.keywordProduct(keyword));
    }

    @PostMapping(value = "/api/products")
    public ResponseEntity<?> save(@Valid @RequestBody ProductDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(err -> {
                errors.put(err.getField(), err.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            int result = service.join(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("success", result));
        } catch (Exception e) {
            log.info("save 예외 : {}", e.getMessage());
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @PutMapping("/api/products/{pcode}")
    public ResponseEntity<?> change(
            @PathVariable String pcode,
            @Valid @RequestBody ProductDto dto,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(err -> {
                errors.put(err.getField(), err.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            int result = service.changeInfo(dto);
            if (result == 0) {
                throw new IllegalAccessException("상품 코드 : " + pcode + "가 존재하지 않습니다.");
            }
            return ResponseEntity.ok().body(Map.of("success", result));
        } catch (Exception e) {
            log.info("change 예외 : {}", e.getMessage());
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/api/products/{pcode}")
    public ResponseEntity<?> remove(@PathVariable String pcode) {
        try {
            int result = service.removeProduct(pcode);
            if (result == 0) {
                throw new IllegalAccessException("상품코드 : " + pcode + "가 존재하지 않습니다.");
            }
            return ResponseEntity.ok().body(Map.of("success", result));
        } catch (Exception e) {
            log.info("delete 예외 : {}", e.getMessage());
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}