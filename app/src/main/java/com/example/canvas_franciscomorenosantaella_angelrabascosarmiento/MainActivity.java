package com.example.canvas_franciscomorenosantaella_angelrabascosarmiento;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    MediaPlayer mp2;
    MediaPlayer mp3;
    MediaPlayer mp4;
    MediaPlayer mp5;
    private LinearLayout canvasLayout;
    public Button button;
    private DisplayMetrics displaymetrics;
    public int cantidad = 0;
    public int ancho;
    public int altura;
    public Button rellenar;
    public Button cola;
    public Button vino;
    public int bebida = Color.CYAN;
    public Button water;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.canvasLayout = (LinearLayout) findViewById(R.id.canvasLayout);

        Vista vista = new Vista(this);
        mp = MediaPlayer.create(this, R.raw.drinksound);
        this.canvasLayout.addView(vista);
        button = findViewById(R.id.Beber);
        rellenar = findViewById(R.id.Rellenar);
        mp2 = MediaPlayer.create(this, R.raw.rellenarsound);
        cola = findViewById(R.id.Cocacola);
        vino = findViewById(R.id.Vino);
        mp3 = MediaPlayer.create(this, R.raw.cocacolaespuma);
        mp4 = MediaPlayer.create(this, R.raw.winesound);
        mp5 = MediaPlayer.create(this, R.raw.drinkwatersound);

    }

    class Vista extends View {
        public Vista(MainActivity context) {
            super(context);
        }

        public void onDraw(Canvas canvas) {
            ancho = canvas.getWidth();
            altura = canvas.getHeight();
            Paint paint = new Paint();
            paint.setColor(bebida);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(ancho, altura / 2, ancho / 2, cantidad, paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(30);
            paint.setColor(Color.BLACK);


            canvas.drawRect(ancho, altura / 2, ancho / 2, 0, paint);


        }


    }

    public void gluglu(View view) {

        mp.start();
        if (cantidad < altura / 2) {
            if (cantidad + 10 > altura / 2) {
                cantidad = altura / 2;
            }
            cantidad += 25;
        } else {
            Toast.makeText(this, "Te lo has bebido todo", Toast.LENGTH_SHORT).show();
        }

        Vista vista = new Vista(this);
        this.canvasLayout.removeAllViews();
        this.canvasLayout.addView(vista);


    }

    public void echarLiquido(View view){
       mp2.start();
        cantidad = 0;



        Vista vista = new Vista(this);
        this.canvasLayout.removeAllViews();
        this.canvasLayout.addView(vista);

    }

    public void colorCola(View view){
        mp3.setVolume(0.2f,0.2f);
        mp3.start();
        bebida = Color.rgb	(111,23,18);
        Vista vista = new Vista(this);
        this.canvasLayout.removeAllViews();
        this.canvasLayout.addView(vista);
    }

    public void colorVino(View view){
        mp4.start();
        bebida = Color.rgb(80, 19, 86);
        Vista vista = new Vista(this);
        this.canvasLayout.removeAllViews();
        this.canvasLayout.addView(vista);
    }

    public void colorWater(View view){
        mp5.start();
        bebida = Color.CYAN;
        Vista vista = new Vista(this);
        this.canvasLayout.removeAllViews();
        this.canvasLayout.addView(vista);
    }


}
