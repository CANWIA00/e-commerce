package com.canwia.relationships.controller;
import com.canwia.relationships.dto.ProductDto;
import com.canwia.relationships.Service.ProductService;
import com.canwia.relationships.dto.request.ProductCreateRequest;
import com.canwia.relationships.dto.request.ProductUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<List<ProductDto>> getAllProductByAccountId(@PathVariable Long id){
        return  ResponseEntity.ok(productService.findAllProductByAccountId(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductCreateRequest productCreateRequest){
        return ResponseEntity.ok(productService.createProduct(productCreateRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDto> updateProductById(@PathVariable Long id, @RequestBody ProductUpdateRequest productUpdateRequest){
        return ResponseEntity.ok(productService.updateProductById(id,productUpdateRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }


}
