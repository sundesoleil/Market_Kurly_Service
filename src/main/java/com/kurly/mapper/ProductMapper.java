package com.kurly.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kurly.vo.ProductVO;
import com.kurly.vo.SimpleProductVO;

@Mapper
public interface ProductMapper {
	public List<Integer> selectProductSeqList(Integer limit);
	public SimpleProductVO selectProduct(Integer seq);
	public List<Integer> selectRecommendSeqList();
	public SimpleProductVO selectRecommendProd(Integer seq);
	public List<Integer> selectMDRecommendSeqList();
	public List<Integer> selectSpecialSeqList();
	public List<Integer> selectAffordSeqList();
	public ProductVO selectProductBySeq(Integer seq);
}
