package com.tradeai.position.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradeai.position.dto.ClientPositionDTO;
import com.tradeai.position.input.ClientPositionInput;
import com.tradeai.position.output.ClientPositionOutput;
import com.tradeai.position.service.ClientPositionService;

@RestController
@RequestMapping("/client-position")
public class PositionController {
	
	@Autowired
	private ClientPositionService service;
	
	@GetMapping ("/health")
	public String health() {
		return " good health Postion Service"; 
		
	}
	
	
	@GetMapping("/{clientId}/date/{dateOfPosition}")
	
	public ResponseEntity<List<ClientPositionOutput>> getPositionsForClient(@PathVariable String clientId, 
			@PathVariable String dateOfPosition) throws ParseException{
		
		List<ClientPositionDTO> listDTO = service.getClientPositions(clientId, dateOfPosition);
		
		List<ClientPositionOutput> output = new ArrayList<>();
		
		for (ClientPositionDTO singlePos : listDTO) {
			
			ClientPositionOutput outputPos = new ClientPositionOutput();
			outputPos.setSecurityId(singlePos.getSecurityId());
			outputPos.setClientId(singlePos.getClientId());
			outputPos.setQuantity(singlePos.getQuantity());
			outputPos.setShortCoverIndicator(singlePos.getShortCoverIndicator());
			outputPos.setSettlementDate(singlePos.getSettlementDate());
			outputPos.setTradeDate(singlePos.getSettlementDate());
			outputPos.setPriceOfSecurity(singlePos.getPriceOfSecurity());
			outputPos.setClientPositionId(singlePos.getClientPositionId());
			outputPos.setBatchPositionId(singlePos.getBatchPositionId());
			output.add(outputPos);
			
		}


		 return new ResponseEntity<List<ClientPositionOutput>>(output, HttpStatus.OK);

		
	}
	
	@PostMapping("/{clientId}/date/{dateOfPosition}")
	
	public ResponseEntity<List<ClientPositionOutput>> loadPostions (@RequestBody List<ClientPositionInput> input) throws ParseException {
		
		List<ClientPositionDTO> listDTO = new ArrayList<>();
	
		for (ClientPositionInput clientPosition : input ) {
			
			ClientPositionDTO dto = new ClientPositionDTO();
			dto.setClientId(clientPosition.getClientId());
			dto.setSecurityId(clientPosition.getSecurityId());
			dto.setQuantity(clientPosition.getQuantity());
			dto.setSettlementDate(clientPosition.getSettlementDate());
			///dto.setTransactionReceivingDate(clientPosition.getTransactionReceivingDate());
			dto.setShortCoverIndicator(clientPosition.getShortCoverIndicator());
			dto.setTradeDate(clientPosition.getSettlementDate());
			dto.setPriceOfSecurity(clientPosition.getPriceOfSecurity());
			listDTO.add(dto);
			
			
		}
		
		listDTO = service.saveClientPosition(listDTO);
		
		List<ClientPositionOutput> output = new ArrayList<>();
		
		for (ClientPositionDTO singlePos : listDTO) {
			
			ClientPositionOutput outputPos = new ClientPositionOutput();
			outputPos.setSecurityId(singlePos.getSecurityId());
			outputPos.setClientId(singlePos.getClientId());
			outputPos.setQuantity(singlePos.getQuantity());
			outputPos.setShortCoverIndicator(singlePos.getShortCoverIndicator());
			outputPos.setSettlementDate(singlePos.getSettlementDate());
			outputPos.setTradeDate(singlePos.getSettlementDate());
			outputPos.setPriceOfSecurity(singlePos.getPriceOfSecurity());
			outputPos.setClientPositionId(singlePos.getClientPositionId());
			outputPos.setBatchPositionId(singlePos.getBatchPositionId());


			
			output.add(outputPos);
			
		}


		 return new ResponseEntity<List<ClientPositionOutput>>(output, HttpStatus.OK);

	}
	
	public String loadPosition() { 
		
		return " load position" ;
		
	}

}
