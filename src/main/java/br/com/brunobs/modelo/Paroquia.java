package br.com.brunobs.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.brunobs.interfaces.Entidade;

@SuppressWarnings("restriction")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Paroquia implements Entidade<Paroquia> {
	@XmlAttribute(name = "id")
	private static Long id = 0l;
	@Column
	private String nome;

	@XmlElementWrapper(name = "grupos")
	@XmlElement(name = "grupo")
	@OneToMany(mappedBy = "paroquia", fetch = FetchType.EAGER)
	private List<Grupo> grupos = new ArrayList<Grupo>();

	@XmlElement(name = "cidade")
	private Cidade cidade;

	public Paroquia(String nome, Cidade cidade) {
		++Paroquia.id;
		this.nome = nome;
		this.cidade = cidade;
	}

	public Paroquia() {
		++Paroquia.id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public static Long getId() {
		return id;
	}

	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void addGrupo(Grupo grupo) {
		this.grupos.add(grupo);
	}

}
