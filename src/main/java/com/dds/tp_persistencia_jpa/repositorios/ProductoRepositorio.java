package com.dds.tp_persistencia_jpa.repositorios;

import com.dds.tp_persistencia_jpa.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto,Long> {
}
