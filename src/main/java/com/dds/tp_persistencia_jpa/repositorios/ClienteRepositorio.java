package com.dds.tp_persistencia_jpa.repositorios;

import com.dds.tp_persistencia_jpa.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {

}
