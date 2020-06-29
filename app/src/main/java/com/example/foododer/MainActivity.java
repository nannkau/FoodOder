package com.example.foododer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String size;
    private String tortilla;
    private String fillings;
    private String bevergare;
    private ArrayList<CheckBox> checkBoxes;
    private ArrayList<CheckBox> checkBoxes1;
    private Button button;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillings="";
        bevergare="";
        checkBoxes= new ArrayList<>();
        checkBoxes1= new ArrayList<>();
        CheckBox checkBox= (CheckBox) findViewById(R.id.checkBox);
        checkBoxes.add(checkBox);
        CheckBox checkBox1= (CheckBox) findViewById(R.id.checkBox1);
        checkBoxes.add(checkBox1);
        CheckBox checkBox2= (CheckBox) findViewById(R.id.checkBox2);
        checkBoxes.add(checkBox2);
        CheckBox checkBox3= (CheckBox) findViewById(R.id.checkBox3);
        checkBoxes.add(checkBox3);
        CheckBox checkBox4= (CheckBox) findViewById(R.id.checkBox4);
        checkBoxes.add(checkBox4);
        CheckBox checkBox11= (CheckBox) findViewById(R.id.checkBox11);
        checkBoxes.add(checkBox11);
        CheckBox checkBox12= (CheckBox) findViewById(R.id.checkBox12);
        checkBoxes.add(checkBox12);
        CheckBox checkBox13= (CheckBox) findViewById(R.id.checkBox13);
        checkBoxes.add(checkBox13);
        CheckBox checkBox14= (CheckBox) findViewById(R.id.checkBox14);
        checkBoxes.add(checkBox14);
        CheckBox checkBox15= (CheckBox) findViewById(R.id.checkBox15);
        checkBoxes.add(checkBox15);
        CheckBox checkBox16= (CheckBox) findViewById(R.id.checkBox16);
        checkBoxes1.add(checkBox16);
        CheckBox checkBox17= (CheckBox) findViewById(R.id.checkBox17);
        checkBoxes1.add(checkBox17);
        CheckBox checkBox18= (CheckBox) findViewById(R.id.checkBox18);
        checkBoxes1.add(checkBox18);
        CheckBox checkBox19= (CheckBox) findViewById(R.id.checkBox19);
        checkBoxes1.add(checkBox19);
        radioButton= (RadioButton) findViewById(R.id.radioButton);
        radioButton2= (RadioButton) findViewById(R.id.radioButton2);
        radioButton3= (RadioButton) findViewById(R.id.radioButton3);
        radioButton4= (RadioButton) findViewById(R.id.radioButton4);
        button= (Button) findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillings="";
                bevergare="";
                if(radioButton.isChecked()) size= radioButton.getText().toString();
                if(radioButton2.isChecked()) size= radioButton2.getText().toString();
                if(radioButton3.isChecked()) tortilla= radioButton3.getText().toString();
                if(radioButton4.isChecked()) tortilla= radioButton4.getText().toString();
                for (int i=0; i< checkBoxes.size();i++){
                    CheckBox cb= checkBoxes.get(i);
                    if (cb.isChecked()){
//                        fillings.concat(cb.getText().toString()+",");
                        fillings=fillings+"\n +"+cb.getText().toString();
                    }
                }
                for (int i=0; i< checkBoxes1.size();i++){
                    CheckBox cb1= checkBoxes1.get(i);
                    if (cb1.isChecked()){
//                        bevergare.concat(cb.getText().toString()+",");
                        bevergare=bevergare+"\n +"+cb1.getText().toString();
                    }
                }
                if (fillings=="" && bevergare=="") Toast.makeText(MainActivity.this,"You haven't chosen any food yet",Toast.LENGTH_SHORT).show();
                else {

                    if(size == null || tortilla == null) Toast.makeText(MainActivity.this,"You have not selected the type of food",Toast.LENGTH_SHORT).show();
                   else{
                        Intent intent = new Intent(Intent.ACTION_SENDTO,             Uri.parse("sms:" + "0799554257"));
                        intent.putExtra("sms_body","I want a "+size+" tacos\nTortilla: "+tortilla+"\nFillings:"+fillings+"\nBevergare:"+bevergare+"\nThank you!");
                        startActivity(intent);
                    }

                }
//                Toast.makeText(MainActivity.this,"I want a"+size+" tacos.Tortilla "+tortilla+"Fillings:"+fillings+"Bevergare"+bevergare+". Thank you!",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
