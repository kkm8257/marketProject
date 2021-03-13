<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header/link.jsp" %>
  
<link href="resources/myCss/productView.css" rel="stylesheet">

 </head>

<body>

<%@ include file="../header/header.jsp" %>

<div class="productView-div">
	
	<div class="productView-form">
	<div class="menu_tip">
	<button type="button" class="btn btn-outline-info " onclick="history.back()">뒤로가기</button>
	<button type="button" class="btn btn-outline-info" onclick="location.href='myInfo_productModify?idx=${product.market_idx}'">수정</button>
	<button type="button" class="btn btn-outline-info" onclick="location.href='myinfo_product_delete?idx=${product.market_idx}'">삭제</button>
	</div>	
		
		<img src="/market_path/${product.market_img }" class="product_img">
		<div class="title">${product.item_title }</div>
		<div class="desc">${product.item_desc }</div>
		<div class="price">가격 ${settingPrice}원</div>
	</div>
	


</div>


</body>

</html>