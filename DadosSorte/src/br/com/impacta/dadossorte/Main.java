package br.com.impacta.dadossorte;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;

public class Main extends Activity implements OnClickListener{
	private Button btnSortear;
	private ImageView imgv1;
	private ImageView imgv2;
	private ImageView imgv3;
	private RatingBar rjbJogadas;

	private Integer jogada = 1;
	private Integer jogadas = 10;
	private Integer acertors = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btnSortear = (Button) findViewById(R.id.btnSortear);
		imgv1      = (ImageView) findViewById(R.id.imgv1);
		imgv2      = (ImageView) findViewById(R.id.imgv2);
		imgv3      = (ImageView) findViewById(R.id.imgv3);
		rjbJogadas = (RatingBar) findViewById(R.id.rtbJogadas);

		btnSortear.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == btnSortear) {
			// 3, 7, 13, 18
			int sorteios[] = new int[3];
			//sorteios[0] = (int)	((Math.random()*5+1);
			//sorteios[1] = (int)	((Math.random()*5+1);
			//sorteios[2] = (int)	((Math.random()*5+1);
			
			//imagens[0].setImageResource(R.drawable.face3);


			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}

			Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
			vibrator.vibrate(600);
		}
	}
}