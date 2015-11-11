package br.livro.android.cap10.notification;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import br.livro.android.cap10.R;
import br.livroandroid.utils.NotificationUtil;

/**
 * Exemplo de Activity que cria uma notificação
 * 
 * @author ricardo
 * 
 */
public class ExemploCriaNotificacaoGrande extends Activity {

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		TextView text = new TextView(this);
		text.setText("Uma notificação foi disparada.");
		setContentView(text);

		// Texto com a chamada para a notificação (barra de status)
		String tickerText = "Mensagem recebida";

		// Detalhes da mensagem, quem enviou e o texto
		String titulo = "Ricardo";
		String mensagem = "Exemplo de notificação";

		// Exibe a notificação para abrir a RecebeuMensagemActivity
		criarNotificacao(tickerText, titulo, mensagem, ExemploExecutaNotificacao.class);
	}

	// Exibe a notificação
	protected void criarNotificacao(String tickerText, String title,String message, Class<?> activity) {
		Intent intent=  new Intent(this, ExemploExecutaNotificacao.class);
		String lines[] = new String []{"Linha 1", "Linha 2", "Linha 3"};
		NotificationUtil.create_v17_big(this, tickerText, title, message,lines, R.drawable.ic_launcher, R.drawable.ic_launcher, intent);
	}
}
