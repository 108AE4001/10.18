package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Main2Activity extends AppCompatActivity {
    private Button send_btn;
    private EditText set_drink;
    private RadioGroup rg1,rg2;

    private String suger = "無糖";
    private String ice_opt = "微冰";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rg1 = findViewById(R.id.raidoGroup);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,int i){
                switch (i){
                    case R.id.radioButton1:
                        suger = "無糖" ;
                        break;
                    case R.id.radioButton2:
                        suger = "少糖";
                        break;
                    case R.id.radioButton3:
                        suger = "半糖";
                        break;
                    case R.id.radioButton4:
                         suger = "全糖";
                         break;
                }
            }

        });
        rg2 = findViewById(R.id.radioGroup2);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup radioGroup,int i){
                switch (i){
                    case R.id.radioButton5:
                        ice_opt = "微冰";
                        break;
                    case R.id.radioButton6:
                        ice_opt = "少冰";
                        break;
                    case R.id.radioButton7:
                        ice_opt = "正常冰";
                        break;
                }
            }
        });
        send_btn = findViewById(R.id.button3);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_drink = findViewById(R.id.edit_drink);
                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putString("suger",suger);
                b.putString("drink", String.valueOf(set_drink.getText()));
                b.putString("ice",ice_opt);
                i.putExtras(b);
                setResult(101,i);
                finish();
            }
        });
    }
}
