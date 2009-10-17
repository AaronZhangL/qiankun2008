package com.qiankunzhang.www.zhuanjia;

/**
 * 
 * @author AaronZhang
 * 
 */
public class KongkongJianChaYuan {
	/**
	 * 
	 * @param beiCeShiZhi_
	 *            被测试值
	 * @return true 是空值 false 不是空值
	 */
	public boolean shiBushiKongDe(String beiCeShiZhi_) {
		boolean 空么 = false;
		if (beiCeShiZhi_ == null || beiCeShiZhi_.length() <= 0
				|| beiCeShiZhi_ == "") {

			空么 = true;
		}
		// System.out.println(beiCeShiZhi_ + "空值检测：结果是 " + 空么);
		return 空么;

	}
}
