package br.edu.ifsuldeminas.mch.webii.crudmanager.dao;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Quarto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer> {
    List<Quarto> findQuartosByStatus(String status);
}
