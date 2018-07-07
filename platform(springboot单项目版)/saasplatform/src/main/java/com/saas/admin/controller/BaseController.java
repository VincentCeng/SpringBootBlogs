
package com.saas.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saas.common.json.JSONResult;
import com.saas.common.param.ErrorCode;
import com.saas.mybatis.plugins.BaseConditionVO;


public class BaseController
{
    Logger logger = LoggerFactory.getLogger(BaseController.class);

    final public JSONResult ajaxSuccess()
    {
        JSONResult ecologyResp = new JSONResult();
        ecologyResp.setCode(ErrorCode.Success);
        ecologyResp.setMsg("success");
        return ecologyResp;
    }

    final public JSONResult ajaxSuccess(String msg)
    {
        JSONResult ecologyResp = new JSONResult();
        ecologyResp.setCode(ErrorCode.Success);
        ecologyResp.setMsg(msg);
        return ecologyResp;
    }
    
    final public JSONResult ajaxSuccess(Object data)
    {
        JSONResult ecologyResp = new JSONResult();
        ecologyResp.setCode(ErrorCode.Success);
        ecologyResp.setResult(data);
        return ecologyResp;
    }

    final public JSONResult ajaxSuccess(Object data, BaseConditionVO page)
    {
        JSONResult ecologyResp = new JSONResult();
        ecologyResp.setCode(ErrorCode.Success);
        ecologyResp.setResult(data);
        ecologyResp.setPage(page);
        return ecologyResp;
    }

    /**
     * 失败
     */
    final public JSONResult ajaxFail(ErrorCode errorCode)
    {
        JSONResult ecologyResp = new JSONResult();
        ecologyResp.setCode(errorCode);
        return ecologyResp;
    }

    final public JSONResult ajaxFail(String message)
    {
        JSONResult ecologyResp = new JSONResult();
        ecologyResp.setCode(ErrorCode.CODE);
        ecologyResp.setMsg(message);
        return ecologyResp;
    }
    
    
    final public JSONResult ajaxFail(ErrorCode errorCode , String message)
    {
        JSONResult ecologyResp = new JSONResult();
        ecologyResp.setCode(errorCode);
        ecologyResp.setMsg(message);
        return ecologyResp;
    }
}
