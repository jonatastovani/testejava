package com.example.testejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testejava.model.RGExpedidorModel;

@Repository
public interface RGExpedidorRepository extends JpaRepository<RGExpedidorModel, Long>{

}
