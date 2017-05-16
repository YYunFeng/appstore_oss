package com.jd.appstore.domain.utils;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
	String userName=null;
	String password=null;
	 
	public MyAuthenticator(){
	}
	public MyAuthenticator(String username, String password) {
		this.userName = username; 
		this.password = password; 
	} 
	protected PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(userName, password);
	}
	
//
//	public static void main(String[] args){
//        //这个类主要是设置邮件
//	  MailSenderInfo mailInfo = new MailSenderInfo();
//	  mailInfo.setMailServerHost("smtp.126.com");
//	  mailInfo.setMailServerPort("25");
//	  mailInfo.setValidate(true);
//	  mailInfo.setUserName("yu449093105@126.com");
//	  mailInfo.setPassword("449093105");//您的邮箱密码
//
//	  mailInfo.setFromAddress("yu449093105@126.com");
//	  mailInfo.setToAddress("yyf@platomix.net");
//	  mailInfo.setSubject("java发送邮件");
//	  mailInfo.setContent("测试");
//        //这个类主要来发送邮件
//	  SimpleMailSender sms = new SimpleMailSender();
////      sms.sendTextMail(mailInfo);//发送文体格式
//      sms.sendHtmlMail(mailInfo);//发送html格式
//	}

}
 
