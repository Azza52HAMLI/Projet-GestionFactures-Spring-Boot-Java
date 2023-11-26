package org.azza.projetGestionFactures.logiqueMetier;

import java.time.LocalDate;
import java.util.Set;

import org.azza.projetGestionFactures.persistance.Client;
import org.azza.projetGestionFactures.persistance.ClientRepository;
import org.azza.projetGestionFactures.persistance.Facture;
import org.azza.projetGestionFactures.persistance.FactureRepository;
import org.azza.projetGestionFactures.persistance.LigneFacture;
import org.azza.projetGestionFactures.persistance.LigneFactureRepository;
import org.azza.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class FactureService {
	
	private FactureRepository facRep;
	
	
	@Autowired
	private LigneFactureRepository ligneRep;
	
	@Autowired
	private LigneFactureService ligneSer;

	public FactureService(FactureRepository facRep) {
		super();
		this.facRep = facRep;
	}
	
	
	/*une méthode qui supprime une facture et ses lignes*/
	@Transactional
	public void supprimerFacture(Facture f) {
		//1. Supprimer les lignes de la facture
		
		Set<LigneFacture> lignesF=f.getLignes() ;
		for(LigneFacture l:lignesF)
			ligneRep.delete(l);
		
		//ou remplacer la boucle for par: ligneRep.deleteAll(lignesF);
		
		//2.Supprimer la facture
		
		facRep.delete(f);	
	}
	
	
	
	
	
	
	@Transactional
	public Facture AjouterFacture(Facture f) {
	
		//1.Enregistrer la facture
		Facture fSaved=facRep.save(f);
		
		//2.Enregistrer les lignes de la facture 
		
		Set<LigneFacture> lignesF=f.getLignes() ;
		
		for(LigneFacture l:lignesF)
		
		ligneRep.save(l);
		
		//ou remplacer la boucle for par:ligneRep.saveAll(lignesF);
		
		return fSaved;
		
	}
	
	
	
	public void ajouterLigneFacture(Facture f,LigneFacture l) {
		//1.vérifier que la ligne correspond bien à la facture
		
		if(!l.getFacture().equals(f))
			System.out.println("Erreur ajout ligne facture: la ligne ne correspond pas "
					+ "à la facture!!!");
		else
			f.getLignes().add(l);
		
		
	}
	/*Renvoyer toutes les factures d’un client entre deux dates, ainsi que leurs lignes*/
	
	public Set<Facture> trouverParClientEtDates(Client c, LocalDate d1, LocalDate d2) {
		
		//1.Obtenir toutes les factures d’un client entre deux dates
		
		Set<Facture> lesFactures=facRep.findByCltCodeAndDateCreationBetween(c.getCode(), d1,d2);
		
		//2.Parcourir l'ensemble des factures et obtenir leurs lignes
		for(Facture f:lesFactures) {
			Set<LigneFacture> lignes=ligneRep.findByfactureNumero(f.getNumero());
			f.setLignes(lignes);
		}
		//3.Renvoyer les factures
			return lesFactures;
		
	}
	
	
	public double calculerMontantFacture(Facture f) {
		
		Set<LigneFacture> lignesF=f.getLignes() ;
		double montantF=0;
		
		for(LigneFacture l:lignesF) {
			ligneSer.calculerTotalLigneFacture(l);
			montantF+=l.getTotalLigne();
		}
		f.setMontant(montantF);
		return montantF;
		
		
	}

}