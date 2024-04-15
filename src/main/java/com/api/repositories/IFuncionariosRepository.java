package com.api.repositories;

import com.api.entities.entity.FuncionariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFuncionariosRepository extends JpaRepository <FuncionariosEntity,Long> {
}
