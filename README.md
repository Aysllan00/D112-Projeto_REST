# D112-Projeto_REST

<b>Alunos: </b>
       <br>
       <br>
       - Ayslan Conti Serafini Costa
       <br>
       - Mateus Borges Rodrigues
<hr>
<h2>Web Service de entregador e seus pedidos</h2>

<h3>Rotas</h3>

http://localhost:9090/PedidoDM112/api/orders - Busca todos os pedidos 
<br>
http://localhost:9090/PedidoDM112/api/orders/{orderCode} - Busca um pedido
<br> 
http://localhost:8080/DeliveryDM112/api/confirmDelivery/{associatedDeliveryPerson}/{orderCode} - Confirma a entrega do pedido
<br>
http://localhost:8080/DeliveryDM112/api/listOrders/{associatedDeliveryPerson} - Lista pedidos do respectivo entregador
<br>
http://localhost:7070/UtilityDM112/api/mail - Envio de e-mail
<br>

<h4> Exemplo confirmação entrega </h4>

http://localhost:8080/DeliveryDM112/api/confirmDelivery/Entregador4/4

<b>OBS:</b> Para funcionamento correto do envio de e-mail, ative a autenticação em duas etapas para o email remetente.
<br>
Acesse o link https://myaccount.google.com/apppasswords e configure uma senha de aplicativo.
<br>
As informações de email devem ser alteradas na classe EmailClient (DeliveryDM112).
 