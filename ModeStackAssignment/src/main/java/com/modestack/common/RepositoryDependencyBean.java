package com.modestack.common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;

import com.modestack.repository.ArticleRepository;
import com.modestack.repository.UserRepository;

@Controller
public class RepositoryDependencyBean {

	@Autowired protected UserRepository userRepository;
	
	@Autowired  protected MongoTemplate mongoTemplate;
	
	@Autowired protected ArticleRepository articleRepository;
	
}
