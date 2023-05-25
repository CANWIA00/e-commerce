package com.canwia.relationships.dto.request;

import lombok.Data;


@Data
public class CommentCreateRequest {
    private String commentText;
    private Long product_id;
    private Long account_id;
}
