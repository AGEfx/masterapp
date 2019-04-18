package com.example.shaba.masterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int n; //количество нажатий
    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Spinner spinner;
    private int[] colors;
    private boolean spinnerVis;
    private boolean btnVis;
    private boolean btnElev;
    private boolean btnClick;
    private float rotation;
    private float elevation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colors = new int[]{R.color.red, R.color.green, R.color.yellow, R.color.blue, R.color.orange,R.color.pink,R.color.sea};
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);



        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {
                if (spinnerVis) {
                    String[] choose = getResources().getStringArray(R.array.colorslist);
                    button.setBackgroundColor(getResources().getColor(colors[selectedItemPosition]));
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Цвет кнопки сменился на : " + choose[selectedItemPosition], Toast.LENGTH_SHORT);
                    toast.show();
                    n = 0;
                }
                spinner.setVisibility(View.INVISIBLE);
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                n++;
                if (n == 5) {
                    button.setBackgroundColor(getResources().getColor(R.color.white));

                    button.setVisibility(View.VISIBLE);
                    btnVis = false;
                    button2.setText("Сделать невидимой");

                    elevation = 0;
                    button.setElevation(elevation);
                    btnElev = false;
                    button4.setText("Поднять");

                    button.setRotation(rotation=0);

                    button5.setText("Сделать некликабельной");
                    button.setClickable(true);
                    btnClick = false;

                    button.setTextSize(14);

                    button.setTextColor(getResources().getColor(R.color.black));
                    Toast.makeText(this, "Опа", Toast.LENGTH_SHORT).show();
                    n = 0;
                }
                break;

            case R.id.button1:
                spinnerVis = true;
                spinner.setVisibility(View.VISIBLE);
                break;

            case R.id.button2:
                if (!btnVis) {
                    button.setVisibility(View.INVISIBLE);
                    btnVis = true;
                    button2.setText("Сделать видимой");
                } else {
                    button.setVisibility(View.VISIBLE);
                    btnVis = false;
                    button2.setText("Сделать невидимой");
                }
                break;

            case R.id.button3:
                button.setRotation(rotation += 15);
                break;

            case R.id.button4:
                if (!btnElev) {
                    elevation = (float) Math.random() * 100;
                    button.setElevation(elevation);
                    btnElev = true;
                    button4.setText("Опустить");
                } else {
                    elevation = 0;
                    button.setElevation(elevation);
                    btnElev = false;
                    button4.setText("Поднять");
                }
                break;


            case R.id.button5:
                if (!btnClick) {
                    button.setClickable(false);
                    btnClick = true;
                    button5.setText("Сделать кликабельной");
                } else {
                    button5.setText("Сделать некликабельной");
                    button.setClickable(true);
                    btnClick = false;
                }
                break;

            case R.id.button6:
                button.setTextColor(getResources().getColor(colors[(int)(Math.random()*colors.length)]));
                break;

            case R.id.button7:
                button.setTextSize((float)Math.random()* 100);
                break;

            case R.id.button8:
                button.setTextSize(14);

            break;
        }
    }
}
