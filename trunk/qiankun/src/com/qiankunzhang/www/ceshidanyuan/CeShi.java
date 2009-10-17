/**
 * 
 */
package com.qiankunzhang.www.ceshidanyuan;

import com.qiankunzhang.www.zhuanjia.JianDanJiZhuTa;

/**
 * @author AaronZhang
 * 
 */
public class CeShi {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String _genmulu = "/home/aaronzhang/名词/混沌";
		String _qinjiedian = "/home/aaronzhang/名词/混沌/宇宙/地球";
		//String _mingci = "宇宙";
		String _mingci = "太阳系";
		JianDanJiZhuTa 简单记住它 = new JianDanJiZhuTa();
		try {
			boolean 记住没有 = 简单记住它.jiYi(_genmulu, _qinjiedian, _mingci);
			if (记住没有 == true) {
				System.out.println("记住了 " + _genmulu + " 下的 " + _mingci);
			} else {
				System.out.println("已经记过 " + _genmulu + " 下的 " + _mingci);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
