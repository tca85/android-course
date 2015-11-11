package br.livro.android.cap10;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.livro.android.cap10.notification.ExemploCriaNotificacao;
import br.livro.android.cap10.notification.ExemploCriaNotificacaoGrande;

/**
 * Exemplo de como exibir uma notificação para o usuário
 * 
 * @author rlecheta
 * 
 */
public class Menu extends ListActivity {

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		String[] mStrings = new String[] { "Criar notificação", "Criar notificação - grande" };

		this.setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mStrings));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		switch (position) {
		case 0:
			startActivity(new Intent(this, ExemploCriaNotificacao.class));
			break;
		case 1:
			startActivity(new Intent(this, ExemploCriaNotificacaoGrande.class));
			break;
		}
	}
}