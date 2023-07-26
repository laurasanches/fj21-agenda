<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<head>
		<title>Lista de Contatos</title>
		<link rel="stylesheet" type="text/css" href="css/estilo_lista.css">
	</head>
	<body class="container">
		<c:import url="cabecalho.jsp"/>
		<h1>Lista de Contatos</h1>
		<a href="mvc?logica=AdicionaContatoLogica" class="add-contact-btn">+Novo Contato</a>
		<table border="1">	
			<thead>
				<tr>
					<td><strong>ID</strong></td>
					<td><strong>Nome</strong></td>
					<td><strong>Email</strong></td>
					<td><strong>Endereço</strong></td>
					<td><strong>Data de Nascimento</strong></td>
				</tr>
			</thead>
			<tbody> 
				<c:forEach var="contato" items="${contatos}" varStatus="id">
					<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
						<td>
							${id.count}
						</td>
						<td>
							${contato.nome}
						</td>
						<td>
							<c:choose>
								<c:when test="${not empty contato.email}">
									<a href="mailto:${contato.email}">${contato.email}</a>
								</c:when>
								<c:otherwise>
									<i>Email não informado</i>
								</c:otherwise>
							</c:choose>							
						</td>
						<td>
							<c:choose>
								<c:when test="${not empty contato.endereco}">
									${contato.endereco}
								</c:when>
								<c:otherwise>
									<i>Endereço não informado</i>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${not empty contato.dataNascimento}">
									<fmt:formatDate value="${contato.dataNascimento}" pattern="dd/MM/yyyy"/>
								</c:when>
								<c:otherwise>
									<i>Sem data</i>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<a href="mvc?logica=MostraContatoLogica&id=${contato.id}">Alterar</a>
							<a href="mvc?logica=RemoveContatoLogica&id=${contato.id}">Remover</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a class="add-contact-btn" href="gerar-relatorio" target="_blank">Imprimir PDF</a>
		
		<c:import url="rodape.jsp"/>
	</body>
</html>