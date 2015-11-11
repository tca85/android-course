package com.example.capitulo22.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private static final String MENSAGEM = "MENSAGEM";
	private ProgressBar progress;
	private TextView text;
	private Button button;
	
	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			Bundle bundle = msg.getData();
			String string = bundle.getString(MENSAGEM);
			
			TextView myTextView = (TextView)findViewById(R.id.textView1);
			myTextView.setText(string);
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		progress = (ProgressBar)findViewById(R.id.progressBar1);
		text = (TextView)findViewById(R.id.textView1);
		button = (Button)findViewById(R.id.button1);
		button.setOnClickListener(this);
	}
	
	private void startProgress() {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i <= 10; i++) {
					final int value = i;
					doProcessamento();
					
					progress.post(new Runnable() {
						
						@Override
						public void run() {
							text.setText("Processando");
							progress.setProgress(value);
						}
					});
				}
				
				Message msg = handler.obtainMessage();
				Bundle bundle = new Bundle();
				bundle.putString(MENSAGEM, "Concluído");
				msg.setData(bundle);
				handler.sendMessage(msg);
			}
		};
		new Thread(runnable).start();
	}
	
	private void doProcessamento() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		startProgress();
	}

}
