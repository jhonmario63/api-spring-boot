package com.api.repository;

import com.api.models.entity.TramitesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TramitesRepository extends JpaRepository<TramitesEntity, Long> {
}
