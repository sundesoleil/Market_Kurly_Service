<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>마켓컬리 :: 내일의 장보기, 마켓컬리</title>
	<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/detail.js"></script>
	<link rel="icon" href="/resources/images/favicon.png" />
	<link rel="stylesheet" href="/resources/css/reset.css" />
	<link rel="stylesheet" href="/resources/css/detail.css" />
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
</head>
<body>
	<%@include file="/WEB-INF/views/includes/header.jsp" %>
	<div class="main">
		<section class="prod_detail_area">
			<div class="prod_img_box">
				<img src="/images/${product.mkpi_uri }" />
			</div>
			<div class="prod_detail_content">
				<p class="prod_name">[${product.mkb_name }] ${product.mkp_name }</p>
				<p class="prod_sub_name">${product.mkp_sub_name }</p>
			
				<div class="price">
					<c:if test="${product.mkp_discount == 1 }">
						<p>회원할인가</p>
						<p>
							<span id="finalPrice" data-value="${product.finalPriceInt }">${product.finalPrice}</span><span>원</span>
							<span>${product.mkp_discount_rate}%</span>
						</p>
						<p id="originPrice">${product.originPrice }원 <i class="far fa-question-circle"></i></p>
					</c:if>
					<c:if test="${product.mkp_discount == 0 }">
						<p>
							<span id="finalPrice" data-value="${product.finalPriceInt }">${product.finalPrice}</span><span>원</span>
						</p>
					</c:if>
				</div>
				<c:if test="${product.mkp_point_rate != null }">
					<div class="point">
						<span>웰컴 ${product.mkp_point_rate }%</span>
						<span>개당 <b id="point" data-value="${product.pointInt }">${product.point}</b>원 적립</span>
					</div>
				</c:if>
				
				<div class="detail_info">
					<div class="row">
						<div>판매단위</div>
						<div>${product.mkp_unit }</div>
					</div>
					<div class="row">
						<div>중량/용량</div>
						<div>${product.mkp_weight }g</div>
					</div>
				</div>
				<div class="detail_info">
					<div class="row">
						<div>배송구분</div>
						<div>
							<c:if test="${product.mkp_early_delivery == 1 && product.mkp_delivery == 1}">
								샛별배송/택배배송
							</c:if>
							<c:if test="${product.mkp_early_delivery == 1 && product.mkp_delivery == 0}">
								샛별배송
							</c:if>
							<c:if test="${product.mkp_early_delivery == 0 && product.mkp_delivery == 1}">
								택배배송
							</c:if>
						</div>
					</div>
				</div>
				<div class="detail_info">
					<div class="row">
						<div>포장타입</div>
						<div>
							<p>${product.mkp_packing_type }</p>
							<p>택배배송은 에코포장이 스티로폼으로 대체됩니다.</p>
						</div>
					</div>
				</div>
				
					<div class="detail_info">
						<div class="row">
							<div>알레르기정보</div>
							<c:if test="${product.mkp_allergy_info != null }">
								<div>${product.mkp_allergy_info }</div>
							</c:if>
							<c:if test="${product.mkp_allergy_info == null }">
								<div>없음</div>
							</c:if>
						</div>
					</div>
				
				<div class="detail_info">
					<div class="row">
						<div>유통기한</div>
						<c:if test="${product.mkp_exp_date == null }">
							<p>정해진 유통기한은 없으나, 가급적 빠른 시일 내 드시기 바랍니다.</p>
						</c:if>
						<c:if test="${product.mkp_exp_date != null }">
							<p>${product.mkp_exp_date }까지</p>
						</c:if>
					</div>
				</div>
				<div class="detail_info last">
					<div class="row">
						<div>구매수량</div>
						<div>
							<button id="decrease">
								<i class="fas fa-minus"></i>
							</button>
							<span class="total">
								1
							</span>
							<button id="increase">
								<i class="fas fa-plus"></i>
							</button>
						</div>
					</div>
				</div>
				<div class="final_price_area">
					<div class="final_price">
						<span>총 상품 금액:</span>
						<span>9999</span>
						<span>원</span>
					</div>
<%-- 					<c:if test="${product.mkp_point_rate != null }"> --%>	
						<div class="final_point">
								<span>적립</span>
								<span>구매 시 <b>0</b>원 적립</span>
						</div>
<%-- 					</c:if> --%>
				</div>
				<div class="button_area">
					<button id="add_alarm">재입고 알림</button>
					<button id="add_mark">늘 사는 것</button>
					<button id="add_cart">장바구니 담기</button>
				</div>
			</div>
		</section>
	</div>
	<%@include file="/WEB-INF/views/includes/footer.jsp" %>
</body>
</html>