package com.api.models.http.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TramiteResponse implements Serializable {

    private String tramite;
    private Long cantidad;

}
