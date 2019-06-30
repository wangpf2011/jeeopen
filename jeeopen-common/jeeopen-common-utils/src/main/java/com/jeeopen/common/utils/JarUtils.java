package com.jeeopen.common.utils;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * All rights Reserved, Designed By www.jeeopen.com
 *
 * @title: JarUtil.java
 * @package com.jeeopen.common.util
 * @description:Jar文件操作工具
 * @author: wangpf
 * @date: 2017年5月22日 下午9:25:14
 * @version V1.0
 * @copyright: 2017 www.jeeopen.com Inc. All rights reserved.
 *
 */
public class JarUtils {

	/**
	 * 解压jar文件到指定目录
	 * 
	 * @param fileName
	 * @param outputPath
	 */
	public static synchronized void decompress(String fileName, String outputPath) {
		// 保证输出路径为目录
		if (!outputPath.endsWith(File.separator)) {
			outputPath += File.separator;
		}
		// 如果不存在输出目录，则创建
		File dir = new File(outputPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// 解压到输出目录
		JarFile jf = null;
		try {
			jf = new JarFile(fileName);
			for (Enumeration<JarEntry> e = jf.entries(); e.hasMoreElements();) {
				JarEntry je = e.nextElement();
				String outFileName = outputPath + je.getName();
				File f = new File(outFileName);
				if (je.isDirectory()) {
					if (!f.exists()) {
						f.mkdirs();
					}
				} else {
					File pf = f.getParentFile();
					if (!pf.exists()) {
						pf.mkdirs();
					}
					InputStream in = jf.getInputStream(je);
					OutputStream out = new BufferedOutputStream(new FileOutputStream(f));
					byte[] buffer = new byte[2048];
					int nBytes;
					while ((nBytes = in.read(buffer)) > 0) {
						out.write(buffer, 0, nBytes);
					}
					out.flush();
					out.close();
					in.close();
				}
			}
		} catch (Exception e) {
			System.out.println("解压" + fileName + "出错！" + e.getMessage());
		} finally {
			if (jf != null) {
				try {
					jf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
