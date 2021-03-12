<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
      <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top py-3 myNav">
    <div class="container">
      <a class="navbar-brand" href="/">Market</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
        <%if(session.getAttribute("session_ok")==null){ %>
         <li class="nav-item active">
            <a class="nav-link" href="login">Login
            </a>
          </li>
               <li class="nav-item active">
            <a class="nav-link" href="join">Join
            </a>
          </li>
          <%}else if(session.getAttribute("session_ok")!=null&&session.getAttribute("session_ok").equals("ok")){ %>
          
           <li class="nav-item active">
            <a class="nav-link" href="saleView"><i class="fas fa-search-dollar fa-2x"></i>
            </a>
          </li>
                   <li class="nav-item active">
            <a class="nav-link" href="logout">Logout
            </a>
          </li>
          
         <li class="nav-item active">
            <a class="nav-link" href="myInfo">myInfo
            </a>
          </li>
          
          <%} %>
    <!--       <li class="nav-item">
            <a class="nav-link" href="#">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Services</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contact</a>
          </li>  -->
        </ul>
      </div>
    </div>
  </nav>