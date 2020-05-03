<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar">
	<ul class="navbar-nav">

		<li class="logo">
			<a href="MainPage.jsp" class="nav-link"> 
				<span class="link-text logo-text">Vaalikone</span> 
				<img src="content/republican-solid.svg">
			</a>
		</li>

		<li class="nav-item">
			<a href="AddPage.jsp" class="nav-link">
				<img src="content/user-plus-solid.svg"> 
				<span class="link-text">Lisää ehdokas</span>
			</a>
		</li>

		<li class="nav-item">
			<a href="ModifyPage.jsp" class="nav-link">
				<img src="content/user-edit-solid.svg"> 
				<span class="link-text">Muokkaa / Poista</span>
			</a>
		</li>

		<li class="nav-item">
			<a href="#" class="nav-link"> 
				<img src="content/file-alt-solid.svg">
				<span class="link-text">Kysymykset</span>
			</a>
		</li>

		<li class="nav-item">
			<a href="/kirjauduUlos" class="nav-link logout"> 
				<img src="content/sign-out-alt-solid.svg"> 
				<span class="link-text">Kirjaudu ulos</span>
			</a>
		</li>

	</ul>
</nav>