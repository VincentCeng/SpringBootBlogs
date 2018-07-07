package com.saas.admin.controller.informationController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.saas.admin.controller.BaseController;
import com.saas.admin.model.information.Information;
import com.saas.admin.service.information.InformationService;
import com.saas.common.json.JSONResult;
import com.saas.mybatis.plugins.BaseConditionVO;

/**
 * @author 刘曾
 * @version 2018年7月7日 下午10:14:12
 * 
 */
@Controller
public class InformationController extends BaseController {
	/**
	 * @author 刘曾
	 * @version 2018年7月7日 下午10:14:12
	 */
	@Autowired
	InformationService informationService;

	@RequestMapping("getAllInformation")
	@ResponseBody
	public JSONResult getAllInformation(BaseConditionVO vo) {
		List<Information> list = informationService.getInformationByPage(vo);
		return ajaxSuccess(list, vo);
	}

}
