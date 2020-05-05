package com.tradeai.position.service;

import java.text.ParseException;
import java.util.List;



import com.tradeai.position.dto.ClientPositionDTO;

public interface ClientPositionService {
	


	
	public List<ClientPositionDTO> saveClientPosition(List<ClientPositionDTO> dto) throws ParseException;
	
	public List<ClientPositionDTO> getClientPositions(String clientId, String date) throws ParseException;
	
	

}
