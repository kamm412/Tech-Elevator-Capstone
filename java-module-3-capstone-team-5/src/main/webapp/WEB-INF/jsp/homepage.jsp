<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Home Page"/>
<!--  included header -->
<%@include file="common/header.jsp" %> 

<c:forEach items="${parks}" var="park">

<div class="parkContainer">

    <c:url value="/parkdetails" var="details" />
    
    <!-- fetched the park image and created  -->
    <a href="${details}?parkCode=${park.parkCode}"> <img class="parkImg" alt="Park Image"
        src="img/parks/${park.parkCode.toLowerCase()}.jpg">   
    </a>
    
    
    <div class="ParkNameandDes">
    
    <!-- fetch park names -->
        <div class="ParkName">
        <c:out value="${park.parkName}" /></div> 
        
        <!-- fetch park details --> 
        <div class="ParkDescription">
        <c:out value="${park.description}" /></div>
    </div>
    
    
    
</div>
</c:forEach>

<br/>
<br/>
<!-- included footer -->
<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>