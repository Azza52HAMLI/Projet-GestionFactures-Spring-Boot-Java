package org.azza.projetGestionFactures.persistance;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, String> {
	
	/*Renvoyer toutes les factures d’un client entre deux dates*/
	
	Set<Facture> findByCltCodeAndDateCreationBetween(String nom, LocalDate d1,LocalDate d2);
	
	


}
