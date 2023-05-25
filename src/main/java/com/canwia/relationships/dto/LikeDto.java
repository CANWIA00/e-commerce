package com.canwia.relationships.dto;

import lombok.Data;

@Data
public class LikeDto {
    private Long id;
    private Long accountId;
    private Long commentId;
}
