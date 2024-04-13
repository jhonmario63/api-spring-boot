package com.api.entities.dto.response;

import com.api.entities.entity.FuncionariosEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {

    private Object data;
    private String message;
    private Integer status;

}
