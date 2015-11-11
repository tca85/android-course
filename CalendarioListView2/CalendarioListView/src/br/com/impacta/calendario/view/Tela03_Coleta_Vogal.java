package br.com.impacta.calendario.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Tela03_Coleta_Vogal extends Activity {

	//-- Passo 1 - Declarando os Atributos
	private TextView txtTexto;
	private Button btnProxima;
	private ListView lsvDados;
	
	private Intent itTela;
	private String mes;
	private String dia;
	//---------------------------------------
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_padrao);
        
        //-- Passo 2 - Vincular
        txtTexto = (TextView)findViewById(R.id.txtTexto);
        
        //-- Recuperando dados do Intent
        Bundle bundle = getIntent().getExtras();
        mes = bundle.getString("mes");
        dia = bundle.getString("dia");
        
        txtTexto.setText(mes + " >> " + dia);
        
        btnProxima = (Button)findViewById(R.id.btnProxima);
        lsvDados = (ListView)findViewById(R.id.lsvDados);
    
        //-- Passo 3 - Adaptador
        TreeSet<String> dados = new TreeSet<String>(); 
        dados.add("E");
        dados.add("U");
        dados.add("O");
        dados.add("U");
        dados.add("A");
        dados.add("A");
        dados.add("I");
        dados.add("U");
        dados.add("A");
        dados.add("I");
        dados.add("I");
        dados.add("E");
        
        Iterator<String> iterator = dados.iterator();
        
        final ArrayList<String> ordem = new ArrayList<String>();
        
        while(iterator.hasNext()) {
        	ordem.add(iterator.next().toString());
        }
        
        ArrayAdapter<String> adaptador =
        new ArrayAdapter<String>
        (
        		Tela03_Coleta_Vogal.this, 
        		android.R.layout.simple_list_item_single_choice,
        		ordem
        );
        
        //-- Passo 4 - Vincular o adaptador com o ListView
        lsvDados.setAdapter(adaptador);
        
        //-- Passo 5 - Configurar o ListView com o modo de escolha
        lsvDados.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        
        //-- Passo 6 - Elaborar o Intent
        itTela = new Intent(Tela03_Coleta_Vogal.this,Tela04_Apresenta_Datas.class);
        
        //-- Passo 7 - Elaborar o Evento do Botao
        btnProxima.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				//-------------------------------------
				//-- Armazenar os dados no Intent
		
				int coleta = lsvDados.getCheckedItemPosition();
				
				String vogal = ordem.get(coleta);
				
				itTela.putExtra("mes"  , mes);
				itTela.putExtra("dia"  , dia);
				itTela.putExtra("vogal", vogal);
				
				//-- Enviar os dados e acionar o Intent
				startActivity(itTela);
				//-------------------------------------
			}
		});
        //----------------------------------------
    }

}