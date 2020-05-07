<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar">
	<ul class="navbar-nav">

		<li class="logo">
			<a href="MainPage.jsp" class="nav-link"> 
				<span class="link-text logo-text">Vaalikone</span>
				<i class="fas fa-republican"></i>
			</a>
		</li>

		<li class="nav-item">
			<a href="AddPage.jsp" class="nav-link">
				<i class="fas fa-user-plus"></i>
				<span class="link-text">Lisää ehdokas</span>
			</a>
		</li>

		<li class="nav-item">
			<a href="ModifyPage.jsp" class="nav-link">
				<i class="fas fa-user-edit"></i>
				<span class="link-text">Muokkaa / Poista</span>
			</a>
		</li>

		<li class="nav-item">
			<a href="AddQuestionPage.jsp" class="nav-link">
				<i class="fas fa-file-alt"></i>
				<span class="link-text">Kysymykset</span>
			</a>
		</li>

		<li class="nav-item">
			<a href="/kirjauduUlos" class="nav-link logout">
				<i class="fas fa-sign-out-alt"></i>
				<span class="link-text">Kirjaudu ulos</span>
			</a>
		</li>

	</ul>
</nav>