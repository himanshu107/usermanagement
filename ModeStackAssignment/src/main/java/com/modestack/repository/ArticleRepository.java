package com.modestack.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.modestack.model.Article;

public interface ArticleRepository  extends MongoRepository<Article, ObjectId> {

}
