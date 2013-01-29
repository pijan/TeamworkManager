<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!--  start nav-outer -->
<div class="nav-outer"> 

		<!-- start nav-right -->
		<div id="nav-right">
		
			<div class="nav-divider">&nbsp;</div>
			<div class="showhide-account"><a href="users/profile"><img src="resources/images/shared/nav/nav_myaccount.gif" width="93" height="14" alt="" /></a></div>
			<div class="nav-divider">&nbsp;</div>
			<a href="j_spring_security_logout" id="logout"><img src="resources/images/shared/nav/nav_logout.gif" width="64" height="14" alt="" /></a>
			<div class="clear">&nbsp;</div>
			
		</div>
		<!-- end nav-right -->


		<!--  start nav -->
		<div class="nav">
		<div class="table">
				
		<ul ${springViewName=="homepage" ? 'class="current"' : 'class="select"'}><li><a href="#nogo"><b>Dashboard</b> <!--[if IE 7]><!--></a><!--<![endif]-->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
		<div class="select_sub ${springViewName=='homepage' ? 'show' : ''}">
			<ul class="sub">
				<li ${springViewName=='homepage' ? 'class="sub_show"' : ''}><a href="">Přehled projektu</a></li>
			</ul>
		</div>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
		</ul>
		
		<div class="nav-divider">&nbsp;</div>
		                    
		<ul ${springViewName=="tasks" ? 'class="current"' : 'class="select"'}><li><a href="#nogo"><b>Úkoly</b><!--[if IE 7]><!--></a><!--<![endif]-->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
		<div class="select_sub ${springViewName=='tasks' ? 'show' : ''}">
			<ul class="sub">
				<li ${springViewName=='tasks' ? 'class="sub_show"' : ''}><a href="#nogo">Zobrazit úkoly</a></li>
				<li><a href="#nogo">Nový úkol</a></li>
			</ul>
		</div>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
		</ul>
		
		<div class="nav-divider">&nbsp;</div>
		
		<ul ${springViewName=="calendar" ? 'class="current"' : 'class="select"'}><li><a href="#nogo"><b>Kalendář</b><!--[if IE 7]><!--></a><!--<![endif]-->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
		<div class="select_sub ${springViewName=='calendar' ? 'show' : ''}">
			<ul class="sub">
				<li ${springViewName=='calendar' ? 'class="sub_show"' : ''}><a href="#nogo">Zobrazit kalendář</a></li>
				<li><a href="#nogo">Nová událost</a></li>
			</ul>
		</div>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
		</ul>
		
		<div class="nav-divider">&nbsp;</div>
		
		<ul ${(springViewName=='notebook' or springViewName=='notebookDetail') ? 'class="current"' : 'class="select"'}><li><a href="notebook/"><b>Poznámky</b><!--[if IE 7]><!--></a><!--<![endif]-->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
		<div class="select_sub ${(springViewName=='notebook' or springViewName=='notebookDetail') ? 'show' : ''}">
			<ul class="sub">
				<li ${springViewName=='notebook' ? 'class="sub_show"' : ''}><a href="notebook/">Zobrazit poznámky</a></li>
				<li><a href="#nogo">Nová poznámka</a></li>			 
			</ul>
		</div>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
		</ul>
		
		<c:if test="${user.authorities[0] == 'ROLE_ADMIN'}">
		<div class="nav-divider">&nbsp;</div>
		
		<ul ${springViewName=="users" or springViewName=="usersNew" or springViewName=="usersEdit" ? 'class="current"' : 'class="select"'}><li><a href="users/"><b>Uživatelé</b><!--[if IE 7]><!--></a><!--<![endif]-->
		<!--[if lte IE 6]><table><tr><td><![endif]-->
		<div class="select_sub ${springViewName=='users' or springViewName=='usersNew' or springViewName=='usersEdit'? 'show' : ''}">
			<ul class="sub">
				<li ${springViewName=='users' ? 'class="sub_show"' : ''}><a href="users/">Seznam uživatelů</a></li>
				<li ${springViewName=='usersNew' ? 'class="sub_show"' : ''}><a href="users/new">Nový uživatel</a></li>
			</ul>
		</div>
		<!--[if lte IE 6]></td></tr></table></a><![endif]-->
		</li>
		</ul>
		</c:if>
		
		<div class="clear"></div>
		</div>
		<div class="clear"></div>
		</div>
		<!--  start nav -->

</div>
<div class="clear"></div>
<!--  start nav-outer -->