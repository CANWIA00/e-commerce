package com.canwia.relationships.dto.request;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    private String productName;
    private Long cost;
}
