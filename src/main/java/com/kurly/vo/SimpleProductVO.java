package com.kurly.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleProductVO {
	private Integer mkp_seq;
	private String mkp_name;
	private String mkp_sub_name;
	private Integer mkp_price;
	private Integer mkp_discount;
	private Integer mkp_discount_rate;
	private Integer mkp_kurly_only;
	private String mkpi_uri; // 이미지 경로
	private String mkb_name;
	
	private String discounted;
	private String originPrice;
	
}
