package com.example.prac1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

     Button btnI,btn,btnN;
     TextView user,num;
     CheckBox fb,bb,ten;
     RadioGroup fav;
     ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Getting Intent Data
         String str1=getIntent().getStringExtra("str1");
         int num1=getIntent().getIntExtra("num1",0);//0=default val
        btnI=findViewById(R.id.button2);
        fb=findViewById(R.id.checkBox);
        bb=findViewById(R.id.checkBox2);
        ten=findViewById(R.id.checkBox3);
        btn=findViewById(R.id.button3);
        user=findViewById(R.id.textView3);
        num=findViewById(R.id.textView4);
        fav=findViewById(R.id.radioGroup);
        btnN=findViewById(R.id.button4);
        user.setText(str1);
        num.setText(String.valueOf(num1));
        //adapter
        listview=findViewById(R.id.listview);
        String[] values = new String[] { "FootBall","Cricket","BasketBall","Tennis ","BaseBall"  };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listview.setAdapter(adapter);

        // getting item clicked in adapter

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity2.this,values[position],Toast.LENGTH_SHORT).show();
            }
        });



        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=" Options Selected : ";
                if(fb.isChecked())
                    s+=String.valueOf(fb.getText());
                if(bb.isChecked())
                    s+=String.valueOf(bb.getText());
                s+="\n Favorite Sport = ";
                int op=fav.getCheckedRadioButtonId();
                //To get Fav sports string message
                if(op!=-1) {
                    RadioButton favsport = fav.findViewById(op);

                    s += String.valueOf(favsport.getText());
                }
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            }
        });

        btnN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(i);
            }
        });

    }
}