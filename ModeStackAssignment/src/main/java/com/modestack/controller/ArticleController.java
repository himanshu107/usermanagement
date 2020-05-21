package com.modestack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.modestack.common.ServiceDependencyBean;
import com.modestack.model.Article;

@Controller
public class ArticleController extends ServiceDependencyBean {

	@RequestMapping(value="/saveArticles" ,method= {RequestMethod.GET,RequestMethod.POST},consumes= {"application/json"} )
	@ResponseBody public String saveArticles(@RequestBody Article article) {
		System.out.println("article save"+article.toString());
		
	    articleService.saveArticle(article);
		return "new article created";
	}	
	
	@RequestMapping(value="/getAllArticles" ,method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody public List<Article> getAllArticles() {
		List<Article> addAllArticles = new ArrayList<Article>();
		List<Article> allArticle =articleService.getAllArticles();
		if(allArticle != null) {
			for(Article article:allArticle) {
				article.setDumId(article.getId().toString());
				addAllArticles.add(article);
			}
		}
		return addAllArticles;
	}
	
}
