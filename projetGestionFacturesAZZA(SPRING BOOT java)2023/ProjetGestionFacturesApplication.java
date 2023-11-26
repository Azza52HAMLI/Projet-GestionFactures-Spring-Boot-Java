package org.azza.projetGestionFactures;

import java.time.LocalDate;
import java.util.Optional;

import org.azza.projetGestionFactures.logiqueMetier.ArticleService;
import org.azza.projetGestionFactures.logiqueMetier.ClientService;
import org.azza.projetGestionFactures.logiqueMetier.FactureService;
import org.azza.projetGestionFactures.persistance.ArticleRepository;
import org.azza.projetGestionFactures.persistance.Article;
import org.azza.projetGestionFactures.persistance.Client;
import org.azza.projetGestionFactures.persistance.Facture;
import org.azza.projetGestionFactures.persistance.FactureRepository;
import org.azza.projetGestionFactures.persistance.LigneFacture;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProjetGestionFacturesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ProjetGestionFacturesApplication.class, args);
		
		/*Création des clients et des articles*/
		Client c1=new Client("c1","Ahmed Tounsi","Tunis");
		Client c2=new Client("c2","Karim Sfaxi","Sfax");
		Article a1=new Article("a1","table",150.0);
		Article a2=new Article("a2","chaise",50.0);
		
		
		/*Ajout des clients et des articles à la BD*/
		ClientService clService=ctx.getBean(ClientService.class);
		clService.ajouterClient(c1);
		//clService.ajouterClient(c2);
		
		ArticleService arService=ctx.getBean(ArticleService.class);
		arService.ajouterArticle(a1);
		arService.ajouterArticle(a2);
		
		/*Supprimer un article via delete() de ArticleRepository */
		
		ArticleRepository a=ctx.getBean(ArticleRepository.class);
		a.delete(a1);
		
		/*créer une facture ayant deux lignes et l’enregistrer*/
		
		//1.créer une facture et ses lignes
		Facture f1=new Facture("f1",LocalDate.now(),c1);
		
	
		arService.ajouterArticle(a1);
		LigneFacture l1=new LigneFacture(a1,f1,20,120);
		LigneFacture l2=new LigneFacture(a2,f1,10,40);
		
		FactureService fSer=ctx.getBean(FactureService.class);
		fSer.ajouterLigneFacture(f1,l1);
		fSer.ajouterLigneFacture(f1,l2);
		//ou f1.getLignes().add(l1);
		
		
		//2.Enregistrer la facture 
		
		fSer.AjouterFacture(f1);//L'enregistrement de la facture prend en charge 
								//l'enregistrement des ses lignes
		
		/*Calculer le montant de la facture*/
		
		fSer.calculerMontantFacture(f1);
		
		System.out.println("La facture suivante vient d'être ajoutée: "+f1);
		
		/*Chercher la facture qui vient d’être enregistrée et afficher les informations de son client*/
		FactureRepository fRep=ctx.getBean(FactureRepository.class);
		Optional<Facture> f=fRep.findById("f1");
		if(f.isPresent()) 
			System.out.println("Le client de la facture \"f1\" est: \n"+f.get().getClt());
		
		/*Créer une autre facture*/
		
		Facture f2=new Facture("f2",LocalDate.now(),c2);
		
		LigneFacture l3=new LigneFacture(a1,f2,200,120);
		LigneFacture l4=new LigneFacture(a2,f2,100,20);
		
		fSer.ajouterLigneFacture(f2,l3);
		fSer.ajouterLigneFacture(f2,l4);
		
		fSer.AjouterFacture(f2);
		
		fSer.calculerMontantFacture(f2);
		
		System.out.println("La facture suivante vient d'être ajoutée: "+f2);
		
		
		
		/*Supprimer la facture f2*/
		
		fSer.supprimerFacture(f2);
		
		System.out.println("La facture suivante vient d'être supprimée: "+f2);
	}

}
