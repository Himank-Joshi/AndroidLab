
//Main File 
public class MainActivity extends AppCompatActivity {
    GridView gridview;
    Button btn;
    private static final String channel_id = "my_channel";

    int[] images = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridview=findViewById(R.id.grid);
        gridview.setAdapter(new ImageAdapter(this,images));
        // just checking for string
        //String[] values = new String[] { "FootBall","Cricket","BasketBall","Tennis ","BaseBall"  };
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
         //       android.R.layout.simple_list_item_1, android.R.id.text1, values);
        //  gridview.setAdapter(adapter);    

    }

}

// Create Another class ImageAdapter
package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    Context context;
    int[] images = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6

    };

    public ImageAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgview;
        if (convertView == null) {
            imgview = new ImageView(context);
            imgview.setLayoutParams(new GridView.LayoutParams(350, 350));
            imgview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imgview = (ImageView) convertView;
        }

        imgview.setImageResource(images[position]);
        return imgview;
    }
}
