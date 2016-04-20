package butterycontent.finalexam;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class Activity2 extends AppCompatActivity {
    public static int HitCount = 1;
    public static String province = "";
    int counter =0;
    TextView hitCounter;
    ImageView flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        hitCounter = (TextView) findViewById(R.id.etxtCount);
        flag = (ImageView) findViewById(R.id.imageView);
       setCount();
        loadImage();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
}

    public void setCount(){

        String setHitCount;
        String setProv;

        SharedPreferences sp = getSharedPreferences(String.valueOf(HitCount), Context.MODE_PRIVATE);
        setHitCount = sp.getString("Hit", "");
        setProv = sp.getString("province", "");
        counter += Integer.parseInt(setHitCount) ;
        hitCounter.setText(String.valueOf(counter));



    }




    public void loadImage(){

        String setProv;

        SharedPreferences sp = getSharedPreferences(String.valueOf(province), Context.MODE_PRIVATE);

        setProv = sp.getString("province", "");

        ;



        //showImgHere.setBackgroundResource(R.drawable.fuzzAldrin);

        String name = setProv.toString();
        AssetManager manager = getAssets();

        try{

            InputStream in = manager.open(name);
            Log.d("Image Name", name );
            flag.setImageBitmap(BitmapFactory.decodeStream(in));

        }catch (Exception e){
            e.printStackTrace();

        }

    }


}
