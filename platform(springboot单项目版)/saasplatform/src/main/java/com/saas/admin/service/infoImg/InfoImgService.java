package com.saas.admin.service.infoImg;

import java.util.List;

import com.saas.admin.model.inforImg.InforImg;

/**
 * 资讯图片业务接口 
* @author 刘曾 
* @version 2018年7月8日 上午1:31:24 
* 
*/

public interface InfoImgService {
	public final String name = "infoImgService.name";
	/** 
	 * @author 刘曾 
	 * @version 2018年7月8日 上午1:31:24 
	 */
	void put(List<InforImg> infolist,Integer id) throws Exception;
}
 