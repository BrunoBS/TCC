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
public class Grupo {

	@XmlAttribute(name = "id")
	private static long id = 0;

	private String nome;

	@XmlElementWrapper(name = "encontristas")
	@XmlElement(name = "encontrista")
	@OneToMany(mappedBy = "grupo", fetch = FetchType.EAGER)
	private List<Encontrista> encontristas = new ArrayList<Encontrista>();

	public Grupo(String nome) {
		++Grupo.id;
		this.nome = nome;
	}

	public Grupo() {
		++Grupo.id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static long getId() {
		return id;
	}

	public List<Encontrista> getEncontristas() {
		return Collections.unmodifiableList(this.encontristas);
	}

	public void addEncontrista(Encontrista encontrista) {
		this.encontristas.add(encontrista);
	}

}
