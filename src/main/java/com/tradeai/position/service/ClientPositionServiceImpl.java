package com.tradeai.position.service;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradeai.position.datamodel.ClientPosition;
import com.tradeai.position.dto.ClientPositionDTO;
import com.tradeai.position.repo.ClientPositionRepository;

@Service
public class ClientPositionServiceImpl implements ClientPositionService {

	@Autowired
	private ClientPositionRepository repository;

	@Override
	public List<ClientPositionDTO> saveClientPosition(List<ClientPositionDTO> clientPosdto) throws ParseException {

		List<ClientPosition> position = new ArrayList<>();

		Integer posId = repository.getPositionId();

		Integer batchId = repository.getBatchId();

		if (posId == null) {
			posId = 0;
		}

		if (batchId == null) {
			batchId = 0;
		}

		batchId = batchId + 1;

		for (ClientPositionDTO dto : clientPosdto) {

			ClientPosition clientPos = new ClientPosition();
			posId = posId + 1;
			clientPos.setClientPositionId(posId);
			clientPos.setBatchPositionId(batchId);
			clientPos.setSecurityId(dto.getSecurityId());
			clientPos.setClientId(dto.getClientId());
			clientPos.setQuantity(dto.getQuantity());
			clientPos.setSettlementDate(Date.valueOf(dto.getSettlementDate()));
			clientPos.setShortCoverIndicator(dto.getShortCoverIndicator());
			///clientPos.setTransactionReceivingDate(Date.valueOf(dto.getTransactionReceivingDate()));
			clientPos.setPriceOfSecurity(dto.getPriceOfSecurity());
			clientPos.setTradeDate(Date.valueOf(dto.getTradeDate()));
			position.add(clientPos);

		}

		Iterable<ClientPosition>  SavedPositions = repository.saveAll(position);
		
		Iterator<ClientPosition> savedPosIterator =  SavedPositions.iterator();
		
		List<ClientPositionDTO> returnCP = new ArrayList<>();
		
		while (savedPosIterator.hasNext()) {
			
			ClientPosition saveCP = savedPosIterator.next();
			
			ClientPositionDTO dto = new ClientPositionDTO();
			dto.setClientId(saveCP.getClientId());
			dto.setSecurityId(saveCP.getSecurityId());
			dto.setQuantity(saveCP.getQuantity());
			dto.setBatchPositionId(saveCP.getBatchPositionId());
			dto.setClientPositionId(saveCP.getClientPositionId());
			dto.setSettlementDate(saveCP.getSettlementDate());
			//dto.setTransactionReceivingDate(saveCP.getTransactionReceivingDate());
			dto.setPriceOfSecurity(saveCP.getPriceOfSecurity());
			dto.setTradeDate(saveCP.getTradeDate());
			dto.setShortCoverIndicator(saveCP.getShortCoverIndicator());
			returnCP.add(dto);
			
		}

		return returnCP;
	}

	@Override
	public List<ClientPositionDTO> getClientPositions(String clientId, String settlementDate) throws ParseException {
		
		List<ClientPositionDTO> dtos = new ArrayList<>();
		
		List<ClientPosition> positions = repository.findByClientIdAndSettlementDate(clientId, Date.valueOf(settlementDate));
		
		for (ClientPosition position : positions) {
			
			ClientPositionDTO dto = new ClientPositionDTO();
			
			dto.setSecurityId(position.getSecurityId());
			dto.setClientId(position.getClientId());
			dto.setSettlementDate(position.getSettlementDate());
			dto.setClientPositionId(position.getClientPositionId());
			dto.setBatchPositionId(position.getBatchPositionId());
			dto.setShortCoverIndicator(position.getShortCoverIndicator());
			dtos.add(dto);
			
			
			
		}


		return dtos;
	}

}
