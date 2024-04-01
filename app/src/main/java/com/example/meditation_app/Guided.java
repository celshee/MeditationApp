package com.example.meditation_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.Button;


public class Guided extends AppCompatActivity {
    Button firstFragmentBtn, secondFragmentBtn,thirdFragmentBtn,fourthFragmentBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guided);


                firstFragmentBtn = findViewById(R.id.fragment1btn);
                secondFragmentBtn = findViewById(R.id.fragment2btn);
                thirdFragmentBtn = findViewById(R.id.button3);
                fourthFragmentBtn= findViewById(R.id.button4);



                firstFragmentBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        replaceFragment(new fragment1());

                    }
                });

                secondFragmentBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        replaceFragment(new fragment2());

                    }
                });

                thirdFragmentBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        replaceFragment(new fragment3());

                    }
                });
                fourthFragmentBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        replaceFragment(new fragment4());

                    }
                });



            }

            private void replaceFragment(Fragment fragment) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,fragment);
                fragmentTransaction.commit();

            }
        }