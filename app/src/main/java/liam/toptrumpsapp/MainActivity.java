package liam.toptrumpsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick1(View view) {
        Intent intentt = new Intent(this, Main3Activity.class);
        startActivity(intentt);
    }

    public void onClick2(View view) {
        Intent intent = new Intent(this, How2play.class);
        startActivity(intent);
    }

    public void onClick3(View view) {
        System.exit(0);
    }
}




