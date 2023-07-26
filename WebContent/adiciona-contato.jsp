<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<html>
<head>
    <link href="css/jquery.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/estilo_add.css">
    <script src="js/jquery.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <title>Adiciona contato</title>
</head>
<body class="container">
<c:import url="cabecalho.jsp"/>
<h1>Adiciona contatos</h1>
<form action="adicionaContato">
    Nome: <input type="text" name="nome" /><br />
    E-mail: <input type="text" name="email" /><br />
    Endereço: <input type="text" name="endereco" /><br />
    Data Nascimento: <caelum:campoData id="dataNascimento" /><br />

    <input type="submit" value="Gravar" />
</form>
<c:import url="rodape.jsp"/>
</body>
</html>
