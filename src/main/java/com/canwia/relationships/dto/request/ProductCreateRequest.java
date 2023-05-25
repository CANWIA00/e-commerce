package com.canwia.relationships.dto.request;

import lombok.Data;

@Data
public class ProductCreateRequest {

    private String productName;
    private Long cost;
    private Long accountId;
}
