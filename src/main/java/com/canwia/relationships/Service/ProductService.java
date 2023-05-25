package com.canwia.relationships.Service;

import com.canwia.relationships.dto.AccountDto;
import com.canwia.relationships.dto.ProductDto;
import com.canwia.relationships.dto.converter.ProductDtoConverter;
import com.canwia.relationships.dto.request.ProductCreateRequest;

import com.canwia.relationships.dto.request.ProductUpdateRequest;
import com.canwia.relationships.exception.ApiRequestException;
import com.canwia.relationships.model.Account;
import com.canwia.relationships.model.Product;
import com.canwia.relationships.repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoConverter productDtoConverter;
    private final AccountService accountService;

    public ProductService(ProductRepository productRepository, ProductDtoConverter productDtoConverter, AccountService accountService) {
        this.productRepository = productRepository;
        this.productDtoConverter = productDtoConverter;
        this.accountService = accountService;
    }


    public ProductDto findProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> {
            throw new ApiRequestException("Product finding exception. There is no product with " + id + " id number!");
        });
        return productDtoConverter.convert(product);
    }

    public List<ProductDto> findAllProductByAccountId(Long id) {
        List<Product> productList = productRepository.findAllProductByAccountId(id).orElseThrow(()->{
            throw new ApiRequestException("Product finding problem with Account " + id + " id number!");
        });
        return productDtoConverter.convertList(productList);
    }


    public ProductDto createProduct(ProductCreateRequest productCreateRequest) {
        Account account = accountService.findAccount(productCreateRequest.getAccountId());

        Product product = new Product();
        product.setProductName(productCreateRequest.getProductName());
        product.setCost(productCreateRequest.getCost());
        product.setAccount(account);

        return productDtoConverter.convert(productRepository.save(product));
    }

    public ProductDto updateProductById(Long id, ProductUpdateRequest productUpdateRequest) {
        Product product = productRepository.findById(id).orElseThrow(()->{
            throw new ApiRequestException("There is no product with " + id + " id number!");
        });

        product.setProductName(productUpdateRequest.getProductName());
        product.setCost(productUpdateRequest.getCost());
        return new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getCost(),
                product.getAccount().getId(),
                product.getAccount().getAccountName()
        );

    }


    public void deleteProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new ApiRequestException("There is no product with " + id + " id number!");
        }
        productRepository.deleteById(id);
    }

    public Product findProduct(Long id) {

        return productRepository.findById(id).orElseThrow(()->{
           throw new ApiRequestException("There is not product with " + id + " id number!");
        });
    }
}