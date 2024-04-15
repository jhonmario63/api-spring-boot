package com.api.repositories;

import com.api.entities.entity.TablaGeneralEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITablaGeneralRepository extends JpaRepository<TablaGeneralEntity,Long>{

}