package br.com.impacta.autoramafipe.view;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import br.com.impacta.autoramafipe.model.Marca;

public class Main extends Activity implements OnClickListener {
	private Button btnDownloadMarca;
	private ProgressDialog mLoginDialog;
	private ListView lsvMarcas;

	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			int valor = msg.what;

			if (valor == 0) {

				try {

				} catch (Exception e) {
					Toast.makeText(getApplicationContext(),
							e.getMessage().toString(), Toast.LENGTH_LONG)
							.show();
				}

			} else {
				Toast.makeText(getApplicationContext(), "bosta",
						Toast.LENGTH_LONG).show();

			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		lsvMarcas = (ListView) findViewById(R.id.lsvMarcas);

		btnDownloadMarca = (Button) findViewById(R.id.btnDownloadMarca);
		btnDownloadMarca.setOnClickListener(this);
	}

	/**
	 * Controla o evento click
	 */
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btnDownloadMarca) {
			try {
				exibirListaModelos();
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(),
						e.getMessage().toString(), Toast.LENGTH_LONG).show();
			}
		}
	}

	/**
	 * Fazer download da lista (JSON) com o modelo dos carros
	 */
	private void exibirListaModelos() throws Exception {
		mLoginDialog = new ProgressDialog(this);
		mLoginDialog.setCancelable(true);
		mLoginDialog.setMessage("Aguarde, buscando dados no WebService");
		mLoginDialog.show();

		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				try {
					List<Marca> listaModeloCarros = obterJSONListaModelos();

					ArrayAdapter<Marca> adaptador = new ArrayAdapter<Marca>(
							Main.this, android.R.layout.simple_list_item_1,
							listaModeloCarros);

					lsvMarcas.setAdapter(adaptador);

					handler.sendEmptyMessage(0);

				} catch (Exception e) {
					Toast.makeText(getApplicationContext(),
							e.getMessage().toString(), Toast.LENGTH_LONG)
							.show();
				}
			}
		};

		new Thread(runnable).start();
	}

	/**
	 * Retornar JSON com as marcas
	 * 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	private ArrayList<Marca> obterJSONListaModelos() throws Exception {
		ArrayList<Marca> colecao_marcas = new ArrayList<Marca>();

		try {
			URL url = new URL(
					"http://fipeapi.appspot.com/api/1/carros/marcas.json");

			HttpURLConnection urlConnection = null;

			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setDoInput(true);
			urlConnection.connect();

			InputStream inputStream = new BufferedInputStream(
					urlConnection.getInputStream());
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream);
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			StringBuffer arquivo = new StringBuffer();
			String linha = new String();

			while ((linha = bufferedReader.readLine()) != null) {
				String item = new String(linha.getBytes("UTF-8"));

				arquivo.append(item);
			}

			JSONObject jsonMarcas = new JSONObject(arquivo.toString());
			JSONArray dados = new JSONArray(jsonMarcas);

			for (int posicao = 0; posicao < dados.length(); posicao++) {
				JSONObject jsonObject = (JSONObject) dados.get(posicao);

				Marca marca = new Marca();

				marca.setName(jsonObject.getString("name"));
				marca.setFipe_name(jsonObject.getString("fipe_name"));
				marca.setOrder(jsonObject.getInt("order"));
				marca.setKey(jsonObject.getString("key"));
				marca.setId(jsonObject.getInt("id"));

				colecao_marcas.add(marca);

				Log.i("MARCA", marca.toString());
			}

			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();

			if (urlConnection != null) {
				urlConnection.disconnect();
			}

			return colecao_marcas;

		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), e.getMessage().toString(),
					Toast.LENGTH_LONG).show();
		} finally {
			return colecao_marcas;
		}
	}
}
