package com.example.demo.controllers;

import com.example.demo.dtos.TopicDto;
import com.example.demo.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// Page Controller takes User object using thymeleaf and inserts information into HTML document
// replacing the need for a lot of Javascript

@Controller
public class PageController {

	@Autowired
	TopicService topicService;

	@GetMapping("/topicSelection")
	public String topicPage(Model model) {
		List<TopicDto> topicList = topicService.findAll();
		model.addAttribute("topicList", topicList);
		return "topic.html";
	}

}