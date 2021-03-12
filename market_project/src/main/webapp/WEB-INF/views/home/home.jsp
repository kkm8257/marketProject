<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  
<link href="resources/myCss/home.css" rel="stylesheet">
<%@ include file="../header/link.jsp" %>
</head>

<body>

<%@ include file="../header/header.jsp" %>


  <!-- Page Content -->
  <div class="container main-content">

    <!-- Jumbotron Header -->
<!--     <header class="jumbotron my-4">
      <h1 class="display-3">A Warm Welcome!</h1>
      <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsa, ipsam, eligendi, in quo sunt possimus non incidunt odit vero aliquid similique quaerat nam nobis illo aspernatur vitae fugiat numquam repellat.</p>
      <a href="#" class="btn btn-primary btn-lg">Call to action!</a>
    </header> -->


<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="resources/img/img_1.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="resources/img/img_2.png" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="resources/img/img_3.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"  data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"  data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

    <!-- Page Features -->
    
    <!-- /.row -->



  <form class="d-flex">
      <input class="my-form-control " type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success" type="submit">Search</button>
   
   </form>

	<div class="search-list">
		
	
	
	
	</div>

  </div>
  <!-- /.container -->




<%@ include file="../footer/footer.jsp" %>


<script>
window.scrollTo({top:0,  behavior:'auto'});
</script>

</body>

</html>
