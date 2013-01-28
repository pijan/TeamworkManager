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
	<script type="text/javascript">
	$(function(){
		$('input').checkBox();
		$('#toggle-all').click(function(){
	 	$('#toggle-all').toggleClass('toggle-checked');
		$('#mainform input[type=checkbox]').checkBox('toggle');
		return false;
		});
	});
	</script>  
	
	
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
	<script type="text/javascript">
	$(document).ready(function() {
		$('.styledselect_form_1').selectbox({ inputClass: "styledselect_form_1" });
		$('.styledselect_form_2').selectbox({ inputClass: "styledselect_form_2" });
	});
	</script>
	
	<!--  styled select box script version 3 --> 
	<script src="<c:url value="/resources/js/jquery/jquery.selectbox-0.5_style_2.js" />" type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$('.styledselect_pages').selectbox({ inputClass: "styledselect_pages" });
	});
	</script>
	
	<!--  styled file upload script --> 
	<script src="<c:url value="/resources/js/jquery/jquery.filestyle.js" />" type="text/javascript"></script>
	<script type="text/javascript" charset="utf-8">
	$(function() {
		$("input.file_1").filestyle({ 
		image: "resources/images/forms/upload_file.gif",
		imageheight : 29,
		imagewidth : 78,
		width : 300
		});
	});
	</script>
	
	<!-- Custom jquery scripts -->
	<script src="<c:url value="/resources/js/jquery/custom_jquery.js" />" type="text/javascript"></script>
	 
	<!-- Tooltips -->
	<script src="<c:url value="/resources/js/jquery/jquery.tooltip.js" />" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery/jquery.dimensions.js" />" type="text/javascript"></script>
	<script type="text/javascript">
	$(function() {
		$('a.info-tooltip ').tooltip({
			track: true,
			delay: 0,
			fixPNG: true, 
			showURL: false,
			showBody: " - ",
			top: -35,
			left: 5
		});
	});
	</script> 
	
	<!--  date picker script -->
	<link rel="stylesheet" href="<c:url value="/resources/css/datePicker.css" />" type="text/css" />
	<script src="<c:url value="/resources/js/jquery/date.js" />" type="text/javascript"></script>
	<script src="<c:url value="/resources/js/jquery/jquery.datePicker.js" />" type="text/javascript"></script>
	<script type="text/javascript" charset="utf-8">
	        $(function()
	{
	
	// initialise the "Select date" link
	$('#date-pick')
		.datePicker(
			// associate the link with a date picker
			{
				createButton:false,
				startDate:'01/01/2005',
				endDate:'31/12/2020'
			}
		).bind(
			// when the link is clicked display the date picker
			'click',
			function()
			{
				updateSelects($(this).dpGetSelected()[0]);
				$(this).dpDisplay();
				return false;
			}
		).bind(
			// when a date is selected update the SELECTs
			'dateSelected',
			function(e, selectedDate, $td, state)
			{
				updateSelects(selectedDate);
			}
		).bind(
			'dpClosed',
			function(e, selected)
			{
				updateSelects(selected[0]);
			}
		);
		
	var updateSelects = function (selectedDate)
	{
		var selectedDate = new Date(selectedDate);
		$('#d option[value=' + selectedDate.getDate() + ']').attr('selected', 'selected');
		$('#m option[value=' + (selectedDate.getMonth()+1) + ']').attr('selected', 'selected');
		$('#y option[value=' + (selectedDate.getFullYear()) + ']').attr('selected', 'selected');
	}
	// listen for when the selects are changed and update the picker
	$('#d, #m, #y')
		.bind(
			'change',
			function()
			{
				var d = new Date(
							$('#y').val(),
							$('#m').val()-1,
							$('#d').val()
						);
				$('#date-pick').dpSetSelected(d.asString());
			}
		);
	
	// default the position of the selects to today
	var today = new Date();
	updateSelects(today.getTime());
	
	// and update the datePicker to reflect it...
	$('#d').trigger('change');
	});
	</script>
	
	<!-- MUST BE THE LAST SCRIPT IN <HEAD></HEAD></HEAD> png fix -->
	<script src="<c:url value="/resources/js/jquery/jquery.pngFix.pack.js" />" type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function(){
	$(document).pngFix( );
	});
	</script>

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
		        <c:when test="${springViewName.equals('homepage')}">Dashboard</c:when>
		        <c:when test="${springViewName.equals('notebook')}">Poznámky</c:when>
		        <c:when test="${springViewName.equals('notebookDetail')}">Poznámka ${noteName}</c:when>
		        <c:when test="${springViewName.equals('users')}">Uživatelé</c:when>
		        <c:when test="${springViewName.equals('usersNew')}">Nový uživatel</c:when>
		        <c:when test="${springViewName.equals('usersEdit')}">Úprava uživatele ${name}</c:when>
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
				
					<c:if test="${flashMessage.getType() == 1}">
					<!--  start message-green -->
					<div id="message-green">
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td class="green-left">${flashMessage.getMessage()}</td>
							<td class="green-right"><a class="close-green"><img src="resources/images/table/icon_close_green.gif"   alt="" /></a></td>
						</tr>
						</table>
					</div>
					<!--  end message-green -->
					</c:if>
					
					<c:if test="${flashMessage.getType() == 2}">
					<!--  start message-yellow -->
					<div id="message-yellow">
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td class="yellow-left">${flashMessage.getMessage()}</td>
							<td class="yellow-right"><a class="close-yellow"><img src="resources/images/table/icon_close_yellow.gif"   alt="" /></a></td>
						</tr>
						</table>
					</div>
					<!--  end message-yellow -->
					</c:if>
					
					<c:if test="${flashMessage.getType() == 3}">
					<!--  start message-blue -->
					<div id="message-blue">
						<table border="0" width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td class="blue-left">${flashMessage.getMessage()}</td>
							<td class="blue-right"><a class="close-blue"><img src="resources/images/table/icon_close_blue.gif"   alt="" /></a></td>
						</tr>
						</table>
					</div>
					<!--  end message-blue -->
					</c:if>			
					
					<c:if test="${flashMessage.getType() == 4}">
					<!--  start message-red -->
					<div id="message-red">
					<table border="0" width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td class="red-left">${flashMessage.getMessage()}</td>
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
 