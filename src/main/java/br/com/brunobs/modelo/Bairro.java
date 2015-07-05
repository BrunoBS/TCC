package br.com.brunobs.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Bairro {
	@XmlAttribute(name = "id")
	private static long id = 0;
	private String nome;

	public Bairro() {
		++Bairro.id;
	}

	public Bairro(String nome) {
		++Bairro.id;
		this.nome = nome;
	}

	public static long getId() {
		return id;
	}

	public static void setId(long id) {
		Bairro.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
