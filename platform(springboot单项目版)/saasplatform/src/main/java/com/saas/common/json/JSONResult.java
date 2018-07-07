package com.saas.common.json;

import com.alibaba.fastjson.JSONObject;
import com.saas.common.param.ErrorCode;

/*
 *  Created by momo on 2016/8/17.
 * ajax接口返回数据格式
 * */
public final class JSONResult {
	private int code;
	private String msg;
	private Object result;
	private Object page;

	public int getCode() {
		return code;
	}

	public void setCode(ErrorCode errorCode) {
		this.code = errorCode.getCode();
		this.msg = errorCode.getMsg();
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Object getPage() {
		return page;
	}

	public void setPage(Object page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

}
