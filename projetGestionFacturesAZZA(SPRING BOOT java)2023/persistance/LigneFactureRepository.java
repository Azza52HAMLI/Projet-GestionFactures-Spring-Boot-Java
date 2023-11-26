package org.azza.projetGestionFactures.persistance;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneFactureRepository extends JpaRepository<LigneFacture, CleLigneFacture> {
	
	/*Retrouver les lignes d’une facture*/

	
	
	Set<LigneFacture>findByfactureNumero(String numFacture);

}
