package com.api.models.http.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResumenRequest implements Serializable {

    private Timestamp fechaInicial;
    private Timestamp fechaFinal;

}
