package com.dds.tp_persistencia_jpa.repositorios;

import com.dds.tp_persistencia_jpa.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepositorio extends JpaRepository<Domicilio,Long> {
}
