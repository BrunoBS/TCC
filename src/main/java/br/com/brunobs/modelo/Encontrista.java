package br.com.brunobs.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Encontrista {
	private static long id = 0;
	private String nome;
	private String email;

	public Encontrista(String nome, String email) {
		++Encontrista.id;
		this.nome = nome;
		this.email = email;
	}

	public Encontrista() {
		++Encontrista.id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getId() {
		return id;
	}

}
