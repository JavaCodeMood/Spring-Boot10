package com.spring.service;

import java.util.List;

import com.spring.common.IBaseService;
import com.spring.model.Message;

public interface MessageService extends IBaseService<Message, Integer>{
	public static final String SERVICE_NAME = "IMessageService";
	public List<Message> list();

}
