package com.xietong.software.util;



import java.util.Properties;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * 电子邮件操作类
 * @author Tlw
 * @version 1.0
 * @since 2010.12.09
 */

public class Cemail {
	
	private static String stmpHost = "smtp.163.com"; // smtp服务器
	private static String stmpUserName = "18766858991@163.com"; // 用户名
	private static String stmpPassword = "Can888812341234"; // 密码
	
	/**
	 * 发送邮件的方法。该方法用指定的系统服务器、用户名、地址发送邮件
	 * @author Tlw
	 * @param receiveAddress - 接收地址
	 * @param subject - 标题
	 * @param content - 正文
	 * 
	 */

	public static void sendEmail(String receiveAddress, String subject, String content) {
		
		
		System.out.println("我进入和这个方法了");
		System.out.println(stmpHost+"  "+stmpUserName+" "+stmpPassword);
		if(stmpHost==null || stmpUserName==null || stmpPassword==null || receiveAddress==null) {
			System.out.println("——————————————————邮件服务器尚未设置，请查看HeadConst————————————————");
			return;
		}
		//如果必要的数据位空 则返回
		if(stmpHost.equals("") || stmpUserName.equals("") || stmpPassword.equals("") || receiveAddress.equals("") ) {
			return;
		}
		System.out.println("我进入和这个方法了333333333");
		Properties props = new Properties();
		// 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）
		props.put("mail.smtp.host", stmpHost);
		// 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
		props.put("mail.smtp.auth", "true");
		// 用刚刚设置好的props对象构建一个session
		Session session = Session.getDefaultInstance(props);
		// 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使
		// 用（你可以在控制台（console)上看到发送邮件的过程）
		session.setDebug(true);
		// 用session为参数定义消息对象
		MimeMessage message = new MimeMessage(session);
		try {
			// 加载发件人地址
			message.setFrom(new InternetAddress(stmpUserName));
			// 加载收件人地址
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiveAddress));
			// 加载标题
			message.setSubject(subject);
			// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
			Multipart multipart = new MimeMultipart();
			

			// 设置邮件的文本内容
			BodyPart contentPart = new MimeBodyPart();
			
			contentPart.setText(content);
			contentPart.setContent(content,"text/html;charset=gbk");
			multipart.addBodyPart(contentPart);

			message.setContent(multipart);
			// 保存邮件
			message.saveChanges();
			// 发送邮件
			Transport transport = session.getTransport("smtp");
			// 连接服务器的邮箱
			transport.connect(stmpHost, stmpUserName, stmpPassword);
			// 把邮件发送出去
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
