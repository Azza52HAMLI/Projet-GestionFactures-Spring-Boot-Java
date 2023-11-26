package org.azza.projetGestionFactures.persistance;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique=true,nullable=false)

	private String code;
	@Column(nullable=false,length = 60)
	private String nom;
	private String adresse;
	
	public Client(String code,String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.code=code;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public Long getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(code);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(code, other.code);
	}
	@Override
	public String toString() {
		return "Client [code=" + code + ", nom=" + nom + ", adresse=" + adresse + "]";
	}
	
	
	
	

}
