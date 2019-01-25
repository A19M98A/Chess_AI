package com.example.amin.chess;

public class List
{
    int poin;
    public AIch A;
    public List Next;
    public void Add(AIch A)
    {
        if (this.A==null)
            this.A=A;
        else
        {
            List ptr=this;
            for (;ptr.Next!=null;ptr=ptr.Next);
            ptr.Next=new List();
            ptr.Next.A=A;
        }
    }
}
