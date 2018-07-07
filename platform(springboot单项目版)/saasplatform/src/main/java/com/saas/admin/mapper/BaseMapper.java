
package com.saas.admin.mapper;

import java.util.List;

/**
 * BaseMapper
 * @param <T>   model
 * @param <PK>  主键
 */
public interface BaseMapper<T, PK extends java.io.Serializable>
{

    int insert(T model);

    int delete(PK modelPK);

    T load(PK id);

    int update(T model);

    int updateSelective(T model);

    int countAll();

    List<T> findAll();

}
