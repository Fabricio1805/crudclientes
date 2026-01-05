package com.crudcliente.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class FieldMessageDTO {
    private String fieldName;
    private String message;
}
