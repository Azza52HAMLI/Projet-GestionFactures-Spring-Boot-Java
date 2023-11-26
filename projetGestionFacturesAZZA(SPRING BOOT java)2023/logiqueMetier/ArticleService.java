package org.azza.projetGestionFactures.logiqueMetier;


import org.azza.projetGestionFactures.persistance.Article;
import org.azza.projetGestionFactures.persistance.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
	
	private ArticleRepository arRep;
	
	ArticleService(ArticleRepository arRep){
		this.arRep=arRep;
	}

	
	public Article ajouterArticle(Article a) {
		
		return arRep.save(a);
	
	}
}
