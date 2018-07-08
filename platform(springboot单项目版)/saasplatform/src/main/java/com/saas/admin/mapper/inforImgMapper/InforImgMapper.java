package com.saas.admin.mapper.inforImgMapper;

import com.saas.admin.model.inforImg.InforImg;

public interface InforImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InforImg record);

    int insertSelective(InforImg record);

    InforImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InforImg record);

    int updateByPrimaryKeyWithBLOBs(InforImg record);

    int updateByPrimaryKey(InforImg record);
}