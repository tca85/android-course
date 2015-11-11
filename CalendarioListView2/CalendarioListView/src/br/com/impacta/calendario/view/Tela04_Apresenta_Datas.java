package br.com.impacta.calendario.view;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import br.com.impacta.calendario.controller.Calendario;
import br.com.impacta.calendario.controller.Feriado;

public class Tela04_Apresenta_Datas extends Activity {

	//-- Passo 1 - Declarando os Atributos
	private TextView txtTexto;
	private Button btnProxima;
	private ListView lsvDados;
	
	private Intent itTela;
	private String mes;
	private String dia;
	private String vogal;
	private Calendario calendario = new Calendario();
	//---------------------------------------
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_padrao);
        
        //-- Passo 2 - Vincular
        txtTexto = (TextView)findViewById(R.id.txtTexto);
        
        //-- Recuperando Dados do Intent
        Bundle bundle = getIntent().getExtras();
        mes   = bundle.getString("mes");
        dia   = bundle.getString("dia");
        vogal = bundle.getString("vogal");
        
        txtTexto.setText(mes + " >> " + dia + " >> " + vogal);
        
        btnProxima = (Button)findViewById(R.id.btnProxima);
        lsvDados = (ListView)findViewById(R.id.lsvDados);
    
        //-- Passo 3 - Adaptador
        //String[] dados = {"JAN","FEV","MAR","ABR","MAI","JUN","JUL","AGO","SET","OUT","NOV","DEZ"};
        
        ArrayList<Feriado> dados =
        calendario.pesquisarDatas(mes, dia);
        
        ArrayAdapter<Feriado> adaptador =
        new ArrayAdapter<Feriado>
        (
        		Tela04_Apresenta_Datas.this, 
        		android.R.layout.simple_list_item_single_choice,
        		dados
        );
        
        //-- Passo 4 - Vincular o adaptador com o ListView
        lsvDados.setAdapter(adaptador);
        
        //-- Passo 5 - Configurar o ListView com o modo de escolha
        lsvDados.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        
        //-- Passo 6 - Elaborar o Intent
        itTela = new Intent(Tela04_Apresenta_Datas.this,Tela01_Coleta_Mes.class);
        
        //-- Passo 7 - Elaborar o Evento do Botao
        btnProxima.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				//-------------------------------------
				//-- Armazenar os dados no Intent
				
				
				//-- Enviar os dados e acionar o Intent
				startActivity(itTela);
				//-------------------------------------
			}
		});
        //----------------------------------------
    }

}