package com.tradeai.position.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 

public class DemandAPIDTO {

	private Integer demandId;
	private String stockId;
	private String clientId;
	private Integer quantity;
	private Date settlementDate;
	
	@Autowired
	private SimpleDateFormat sdf;

	public void setSettlementDate(String date) throws ParseException {

		settlementDate = sdf.parse(date);

	}

	public String getSettlementDate() {

		return sdf.format(settlementDate);
	}

	
	
	
}
