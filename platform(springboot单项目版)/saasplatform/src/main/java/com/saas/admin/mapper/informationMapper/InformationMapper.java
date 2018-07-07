package com.saas.admin.mapper.informationMapper;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.saas.admin.model.information.Information;
import com.saas.mybatis.plugins.BaseConditionVO;

public interface InformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKeyWithBLOBs(Information record);

    int updateByPrimaryKey(Information record);
    
    Page<Information> findInformationByVo(@Param("vo")BaseConditionVO vo);
}