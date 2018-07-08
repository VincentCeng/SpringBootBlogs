package com.saas.admin.service.infoImg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saas.admin.mapper.inforImgMapper.InforImgMapper;
import com.saas.admin.model.inforImg.InforImg;

/**
 * @author 刘曾
 * @version 2018年7月8日 上午1:33:42
 * 
 */
@Service(InfoImgService.name)
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class InfoImgServiceImpl implements InfoImgService {

	@Autowired
	InforImgMapper inforImgMapper;

	/*
	 * 增加资讯图片 (non-Javadoc)
	 * 
	 * @see com.saas.admin.service.infoImg.InfoImgService#put(java.util.List,
	 * java.lang.Integer)
	 */
	@Override
	public void put(List<InforImg> infolist, Integer id) throws Exception {
		/**
		 * @author 刘曾
		 * @version 2018年7月8日 上午1:33:42
		 */
		for (InforImg inforImg : infolist) {
			inforImg.setInfoId(id);
			inforImgMapper.insertSelective(inforImg);
		}
	}

}
