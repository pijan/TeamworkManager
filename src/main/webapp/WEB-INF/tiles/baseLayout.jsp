<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="uri" value="${req.requestURI}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Teamwork Manager</title>
	
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	
	<base href="${fn:replace(req.requestURL, fn:substring(uri, 0, fn:length(uri)), req.contextPath)}/" />
	
	<link rel="stylesheet" href="<c:url value="/resources/css/screen.css" />" type="text/css" media="screen" title="default" />

	<!--[if IE]>
	<link rel="stylesheet" media="all" type="text/css" href="<c:url value="/resources/css/pro_dropline_ie.css />" />
	<![endif]-->
	
	<!--  jquery core -->
	<script src="<c:url value="/resources/js/jquery/jquery-1.4.1.min.js" />" type="text/javascript"></script>
	<!--  checkbox styling script -->
	<script src="<c:url value="/resources/js/jquery/ui.core.js" />" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery/ui.checkbox.js" />" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery/jquery.bind.js" />" type="text/javascript"></script>
			
	<![if !IE 7]>
	<!--  styled select box script version 1 -->
	<script src="<c:url value="/resources/js/jquery/jquery.selectbox-0.5.js" />" type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$('.styledselect').selectbox({ inputClass: "selectbox_styled" });
	});
	</script>	
	<![endif]>
	
	<!--  styled select box script version 2 --> 
	<script src="<c:url value="/resources/js/jquery/jquery.selectbox-0.5_style_2.js" />" type="text/javascript"></script>
	<!--  styled select box script version 3 --> 
	<script src="<c:url value="/resources/js/jquery/jquery.selectbox-0.5_style_2.js" />" type="text/javascript"></script>
	<!--  styled file upload script --> 
	<script src="<c:url value="/resources/js/jquery/jquery.filestyle.js" />" type="text/javascript"></script>
	<!-- Custom jquery scripts -->
	<script src="<c:url value="/resources/js/jquery/custom_jquery.js" />" type="text/javascript"></script>
	 
	<!-- Tooltips -->
	<script src="<c:url value="/resources/js/jquery/jquery.tooltip.js" />" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery/jquery.dimensions.js" />" type="text/javascript"></script>
	
	<!--  date picker script -->
	<link rel="stylesheet" href="<c:url value="/resources/css/datePicker.css" />" type="text/css" />
	<script src="<c:url value="/resources/js/jquery/date.js" />" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery/jquery.datePicker.js" />" type="text/javascript"></script>
	
	<!-- MUST BE THE LAST SCRIPT IN <HEAD></HEAD></HEAD> png fix -->
	<script src="<c:url value="/resources/js/jquery/jquery.pngFix.pack.js" />" type="text/javascript"></script>

	<script src="<c:url value="/resources/js/scripts.js" />" type="text/javascript"></script>

