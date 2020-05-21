package com.modestack.service;

import java.util.List;

import com.modestack.model.Article;

public interface ArticleService {

	public void saveArticle(Article article);

	public List<Article> getAllArticles();

}
