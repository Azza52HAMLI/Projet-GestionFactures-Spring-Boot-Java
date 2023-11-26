package org.azza.projetGestionFactures.persistance;



import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Article {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true,nullable=false)
	private String code;
	@Column(nullable=false,length = 150)
	private String nom;
	private Double prixUnitaire;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(String code, String nom, double prixUnitaire) {
		super();
		this.code = code;
		this.nom = nom;
		this.prixUnitaire = prixUnitaire;
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
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
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
		Article other = (Article) obj;
		return Objects.equals(code, other.code);
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", code=" + code + ", nom=" + nom + ", prixUnitaire=" + prixUnitaire + "]";
	}
	
	

}
