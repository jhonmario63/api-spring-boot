package com.api.services.interfaces;

import com.api.entities.dto.request.CitasRequest;
import com.api.entities.dto.response.ApiResponse;

import java.util.List;

public interface CitasInterface {

    ApiResponse postImportarCitas(List<CitasRequest> object);

}
