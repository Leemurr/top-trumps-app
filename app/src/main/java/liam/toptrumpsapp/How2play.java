package liam.toptrumpsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class How2play extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how2play);
        rules();
    }


    public void rules() {
        TextView tv = (TextView) findViewById(R.id.textView4);
        tv.setText("\n○ Each player is dealt 3 cards\n\n○ The first player picks any attribute from their top card\n\n○ The second player then picks the same attribute from their card\n\n○ The cards are then compared against each other\n\n○ The winner is whoever has the highest number for that attribute\n\n○ You repeat until you've used all your cards\n\n ○ The overall winner is whoever scored the most wins!");
    }

    public void onClicker1(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

