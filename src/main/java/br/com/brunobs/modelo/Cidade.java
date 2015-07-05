package br.com.brunobs.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Cidade {

	@XmlAttribute(name = "id")
	private static long id = 0;

	private String nome;

	@XmlElementWrapper(name = "bairros")
	@XmlElement(name = "bairro")
	@OneToMany(fetch = FetchType.EAGER)
	private List<Bairro> bairros = new ArrayList<Bairro>();

	public static long getId() {
		return id;
	}

	public Cidade(String nome) {
		++Cidade.id;
		this.nome = nome;
	}

	public Cidade() {
		++Cidade.id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Bairro> getBairros() {
		return Collections.unmodifiableList(this.bairros);
	}

	public void addBairros(Bairro bairro) {
		this.bairros.add(bairro);
	}

}
