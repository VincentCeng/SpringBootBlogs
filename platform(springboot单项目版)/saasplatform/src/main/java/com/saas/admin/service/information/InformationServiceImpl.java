package com.saas.admin.service.information;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.saas.admin.mapper.informationMapper.InformationMapper;
import com.saas.admin.model.inforImg.InforImg;
import com.saas.admin.model.information.Information;
import com.saas.mybatis.plugins.BaseConditionVO;

/**
 * @author 刘曾
 * @version 2018年7月7日 下午10:07:37
 * 
 */
@Service(InformationService.name)
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class InformationServiceImpl implements InformationService {

	@Autowired
	InformationMapper informationMapper;

	/*
	 * 分页查询Information (non-Javadoc)
	 * 
	 * @see com.saas.admin.service.information.InformationService#
	 * getInformationByPage(com.saas.mybatis.plugins.BaseConditionVO)
	 */
	@Override
	public List<Information> getInformationByPage(BaseConditionVO vo) {
		/**
		 * @author 刘曾
		 * @version 2018年7月7日 下午10:07:37
		 */
		// 开始分页
		PageHelper.offsetPage(vo.getPage(), vo.getCount());
		// PageHelper.startPage(pageNum, pageSize, orderBy)
		Page<Information> value = informationMapper.findInformationByVo(vo);
		// 设置返回参数
		vo.setTotal(value.getTotal());
		vo.setTotalPage(value.getPages());
		return value;
	}

	/*
	 * 根据id删除
	 * (non-Javadoc)
	 * @see com.saas.admin.service.information.InformationService#deleteInformationById(java.lang.Integer)
	 */
	@Override
	public Integer deleteInformationById(Integer id) {
		/**
		 * @author 刘曾
		 * @version 2018年7月8日 上午12:50:05
		 */
		int i = informationMapper.deleteByPrimaryKey(id);
		return i;
	}

	@Override
	public Integer addInformation(Information information) {
		/** 
		 * @author 刘曾 
		 * @version 2018年7月8日 上午1:11:40 
		 */ 
		information.setState(0);
		information.setAttention(0);
		information.setUpdateTime(new Date());
		information.setCreateTime(new Date());
		informationMapper.insertSelective(information);
		return information.getId();
	}

	@Override
	public void putInformationAndImg(List<InforImg> infolist, Integer id) throws Exception {
		/** 
		 * @author 刘曾 
		 * @version 2018年7月8日 上午1:28:28 
		 */ 
		
	}
}
