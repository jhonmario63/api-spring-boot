package com.api.repositories;
import com.api.entities.entity.CitasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitasRepository extends JpaRepository<CitasEntity, Long> {

}
