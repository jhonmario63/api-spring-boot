package com.api.repository;

import com.api.models.entity.ReportesEntity;
import com.api.models.http.request.ResumenRequest;
import com.api.models.http.response.TramiteResponse;
import jakarta.persistence.EntityManager;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ReportesRepository extends JpaRepository<ReportesEntity, Integer> {
    @Query("SELECT u FROM ReportesEntity u WHERE u.fechaCreacion BETWEEN :fechaInicial AND :fechaFinal")
    List<ReportesEntity> findByFechaCreacionBetween(@Param("fechaInicial") Timestamp fechaInicial, @Param("fechaFinal") Timestamp fechaFinal);

}
