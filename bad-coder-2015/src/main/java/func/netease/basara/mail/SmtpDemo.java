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
	// 3��Session���ã��򵥡�TLS��SSL
	//
	//

	/**
	 * ΪSMTP����������һ���Ȳ���ҪTSL����Ҳ����Ҫ��֤��Session ����Gmail����ҪSSL���ܵģ�����û��25�˿ڣ�Ҳ���޷�����
	 */
	public static Session buildSimpleSession() {
		Properties mailProps = new Properties();
		mailProps.put("mail.transport.protocol", "smtp");
		mailProps.put("mail.host", "smtp.qq.com");
		mailProps.put("mail.from", "example@example.com");
		return Session.getDefaultInstance(mailProps);
	}

	/**
	 * ΪSMTP��������Gmail������һ����ҪTSL���ܺ���֤��Session���� ������һ�����⣺��ssl����֮�󵽵�Ҫ��Ҫ��smtp�������s
	 */
	public static Session buildSSLSession() {
		Properties mailProps = new Properties();
		mailProps.put("mail.transport.protocol", "smtps");
		// �趨��������
		mailProps.put("mail.host", "smtp.gmail.com");
		// �趨�����ߣ�����Ŀǰû�����к��ô�
		mailProps.put("mail.from", "example@gmail.com");
		// �趨�������˿�
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
	 * ΪSMTP��������Gmail������һ����ҪTSL���ܺ���֤��Session����
	 *
	 */
	public static Session buildTLSSession() {
		Properties mailProps = new Properties();
		// �趨����Э��
		mailProps.put("mail.transport.protocol", "smtp");
		// �趨��������
		mailProps.put("mail.host", "smtp.gmail.com");
		// �趨�����ߣ�����Ŀǰû�����к��ô�
		mailProps.put("mail.from", "example@gmail.com");
		// �趨�������˿�
		mailProps.put("mail.smtp.port", "587");

		// �趨�Ƿ���tls����
		mailProps.put("mail.smtp.starttls.enable", "true");
		// �趨�Ƿ�����֤
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
	// 3�ִ����ʼ����󣺴��ı�������������ǶͼƬ
	//
	//

	/**
	 * ����һ���򵥴��ı���Ϣ�ʼ�
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
	 * ����һ������ͼƬ�������ʼ�
	 *
	 */
	public static Message buildMessageWithAttachment(Session session) throws MessagingException, IOException {
		SMTPMessage m = new SMTPMessage(session);
		MimeMultipart content = new MimeMultipart();

		// ����ı�����
		MimeBodyPart mainPart = new MimeBodyPart();
		mainPart.setText("Hello there! This is simple demo message");
		content.addBodyPart(mainPart);

		// ���ͼƬ����
		MimeBodyPart imagePart = new MimeBodyPart();
		imagePart.attachFile("D:\\����.txt");
		content.addBodyPart(imagePart);

		m.setContent(content);
		m.setSubject("Demo message with a teapot!");
		return m;
	}

	/**
	 * ����һ������ͼƬ��Ƕ��HTML������ʼ�
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

		// INLINE��������������һ���͵ı�ͷ�������ͣ���ʾ�������丽�����������ʹ�ô���������ȷ�����ֵ���
		// �ʼ���������ȷ��ʽ�������INLINE�Ļ��������û��򿪵����ʼ���ʱ��ͻ���ʾ�������������ATTACHMENT
		// �Ļ������û��������ͼ��Ż���ʾ
		imagePart.setDisposition(MimeBodyPart.ATTACHMENT);
		content.addBodyPart(imagePart);

		m.setContent(content);
		m.setSubject("Demo HTML message");
		return m;
	}

	//
	//
	// 2�ַ����ʼ���ʽ�����ˡ�����
	//
	//

	/**
	 * ��Transport�������ʼ�
	 *
	 */
	public static void addressAndSendMessage(Message message, String recipient)
			throws AddressException, MessagingException {
		message.setRecipient(RecipientType.TO, new InternetAddress(recipient));
		Transport.send(message);
	}

	/**
	 * ������ͬʱ�����ʼ�
	 */
	public static void sendMessageToAddress(Message message, String recipient) throws MessagingException {
		InternetAddress[] recipients = { new InternetAddress(recipient), new InternetAddress(recipient) };
		Transport.send(message, recipients);
	}

}
