package br.edu.infnet.projeto.ejb.core;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.PostConstruct;
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

import br.edu.infnet.projeto.ejb.avaliacao.Avaliacao;
import br.edu.infnet.projeto.ejb.avaliacao.AvaliacaoAluno;
import br.edu.infnet.projeto.ejb.infnet.Aluno;
import br.edu.infnet.projeto.ejb.parametros.Parametros;

@Stateless
public class Email {
	
	@Resource(name = "java:app/mail/gmail")
	private Session mySession;
	@EJB
	Repositorio repositorio;
	Parametros parametros;
	
	@PostConstruct
	public void inicializacao() {
		List<Parametros> parametrosList = repositorio.listar(Parametros.class);
		if (parametrosList != null && parametrosList.size() > 0)
			this.parametros = parametrosList.get(0);
	}
	
	public void enviarMsgAbertura(Aluno aluno, Avaliacao avaliacao) throws InfnetException{
		if (parametros != null) {
			String mensagem = parametros.getMsgAbertura();
			mensagem = mensagem.replace(parametros.getTagNomeAluno(), aluno.getNome());
			mensagem = mensagem.replace(parametros.getTagModulo(), avaliacao.getTurma().getModulo().getNome());
			mensagem = mensagem.replace(parametros.getTagDataFim(), avaliacao.getDataTermino().toString());
			mensagem = mensagem.replace(parametros.getTagLink(), gerarLink(aluno.getId(), avaliacao.getId()));
			mensagem = mensagem.replace(parametros.getTagNomeAluno(), aluno.getNome());
			enviarMsg(aluno.getEmail(), parametros.getAssuntoMsgAbertura(), mensagem);
		}
		else 
			throw new InfnetException("Sistema não possui parâmetros cadastrados");
	}
	
	private String gerarLink(Long idAluno, Long idAvaliacao){
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(parametros.getUrlServidor());
			sb.append("/");
			sb.append(parametros.getNomeAplicacao());
			sb.append("/");
			sb.append(parametros.getNomeFormularioAvaliacao());
			sb.append("?id=");
			String id = Seguranca.encriptar(idAluno.toString() + ":" + idAvaliacao.toString());
			sb.append(URLEncoder.encode(id, "UTF-8"));
			
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new InfnetException("Erro ao enviar e-mail: " + e.getMessage());
		}
	}
	
	private void enviarMsg(String destinatario, String assunto, String corpo){
		try {
			Message message = new MimeMessage(mySession);
			Address toAddress = new InternetAddress(destinatario);
			message.addRecipient(Message.RecipientType.TO, toAddress);
			message.setSubject(assunto);
			message.setContent(corpo, "text/plain");
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new InfnetException("Erro ao enviar e-mail: " + e.getMessage());
		}
	}
	
	public void enviarMsgConfirmaRecebAval(AvaliacaoAluno avaliacao) throws InfnetException{
		if (parametros != null) {			
			String mensagem = parametros.getMsgConfirmacao();
			mensagem = mensagem.replace(parametros.getTagNomeAluno(), avaliacao.getAluno().getNome());
			mensagem = mensagem.replace(parametros.getTagModulo(), avaliacao.getAvaliacao().getTurma().getModulo().getNome());
			mensagem = mensagem.replace(parametros.getTagDataFim(), avaliacao.getAvaliacao().getDataTermino().toString());
			mensagem = mensagem.replace(parametros.getTagLink(), gerarLink(avaliacao.getAluno().getId(), avaliacao.getAvaliacao().getId()));
			enviarMsg(avaliacao.getAluno().getEmail(), parametros.getAssuntoMsgConfirmacao(), mensagem);
		}
		else 
			throw new InfnetException("Sistema não possui parâmetros cadastrados");
	}
	
}
