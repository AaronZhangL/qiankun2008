/**
 * 
 */
package com.qiankunzhang.www.zhuanjia;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.qiankunzhang.www.kun.KunXianSheng;

/**
 * @author AaronZhang
 * 
 */
public class JianDanJiZhuTa {

	/**
	 * 
	 * @param qinjiedian_
	 *            亲节点
	 * @param mingci_
	 *            名词
	 * @return true 记住了 false 没记住
	 * @throws Exception
	 */
	private boolean zhuiJiaJiYi(String qinJieDian_, String mingCi_)
			throws Exception {
		// 空值检查
		KongkongJianChaYuan 空值检查员 = new KongkongJianChaYuan();
		if (空值检查员.shiBushiKongDe(qinJieDian_)) {
			System.out.println("不对啊，不记得有这个名词啊!");
			return false;
		}
		if (空值检查员.shiBushiKongDe(mingCi_)) {
			System.out.println("给个名词啊，总不能啥也不记啊！");
			return false;
		}

		boolean result = false;
		File dirFile = null;
		dirFile = new File(qinJieDian_ + System.getProperty("file.separator")
				+ mingCi_);// 本地
		if (!(dirFile.exists()) && !(dirFile.isDirectory())) {
			boolean creadok = dirFile.mkdirs();
			result = creadok;
			if (creadok) {
				System.out.println("记住了" + mingCi_ + "！ ");
			} else {
				System.out.println("没记住" + mingCi_ + "！ ");
			}
		}

		return result;
	}

	private boolean chaDuiJiYi(String qinJieDian_, String ziJieDian_,
			String mingCi_) {
		boolean 记忆结果 = false;
		// 将子节点记在名词下
		String muBiao_mingCi = ziJieDian_ + System.getProperty("file.separator") +mingCi_;
    	// 获取源文件夹当前下的文件或目录
		File[] file = (new File(muBiao_mingCi)).listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) {
				// 复制名词
				try {
					copyFile(file[i], new File(ziJieDian_ + file[i].getName()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e);
					System.out.println("复制名词出错！");
				}
			}
			if (file[i].isDirectory()) {
				// 复制名词目录
				String sourceDir = muBiao_mingCi + File.separator + file[i].getName();
				String targetDir = ziJieDian_ + File.separator + file[i].getName();
				try {
					copyDirectiory(sourceDir, targetDir);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e);
					System.out.println("复制名词目录出错！");
				}
			}
		}
		return 记忆结果;

	}

	/**
	 * 
	 * @param qinJieDian_
	 *            亲节点
	 * @param ziJieDian_
	 *            子节点
	 * @param mingCi_
	 *            名词
	 * @return true 记忆成功 false 记忆失败
	 * @throws Exception
	 */
	public boolean jiYi(String qinJieDian_, String ziJieDian_, String mingCi_)
			throws Exception {
		// 空值检查
		KongkongJianChaYuan 空值检查员 = new KongkongJianChaYuan();
		if (空值检查员.shiBushiKongDe(qinJieDian_)) {
			System.out.println("不对啊，至少得告诉我一个名词啊!");
			return false;
		}

		if (空值检查员.shiBushiKongDe(ziJieDian_)) {
			System.out.println("给个名词啊，总不能啥也不记啊！");
			return false;
		}
		if (空值检查员.shiBushiKongDe(mingCi_)) {
			System.out.println("给个名词啊，总不能啥也不记啊！");
			return false;
		}

		// 去问坤先生
		KunXianSheng 坤先生 = new KunXianSheng();
		boolean 记忆方式 = 坤先生.zhenYangJiYi(qinJieDian_, ziJieDian_, mingCi_);
		boolean result = false;

		// 追加记忆
		result = this.zhuiJiaJiYi(qinJieDian_, mingCi_);

		// 插队记忆
		if (记忆方式 == true) {

		}
		return result;
	}

	// 复制文件
	public static void copyFile(File sourceFile, File targetFile)
			throws IOException {
		// 新建文件输入流并对它进行缓冲
		FileInputStream input = new FileInputStream(sourceFile);
		BufferedInputStream inBuff = new BufferedInputStream(input);

		// 新建文件输出流并对它进行缓冲
		FileOutputStream output = new FileOutputStream(targetFile);
		BufferedOutputStream outBuff = new BufferedOutputStream(output);

		// 缓冲数组
		byte[] b = new byte[1024 * 5];
		int len;
		while ((len = inBuff.read(b)) != -1) {
			outBuff.write(b, 0, len);
		}
		// 刷新此缓冲的输出流
		outBuff.flush();

		// 关闭流
		inBuff.close();
		outBuff.close();
		output.close();
		input.close();
	}

	// 复制文件夹
	public static void copyDirectiory(String sourceDir, String targetDir)
			throws IOException {
		// 新建目标目录
		(new File(targetDir)).mkdirs();
		// 获取源文件夹当前下的文件或目录
		File[] file = (new File(sourceDir)).listFiles();
		for (int i = 0; i < file.length; i++) {
			if (file[i].isFile()) {
				// 源文件
				File sourceFile = file[i];
				// 目标文件
				File targetFile = new File(new File(targetDir)
						.getAbsolutePath()
						+ File.separator + file[i].getName());
				copyFile(sourceFile, targetFile);
			}
			if (file[i].isDirectory()) {
				// 准备复制的源文件夹
				String dir1 = sourceDir + System.getProperty("file.separator")
						+ file[i].getName();
				// 准备复制的目标文件夹
				String dir2 = targetDir + System.getProperty("file.separator")
						+ file[i].getName();
				copyDirectiory(dir1, dir2);
			}
		}
	}
}
