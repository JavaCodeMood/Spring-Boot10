package com.spring.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.spring.model.Message;
import com.spring.service.MessageService;

@Controller
public class MessageController {
	@Resource
    private MessageService messageService;
	
	@RequestMapping("/message/{currentPage}")
	public String message(@PathVariable("currentPage") Integer currentPage,Model model){
		if(currentPage != null){
			//每页显示2条数据
			PageHelper.startPage(currentPage,2);
		}
		//将数据存入list集合中
		List<Message> messages = messageService.list();
		//将参数传给页面
		model.addAttribute("messages",messages);
		return "message";
	}

}
