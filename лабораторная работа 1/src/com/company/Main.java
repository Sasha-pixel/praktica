package com.company;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String arr[]){
        Scanner in = new Scanner(System.in);
        String S;
        System.out.println("Введите комбинацию скобок: ");
        S=in.nextLine();
        char []ar=S.toCharArray();
        Stack stack=new Stack<Character>();
        if(ar[0] == ')' || ar[0] == ']' || ar[0] == '}' || ar.length % 2 != 0)
        {
            System.out.println("Неправильная комбинация");
            return;
        }
        for(int i = 0;i<ar.length;i++)
        {
            switch (ar[i])
            {
                case '(' : stack.push(ar[i]); break;
                case '[' : stack.push(ar[i]); break;
                case '{' :stack.push(ar[i]); break;
                case ')' : {
                    if (stack.size()!=0) {
                        if (stack.peek().equals('('))
                            stack.pop();
                    }
                } break;
                case '}' : {
                    if(stack.size()!=0) {
                        if (stack.peek().equals('{'))
                            stack.pop();
                    }
                } break;
                case ']' : {
                    if(stack.size()!=0) {
                        if (stack.peek().equals('['))
                            stack.pop();
                    }
                } break;
            }
        }
        if(stack.size()==0)
            System.out.println("Введена правильная комбинация скобок");
        else
            System.out.println("Введена неправильная комбинация скобок");
    }
}
