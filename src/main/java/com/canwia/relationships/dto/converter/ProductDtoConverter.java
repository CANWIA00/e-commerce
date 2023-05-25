package com.canwia.relationships.dto.converter;
import com.canwia.relationships.dto.ProductDto;
import com.canwia.relationships.dto.request.ProductCreateRequest;
import com.canwia.relationships.model.Product;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class ProductDtoConverter {

    /** convert to Dto **/
    public ProductDto convert(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setProductName(product.getProductName());
        productDto.setCost(product.getCost());
        productDto.setAccount_id(product.getAccount().getId());
        productDto.setAccount_name(product.getAccount().getAccountName());
        return productDto;
    }

    public List<ProductDto> convertList(List<Product> productList){
        return productList.stream().map(this::convert).toList();
    }



}
