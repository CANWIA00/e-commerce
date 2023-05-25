package com.canwia.relationships.dto;

import com.canwia.relationships.model.Account;
import com.canwia.relationships.model.Product;
import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private String commentText;
    private Long product_id;
    private Long account_id;
}
