package org.azza.projetGestionFactures.persistance;

import java.time.LocalDate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Facture {
	@Id
	private String numero;
	private LocalDate dateCreation;
	@Transient
	private double montant;
	
	@ManyToOne ( cascade = {CascadeType.PERSIST, CascadeType.MERGE}) 
	private Client clt;
	
	
	
	@Transient
	private Set<LigneFacture> lignes= new HashSet<LigneFacture>();
	
	

	

	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
//Ce n'est pas la peine d'inclure montant dans le constructeur car il est transient
	public Facture(String numero, LocalDate dateCreation,  Client clt) {
		super();
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.clt = clt;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getMontant() {
		
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Client getClt() {
		return clt;
	}

	public void setClt(Client clt) {
		this.clt = clt;
	}
	
	
	

	public Set<LigneFacture> getLignes() {
		return lignes;
	}
	
	

	public void setLignes(Set<LigneFacture> lignes) {
		this.lignes = lignes;
	}
	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facture other = (Facture) obj;
		return Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "Facture [numero=" + numero + ", dateCreation=" + dateCreation + ", montant=" + montant + ", clt=" + clt
				+ "]";
	}
	
	

}
