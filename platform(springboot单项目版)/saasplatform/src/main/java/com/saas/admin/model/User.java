package com.saas.admin.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.saas.admin.model.role.Role;

public class User implements Serializable {

	private static final long serialVersionUID = 549584054460720088L;

	private Integer uid;

	private Integer rid;

	@NotNull(message = "用户名不能为空")
	private String username;

	@NotNull(message = "密码不能为空")
	private String password;

	private Role role;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", rid=" + rid + ", username=" + username + ", password=" + password + ", role="
				+ role + "]";
	}

}