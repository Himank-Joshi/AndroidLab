//main
package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;

    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.editTextText);
        et2=findViewById(R.id.editTextText2);
        et3=findViewById(R.id.editTextText3);
        et4=findViewById(R.id.editTextText4);
        bt=findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n,p,e,ph;
                n=String.valueOf(et1.getText());
                p=String.valueOf(et2.getText());
                e=String.valueOf(et3.getText());
                ph=String.valueOf(et4.getText());
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String MobilePattern = "[0-9]+";
                int flag=0;
                if(e.matches(emailPattern)&& ph.matches(MobilePattern) && ph.length()==10){
                    flag=1;
                }
                if(flag==0){
                    Toast.makeText(MainActivity.this, "enter correct format", Toast.LENGTH_SHORT).show();
                } else if (flag==1 && n.equals("raiyan") && p.equals("123")) {
                    Intent intent=new Intent(MainActivity.this,hobbies.class);
                    startActivity(intent);
                }
            }
        });
    }
}


//quiz


package com.example.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class quiz extends AppCompatActivity {
    TextView tv;
    ListView lv;
    String[] items={"pen","pencil","eraser","laptop","sharpner","mobile","helmet"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        tv=findViewById(R.id.textView7);
        lv=findViewById(R.id.listview);

        String str= getIntent().getStringExtra("hobby");
        tv.setText(str);
        ArrayAdapter arr =new ArrayAdapter<String>(quiz.this, android.R.layout.simple_list_item_1,items );
        lv.setAdapter(arr);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(quiz.this, "bsdk"+ items[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}



//hobbies


package com.example.registration;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class hobbies extends AppCompatActivity {

    Button btn;

    RadioGroup rg;
    CheckBox ch1,ch2,ch3;
    String str2="";
    String str="";
    int score=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);
        btn=findViewById(R.id.button2);
        rg=findViewById(R.id.radioGroup3);
        ch1=findViewById(R.id.checkBox4);
        ch2=findViewById(R.id.checkBox5);
        ch3=findViewById(R.id.checkBox6);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ans1=rg.getCheckedRadioButtonId();
                if(ans1!=-1){
                    RadioButton rb=rg.findViewById(ans1);
                    str=String.valueOf(rb.getText().toString());
                }

                if(ch1.isChecked()){
                    str2=str2+String.valueOf(ch1.getText().toString());
                } else if (ch2.isChecked()) {
                    str2+=String.valueOf( ch2.getText().toString());

                }
                else
                    str2+=String.valueOf(ch3.getText().toString());
                String str7="football";
                String str8="dance";

                if(str.equals(str7) && str2.equals(str8)){
                    score=2;
                }else if (str2.equals(str8)) {
                    score=1;

                }
                else if(str.equals(str7)){
                    score=1;
                }
                else {
                    score=0;
                }
                new AlertDialog.Builder(hobbies.this)
                        .setTitle("title")
                        .setMessage("are you sure")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent= new Intent(hobbies.this,quiz.class);
                                startActivity(intent);

                                intent.putExtra("hobby",str);
                            }
                        }
                        ).setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(hobbies.this, "score is"+score, Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });



    }
}