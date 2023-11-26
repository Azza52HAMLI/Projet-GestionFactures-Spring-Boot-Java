package org.azza.projetGestionFactures.logiqueMetier;

import java.time.LocalDate;
import java.util.Set;

import org.azza.projetGestionFactures.persistance.Client;
import org.azza.projetGestionFactures.persistance.ClientRepository;
import org.azza.projetGestionFactures.persistance.Facture;
import org.azza.beans.factory.annotation.Autowired;
import org.azza.stereotype.Service;

@Service
public class ClientService {
	
private ClientRepository clRep;

@Autowired
FactureService facServ;

	
	ClientService(ClientRepository clRep){
		this.clRep=clRep;
	}
	
	public Client ajouterClient(Client c) {
		return clRep.save(c);
	}

	public boolean existe(Client c) {
		if (c.getId()==null) return false;
		return clRep.existsById(c.getId());//ou return true directement???
	}
	
	/*Calculer le chiffre d’affaires d’un client c dans une année a*/
	
	public double getChiffreAffairesClient(Client c, int a) {
		//1.Obtenir les factures du client dans l'année a
		
		 LocalDate dateDebut = LocalDate.of(a, 1, 1);  
		 LocalDate dateFin = LocalDate.of(a, 12, 31); 
		 
		 Set<Facture> facturesClt=facServ.trouverParClientEtDates(c, dateDebut, dateFin);
		 
		 //2.Sommer les montants des factures
		 double chiffreAffaire=0;
		 double montantF;
		 for(Facture f:facturesClt) {
			 montantF=f.getMontant();
			 if(montantF==0)
			 montantF=facServ.calculerMontantFacture(f);
			 
			 chiffreAffaire+=montantF;
		 }
		 
		 //3.Retourner le chiffre d'affaires
		 return chiffreAffaire;
		
	}

}
 