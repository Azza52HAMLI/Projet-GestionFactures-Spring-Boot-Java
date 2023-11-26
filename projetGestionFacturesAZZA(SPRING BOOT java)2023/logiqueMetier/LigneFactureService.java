package org.azza.projetGestionFactures.logiqueMetier;


import org.azza.projetGestionFactures.persistance.LigneFacture;
import org.azza.projetGestionFactures.persistance.LigneFactureRepository;
import org.springframework.stereotype.Service;

@Service
public class LigneFactureService {
	
	private LigneFactureRepository ligneRep;
	
	public LigneFactureService(LigneFactureRepository ligneRep) {
		this.ligneRep=ligneRep;
	}
	
	
	public void calculerTotalLigneFacture(LigneFacture l) {
		l.setTotalLigne(l.getQte()*l.getPrixUnitaire());
	}

}
