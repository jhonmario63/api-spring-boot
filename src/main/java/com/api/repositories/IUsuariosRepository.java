package com.api.repositories;

import com.api.entities.entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuariosRepository extends JpaRepository<UsuariosEntity, String> {
    UsuariosEntity findByUserAndPasswordAndEstado(String user, String password, Boolean estado);

}
