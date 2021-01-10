package com.dibas;

public class SendMailSSL {
	public static void main(String[] args) {
		MailSender.send(Constants.FROM_MAILID, Constants.SECRET_CODE, Constants.TO_MAILID, Constants.SUBJECT,
				Constants.MESSAGE_BODY);
	}
}
