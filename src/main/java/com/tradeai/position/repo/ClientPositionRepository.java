package com.tradeai.position.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tradeai.position.datamodel.ClientPosition;

public interface ClientPositionRepository extends CrudRepository<ClientPosition, Integer> {

	@Query("select max (clientPositionId) from ClientPosition")
	public Integer getPositionId();

	@Query("select max (batchPositionId) from ClientPosition")
	public Integer getBatchId();
	
	public List<ClientPosition> findByClientIdAndSettlementDate(String clientId, Date settlementDate);
	
	

}
