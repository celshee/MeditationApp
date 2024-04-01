package com.example.meditation_app;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Focus extends AppCompatActivity {
    Button firstFragmentBtn, secondFragmentBtn,thirdFragmentBtn,fourthFragmentBtn,fivthFragmentBtn,sixthFragmentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus);



                firstFragmentBtn = findViewById(R.id.fragment1btn);
                secondFragmentBtn = findViewById(R.id.fragment2btn);
                thirdFragmentBtn = findViewById(R.id.button3);
                fourthFragmentBtn= findViewById(R.id.button4);
                fivthFragmentBtn = findViewById(R.id.button5);
                sixthFragmentBtn = findViewById(R.id.button6);


                firstFragmentBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        replaceFragment(new fragmen1());

                    }
                });

                secondFragmentBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        replaceFragment(new fragmen2());

                    }
                });

                thirdFragmentBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        replaceFragment(new fragmen3());

                    }
                });
                fourthFragmentBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        replaceFragment(new fragmen4());

                    }
                });
                fivthFragmentBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        replaceFragment(new fragmen5());

                    }
                });
                sixthFragmentBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        replaceFragment(new fragmen6());

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