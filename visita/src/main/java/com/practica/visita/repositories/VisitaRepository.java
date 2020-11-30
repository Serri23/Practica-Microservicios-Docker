package com.practica.visita.repositories;

import com.practica.entidadesMySQL.domains.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaRepository extends JpaRepository<Visita,String> {
}
