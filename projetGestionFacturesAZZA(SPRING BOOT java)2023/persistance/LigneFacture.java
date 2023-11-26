package org.azza.projetGestionFactures.persistance;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Transient;

@Entity
public class LigneFacture {
	@EmbeddedId
	private CleLigneFacture id;
	@ManyToOne
	@MapsId("articleId")
	private Article article;
	@ManyToOne
	@MapsId("factureId")
	private Facture facture;
	
	
	private int qte;
	//On ne peut pas le modifier, une fois inséré dans la table, on ne peut jamais le modifier
	@Column(updatable=false)
	double prixUnitaire;
	
	@Transient
	double totalLigne;
	
	//Constructeur sans paramètres
	public LigneFacture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Constructeur avec paramètres
	public LigneFacture( Article article, Facture facture, int qte, double prixUnitaire) {
		super();
		this.id = new CleLigneFacture(article.getId(),facture.getNumero()) ;
		this.article = article;
		this.facture = facture;
		this.qte = qte;
		this.prixUnitaire = prixUnitaire;
		
	}
	
	//Getters and Setters
	public CleLigneFacture getId() {
		return id;
	}
	public void setId(CleLigneFacture id) {
		this.id = id;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public double getTotalLigne() {
		
		return totalLigne;
	}
	
	
	
	
	
	public void setTotalLigne(double totalLigne) {
		this.totalLigne = totalLigne;
	}

	//equals and hashCode
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneFacture other = (LigneFacture) obj;
		return Objects.equals(id, other.id);
	}
	
	//toString
	@Override
	public String toString() {
		return "LigneFacture [id=" + id + ", article=" + article + ", facture=" + facture + ", qte=" + qte
				+ ", prixUnitaire=" + prixUnitaire + ", totalLigne=" + totalLigne + "]";
	}
	
	
	

}
