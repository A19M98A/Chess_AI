package com.example.amin.chess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Chess
{
    boolean F;
    int[][] Flat=new int[8][8];
    ImageView[][] views;
    int x,y;
    AIch Ai;
    public Chess(ImageView[][] views, int A, int B)
    {
        this.views=views;
        for (int i=0; i < 8; i++)
        {
            for (int j=0; j < 8; j++)
            {
                if (i<2)
                    Flat[i][j]=1;
                else if (i>5)
                    Flat[i][j]=2;
                else
                    Flat[i][j]=0;
            }
        }

        for (int i=0; i<2; i++)
        {
            for (int j=0; j<8; j++)
            {
                views[i][j].setImageResource(A);
            }
        }
        for (int i=6; i<8; i++)
        {
            for (int j=0; j<8; j++)
            {
                views[i][j].setImageResource(B);
            }
        }
    }
    public void Click(int I, int J)
    {
        if (Flat[I][J]==2 && I!=0)
        {
            for (int i=0; i<8; i++)
                for (int j=0; j<8; j++)
                    if (Flat[i][j]<2) {
                        if (Flat[i][j] == 0) {
                            views[i][j].setImageBitmap(null);
                        } else {
                            views[i][j].setImageResource(R.drawable.a);
                        }
                    }
            if (J != 0)
                if (Flat[I - 1][J - 1] < 2)
                    views[I - 1][J - 1].setImageResource(Flat[I - 1][J - 1]==0?R.drawable.y:R.drawable.ra);
            if (Flat[I - 1][J]==0)
                views[I - 1][J].setImageResource(R.drawable.y);
            if (J != 7)
                if (Flat[I - 1][J + 1] < 2)
                    views[I - 1][J + 1].setImageResource(Flat[I - 1][J + 1]==0?R.drawable.y:R.drawable.ra);
            x=I;
            y=J;
            F=true;
        }
        else if (F)
        {
            for (int i=0; i<8; i++)
                for (int j=0; j<8; j++)
                    if (Flat[i][j]!=2) {
                        if (Flat[i][j] == 0) {
                            views[i][j].setImageBitmap(null);
                        } else {
                            views[i][j].setImageResource(R.drawable.a);
                        }
                    }
            if (x - 1 == I && (y == J || y - 1 == J || y + 1 == J) && (Flat[I][J] == 0 || J != y)  && Flat[I][J] != 2) {
                F=false;
                views[I][J].setImageResource(R.drawable.p);
                Flat[I][J] = 2;
                Flat[x][y]=0;
                views[x][y].setImageBitmap(null);
                for (int i=0; i<8; i++)
                    for (int j=0; j<8; j++)
                        if (Flat[i][j]<2) {
                            if (Flat[i][j] == 0) {
                                views[i][j].setImageBitmap(null);
                            } else {
                                views[i][j].setImageResource(R.drawable.a);
                            }
                        }
                AIch AI=new AIch(Flat);
                int[] AIP=AI.AIPlay(4);
                Flat[AIP[0]][AIP[1]] = 1;
                Flat[AIP[3]][AIP[4]]=0;
                views[AIP[0]][AIP[1]].setImageResource(R.drawable.a);
                views[AIP[3]][AIP[4]].setImageBitmap(null);
            }
        }
        if (I == 0) F=false;
    }
}
