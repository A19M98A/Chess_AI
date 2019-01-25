package com.example.amin.chess;

public class AIch
{
    int[][] Flat=new int[8][8];
    List Childs=new List();
    AIch ch;
    public AIch(int[][] Flat)
    {
        this.Flat=Flat;
    }
    public int[][] Copy(int[][] A)
    {
        int[][] R=new int[8][8];
        for (int i=0; i<8; i++)
        {
            for (int j=0; j<8; j++)
            {
                R[i][j]=A[i][j];
            }
        }
        return R;
    }
    public int[] AIPlay(int v)
    {
        int[] R=new int[5];
        R[0]=0;
        R[1]=0;
        R[2]=0;
        R[3]=0;
        R[4]=0;
        if (v==0)
        {
            //hiuristic
            int S=0;
            for (int i=0; i<8; i++)
            {
                for (int j=0; j<8; j++)
                {
                    if (Flat[i][j]==1)
                    {
                        if (i>0)
                            if (j>0)
                                if (Flat[i-1][j-1]==1)
                                    S+=i*2;
                        if (i>0)
                            if (j<7)
                                if (Flat[i-1][j+1]==1)
                                    S+=i*2;
                        if (i<7)
                            if (j>0)
                                if (Flat[i+1][j-1]==2)
                                    S-=i*2;
                        if (i<7)
                            if (j<7)
                                if (Flat[i+1][j+1]==2)
                                    S-=i*2;
                        S+=i;
                    }
                    if (Flat[i][j]==2)
                    {
                        if (i>0)
                            if (j>0)
                                if (Flat[i-1][j-1]==1)
                                    S+=(7-i)*2;
                        if (i>0)
                            if (j<7)
                                if (Flat[i-1][j+1]==1)
                                    S+=(7-i)*2;
                        if (i<7)
                            if (j>0)
                                if (Flat[i+1][j-1]==2)
                                    S-=(7-i)*2;
                        if (i<7)
                            if (j<7)
                                if (Flat[i+1][j+1]==2)
                                    S-=(7-i)*2;
                        S-=(7-i)*4;
                    }
                }
            }
            R[2]=S;
            return R;
        }
        if (v%2==1)
            R[2]=100;
        else
            R[2]=-100;
        for (int i=0; i<8; i++)
        {
            for (int j=0; j<8; j++)
            {
                if (Flat[i][j]==1 && v%2==0 && i<7)
                {
                    if (Flat[i+1][j]==0)
                    {
                        int[][] PFlat=Copy(Flat);
                        PFlat[i][j]=0;
                        PFlat[i+1][j]=1;
                        AIch ch=new AIch(PFlat);
                        int[] P = ch.AIPlay(v-1);
                        if (P[2]>R[2])
                        {
                            R[0]=i+1;
                            R[1]=j;
                            R[2]=P[2];
                            R[3]=i;
                            R[4]=j;
                            this.ch=ch;
                        }
                    }
                    if (j != 7)
                    {
                        if (Flat[i+1][j+1]!=1)
                        {
                            int[][] PFlat=Copy(Flat);
                            PFlat[i][j]=0;
                            PFlat[i+1][j+1]=1;
                            AIch ch=new AIch(PFlat);
                            int[] P = ch.AIPlay(v-1);
                            if (P[2]>R[2])
                            {
                                R[0]=i+1;
                                R[1]=j+1;
                                R[2]=P[2];
                                R[3]=i;
                                R[4]=j;
                                this.ch=ch;
                            }
                        }
                    }
                    if (j != 0)
                    {
                        if (Flat[i+1][j-1]!=1)
                        {
                            int[][] PFlat=Copy(Flat);
                            PFlat[i][j]=0;
                            PFlat[i+1][j-1]=1;
                            AIch ch=new AIch(PFlat);
                            int[] P = ch.AIPlay(v-1);
                            if (P[2]>R[2])
                            {
                                R[0]=i+1;
                                R[1]=j-1;
                                R[2]=P[2];
                                R[3]=i;
                                R[4]=j;
                                this.ch=ch;
                            }
                        }
                    }
                }
                if (Flat[i][j]==2 && v%2==1 && i>0)
                {
                    if (Flat[i-1][j]==0)
                    {
                        int[][] PFlat=Copy(Flat);
                        PFlat[i][j]=0;
                        PFlat[i-1][j]=2;
                        AIch ch=new AIch(PFlat);
                        int[] P = ch.AIPlay(v-1);
                        if (P[2]<R[2])
                        {
                            R[0]=i-1;
                            R[1]=j;
                            R[2]=P[2];
                            R[3]=i;
                            R[4]=j;
                            this.ch=ch;
                        }
                    }
                    if (j != 7)
                    {
                        if (Flat[i-1][j+1]!=2)
                        {
                            if (Flat[i-1][j+1]==1)
                                Flat[i-1][j+1]=1;
                            int[][] PFlat=Copy(Flat);
                            PFlat[i][j]=0;
                            PFlat[i-1][j+1]=2;
                            AIch ch=new AIch(PFlat);
                            int[] P = ch.AIPlay(v-1);
                            if (P[2]<R[2])
                            {
                                R[0]=i-1;
                                R[1]=j+1;
                                R[2]=P[2];
                                R[3]=i;
                                R[4]=j;
                                this.ch=ch;
                            }
                        }
                    }
                    if (j != 0)
                    {
                        if (Flat[i-1][j-1]!=2)
                        {
                            if (Flat[i-1][j-1]==1)
                                Flat[i-1][j-1]=1;
                            int[][] PFlat=Copy(Flat);
                            PFlat[i][j]=0;
                            PFlat[i-1][j-1]=2;
                            AIch ch=new AIch(PFlat);
                            int[] P = ch.AIPlay(v-1);
                            if (P[2]<R[2])
                            {
                                R[0]=i-1;
                                R[1]=j-1;
                                R[2]=P[2];
                                R[3]=i;
                                R[4]=j;
                                this.ch=ch;
                            }
                        }
                    }
                }
            }
        }
        return R;
    }
}
