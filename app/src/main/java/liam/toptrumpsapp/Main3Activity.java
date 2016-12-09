package liam.toptrumpsapp;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import java.util.Arrays;
        import java.util.Random;

public class Main3Activity extends AppCompatActivity {

    public boolean intro = true;
    public deck playerCard;
    public deck cpuCard;
    public int round = 0;
    public boolean plyWin = true;
    public int plyChc;
    public int rnd;
    public deck[] myDeck;
    float[] plyAtts = new float[6];
    float[] cpuAtts = new float[6];
    public String attName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        game();
    }

    public void sendData(){
        Bundle bundle = new Bundle();
        bundle.putInt("playerChoice", plyChc);
        bundle.putString("attyName", attName);
        bundle.putFloatArray("playerAtts", plyAtts);
        bundle.putFloatArray("cpuAtts", cpuAtts);
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    public void onClickHandler2(View view) {
        plyChc = 1;
        attName = "Weight";
        sendData();
    }

    public void onClickHandler3(View view) {
        plyChc = 2;
        attName = "Damage";
        sendData();
    }

    public void onClickHandler4(View view) {
        plyChc = 3;
        attName = "Reload Speed";
        sendData();
    }

    public void onClickHandler5(View view) {
        plyChc = 4;
        attName = "Magazine Size";
        sendData();
    }

    public void onClickHandler6(View view) {
        plyChc = 5;
        attName = "Accuracy";
        sendData();
    }

    public void onClickHandler7(View view) {
        plyChc = 6;
        attName = "Range";
        sendData();
    }


    public void game() {
        deck[] weaponList = new deck[6];
        weaponList[0] = new weapon(-12.4f, 85, -4.5f, 6, 75, 10, "Shotgun");
        weaponList[1] = new weapon(-3.2f, 25, -0.8f, 12, 70, 60, "Pistol");
        weaponList[2] = new weapon(-5.4f, 35, -1.4f, 22, 60, 60, "SMG");
        weaponList[3] = new weapon(-5.2f, 50, -1.8f, 32, 80, 80, "Rifle");
        weaponList[4] = new weapon(-6.8f, 75, -2.0f, 8, 90, 110, "Sniper Rifle");
        weaponList[5] = new weapon(-11.3f, 100, -6.0f, 1, 55, 100, "Rocket Launcher");

        myDeck = Arrays.copyOf(weaponList, weaponList.length);

        //shuffles the deck
        int n = myDeck.length;
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            deck temp = myDeck[r];
            myDeck[r] = myDeck[i];
            myDeck[i] = temp;
        }

        //new arrays to store each players hand of cards
        deck[] playerHand = new deck[3];
        deck[] cpuHand = new deck[3];

        //The cards are "dealt" 1 by 1 starting with the player.
        playerHand[0] = myDeck[0];
        playerHand[1] = myDeck[2];
        playerHand[2] = myDeck[4];
        cpuHand[0] = myDeck[1];
        cpuHand[1] = myDeck[3];
        cpuHand[2] = myDeck[5];

        //get next card
        playerCard = playerHand[round];
        cpuCard = cpuHand[round];

        //prints out the players card
        TextView tv = (TextView) findViewById(R.id.updateable_txt);
        tv.setText("Your card is: " + playerCard.name);

        //This array stores all player attributes for their chosen card.
        plyAtts[0] = playerCard.att1;
        plyAtts[1] = playerCard.att2;
        plyAtts[2] = playerCard.att3;
        plyAtts[3] = playerCard.att4;
        plyAtts[4] = playerCard.att5;
        plyAtts[5] = playerCard.att6;

        //This array stores all CPU attributes for their card.
        cpuAtts[0] = cpuCard.att1;
        cpuAtts[1] = cpuCard.att2;
        cpuAtts[2] = cpuCard.att3;
        cpuAtts[3] = cpuCard.att4;
        cpuAtts[4] = cpuCard.att5;
        cpuAtts[5] = cpuCard.att6;



        TextView tv2 = (TextView) findViewById(R.id.updateable_txt3);
        tv2.setText("Pick an attribute!");

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText("Weight:     " + plyAtts[0]);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setText("Damage:     " + plyAtts[1]);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setText("Reload Speed:     " + plyAtts[2]);

        Button button5 = (Button) findViewById(R.id.button5);
        button5.setText("Magazine Size:     " + plyAtts[3]);

        Button button6 = (Button) findViewById(R.id.button6);
        button6.setText("Accuracy:     " + plyAtts[4]);

        Button button7 = (Button) findViewById(R.id.button7);
        button7.setText("Range:     " + plyAtts[5]);



    }

}