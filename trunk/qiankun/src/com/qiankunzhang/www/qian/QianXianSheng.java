/**
 * 
 */
package com.qiankunzhang.www.qian;

import com.qiankunzhang.www.zhuanjia.JiZhuTa;
import com.qiankunzhang.www.zhuanjia.ZhaoA;

/**
 * @author AaronZhang
 * @version 0.0
 * @since 2009/09/30
 */
public class QianXianSheng {

	// 取得根节点
	public static String genjiedian = "";
	private String mingci = "";

	// 取得名词

	public void setMingci(String mingci) {
		this.mingci = mingci;
	}

	public String getMingci() {
		return mingci;
	}

	public boolean jizhu(String mingci) {
		boolean jizhumeiyou = false;
		// 查找是否存在这个名词，去问zhaoa
		ZhaoA zhao_a = new ZhaoA();
		JiZhuTa jizhuta_a = new JiZhuTa(zhao_a.zhaoshenme(mingci), mingci);
		return jizhumeiyou;
	}

}
