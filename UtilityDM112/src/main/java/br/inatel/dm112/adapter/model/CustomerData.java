package br.inatel.dm112.adapter.model;

public class CustomerData {

	private String UF;
	private String Cidade;
	private String Cep;
	private String Bairro;
	private String Logradouro;
	private String Numero;
	private String Complemento;

	private String email = "customer_email@gmail.com";

	public CustomerData(String cpf) {
		this.setUF("MG");
		this.setCidade("Santa Rita do Sapucaí");
		this.setCep("37545-000");
		this.setBairro("Inatel");
		this.setLogradouro("Av. João de Camargo");
		this.setNumero("510");
		this.setComplemento("Ap. 2");
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getCep() {
		return Cep;
	}

	public void setCep(String cep) {
		Cep = cep;
	}

	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	public String getComplemento() {
		return Complemento;
	}

	public void setComplemento(String complemento) {
		Complemento = complemento;
	}

}

