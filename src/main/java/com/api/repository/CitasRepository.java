package com.api.repository;
import com.api.models.entity.CitasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitasRepository extends JpaRepository<CitasEntity, Integer> {

}
