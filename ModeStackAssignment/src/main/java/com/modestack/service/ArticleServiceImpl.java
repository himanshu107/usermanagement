package com.modestack.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.modestack.common.RepositoryDependencyBean;
import com.modestack.model.Article;


@Service
public class ArticleServiceImpl extends RepositoryDependencyBean implements ArticleService {

	@Override
	public void saveArticle(Article article) {
		articleRepository.save(article);
	}

	@Override
	public List<Article> getAllArticles() {
		List<Article> allArticle =articleRepository.findAll();
		return allArticle;
	}

	
}
