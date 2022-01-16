package com.example.canvas_franciscomorenosantaella_angelrabascosarmiento;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout canvasLayout;
    public Button button;
    private DisplayMetrics displaymetrics;
    public int cantidad = 0;
    public int  altura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.canvasLayout = (LinearLayout) findViewById(R.id.canvasLayout);

        Vista vista = new Vista(this);

        this.canvasLayout.addView(vista);
        button = findViewById(R.id.Beber);

    }

    class Vista extends View {
        public Vista(MainActivity context) {
            super(context);
        }

        public void onDraw(Canvas canvas) {
            int ancho = canvas.getWidth();
            altura = canvas.getHeight();
            Paint paint = new Paint();
            paint.setColor(Color.YELLOW);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(ancho, altura / 2, ancho / 2, cantidad, paint);

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(30);
            paint.setColor(Color.BLACK);



            canvas.drawRect(ancho, altura / 2, ancho / 2, 0, paint);



        }

        //Button button = findViewById(R.id.Beber);


    }

    public void gluglu(View view) {

            if (cantidad < altura/2) {
                if(cantidad +10 > altura/2){
                    cantidad = altura/2;
                }
                cantidad += 25;
            } else {
                Toast.makeText(this, "Te lo has bebido todo", Toast.LENGTH_SHORT).show();
            }

            Vista vista = new Vista(this);
            this.canvasLayout.removeAllViews();
            this.canvasLayout.addView(vista);


        }

    }
