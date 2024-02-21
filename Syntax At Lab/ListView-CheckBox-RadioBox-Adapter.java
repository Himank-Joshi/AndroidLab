//all imports used in code 
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


//LIST VIEW AND ADAPTER
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


// Radio Button and check box 

fb=findViewById(R.id.checkBox);
bb=findViewById(R.id.checkBox2);
ten=findViewById(R.id.checkBox3);
btn=findViewById(R.id.button3);
user=findViewById(R.id.textView3);
num=findViewById(R.id.textView4);
fav=findViewById(R.id.radioGroup);

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