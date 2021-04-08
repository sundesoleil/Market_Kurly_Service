package com.kurly.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kurly.mapper.ProductMapper;
import com.kurly.vo.ProductVO;
import com.kurly.vo.SimpleProductVO;

@Service
public class ProductService {
	@Autowired
	ProductMapper mapper;
	
	public List<SimpleProductVO> selectProdcuts(){
		List<Integer> seqList = mapper.selectProductSeqList(4);
		List<SimpleProductVO> productList = new ArrayList<SimpleProductVO>();
		for(int i=0; i<seqList.size(); i++) {
			Integer seq = seqList.get(i);
			SimpleProductVO product = mapper.selectProduct(seq);
			DecimalFormat format = new DecimalFormat("###,###");
			
			if(product.getMkp_discount() == 1) {
				Integer price = Math.round(
						product.getMkp_price() - 
						product.getMkp_price() * 
						product.getMkp_discount_rate() / 100
						);
						product.setDiscounted(format.format(price));
				/*
				 Long price = Math.round(
						product.getMkp_price() - 
						product.getMkp_price() * 
						(product.getMkp_discount_rate() / 100.0)
						);
				 */
			}

			product.setOriginPrice(format.format(product.getMkp_price()));
			productList.add(product);
		}
		return productList;
	}
	
	public List<SimpleProductVO> selectRecommendProducts(){
		List<Integer> seqList = mapper.selectRecommendSeqList();
		List<SimpleProductVO> productList = new ArrayList<SimpleProductVO>();
		for(int i=0; i<seqList.size(); i++) {
			Integer seq = seqList.get(i);
			SimpleProductVO product = mapper.selectRecommendProd(seq);
			DecimalFormat format = new DecimalFormat("###,###");
			
			if(product.getMkp_discount() == 1) {
				Integer price = Math.round(
						product.getMkp_price() - 
						product.getMkp_price() * 
						product.getMkp_discount_rate() / 100
						);
						product.setDiscounted(format.format(price));
			}

			product.setOriginPrice(format.format(product.getMkp_price()));
			productList.add(product);
		}
		return productList;
	}
	
	public List<SimpleProductVO> selectMDRecommendProducts(){
		List<Integer> seqList = mapper.selectMDRecommendSeqList();
		List<SimpleProductVO> productList = new ArrayList<SimpleProductVO>();
		for(int i=0; i<seqList.size(); i++) {
			Integer seq = seqList.get(i);
			SimpleProductVO product = mapper.selectRecommendProd(seq);
			DecimalFormat format = new DecimalFormat("###,###");
			
			if(product.getMkp_discount() == 1) {
				Integer price = Math.round(
						product.getMkp_price() - 
						product.getMkp_price() * 
						product.getMkp_discount_rate() / 100
						);
						product.setDiscounted(format.format(price));
			}

			product.setOriginPrice(format.format(product.getMkp_price()));
			productList.add(product);
		}
		return productList;
	}
	public List<SimpleProductVO> selectSpecialProducts(){
		List<Integer> seqList = mapper.selectSpecialSeqList();
		List<SimpleProductVO> productList = new ArrayList<SimpleProductVO>();
		for(int i=0; i<seqList.size(); i++) {
			Integer seq = seqList.get(i);
			SimpleProductVO product = mapper.selectRecommendProd(seq);
			DecimalFormat format = new DecimalFormat("###,###");
			
			if(product.getMkp_discount() == 1) {
				Integer price = Math.round(
						product.getMkp_price() - 
						product.getMkp_price() * 
						product.getMkp_discount_rate() / 100
						);
						product.setDiscounted(format.format(price));
			}

			product.setOriginPrice(format.format(product.getMkp_price()));
			productList.add(product);
		}
		return productList;
	}
	public List<SimpleProductVO> selectAffordProducts(){
		List<Integer> seqList = mapper.selectAffordSeqList();
		List<SimpleProductVO> productList = new ArrayList<SimpleProductVO>();
		for(int i=0; i<seqList.size(); i++) {
			Integer seq = seqList.get(i);
			SimpleProductVO product = mapper.selectRecommendProd(seq);
			DecimalFormat format = new DecimalFormat("###,###");
			
			if(product.getMkp_discount() == 1) {
				Integer price = Math.round(
						product.getMkp_price() - 
						product.getMkp_price() * 
						product.getMkp_discount_rate() / 100
						);
						product.setDiscounted(format.format(price));
			}

			product.setOriginPrice(format.format(product.getMkp_price()));
			productList.add(product);
		}
		return productList;
	}
	public ProductVO selectProductBySeq(Integer seq) {
		ProductVO product = mapper.selectProductBySeq(seq);
		DecimalFormat formatter = new DecimalFormat("###,###");
		
		if(product.getMkp_discount() != null) {
			if(product.getMkp_discount() == 1) {
				Integer price = product.getMkp_price();
				price = price - (int)Math.floor(price * product.getMkp_discount_rate() / 100.0);
				
				product.setFinalPrice(formatter.format(price));
				product.setFinalPriceInt(price);
			}
			else {
				product.setFinalPrice(formatter.format(product.getMkp_price()));
				product.setFinalPriceInt(product.getMkp_price());
			}
		}
		
		product.setOriginPrice(formatter.format(product.getMkp_price()));
		Integer point = null;
		
		if(product.getMkp_point_rate() != null) {
			point = (int)(product.getMkp_price() * product.getMkp_point_rate() / 100.0);
		}else {
			point = 0;
		}
		product.setPoint(formatter.format(point));
		product.setPointInt(point);
		return product;
	}
}