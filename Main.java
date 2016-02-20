package co.tylerblanton.java_toh;

import java.util.*;

public class Main
{
   static  Stack<Integer> A = new Stack<Integer>();
    static Stack<Integer> B = new Stack<Integer>();
    static Stack<Integer> C = new Stack<Integer>();
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("How many items are on tower A?");
        int stackStartSize = s.nextInt();

        for(int i = stackStartSize; i > 0; --i)
        {
            A.push(new Integer(i));
        }

        displayTowers(A, B, C);
        hanoi(stackStartSize, A, B, C);

    }

    static void hanoi(int rings, Stack<Integer> start, Stack<Integer> aux, Stack<Integer> end)
    {
        //displayTowers(A, B, C);
        if(rings == 1)
        {
            end.push(start.pop());
            displayTowers(A, B, C);
        }
        else
        {
            hanoi(rings-1, start, end, aux);
            //displayTowers(A, B, C);
            end.push(start.pop());        //this fails because end eventually has size 0
            displayTowers(A, B, C);
            hanoi(rings-1, aux, start, end);
        }
    }

    static void displayTowers(Stack<Integer> A, Stack<Integer> B, Stack<Integer> C)
    {
        Stack<Integer> aCopy = new Stack<Integer>();
        aCopy.addAll(A);

        Stack<Integer> bCopy = new Stack<Integer>();
        bCopy.addAll(B);

        Stack<Integer> cCopy = new Stack<Integer>();
        cCopy.addAll(C);

        System.out.print("[");
        int Asize = A.size();
        for(int i = 0; i < Asize; ++i)
        {
            if(i != Asize-1)
            {
                System.out.print(aCopy.get(i) + ", ");
            }
            else
            {
                System.out.print(aCopy.get(Asize-1) + "]\n");
            }
        }
        if(Asize == 0)
        {
            System.out.print("]\n");
        }

        System.out.print("[");
        int Bsize = B.size();
        for(int i = 0; i < Bsize; ++i)
        {
            if(i != Bsize-1)
            {
                System.out.print(bCopy.get(i) + ", ");
            }
            else
            {
                System.out.print(bCopy.get(Bsize-1) + "]\n");
            }
        }
        if(Bsize == 0)
        {
            System.out.print("]\n");
        }


        System.out.print("[");
        int Csize = C.size();
        for(int i = 0; i < Csize; ++i)
        {
            if(i != Csize-1)
            {
                System.out.print(cCopy.get(i) + ", ");
            }
            else
            {
                System.out.print(cCopy.get(Csize-1) + "]\n");
            }
        }
        if(Csize == 0)
        {
            System.out.print("]\n");
        }
        System.out.println("-------------------------------------------------");
    }
}