</head>
<body>

	
	<!-- Start: page-top-outer -->
	<div id="page-top-outer">    
	
	<!-- Start: page-top -->
	<div id="page-top">
	
		<!-- start logo -->
		<div id="logo">
		<a href=""><img src="resources/images/shared/logo.png" width="156" height="40" alt="" /></a>
		</div>
		<!-- end logo -->
		
		<!--  start top-search
		<div id="top-search">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
			<td><input type="text" value="Search" onblur="if (this.value=='') { this.value='Search'; }" onfocus="if (this.value=='Search') { this.value=''; }" class="top-search-inp" /></td>
			<td>
			<select  class="styledselect">
				<option value=""> All</option>
				<option value=""> Products</option>
				<option value=""> Categories</option>
				<option value="">Clients</option>
				<option value="">News</option>
			</select> 
			</td>
			<td>
			<input type="image" src="resources/images/shared/top_search_btn.gif"  />
			</td>
			</tr>
			</table>
		</div>
	 	<!--  end top-search -->
	 	<div id="top-user">
			Přihlášený uživatel: <a href="users/profile">${user.name}</a>
	 	</div>
	 	<div class="clear"></div>
	
	</div>
	<!-- End: page-top -->
	
	</div>
	<!-- End: page-top-outer -->
		
	<div class="clear">&nbsp;</div>
	 
	<!--  start nav-outer-repeat................................................................................................. START -->
	<div class="nav-outer-repeat"> 
	
		<tiles:insertAttribute name="menu" />
	
	</div>
	<!--  start nav-outer-repeat................................................... END -->
	
	  <div class="clear"></div>
	 
	<!-- start content-outer ........................................................................................................................START -->
	<div id="content-outer">
	<!-- start content -->
	<div id="content">
	
	
	
	<!--  start page-heading -->
	<div id="page-heading">
		<h1>		
			<c:choose>
		    	<c:when test="${springViewName=='homepage'}">Dashboard</c:when>
		        <c:when test="${springViewName=='notebook'}">Poznámky</c:when>
		        <c:when test="${springViewName=='notebookDetail'}">Poznámka ${noteName}</c:when>
		        <c:when test="${springViewName=='users'}">Správa uživatelů</c:when>
		        <c:when test="${springViewName=='usersNew'}">Nový uživatel</c:when>
		        <c:when test="${springViewName=='usersEdit'}">Úprava uživatele ${name}</c:when>
		        <c:when test="${springViewName=='usersProfile'}">Uživatelský profil (${user.name})</c:when>
		        <c:otherwise>${springViewName}</c:otherwise>
		    </c:choose>
		</h1>
	</div>
	<!-- end page-heading -->

	<table border="0" width="100%" cellpadding="0" cellspacing="0" id="content-table">
	<tr>
		<th rowspan="3" class="sized"><img src="resources/images/shared/side_shadowleft.jpg" width="20" height="300" alt="" /></th>
		<th class="topleft"></th>
		<td id="tbl-border-top">&nbsp;</td>
		<th class="topright"></th>
		<th rowspan="3" class="sized"><img src="resources/images/shared/side_shadowright.jpg" width="20" height="300" alt="" /></th>
	</tr>
	<tr>
		<td id="tbl-border-left"></td>
		<td>
		
		<!--  start content-table-inner ...................................................................... START -->
		<div id="content-table-inner">
		
			<!--  start table-content  -->
			<div id="table-content">
	
				<c:if test="${not empty flashMessage}">
				
					<c:if test="${flashMessage.type == 1}">
					<!--  start message-green -->
					<div id="message-green">
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td class="green-left">${flashMessage.message}</td>
							<td class="green-right"><a class="close-green"><img src="resources/images/table/icon_close_green.gif"   alt="" /></a></td>
						</tr>
						</table>
					</div>
					<!--  end message-green -->
					</c:if>
					
					<c:if test="${flashMessage.type == 2}">
					<!--  start message-yellow -->
					<div id="message-yellow">
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td class="yellow-left">${flashMessage.message}</td>
							<td class="yellow-right"><a class="close-yellow"><img src="resources/images/table/icon_close_yellow.gif"   alt="" /></a></td>
						</tr>
						</table>
					</div>
					<!--  end message-yellow -->
					</c:if>
					
					<c:if test="${flashMessage.type == 3}">
					<!--  start message-blue -->
					<div id="message-blue">
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td class="blue-left">${flashMessage.message}</td>
							<td class="blue-right"><a class="close-blue"><img src="resources/images/table/icon_close_blue.gif"   alt="" /></a></td>
						</tr>
						</table>
					</div>
					<!--  end message-blue -->
					</c:if>			
					
					<c:if test="${flashMessage.type == 4}">
					<!--  start message-red -->
					<div id="message-red">
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td class="red-left">${flashMessage.message}</td>
						<td class="red-right"><a class="close-red"><img src="resources/images/table/icon_close_red.gif"   alt="" /></a></td>
					</tr>
					</table>
					</div>
					<!--  end message-red -->
					</c:if>				
				
				</c:if>
	 
				<tiles:insertAttribute name="content" />
					
		
			<!--  end table-content  -->
	
			<div class="clear"></div>
		 
		</div>
		<!--  end content-table-inner ............................................END  -->
		</td>
		<td id="tbl-border-right"></td>
	</tr>
	<tr>
		<th class="sized bottomleft"></th>
		<td id="tbl-border-bottom">&nbsp;</td>
		<th class="sized bottomright"></th>
	</tr>
	</table>
		
		
		
		<div class="clear">&nbsp;</div>
	
	</div>
	<!--  end content -->
	<div class="clear">&nbsp;</div>
	</div>
	<!--  end content-outer........................................................END -->
	
	<div class="clear">&nbsp;</div>
	    
	<!-- start footer -->         
	<div id="footer">
	<!-- <div id="footer-pad">&nbsp;</div> -->
		<!--  start footer-left -->
		<div id="footer-left">
		Admin Skin &copy; Copyright Internet Dreams Ltd. <a href="">www.netdreams.co.uk</a>. All rights reserved.</div>
		<!--  end footer-left -->
		<div class="clear">&nbsp;</div>
	</div>
	<!-- end footer -->
	 
	
	

</body>
</html>
 