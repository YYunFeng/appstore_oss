package com.jd.appstore.domain.utils;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

/**
 * 简单邮件发送器
 */
public class SimpleMailSender {
    /**
     * 以文本格式发送邮件
     *
     * @param mailInfo 待发送的邮件的信息
     */
    public boolean sendMail(MailSenderInfo mailInfo) {
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        if (mailInfo.isValidate()) {
            // 如果需要身份认证，则创建一个密码验证器
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address[] tos = null;
            if (mailInfo.getToAddress() != null && mailInfo.getToAddress().length != 0) {
                tos = new InternetAddress[mailInfo.getToAddress().length];
                for (int i = 0; i < mailInfo.getToAddress().length; i++) {
                    tos[i] = new InternetAddress(mailInfo.getToAddress()[i]);
                }
            }
            mailMessage.setRecipients(Message.RecipientType.TO, tos);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // 设置邮件消息的主要内容

            MimeMultipart multi = new MimeMultipart();
            // 邮件正文
            MimeBodyPart bpContent = new MimeBodyPart();
            SimpleDateFormat datef = new SimpleDateFormat("yyyyMMdd");
            String endTime = "";
            Calendar cal1 = Calendar.getInstance();
            cal1.add(Calendar.DATE, -1);
            Date time = cal1.getTime();
            endTime = datef.format(time);
            bpContent.setContent(endTime + mailInfo.getContent(), "text/html;charset=utf-8");
            multi.addBodyPart(bpContent);

            // 附件
            if (mailInfo.getFileName() != null && mailInfo.getFileName().length != 0) {
                for (int i = 0; i < mailInfo.getFileName().length; i++) {
                    FileDataSource fds = new FileDataSource(mailInfo.getFileName()[i]); //必须存在的文档，否则throw异常。
                    BodyPart fileBodyPart = new MimeBodyPart(); //第二个BodyPart
                    fileBodyPart.setDataHandler(new DataHandler(fds)); //字符流形式装入文件
                    if (i == 0) {
                        fileBodyPart.setFileName(MimeUtility.encodeText(MailConstant.SHANGHAIGEREN + endTime + ".xlsx"));
                    } else if (i == 1) {
                        fileBodyPart.setFileName(MimeUtility.encodeText(MailConstant.SHANGHAIMEIRI + endTime + ".xlsx"));
                    } else {
                        fileBodyPart.setFileName(MimeUtility.encodeText(fds.getName()));
                    }
                    multi.addBodyPart(fileBodyPart);
                }
            }
            mailMessage.setContent(multi);
            mailMessage.saveChanges();
            // 发送邮件*/
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 发送邮件
     *
     * @param mailInfo 待发送的邮件信息
     */
    public static boolean sendHtmlMail(MailSenderInfo mailInfo) {
        // 判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        //如果需要身份认证，则创建一个密码验证器
        if (mailInfo.isValidate()) {
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址，并设置到邮件消息中
            Address to = new InternetAddress(mailInfo.getToAddress()[0]);
            // Message.RecipientType.TO属性表示接收者的类型为TO
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            // 将MiniMultipart对象设置为邮件内容
            mailMessage.setContent(mainPart);
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void main(String args[]) {
        try {

        /*    String endTime = "";
            Calendar cal1 = Calendar.getInstance();
            cal1.add(Calendar.DATE,   -1);
            SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");
            Date time = cal1.getTime();
            endTime = datef.format(time);
            System.out.println(endTime);*/
 /*  *//*         MailSenderInfo mailSenderInfo = new MailSenderInfo();
            mailSenderInfo.setFromAddress("yyf@platomix.net");
            mailSenderInfo.setPassword("shangxin2012");
            String[] toAddress = new String[2];
            toAddress[0] = "449093105@qq.com";
            toAddress[1] = "zqq@platomix.net";
            mailSenderInfo.setToAddress(toAddress);
            mailSenderInfo.setUserName("yyf@platomix.net");
            mailSenderInfo.setSubject("测试测试");
            mailSenderInfo.setContent("aaaaaaaaaaaaaaa");
            mailSenderInfo.setValidate(true);
            String[] strings = new String[2];
            strings[0] = "C:\\chroot\\www\\img.appstore.taotaojing.cn\\installlogExcel\\1379836041239.xlsx";
            strings[1] = "C:\\chroot\\www\\img.appstore.taotaojing.cn\\installlogExcel\\2013-09-012013-09-221379836014180.xlsx";
            mailSenderInfo.setFileName(strings);
            SimpleMailSender simpleMailSender = new SimpleMailSender();
            simpleMailSender.sendMail(mailSenderInfo);*/

            MailSenderInfo mailSenderInfo = new MailSenderInfo();
            mailSenderInfo.setFromAddress(MailConstant.FROMADDRESS);
            mailSenderInfo.setToAddress(MailConstant.TOADDRESS);
            mailSenderInfo.setUserName(MailConstant.USERNAME);
            mailSenderInfo.setSubject(MailConstant.SUBJECT);
            mailSenderInfo.setPassword(MailConstant.PASSWORD);
            mailSenderInfo.setContent(MailConstant.CONTENT);
            mailSenderInfo.setValidate(true);
            String[] strings = new String[2];
            strings[0] = "C:\\chroot\\www\\img.appstore.taotaojing.cn\\installlogExcel\\1379836041239.xlsx";
            strings[1] = "C:\\chroot\\www\\img.appstore.taotaojing.cn\\installlogExcel\\2013-09-012013-09-221379836014180.xlsx";
            mailSenderInfo.setFileName(strings);
            SimpleMailSender simpleMailSender = new SimpleMailSender();
            simpleMailSender.sendMail(mailSenderInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

