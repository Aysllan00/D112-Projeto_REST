<!DOCTYPE html>
<html>
	<head>
		<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<title>Utility services</title>
			<style>
				body{
					padding: 5px;
				}
				h2 {
					color: limegreen;
				}
			</style>
	</head>
	<body>
		<h2>index.jsp ok!</h2>
		<br/>
		<h1>Serviços disponíveis:</h1>
		<br>
		<h3>Envio de email</h3>
		POST:
		<br/>
		URL: http://localhost:7070/UtilityDM112/api/mail
		<br/>
		<br/>
		<b>JSON Body:</b>
		<br/>
		<code>
			{
			<br/>
			"from": "from_addr@email.com",
			<br/>
			"password": "email_password",
			<br/>
			"to": "your_email@email.com",
			<br/>
			"body": "Detalhes do pedido"
			<br/>
			}
		</code>
		<br>

		<p><b>OBS:</b> Para funcionamento correto, ative a autenticação em duas etapas para o email remetente.<br>
			Acesse o link https://myaccount.google.com/apppasswords e configure uma senha de aplicativo.<br> Essa senha é
			a que deve ser utilizada no POST.
		</p>
	</body>
</html>
