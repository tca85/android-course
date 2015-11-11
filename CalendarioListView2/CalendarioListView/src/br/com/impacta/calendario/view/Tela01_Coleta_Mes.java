package br.com.impacta.calendario.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Tela01_Coleta_Mes extends Activity {

	//-- Passo 1 - Declarando os Atributos
	private TextView txtTexto;
	private Button btnProxima;
	private ListView lsvDados;
	
	private Intent itTela;
	//---------------------------------------
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_padrao);
        
        //-- Passo 2 - Vincular
        txtTexto = (TextView)findViewById(R.id.txtTexto);
        btnProxima = (Button)findViewById(R.id.btnProxima);
        lsvDados = (ListView)findViewById(R.id.lsvDados);
    
        //-- Passo 3 - Adaptador
        
        final String[] dados = {"JAN","FEV","MAR","ABR","MAI","JUN","JUL","AGO","SET","OUT","NOV","DEZ"};
        
        ArrayAdapter<String> adaptador =
        new ArrayAdapter<String>
        (
        		Tela01_Coleta_Mes.this, 
        		android.R.layout.simple_list_item_single_choice,
        		dados
        );
        
        //-- Passo 4 - Vincular o adaptador com o ListView
        lsvDados.setAdapter(adaptador);
        
        //-- Passo 5 - Configurar o ListView com o modo de escolha
        lsvDados.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        
        //-- Passo 6 - Elaborar o Intent
        itTela = new Intent(Tela01_Coleta_Mes.this,Tela02_Coleta_Dia.class);
        
        //-- Passo 7 - Elaborar o Evento do Botao
        btnProxima.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				//-------------------------------------
				//-- Armazenar os dados no Intent
				int pos = lsvDados.getCheckedItemPosition();
				
				String informacao = ((pos+1)<10?"0":"")+(pos+1);
				
				itTela.putExtra("mes", informacao);
				//-- Enviar os dados e acionar o Intent
				startActivity(itTela);
				//-------------------------------------
			}
		});
        //----------------------------------------
    }

}