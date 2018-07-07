package com.saas.admin.service.information;

import java.util.List;

import com.saas.admin.model.inforImg.InforImg;
import com.saas.admin.model.information.Information;
import com.saas.mybatis.plugins.BaseConditionVO;

/** 
 * Information业务方法类
* @author 刘曾 
* @version 2018年7月7日 下午10:04:40 
* 
*/
public interface InformationService {
	
	public final String name = "informationService";
	/** 
	 * 分页查询
	 * @author 刘曾 
	 * @version 2018年7月7日 下午10:04:40 
	 */
	List<Information> getInformationByPage(BaseConditionVO vo);
	
	/*
	 * 删除
	 */
	Integer deleteInformationById(Integer id);
	
	/*
	 * 增加
	 */
	Integer addInformation(Information information);
	/*
	 * 增加图片
	 */
	void putInformationAndImg(List<InforImg> infolist,Integer id) throws Exception;
}
 