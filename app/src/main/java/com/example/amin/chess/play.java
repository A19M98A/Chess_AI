package com.example.amin.chess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class play extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        final ImageView[][] views=new ImageView[8][8];

        views[0][0]=(ImageView) findViewById(R.id.a1);
        views[0][1]=(ImageView) findViewById(R.id.a2);
        views[0][2]=(ImageView) findViewById(R.id.a3);
        views[0][3]=(ImageView) findViewById(R.id.a4);
        views[0][4]=(ImageView) findViewById(R.id.a5);
        views[0][5]=(ImageView) findViewById(R.id.a6);
        views[0][6]=(ImageView) findViewById(R.id.a7);
        views[0][7]=(ImageView) findViewById(R.id.a8);
        views[1][0]=(ImageView) findViewById(R.id.b1);
        views[1][1]=(ImageView) findViewById(R.id.b2);
        views[1][2]=(ImageView) findViewById(R.id.b3);
        views[1][3]=(ImageView) findViewById(R.id.b4);
        views[1][4]=(ImageView) findViewById(R.id.b5);
        views[1][5]=(ImageView) findViewById(R.id.b6);
        views[1][6]=(ImageView) findViewById(R.id.b7);
        views[1][7]=(ImageView) findViewById(R.id.b8);
        views[2][0]=(ImageView) findViewById(R.id.c1);
        views[2][1]=(ImageView) findViewById(R.id.c2);
        views[2][2]=(ImageView) findViewById(R.id.c3);
        views[2][3]=(ImageView) findViewById(R.id.c4);
        views[2][4]=(ImageView) findViewById(R.id.c5);
        views[2][5]=(ImageView) findViewById(R.id.c6);
        views[2][6]=(ImageView) findViewById(R.id.c7);
        views[2][7]=(ImageView) findViewById(R.id.c8);
        views[3][0]=(ImageView) findViewById(R.id.d1);
        views[3][1]=(ImageView) findViewById(R.id.d2);
        views[3][2]=(ImageView) findViewById(R.id.d3);
        views[3][3]=(ImageView) findViewById(R.id.d4);
        views[3][4]=(ImageView) findViewById(R.id.d5);
        views[3][5]=(ImageView) findViewById(R.id.d6);
        views[3][6]=(ImageView) findViewById(R.id.d7);
        views[3][7]=(ImageView) findViewById(R.id.d8);
        views[4][0]=(ImageView) findViewById(R.id.e1);
        views[4][1]=(ImageView) findViewById(R.id.e2);
        views[4][2]=(ImageView) findViewById(R.id.e3);
        views[4][3]=(ImageView) findViewById(R.id.e4);
        views[4][4]=(ImageView) findViewById(R.id.e5);
        views[4][5]=(ImageView) findViewById(R.id.e6);
        views[4][6]=(ImageView) findViewById(R.id.e7);
        views[4][7]=(ImageView) findViewById(R.id.e8);
        views[5][0]=(ImageView) findViewById(R.id.f1);
        views[5][1]=(ImageView) findViewById(R.id.f2);
        views[5][2]=(ImageView) findViewById(R.id.f3);
        views[5][3]=(ImageView) findViewById(R.id.f4);
        views[5][4]=(ImageView) findViewById(R.id.f5);
        views[5][5]=(ImageView) findViewById(R.id.f6);
        views[5][6]=(ImageView) findViewById(R.id.f7);
        views[5][7]=(ImageView) findViewById(R.id.f8);
        views[6][0]=(ImageView) findViewById(R.id.g1);
        views[6][1]=(ImageView) findViewById(R.id.g2);
        views[6][2]=(ImageView) findViewById(R.id.g3);
        views[6][3]=(ImageView) findViewById(R.id.g4);
        views[6][4]=(ImageView) findViewById(R.id.g5);
        views[6][5]=(ImageView) findViewById(R.id.g6);
        views[6][6]=(ImageView) findViewById(R.id.g7);
        views[6][7]=(ImageView) findViewById(R.id.g8);
        views[7][0]=(ImageView) findViewById(R.id.h1);
        views[7][1]=(ImageView) findViewById(R.id.h2);
        views[7][2]=(ImageView) findViewById(R.id.h3);
        views[7][3]=(ImageView) findViewById(R.id.h4);
        views[7][4]=(ImageView) findViewById(R.id.h5);
        views[7][5]=(ImageView) findViewById(R.id.h6);
        views[7][6]=(ImageView) findViewById(R.id.h7);
        views[7][7]=(ImageView) findViewById(R.id.h8);

        int A= R.drawable.a;
        int B=R.drawable.p;

        final Chess Play=new Chess(views,A,B);

        for (int i=0; i<8; i++)
        {
            for (int j=0; j<8; j++)
            {
                final int finalI = i;
                final int finalJ = j;
                views[i][j].setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Play.Click(finalI,finalJ);
                    }
                });
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();





    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(View view) {



    }
}
