package com.zr.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args){
		String sqlFragment = "insert into t_role(role_id,role_name,"
		+ "role_level,org_id,role_type,role_status,add_user_id,"
		+ "add_time,upd_user_id,upd_time) values(#{id},"
		+ "${role_name},${role_level},${org_id},${role_type},"
		+ "${role_status},"
		+ "#E{accId},#{dateInt},#{accId},#E{dateInt})";
		Pattern pattern = Pattern.compile("#E\\{[\\w]*\\}");
		Matcher matcher = pattern.matcher(sqlFragment);
		//循环，字符串中有多少个符合的，就循环多少次
		while(matcher.find()){
			//每一个符合正则的字符串
			String e = matcher.group();
			//截取出括号中的内容
			String substring = e.substring(3, e.length()-1);
			//字符串截取
			CharSequence subSequence = sqlFragment.subSequence(matcher.start(0), matcher.end(0));
			System.out.println("开始位置:"+matcher.start(0)+" 结束位置:"+matcher.end(0));
			System.out.println(subSequence.toString());
			System.out.println(e);
			//进行替换
			sqlFragment = sqlFragment.replaceAll("\\#E\\{"+substring+"\\}", "123123498496416");
			//此句代码与上句代码结果一致
//			sqlFragment = sqlFragment.replace(e, "123123");
			
		}
		System.out.println(sqlFragment);
	}
	
}
