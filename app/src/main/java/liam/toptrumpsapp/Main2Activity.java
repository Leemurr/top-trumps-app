package liam.toptrumpsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    public float playerAttribute;
    public float cpuAttribute;
    public int plyScore = 0;
    public int cpuScore = 0;
    public boolean plyWin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        game2();
    }

    public void game2() {

        Bundle bundle = this.getIntent().getExtras();
        int plyChc = bundle.getInt("playerChoice", 0);
        float[] plyAtts = bundle.getFloatArray("playerAtts");
        float[] cpuAtts = bundle.getFloatArray("cpuAtts");
        String attName = bundle.getString("attyName");

        playerAttribute = plyAtts[plyChc - 1];
        cpuAttribute = cpuAtts[plyChc - 1];

        TextView tv5 = (TextView) findViewById(R.id.textView5);
        tv5.setText("You picked: " + attName);

        //prints out player and cpu attribute stats
        if (playerAttribute < 0 ){
            TextView tv2 = (TextView) findViewById(R.id.updateable_txt2);
            tv2.setText("Your Attribute: " + -playerAttribute + "\nCPU Attribute: " + -cpuAttribute);
        }
        else {
            TextView tv3 = (TextView) findViewById(R.id.updateable_txt2);
            tv3.setText("Your Attribute: " + playerAttribute + "\nCPU Attribute: " + cpuAttribute);
        }

        //compare attributes
        if (playerAttribute > cpuAttribute) {
            plyScore = plyScore + 1;
            TextView tv4 = (TextView) findViewById(R.id.updateable_txt4);
            tv4.setText("PLAYER 1 WINS\nPLAYER SCORE: " + plyScore + "\nCPU SCORE: " + cpuScore + "\n");

            plyWin = true;

        } else {
            cpuScore = cpuScore + 1;
            TextView tv4 = (TextView) findViewById(R.id.updateable_txt4);
            tv4.setText("CPU WINS\n PLAYER SCORE: " + plyScore + "\nCPU SCORE: " + cpuScore + "\n");
            plyWin = false;
        }




    }

}
