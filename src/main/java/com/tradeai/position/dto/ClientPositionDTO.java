package com.tradeai.position.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ClientPositionDTO {

	private Integer clientPositionId;
	
	private Integer batchPositionId;

	private String clientId;

	private Date tradeDate;

	private Date settlementDate;

	private Date transactionReceivingDate;

	private String securityId;

	private Integer quantity;

	private Double priceOfSecurity;

	private String shortCoverIndicator;

	@Autowired
	private SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
	
	



	public void setSettlementDate(String date) throws ParseException {

		settlementDate = sdf.parse(date);

	}
	
	public void setSettlementDate(java.sql.Date date) throws ParseException {


			settlementDate = new Date(date.getTime());

	}

	public String getSettlementDate() {

		return sdf.format(settlementDate);
	}

	public void setTradeDate(String date) throws ParseException {

		tradeDate = sdf.parse(date);

	}
	
	public void setTradeDate(java.sql.Date date) throws ParseException {

		tradeDate =  new Date(date.getTime());

	}

	public String getTradeDate() {

		return sdf.format(tradeDate);
	}

	public void setTransactionReceivingDate(String date) throws ParseException {

		transactionReceivingDate = sdf.parse(date);

	}
	
	public void setTransactionReceivingDate(java.sql.Date date) throws ParseException {

		transactionReceivingDate = new Date(date.getTime());


	}

	public String getTransactionReceivingDate() {

		return sdf.format(transactionReceivingDate);
	}

}
