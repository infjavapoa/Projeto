package br.edu.infnet.projeto.ejb.core;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import br.edu.infnet.projeto.ejb.infnet.Aluno;
import br.edu.infnet.projeto.ejb.parametros.Parametros;

@Stateless
public class Email {
	
	@Resource(name = "java:app/mail/gmail")
	private Session mySession;
	@EJB
	Repositorio repositorio;
	private String emissor = "mrmello@gmail.com";
	private String assuntoMsgAbertura = "INFNET - Abertura de Avaliação de Módulo";
	Parametros parametros;
	
	public void enviarMsgAbertura(Aluno aluno){
		String mensagem = parametros.getMsgAbertura();
		mensagem.replace(":aluno", aluno.getNome());
		enviarMsg(aluno.getEmail(), assuntoMsgAbertura, mensagem);
	}
	
	private void enviarMsg(String destinatario, String assunto, String corpo){
		try {
			Message message = new MimeMessage(mySession);
			message.setFrom(new InternetAddress(emissor));
			Address toAddress = new InternetAddress(destinatario);
			message.addRecipient(Message.RecipientType.TO, toAddress);
			message.setSubject(assunto);
			message.setContent(corpo, "text/plain");
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
