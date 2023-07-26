
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib tagdir="/WEB-INF/tags" prefix="dt" %>

<html>
	<head>
		<title>Altera</title>	
		<link rel="stylesheet" href="css/estilo_altera.css">			
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>		
		<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
			<h1>Altera contatos</h1>
		<form action="mvc?logica=AlteraContatoLogica" method="post" >
			<input id="id" name="id" type="hidden" value="${contato.id}" />
		
			<strong>Nome: </strong>
			<input id="nome" name="nome" type="text" value="${contato.nome}" /><br/>
			
			<strong>Email: </strong>
			<input id="email" name="email" type="text" value="${contato.email}" /><br/>
			
			<strong>Endereço: </strong>
			<input id="endereco" name="endereco" type="text" value="${contato.endereco}" /><br/>
			
			<c:set var="dataNascimento">
				<fmt:formatDate value="${contato.dataNascimento}" pattern="dd/MM/yyyy"/>
			</c:set>
			<strong>Data de Nascimento: </strong>			
			<dt:campoData id="dataNascimento" value="${dataNascimento}" /><br/>
			
			<input type="submit" value="Altera Contato" />
		</form>
		<c:import url="rodape.jsp"/>
	</body>
</html>
