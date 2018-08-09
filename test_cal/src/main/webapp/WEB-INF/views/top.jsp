<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="./resources/bootstrap-4.1.3/bootstrap.min.css"> -->
<link rel="stylesheet" href="./resources/bootswatch-theme/bootstrap.min.css">
<script src="./resources/bootstrap-4.1.3/bootstrap.min.js"></script>
<link rel="stylesheet" href="./resources/common.css">
<script src="./resources/common.js"></script>


<div class="bs-component">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="">Logo</a>
	  <button class="navbar-toggler collapsed" aria-expanded="false" aria-controls="navbarColor03" aria-label="Toggle navigation" type="button" data-target="#navbarColor03" data-toggle="collapse">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="navbar-collapse collapse" id="navbarColor03">
	    <ul class="navbar-nav mr-auto">
	      <li id="home" class="nav-item">
	        <a class="nav-link" href="">ホーム</a>
	      </li>
	      <li id="file" class="nav-item">
	        <a class="nav-link" href="testPage">ファイル</a>
	      </li>
	      <li id="list" class="nav-item">
	        <a class="nav-link" href="#">リスト</a>
	      </li>
	      <li id="baggage" class="nav-item">
	        <a class="nav-link" href="#">荷物管理番号</a>
	      </li>
	    </ul>
	    <form class="form-inline my-2 my-lg-0">
	      <input class="form-control mr-sm-2" type="text" placeholder="Search">
	      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
	    </form>
	  </div>
	</nav>
   </div>
