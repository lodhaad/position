package com.tradeai.position.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ClientPositionInput {
	

	private String clientId;

	private String tradeDate;

	private String settlementDate;

	private String transactionReceivingDate;

	private String securityId;

	private Integer quantity;

	private Double priceOfSecurity;

	private String shortCoverIndicator;

}
