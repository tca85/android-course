package br.com.impacta.deasafio02calendario.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import br.com.impacta.desafio02calendario.R;

public class Main extends Activity implements OnClickListener{

	//-----------------------------------------------------------------------------------	
	private ImageButton imbAnterior;
	private ImageButton imbProximo;
	private ListView    lsvDados;
	private TextView    txvData;
	private TextView    txvSemana;
	private Calendar    calendar = Calendar.getInstance();
	private Integer     qtdDias = 0;
	private Calendario  feriados = new Calendario();

	//-----------------------------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		imbAnterior = (ImageButton) findViewById(R.id.imbAnterior);
		imbProximo  = (ImageButton) findViewById(R.id.imbProximo);
		lsvDados    = (ListView)    findViewById(R.id.lsvDados);
		txvData     = (TextView)    findViewById(R.id.txvData);
		txvSemana   = (TextView)    findViewById(R.id.txvSemana);

		imbAnterior.setOnClickListener(this);
		imbProximo.setOnClickListener(this);

		String dataHoje[] = this.getData(qtdDias);

		txvData.setText(dataHoje[0]);
		txvSemana.setText(dataHoje[1]);
	}

	//-----------------------------------------------------------------------------------
	@Override
	public void onClick(View v) {
		if (v == imbAnterior) {
			this.getDataAnterior();

		}else if (v == imbProximo){
			this.getProximaData();
		}
	}

	//-----------------------------------------------------------------------------------
	/**
	 * Retorna a data e o dia da semana
	 * @return
	 */
	public String[] getData(int qtdDias){
		Calendar calendar = this.calendar;	
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		String dataAtual = new String();
		int diaSemana;

		String semana[] = 
			{"Domingo",
				"Segunda-Feira",
				"Terça-Feira",
				"Quarta-Feira",
				"Quinta-Feira",
				"Sexta-Feira",
				"Sábado"
			};

		calendar.add(Calendar.DATE, qtdDias);

		dataAtual = dateFormat.format(calendar.getTime());		
		diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
		diaSemana = diaSemana - 1;

		// tupla: permite retornar 'n' informações
		return new String[]{ dataAtual, semana[diaSemana]};		
	}
	//-----------------------------------------------------------------------------------
	public void getDataAnterior(){
		String dataAnterior[] = this.getData(qtdDias - 1);

		txvData.setText(dataAnterior[0]);
		txvSemana.setText(dataAnterior[1]);
		this.preencherListView(dataAnterior);
	}

	//-----------------------------------------------------------------------------------
	public void getProximaData(){
		String proximaData[] = this.getData(qtdDias + 1);

		txvData.setText(proximaData[0]);
		txvSemana.setText(proximaData[1]);
		this.preencherListView(proximaData);
	}

	//-----------------------------------------------------------------------------------
	public void preencherListView(String valor[]){
		String mes, dia;
		
		mes = "01";
		dia = "01";
		
		ArrayList<Feriado> dados = feriados.pesquisarDatas(mes, dia);

		ArrayAdapter<Feriado> adaptador = new ArrayAdapter<Feriado>(
				Main.this, 
				android.R.layout.simple_list_item_1, 
				feriados.sacola);

		lsvDados.setAdapter(adaptador);			
	}
}