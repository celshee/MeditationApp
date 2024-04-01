package com.example.meditation_app;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;


public class Home extends AppCompatActivity {


        ImageButton imageButton1;
        ImageButton imageButton2;
        ImageButton imageButton3;
        ImageButton imageButton4;
        ImageButton imageButton5;
        ImageButton imageButton6;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
            imageButton1 = findViewById(R.id.imageButton1);
            imageButton2 = findViewById(R.id.imageButton2);
            imageButton3 = findViewById(R.id.imageButton3);
            imageButton4 = findViewById(R.id.imageButton4);
            imageButton5 = findViewById(R.id.imageButton5);
            imageButton6 = findViewById(R.id.imageButton6);
            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Home.this, Mind.class);
                    startActivity(intent);
                }
            });
            imageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Home.this, Focus.class);
                    startActivity(intent);            }
            });

            imageButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Home.this,Kind.class);
                    startActivity(intent);            }
            });

            imageButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Home.this,Guided.class);
                    startActivity(intent);               }
            });

            imageButton5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Home.this,Open.class);
                    startActivity(intent);            }
            });

            imageButton6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Home.this,Login.class);
                    startActivity(intent);            }
            });

        }
    }

