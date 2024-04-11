package com.api.repositories;

import com.api.entities.entity.FuncionariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFuncionariosRepository extends JpaRepository <FuncionariosEntity,Long> {
}
