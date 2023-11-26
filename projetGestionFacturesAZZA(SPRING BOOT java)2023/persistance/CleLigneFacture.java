package org.azza.projetGestionFactures.persistance;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class CleLigneFacture {
	private Long articleId;
	private String factureId;
	
	

	
	
public CleLigneFacture() {
		super();
		// TODO Auto-generated constructor stub
	}



public CleLigneFacture(Long articleId, String factureId) {
		super();
		this.articleId = articleId;
		this.factureId = factureId;
	}



public Long getArticleId() {
	return articleId;
}

public void setArticleId(Long articleId) {
	this.articleId = articleId;
}

public String getFactureId() {
	return factureId;
}

public void setFactureId(String factureId) {
	this.factureId = factureId;
}



@Override
public int hashCode() {
	return Objects.hash(articleId, factureId);
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CleLigneFacture other = (CleLigneFacture) obj;
	return Objects.equals(articleId, other.articleId) && Objects.equals(factureId, other.factureId);
}



}

