<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header/link.jsp" %>
  
 <link href="resources/myCss/saleView.css" rel="stylesheet">

 </head>

<body>

<%@ include file="../header/header.jsp" %>

<div class="saleView-div">

	<form class="saleView-form" action="modifyProduct" method="post"  enctype="multipart/form-data"  onsubmit="return chk_file();">
		<select name="item_kinds" class="kinds">
			<option>가구</option>
			<option>의류</option>
			<option>컴퓨터</option>
			<option>패션잡화</option>
			<option>컴퓨터</option>
		</select>
		<input type="hidden" name="market_idx" value="${product.market_idx }">
		<input type="text" placeholder="상품 이름" name="item_title" class="title" value="${product.item_title }">
		<input type="text" placeholder="가격" name="item_price" class="price" value=${product.market_price }>
		<textarea rows="7" cols="60" placeholder="설명" name="item_desc" class="desc" >${product.item_desc }</textarea>
		<input type="file" name="file" class="file" id="file_id" value=${product.market_img }>

		<div>
		<input type="submit" value="등록" class="btn btn-outline-info submitBtn" >
		<button type="button" class="btn btn-outline-info backBtn" onclick="history.back()">뒤로가기</button>	
		</div>
	</form>
	
</div>



<%@ include file="../footer/footer.jsp" %>

<script>
function chk_file(){
	   var fileCheck = $("#file_id").val();
	   console.log(">>"+fileCheck);
	    if(fileCheck==''){
	        alert("파일을 첨부해 주세요");
	        return false;
	    }
	    else{
	    	true;
	    }
}
 
</script>

</body>

</html>