package com.kurly.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kurly.service.CategoryService;
import com.kurly.service.ProductService;
import com.kurly.vo.ClassifyDataVO;
import com.kurly.vo.SimpleProductVO;

@Controller
public class MainController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String getMain(Model model, HttpSession session) {
		
		List<ClassifyDataVO> categoryList = categoryService.selectCategories();
		session.setAttribute("categoryList", categoryList);
		
		List<SimpleProductVO> recentProductList = productService.selectProdcuts();
		model.addAttribute("recentProductList", recentProductList);
		
		List<SimpleProductVO> recommendProductList = productService.selectRecommendProducts();
		model.addAttribute("recommendProductList", recommendProductList);
		
		List<SimpleProductVO> mdRecommendProductList = productService.selectMDRecommendProducts();
		model.addAttribute("mdRecommendProductList", mdRecommendProductList);
		
		List<SimpleProductVO> specialProductList = productService.selectSpecialProducts();
		model.addAttribute("specialProductList", specialProductList);
		
		List<SimpleProductVO> affordProductList = productService.selectAffordProducts();
		model.addAttribute("affordProductList", affordProductList);
		
		return "/main";
	}
}
