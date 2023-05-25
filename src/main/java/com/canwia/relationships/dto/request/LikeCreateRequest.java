package com.canwia.relationships.dto.request;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class LikeCreateRequest {


    private Long accountId;

    private Long commentId;
}
