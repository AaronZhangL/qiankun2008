/**
 * 
 */
package com.qiankunzhang.www.zhuanjia;

import com.qiankunzhang.www.qian.JieDian;

/**
 * @author AaronZhang
 *
 */
public class ZhaoA {
	
	
	public JieDian zhaoshenme(String yaozhaodeci){
		JieDian jiedian_a = new JieDian();//初始化为世界之初
		if (yaozhaodeci == null) {
			//不对啊，你得告诉我问的是什么啊？
			//返回根节点
		}else {
			//找到位置，查找需要第三方lib	
			
			//重置节点内容
			jiedian_a.setQinjiedian("");
			jiedian_a.setZijiedian("");
			jiedian_a.setXkuozhan("");
			jiedian_a.setYkuozhan("");
		}

		return jiedian_a;
	}


}
