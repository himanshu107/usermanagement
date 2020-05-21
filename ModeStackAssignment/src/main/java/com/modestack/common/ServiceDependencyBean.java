package com.modestack.common;

import org.springframework.beans.factory.annotation.Autowired;

import com.modestack.service.ArticleService;
import com.modestack.service.UserService;

public class ServiceDependencyBean {

 protected @Autowired UserService userService;
 
 protected @Autowired ArticleService articleService;
 
}
