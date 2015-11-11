package br.com.impacta.desafio01megasena;

import java.util.Iterator;
import java.util.TreeSet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity {

	private Button btnGerarSorteio;
	private TextView[] numeros;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		numeros = new TextView[6];
		numeros[0] = (TextView)findViewById(R.id.txvNr01);
		numeros[1] = (TextView)findViewById(R.id.txvNr02);
		numeros[2] = (TextView)findViewById(R.id.txvNr03);
		numeros[3] = (TextView)findViewById(R.id.txvNr04);
		numeros[4] = (TextView)findViewById(R.id.txvNr05);
		numeros[5] = (TextView)findViewById(R.id.txvNr06);

		btnGerarSorteio = (Button)findViewById(R.id.btnGerarSorteio);

		btnGerarSorteio.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// Treeset não permite duplicidade. Pesquisar sobre TreeMap, HashMap, LinkedHashMap
				TreeSet<String> sorteios = new TreeSet<String>();

				do {
					int sorteio = (int) ((Math.random() * 59) + 1);

					// operador ternário, switch/case, if
					String saida = (sorteio < 10 ? "0" : "") + sorteio;
					sorteios.add(saida);

				} while (sorteios.size() < 6 );

				int posicao = 0;

				Iterator<String>informacoes = sorteios.iterator();

				while (informacoes.hasNext()) {
					numeros[posicao].setText(informacoes.next());
					posicao++;					
				}
			}
		});
	}
}
