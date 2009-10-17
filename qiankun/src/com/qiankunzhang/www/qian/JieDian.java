/**
 * 
 */
package com.qiankunzhang.www.qian;

/**
 * @author AaronZhang
 * 
 */
public class JieDian {

	private String qinjiedian = "";
	private String zijiedian = "";
	private String xkuozhan = "";
	private String ykuozhan = "";

	public JieDian() {
		// 初始化成亲节点
		this.qinjiedian = "混沌";
		this.zijiedian = "混沌";
		this.xkuozhan = "0";// 从命名树上取得，去问dizhu
		this.ykuozhan = "0";

	}

	public void setQinjiedian(String qinjiedian) {
		this.qinjiedian = qinjiedian;
	}

	public String getQinjiedian() {
		return qinjiedian;
	}

	public void setZijiedian(String zijiedian) {
		this.zijiedian = zijiedian;
	}

	public String getZijiedian() {
		return zijiedian;
	}

	public void setXkuozhan(String xkuozhan) {
		this.xkuozhan = xkuozhan;
	}

	public String getXkuozhan() {
		return xkuozhan;
	}

	public void setYkuozhan(String ykuozhan) {
		this.ykuozhan = ykuozhan;
	}

	public String getYkuozhan() {
		return ykuozhan;
	}

}
