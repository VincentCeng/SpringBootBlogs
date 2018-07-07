package com.saas.admin.controller.error;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.saas.common.exception.ServiceException;
import com.saas.common.json.JSONResult;
import com.saas.common.param.ErrorCode;

/**
 * 自定义异常处理
 * @ClassName: CustomExceptionHandler 
 * @Description: (这里用一句话描述这个类的作用) 
 * @author Orchid
 * @date 2018年6月22日 下午5:05:36 
 *
 */
@ControllerAdvice  
public class CustomExceptionHandler {  
	Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);  
	
	/**
	 * runtime异常处理
	 * @Title: jsonExceptionHandler 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @date 2018年6月26日 下午3:47:07
	 * @param req
	 * @param e
	 * @return JSONResult    返回类型 
	 */
    @ExceptionHandler(value = ServiceException.class)  
    @ResponseBody  
    public JSONResult jsonExceptionHandler(HttpServletRequest req, Exception e) {  
    	JSONResult ecologyResp = new JSONResult();
        ecologyResp.setCode(ErrorCode.ERROT_FOR_ALL);
        ecologyResp.setMsg(e.getMessage());
        return ecologyResp;  
    }
    
    /**
     * shiro未授权异常拦截
     * @Title: handleException 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @date 2018年6月26日 下午3:48:10
     * @param e
     * @return String    返回类型 
     */
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(UnauthorizedException.class)
    public String handleException(UnauthorizedException e) {
        return "403";
    }

    /**
     * shiro无权限异常拦截
     * @Title: handleException 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @date 2018年6月26日 下午3:48:10
     * @param e
     * @return String    返回类型 
     */
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(AuthorizationException.class)
    public String handleException2(AuthorizationException e) {
        return "403";
    }
}