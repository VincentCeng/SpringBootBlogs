package com.saas.admin.service.information;

import java.util.List;

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
}
 