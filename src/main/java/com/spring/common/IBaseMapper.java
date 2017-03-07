package com.spring.common;


public interface IBaseMapper<Entity, T> {
    public int insert(Entity entity);

    public int update(Entity entity);

    public int delete(Integer id);

    public Entity queryById(T t);
}
