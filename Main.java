package co.tylerblanton.java_toh;

import java.util.*;

public class Main
{
    static int moves = 0;

    static customStack A = new customStack("A");
    static customStack B = new customStack("B");
    static customStack C = new customStack("C");

//    static  Stack<Integer> A = new Stack<>();
//    static Stack<Integer> B = new Stack<>();
//    static Stack<Integer> C = new Stack<>();
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("How many items are on tower A?");
        int stackStartSize = s.nextInt();

        for(int i = stackStartSize; i > 0; --i)
        {
            A.stack.push(i);
        }

        displayTowers(A.stack, B.stack, C.stack);
        moveDisks(stackStartSize, A, B, C);

        System.out.println("Number of Moves: " + moves);
    }

    static void moveDisks(int rings, customStack start, customStack aux, customStack end)
    {
        if(rings == 1)
        {
            end.stack.push(start.stack.pop());
            System.out.println(start.name + " -> " + end.name);
            moves++;
            displayTowers(A.stack, B.stack, C.stack);
        }
        else
        {
            moveDisks(rings-1, start, end, aux);
            end.stack.push(start.stack.pop());
            System.out.println(start.name + " -> " + end.name);
            moves++;
            displayTowers(A.stack, B.stack, C.stack);
            moveDisks(rings-1, aux, start, end);
        }
    }

    static void displayTowers(Stack<Integer> A, Stack<Integer> B, Stack<Integer> C)
    {
        System.out.println("** Move Number: " + moves);
        Stack<Integer> aCopy = new Stack<>();   //replace Integer if things go wrong
        aCopy.addAll(A);

        Stack<Integer> bCopy = new Stack<>();
        bCopy.addAll(B);

        Stack<Integer> cCopy = new Stack<>();
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
    static class customStack
    {
        Stack<Integer> stack;
        String name;
        customStack(String nName)
        {
            name = nName;
            stack = new Stack<>();
        }
    }
}



