package com.saas.admin.controller.informationController;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSONArray;
import com.saas.admin.controller.BaseController;
import com.saas.admin.model.inforImg.InforImg;
import com.saas.admin.model.information.Information;
import com.saas.admin.param.Constants;
import com.saas.admin.service.infoImg.InfoImgService;
import com.saas.admin.service.information.InformationService;
import com.saas.common.json.JSONResult;
import com.saas.mybatis.plugins.BaseConditionVO;

/**
 * @author 刘曾
 * @version 2018年7月7日 下午10:14:12
 * 
 */
@Controller
//@RequestMapping(value="api/free")
public class InformationController extends BaseController {
	Logger log = LoggerFactory.getLogger("InformationController");
	/**
	 * @author 刘曾
	 * @version 2018年7月7日 下午10:14:12
	 */
	@Autowired
	InformationService informationService;

	@Autowired
	InfoImgService infoImgService;

	/*
	 * 后台分页查询
	 */
	@RequestMapping(value = "getAllInformation", method = RequestMethod.GET)
	@ResponseBody
	public JSONResult getAllInformation(BaseConditionVO vo) {
		List<Information> list = informationService.getInformationByPage(vo);
		return ajaxSuccess(list, vo);
	}

	/*
	 * 通过id删除
	 */
	@RequestMapping("deleteInformationById")
	@ResponseBody
	public JSONResult deleteInformationById(Integer id) {
		try {
			informationService.deleteInformationById(id);
		} catch (Exception e) {
			ajaxFail("删除操作失败");
			log.error("资讯删除失败原因======>>", e.getMessage());
		}
		return ajaxSuccess("删除操作成功!");
	}

	/*
	 * 后台增加资讯
	 */
	@RequestMapping(value = "addInformation", method = RequestMethod.POST)
	@ResponseBody
	public JSONResult addInformation(String jsonStr, Information information, HttpServletRequest request,
			Integer[] channelIds) {
		JSONArray jsonArray = JSONArray.parseArray(jsonStr);
		List<InforImg> infoImgs = new ArrayList<>();
		try {
			information.setSort(1000.00);
			Integer id = informationService.addInformation(information);
			if (channelIds != null) {
				informationService.addInformation(information);
			}
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			if (multipartResolver.isMultipart(request)) {
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				Iterator<String> iter = multiRequest.getFileNames();
				int i = 0;
				while (iter.hasNext()) {
					MultipartFile file = multiRequest.getFile(iter.next().toString());
					if (file != null) {
						String fileName = UUID.randomUUID().toString() + file.getOriginalFilename().substring(
								file.getOriginalFilename().lastIndexOf("."), file.getOriginalFilename().length());
						String path = System.getProperty(Constants.Path.INFORMATION_PUT) + fileName;
						// 文件开始上传
						file.transferTo(new File(path));
						InforImg infoImg = jsonArray.getObject(i++, InforImg.class);
						infoImg.setImg(fileName);
						infoImgs.add(infoImg);
						// return fileName;
					}
				}
			}
			if (infoImgs.size() > 0) {
				infoImgService.put(infoImgs, id);
				return ajaxSuccess("操作成功");
			}
			return ajaxSuccess("操作成功");
		} catch (Exception e) {
			return ajaxFail(e.getMessage());
		}
	}

}
