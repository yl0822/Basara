package func.netease.basara.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.smtp.SMTPMessage;

/**
 * @author long.yl.
 */
public class SmtpDemo {

	public static void main(String[] args) throws MessagingException, IOException {
		// Session session1 = buildSimpleSession();
		Session session2 = buildSSLSession();
		// Session session3 = buildTLSSession();
		Message simpleMessage = buildSimpleMessage(session2);
		// sendMessageToAddress(simpleMessage, "sdstyle0822@gmail.com");
		// Message messageWithAttachment = buildMessageWithAttachment(session2);
		// sendMessageToAddress(messageWithAttachment, "sdstyle0822@gmail.com");
		// Message withImage = buildMessageWithEmbeddedImage(session3);
		addressAndSendMessage(simpleMessage, "839880341@qq.com");
	}

	//
	//
	// 3种Session设置：简单、TLS、SSL
	//
	//

	/**
	 * 为SMTP服务器创建一个既不需要TSL加密也不需要认证的Session 由于Gmail是需要SSL加密的，所以没有25端口，也就无法创建
	 */
	public static Session buildSimpleSession() {
		Properties mailProps = new Properties();
		mailProps.put("mail.transport.protocol", "smtp");
		mailProps.put("mail.host", "smtp.qq.com");
		mailProps.put("mail.from", "example@example.com");
		return Session.getDefaultInstance(mailProps);
	}

	/**
	 * 为SMTP服务器（Gmail）创建一个需要TSL加密和认证的Session对象 这里有一个问题：用ssl加密之后到底要不要在smtp后面加上s
	 */
	public static Session buildSSLSession() {
		Properties mailProps = new Properties();
		mailProps.put("mail.transport.protocol", "smtps");
		// 设定主机名称
		mailProps.put("mail.host", "smtp.gmail.com");
		// 设定发送者，但是目前没看到有何用处
		mailProps.put("mail.from", "example@gmail.com");
		// 设定服务器端口
		mailProps.put("mail.smtp.port", "465");

		mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		mailProps.put("mail.smtp.auth", "true");

		final PasswordAuthentication usernamePassword = new PasswordAuthentication("support@escort.com.vn",
				"escortsecurity1234");
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return usernamePassword;
			}
		};
		Session session = Session.getInstance(mailProps, auth);
		session.setDebug(true);
		return session;
	}

	/**
	 * 为SMTP服务器（Gmail）创建一个需要TSL加密和认证的Session对象
	 *
	 */
	public static Session buildTLSSession() {
		Properties mailProps = new Properties();
		// 设定传输协议
		mailProps.put("mail.transport.protocol", "smtp");
		// 设定主机名称
		mailProps.put("mail.host", "smtp.gmail.com");
		// 设定发送者，但是目前没看到有何用处
		mailProps.put("mail.from", "example@gmail.com");
		// 设定服务器端口
		mailProps.put("mail.smtp.port", "587");

		// 设定是否开启tls加密
		mailProps.put("mail.smtp.starttls.enable", "true");
		// 设定是否开启认证
		mailProps.put("mail.smtp.auth", "true");

		// final, because we're using it in the closure below
		final PasswordAuthentication usernamePassword = new PasswordAuthentication("support@escort.com.vn",
				"escortsecurity1234");
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return usernamePassword;
			}
		};
		Session session = Session.getInstance(mailProps, auth);
		session.setDebug(true);
		return session;

	}

	//
	//
	// 3种创建邮件对象：纯文本、带附件、内嵌图片
	//
	//

	/**
	 * 创建一个简单纯文本信息邮件
	 *
	 */
	public static Message buildSimpleMessage(Session session) throws MessagingException {
		SMTPMessage m = new SMTPMessage(session);
		MimeMultipart content = new MimeMultipart();
		MimeBodyPart mainPart = new MimeBodyPart();
		mainPart.setText("Hello there! This is simple demo message");
		content.addBodyPart(mainPart);
		m.setContent(content);
		m.setSubject("Demo message");
		return m;
	}

	/**
	 * 创建一个带有图片附件的邮件
	 *
	 */
	public static Message buildMessageWithAttachment(Session session) throws MessagingException, IOException {
		SMTPMessage m = new SMTPMessage(session);
		MimeMultipart content = new MimeMultipart();

		// 添加文本内容
		MimeBodyPart mainPart = new MimeBodyPart();
		mainPart.setText("Hello there! This is simple demo message");
		content.addBodyPart(mainPart);

		// 添加图片附件
		MimeBodyPart imagePart = new MimeBodyPart();
		imagePart.attachFile("D:\\读书.txt");
		content.addBodyPart(imagePart);

		m.setContent(content);
		m.setSubject("Demo message with a teapot!");
		return m;
	}

	/**
	 * 创建一个带有图片内嵌在HTML里面的邮件
	 *
	 */
	public static Message buildMessageWithEmbeddedImage(Session session) throws MessagingException, IOException {
		SMTPMessage m = new SMTPMessage(session);
		MimeMultipart content = new MimeMultipart("related");

		// ContentID is used by both parts
		String cid = ContentIdGenerator.getContentId();

		// HTML part
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setText("<html><head>" + "<title>This is not usually displayed</title>" + "</head>\n"
				+ "<body><div><b>Hi there!</b></div>" + "<div>Sending HTML in email is so <i>cool!</i> </div>\n"
				+ "<div style=" + "color:green" + ">And here's an image: <img src=\"cid:" + cid + "\" /></div>\n"
				+ "<div>I hope you like it!</div></body></html>", "US-ASCII", "html");
		content.addBodyPart(textPart);

		// Image part
		MimeBodyPart imagePart = new MimeBodyPart();
		imagePart.attachFile("D:\\logo.jpg");
		imagePart.setContentID("<" + cid + ">");

		// INLINE属性设置与邮箱一起发送的标头处置类型，显示电子邮箱附件的软件可以使用处置类型来确定呈现电子
		// 邮件附件的正确方式，如果是INLINE的话，则在用户打开电子邮件的时候就会显示出来，而如果是ATTACHMENT
		// 的话，则当用户点击附件图标才会显示
		imagePart.setDisposition(MimeBodyPart.ATTACHMENT);
		content.addBodyPart(imagePart);

		m.setContent(content);
		m.setSubject("Demo HTML message");
		return m;
	}

	//
	//
	// 2种发送邮件方式：单人、多人
	//
	//

	/**
	 * 用Transport来发送邮件
	 *
	 */
	public static void addressAndSendMessage(Message message, String recipient)
			throws AddressException, MessagingException {
		message.setRecipient(RecipientType.TO, new InternetAddress(recipient));
		Transport.send(message);
	}

	/**
	 * 给多人同时发送邮件
	 */
	public static void sendMessageToAddress(Message message, String recipient) throws MessagingException {
		InternetAddress[] recipients = { new InternetAddress(recipient), new InternetAddress(recipient) };
		Transport.send(message, recipients);
	}

}
