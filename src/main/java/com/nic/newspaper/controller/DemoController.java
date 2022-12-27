package com.nic.newspaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nic.newspaper.entity.Article;
import com.nic.newspaper.entity.Comment;
import com.nic.newspaper.service.ArticleService;
import com.nic.newspaper.service.CommentService;

@Controller
public class DemoController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	// add request mapping for /leaders

	@GetMapping("/leaders")
	public String showLeaders() {
		
		return "leaders";
	}
	
	// add request mapping for /systems
	
	@GetMapping("/systems")
	public String showSystems() {
		
		return "systems";
	}
	
	@GetMapping("/articles")
	public String showArticles(Model theModel) {
		
		List<Article> theArticles = articleService.getArticles();
		List<Comment> theComments = commentService.getCommnets();
		
		theModel.addAttribute("articles", theArticles);
		theModel.addAttribute("comments", theComments);
		
		return "main";
	}
	
}










