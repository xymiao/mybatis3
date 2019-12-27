package com.xymiao.mybatis3.pojo;

public class TUser {
	private String uid;
	private String uname;
	private String pwd;
	private String flag; 
	private String loginid;
	public String getFlag() {
		return flag;
	}
	public String getLoginid() {
		return loginid;
	}
	public String getPwd() {
		return pwd;
	}
	public String getUid() {
		return uid;
	}
	public String getUname() {
		return uname;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "TUser [uid=" + uid + ", uname=" + uname + ", pwd=" + pwd + ", flag=" + flag + ", loginid=" + loginid
				+ "]";
	}
}
