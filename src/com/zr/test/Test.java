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
		//ѭ�����ַ������ж��ٸ����ϵģ���ѭ�����ٴ�
		while(matcher.find()){
			//ÿһ������������ַ���
			String e = matcher.group();
			//��ȡ�������е�����
			String substring = e.substring(3, e.length()-1);
			//�ַ�����ȡ
			CharSequence subSequence = sqlFragment.subSequence(matcher.start(0), matcher.end(0));
			System.out.println("��ʼλ��:"+matcher.start(0)+" ����λ��:"+matcher.end(0));
			System.out.println(subSequence.toString());
			System.out.println(e);
			//�����滻
			sqlFragment = sqlFragment.replaceAll("\\#E\\{"+substring+"\\}", "123123498496416");
			//�˾�������Ͼ������һ��
//			sqlFragment = sqlFragment.replace(e, "123123");
			
		}
		System.out.println(sqlFragment);
	}
	
}
