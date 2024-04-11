package com.api.repositories;
import com.api.entities.entity.CitasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICitasRepository extends JpaRepository<CitasEntity, Long> {

}
