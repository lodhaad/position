package com.tradeai.position.datamodel;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "client_position", schema = "positions")
public class ClientPosition {
	
	@Id
	@Column(name = "client_position_id")
	private Integer clientPositionId;
	
	@Column(name = "client_batch_id")
	private Integer batchPositionId;
	
	@Column(name = "client_id")
	private String clientId;
	
	@Column(name = "trade_date")
	private Date tradeDate;
	
	@Column(name = "settlement_date")
	private Date settlementDate;
	
	@Column(name = "receiving_date")
	private Date transactionReceivingDate;
	
	@Column(name = "security_id")
	private String securityId;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price")
	private Double priceOfSecurity;
	
	@Column(name = "short_cover_indicator")
	private String shortCoverIndicator;
	

}
