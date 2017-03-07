package com.spring.mapper;

import com.spring.common.IBaseMapper;
import com.spring.model.Message;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageMapper extends IBaseMapper<Message, Integer>{
    public List<Message> list();
}
