package com.freesofts.lowcode.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * Description:驼峰法-下划线互转 </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</       br>
 * date: 2022/7/19 16:37</br>
 * @since JDK 1.8
 */

public class UnderlineToCamelUtils {

	/**
	 * 下划线转驼峰法
	 *
	 * @param line       源字符串
	 * @param smallCamel 大小驼峰,是否为小驼峰
	 * @return 转换后的字符串
	 */
	public static String underlineToCamel(String line, boolean smallCamel) {
		if (line == null || "".equals(line)) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		Pattern pattern = compile("([A-Za-z\\d]+)(_)?");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(smallCamel && matcher.start() == 0 ? Character.toLowerCase(word.charAt(0)) : Character.toUpperCase(word.charAt(0)));
			int index = word.lastIndexOf('_');
			if (index > 0) {
				sb.append(word.substring(1, index).toLowerCase());
			} else {
				sb.append(word.substring(1).toLowerCase());
			}
		}
		return sb.toString();
	}

	/**
	 * 驼峰法转下划线
	 *
	 * @param line 源字符串
	 * @return 转换后的字符串  小写
	 */
	public static String camelToUnderline(String line) {
		if (line == null || "".equals(line)) {
			return "";
		}
		//如果字符串中包含 _  ，则跳过
		if (line.indexOf("_") != -1) {
			return line;
		}
		line = String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
		StringBuffer sb = new StringBuffer();
		Pattern pattern = compile("[A-Z]([a-z\\d]+)?");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(word.toUpperCase());
			sb.append(matcher.end() == line.length() ? "" : "_");
		}
		return sb.toString().toLowerCase();
	}


	public static void main(String[] args) {
		String line = "createdBy";
		System.out.println(camelToUnderline(line));
//		String camel=underlineToCamel(line,true);
//		System.out.println(camel);
	}
}
