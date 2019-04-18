<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/WEB-INF/jsp/common/header.jsp" %>

  <!-- park image -->
<div class="parkDetailContainer">
<img class="parkDetailImg" alt="Park Image"
        src="img/parks/${park.parkCode.toLowerCase()}.jpg">

    <!-- get all the details for park -->
    <div class="parkDetailOutput">
        <h2 class="detailParkName">
            <c:out value="${park.parkName}" />
        </h2>
        <h3 class="parkState">
            State:
            <c:out value="${park.state}" />
        </h3>
        <h4 class="parkAcerage">
            Acreage:
            <c:out value="${park.acreage}" />
        </h4>
        <h4 class="parkAcerage">
            Elevation(ft.):
            <c:out value="${park.elevationInFeet}" />
        </h4>
        <h4 class="parkMilesOfTrail">
            Miles of Trail:
            <c:out value="${park.milesOfTrail}" />
        </h4>
         <h4 class="parknumberOfCampsite">
            Number of Campsites:
            <c:out value="${park.numberOfCampsite}" />
        </h4>
        <h4 class="parkClimate">
            Climate:
            <c:out value="${park.climate}" />
        </h4>
        <h4 class="parkYearFounded">
            Year Founded:
            <c:out value="${park.yearFounded}" />
        </h4>
        <h4 class="parkAnnualVisitorCount">
            Annual Visitors:
            <c:out value="${park.annualVisitorCount}" />
        </h4>
         <h4 class="parkQuote">
            Quote:
            <c:out value="${park.quote}" />
        </h4>
        <h4 class="parkQuoteSource">
            Quote Source:
            <c:out value="${park.quoteSource}" />
        </h4>
        <h4 class="parkDescription">
            Description:
            <c:out value="${park.description}" />
        </h4>
        <h4 class="parkEntryFee">
            Entry Fee:
            <c:out value="${park.entryFee}" />
        </h4>
        <h4 class="parkNumberOfAnimalSpecies">
            Number Of Animal Species:
            <c:out value="${park.numberOfAnimalSpecies}" />
        </h4>
         
    </div>
    
   <!--  Redirecting to the bellow mentioned URl -->
    <c:url value="/parkdetails" var="formAction" />
    
  <!--   Form action post for temperature -->
    <form method="POST" action="${formAction}">

        <label for="tempType">Temp Type</label>
        <select id="tempType" name="tempType">
            <option value="true"> F </option>
            <option value="false"> C </option>
        </select>
        <input type="hidden" name="parkCode" value="${park.parkCode}"/> 
        <input type="submit" value="Submit"/>
    </form>
    
    <div>
			<div class="weatherGrid">
				<c:out value="${fiveDayForecastValue}" />
				<c:forEach var="forecast" items="${parkForecast}"> <!-- getting weather image for each weather -->

                <c:url var="forecastImage" value="img/weather/${forecast.forecast.toLowerCase()}.png" /> <!-- getting weather image rest four-->
                
                <c:choose>
                    <c:when test="${forecast.fiveDayForecastValue == 1}">
                    <div class="todaysWeather">
                                
                        <div class="today">This week's forecast:
                            <p>Today</p>
                        </div>
                        <img class="todaysWeatherImage" alt="${forecast.forecast}" src="${forecastImage}">  <!--  getting weather image for today -->
                        
                    <div class="todaysTemp">
                    
                    <!-- display in celcius -->
                        <c:if test="${isF == false}">
                            <fmt:formatNumber var="formattedCHigh" maxFractionDigits="0" value="${((forecast.high - 32) * (.5556)) }" />
                            High <c:out value="${formattedCHigh}" /> C
                            <fmt:formatNumber var="formattedCLow" maxFractionDigits="0" value="${((forecast.high - 32) * (.5556)) }" />
                            Low <c:out value="${formattedCLow}" /> C
                        </c:if>
                        
                        <!-- display in farenhit -->
                        <c:if test="${isF == true || isF == null}">
                            High <c:out value="${forecast.high}" /> F
                            Low <c:out value="${forecast.low}" /> F
                        </c:if>                         
                    
                    <!-- messages for users as per forecast value  -->
                        <c:if test="${forecast.high > 75}">
                            <p>Bring an extra gallon of water</p>
                        </c:if>
                        
                        <c:if test="${(forecast.high - forecast.low) > 20}">
                            <p>Wear breathable layers</p>
                        </c:if>
                        
                        <c:if test="${forecast.low < 20}">
                            <p>Beware the dangers of exposure to fridge temperatures</p>
                        </c:if>
                        
				<!-- messages for users as per forecast value  -->
                        <c:choose>
                            <c:when test="${forecast.forecast.equals('rain')}">
                                <p>Pack rain gear and wear waterproof shoes</p>
                            </c:when>
                            <c:when test="${forecast.forecast.equals('snow')}">
                                <p>Pack snow shoes</p>
                            </c:when>
                            <c:when test="${forecast.forecast.equals('sunny')}">
                            <p>Pack sunblock</p>
                            </c:when>
                            <c:when test="${forecast.forecast.equals('thunderstorm')}">
                            <p>Seek shelter and avoid hiking on exposed ridges</p>
                            </c:when>
                            <c:when test="${forecast.forecast.equals('cloudy')}">
                            <p>Don't bring sunglasses, they are not needed</p>
                            </c:when>
                            <c:when test="${forecast.forecast.equals('partly cloudy')}">
                            <p>Don't bring sunglasses</p>
                            </c:when>
                            
                            
                        </c:choose> 
                        </div>
                    </div>  
                </c:when>
                    <c:otherwise>
                    
                    <!-- session handling -->
                     <div class="weeksWeather">
                        <img class="weeksWeatherImage" alt="${forecast.forecast}"
                            src="${forecastImage}">
                        <div class="weeksTemp">
                            <c:if test="${isF == false}">
                                <fmt:formatNumber var="formattedCHigh" maxFractionDigits="0" value="${((forecast.high - 32) * (.5556)) }" />
                                High <c:out value="${formattedCHigh}" /> C
                                 Low <fmt:formatNumber var="formattedCLow" maxFractionDigits="0" value="${((forecast.high - 32) * (.5556)) }" />
                            <c:out value="${formattedCLow}" /> C
                            </c:if>
                            <c:if test="${isF == true || isF == null}">
                                High <c:out value="${forecast.high}" /> F
                                Low <c:out value="${forecast.low}" /> F
                            </c:if>
                        </div> 
                        
                    </div>          
                    </c:otherwise>
                </c:choose>
        
            </c:forEach>
        </div>

		</div>

	</div>
	
<%@ include file="/WEB-INF/jsp/common/footer.jsp" %>