<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>National Parks Geek</title>
	<c:url value="/css/site.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
    
</head>

<body>
	<header>
		<c:url value="/" var="homePageUrl"/>
		<c:url value="/img/logo.png" var="logoSrc"/>
		<a href="${homePageUrl}">
		<img src="${logoSrc }" alt="home page logo"></a>
	</header>
	
	<nav>
		<ul>
			<c:url value="/" var="homePageUrl" />
			<li><a href="${homePageUrl}">Home Page</a></li>
			<c:url value="/surveyInputPage" var="surveyUrl" />
			<li><a href="${surveyUrl}">Survey Page</a></li>
		</ul>
	</nav>