package com.example.tictactoe_2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ImageView imageView;
String[][] check;
View[][] imageid;
ArrayList chance;
TextView winner;
ArrayList<ImageView> imageViews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViews=new ArrayList<ImageView>();
        winner=(TextView)findViewById(R.id.winner);
 chance=new ArrayList();
 chance.add("x");

        check =new String[3][3];
        for(int i=0;i<=2;i++){
            for(int j=0;j <=2;j++){
                check[i][j]="null";
            }
        }
imageid=new View[3][3];
        imageid[0][0]=findViewById(R.id.img0);
        imageid[0][1]=findViewById(R.id.img1);
        imageid[0][2]=findViewById(R.id.img2);
        imageid[1][0]=findViewById(R.id.img3);
        imageid[1][1]=findViewById(R.id.img4);
        imageid[1][2]=findViewById(R.id.img5);
        imageid[2][0]=findViewById(R.id.img6);
        imageid[2][1]=findViewById(R.id.img7);
        imageid[2][2]=findViewById(R.id.img8);


    }

    public void drawImage(View view) {


   imageView=(ImageView)view.findViewById(view.getId());
   imageViews.add(imageView);
for(int i=0;i<=2;i++){
    for(int j=0;j<=2;j++){
        if(imageid[i][j]==imageView){
            if(check[i][j]=="null"){
             if(chance.get(chance.size()-1)=="x"){
                 imageView.setImageResource(R.drawable.x);
                 check[i][j]="x";
                 chance.add("o");
             }else if(chance.get(chance.size()-1)=="o"){
                 imageView.setImageResource(R.drawable.zero);
                 check[i][j]="o";
                 chance.add("x");
             }

            }
        }
    }
}

             winnerX();
             winnerO();

    }

    private void winnerO() {

        for(int i=0;i<=2;i++){
            if(check[i][0]=="o" && check[i][1]=="o" && check[i][2]=="o"){
                winner.setText(" O  winner");
                clearScreen();
            }
        }

        for(int i=0;i<=2;i++){
            if(check[0][i]=="o"&& check[1][i] =="o" && check[2][i]=="o"){
                winner.setText("O winner");
                clearScreen();
            }


            if(check[0][0]=="o"&& check[1][1]=="o" && check[2][2]=="o" ){
                winner.setText("O winner");
                clearScreen();
            }
            if(check[0][2]=="o"&& check[1][1]=="o" && check[2][0]=="o" ){
                winner.setText("O winner");
                clearScreen();
            }

        }

    }

    private void clearScreen() {
        SystemClock.sleep(2000);
        for(ImageView image:imageViews){
            image.setVisibility(View.GONE);
        }
    }

    private void winnerX() {
        for(int i=0;i<=2;i++){
          if(check[i][0]=="x" && check[i][1]=="x" && check[i][2]=="x"){
              winner.setText(" X  winner");
              clearScreen();
          }
        }

        for(int i=0;i<=2;i++){
            if(check[0][i]=="x"&& check[1][i] =="x"&& check[2][i]=="x"){
                winner.setText("X winner");
                clearScreen();
            }


                if(check[0][0]=="x"&& check[1][1]=="x" && check[2][2]=="x" ){
                    winner.setText("X winner");
                    clearScreen();
                }
            if(check[0][2]=="x"&& check[1][1]=="x" && check[2][0]=="x" ){
                winner.setText("X winner");
                clearScreen();
            }

        }



    }
}