package br.edu.ifsuldeminas.mch.webii.crudmanager.dao;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
