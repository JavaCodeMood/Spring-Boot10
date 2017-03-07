package com.spring.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mapper.MessageMapper;
import com.spring.model.Message;
import com.spring.service.MessageService;

@Service("IMessageService")
@Transactional(rollbackFor={Exception.class})
public class MessageServiceImpl implements MessageService{
	@Resource
	private MessageMapper messageMapper;

	@Override
	public int insert(Message message) {
		
		return messageMapper.insert(message);
	}

	@Override
	public int update(Message message) {
		
		return messageMapper.update(message);
	}

	@Override
	public int delete(Integer id) {
		
		return messageMapper.delete(id);
	}

	@Override
	public Message queryById(Integer id) {
		
		return messageMapper.queryById(id);
	}

	@Override
	public List<Message> list() {
		
		return messageMapper.list();
	}

}
