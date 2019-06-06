package com.maia.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maia.course.domain.Request;
import com.maia.course.domain.RequestStage;

@Repository
public interface RequestStageRepository extends JpaRepository<RequestStage, Long> {
	
	
	/*Buscar todos os Pedidos com base no Id do Usuario*/
	public List<Request>findAllByRequestId(Long id);
		
	



}
