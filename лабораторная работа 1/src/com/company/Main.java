package com.company;
import java.lang.String;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        Deque<Double> chi = new ArrayDeque<>();
        Scanner in = new Scanner(System.in);
        double sum = 0;
        System.out.print("Введите арифметическое выражение\n");
        String S = in.nextLine();
        String[] arr = new String[S.length() + 100];
        int i = 1;
        int k = 1;
        arr[0] = String.valueOf(S.charAt(0));
        //Разбитие строки на элементы и запихивание в массив
        while (k < S.length()) {
            if ((arr[i - 1].charAt(0) >= '0' && arr[i - 1].charAt(0) <= '9' && S.charAt(k) >= '0' && S.charAt(k) <= '9')
                    || (arr[i - 1].length() > 1 && ((arr[i - 1].charAt(1) >= '0' && arr[i - 1].charAt(1) <= '9' && S.charAt(k) >= '0' && S.charAt(k) <= '9')))
                    || (i > 1 && S.charAt(k) >= '0' && S.charAt(k) <= '9' && arr[i - 1].charAt(0) == '-' && arr[i - 2].charAt(0) == '(')
                    ||(S.charAt(k) >= '0' && S.charAt(k) <= '9'&&i==1&&arr[i-1].charAt(0)=='-')
            ) {
                arr[i - 1] = arr[i - 1] + S.charAt(k);
            } else {
                arr[i] = "" + S.charAt(k);
                if ((arr[i - 1].charAt(0) <= '9' && arr[i - 1].charAt(0) >= '0')|| (arr[i - 1].length() > 1 && arr[i - 1].charAt(1) >= '0' && arr[i - 1].charAt(1) <= '9')) {
                    chi.push(Double.parseDouble(arr[i - 1]));
                } else {
                    if (arr[i - 1].charAt(0) == ')') {
                        boolean key = false;
                        while (1 > 0) {
                            if (stack.size() > 0 && stack.peek().equals("^")) {
                                chi.push(Math.pow(chi.pop(),chi.pop()));

                                stack.pop();
                            }
                            if (stack.size() > 0 && stack.peek().equals("+")) {
                                chi.push(chi.pop() + chi.pop());

                                stack.pop();
                            }
                            if (stack.size() > 0 && stack.peek().equals("-")) {
                                chi.push(-chi.pop() + chi.pop());
                                stack.pop();
                            }
                            if (stack.size() > 0 && stack.peek().equals("/")) {
                                double pochka = chi.pop();
                                chi.push(chi.pop() / pochka);
                                stack.pop();
                            }
                            if (stack.size() > 0 && stack.peek().equals("*")) {
                                chi.push(chi.pop() * chi.pop());
                                stack.pop();
                            }
                            if (stack.peek().equals("(")) {
                                stack.pop();
                                break;
                            }
                        }
                    }
                    else  if (chi.size()>1&&stack.size() > 0 && stack.peek().equals("^")&&arr[i-1].charAt(0)!='(') {
                        double zam=chi.pop();
                        chi.push(Math.pow(chi.pop(),zam));
                        stack.pop();
                        if(arr[i-1].charAt(0)!='^'){stack.push(arr[i-1]);}
                    }
                    else if (stack.size() > 0 && (arr[i - 1].charAt(0) == '*' || arr[i - 1].charAt(0) == '/') && (stack.peek().equals("*") || stack.peek().equals("/"))) {
                        if (stack.peek().equals("*")) {
                            chi.push(chi.pop() * chi.pop());
                            stack.pop();
                        } else if (stack.peek().equals("/")) {
                            double pack = chi.pop();
                            chi.push(chi.pop() / pack);
                            stack.pop();
                        }
                        stack.push(arr[i - 1]);
                    } else if (arr[i - 1].charAt(0) == '(' || stack.size() < 1 || arr[i - 1].charAt(0) == '*' || arr[i - 1].charAt(0) == '/') {
                        stack.push(arr[i - 1]);
                    } else {
                        if ((arr[i - 1].charAt(0) == '+' || arr[i - 1].charAt(0) == '-') && !stack.peek().equals("(")) {
                            if (stack.size() > 0 && stack.peek().equals("+")) {
                                chi.push(chi.pop() + chi.pop());

                                stack.pop();
                                stack.push(arr[i - 1]);
                            } else if (stack.size() > 0 && stack.peek().equals("-")) {
                                chi.push(-chi.pop() + chi.pop());
                                stack.pop();
                                stack.push(arr[i - 1]);
                            } else if (stack.size() > 0 && stack.peek().equals("/")) {
                                double pack = chi.pop();
                                chi.push(chi.pop() / pack);
                                stack.pop();
                                stack.push(arr[i - 1]);
                            } else if (stack.size() > 0 && stack.peek().equals("*")) {
                                chi.push(chi.pop() * chi.pop());
                                stack.pop();
                                stack.push(arr[i - 1]);
                            }
                        } else stack.push(arr[i - 1]);
                    }
                }
                i++;
            }
            k++;
        }
        if (arr[i - 1].charAt(0) <= '9' && arr[i - 1].charAt(0) >= '0') {
            chi.push(Double.parseDouble(arr[i - 1]));
        }
        else {
            if (arr[i - 1].charAt(0) == ')') {
                boolean key = false;
                while (1 > 0) {
                    if (stack.size() > 0 && stack.peek().equals("+")) {
                        chi.push(chi.pop() + chi.pop());

                        stack.pop();
                    }
                    if (stack.size() > 0 && stack.peek().equals("-")) {
                        chi.push(-chi.pop() + chi.pop());
                        stack.pop();
                    }
                    if (stack.size() > 0 && stack.peek().equals("/")) {
                        double pochka = chi.pop();
                        chi.push(chi.pop() / pochka);
                        stack.pop();
                    }
                    if (stack.size() > 0 && stack.peek().equals("*")) {
                        chi.push(chi.pop() * chi.pop());
                        stack.pop();
                    }
                    if (stack.peek().equals("(")) {
                        stack.pop();
                        break;
                    }
                }
            }
            else  if (stack.size() > 0 && stack.peek().equals("^")) {
                double zam=chi.pop();
                chi.push(Math.pow(chi.pop(),zam));
                stack.pop();
                if(arr[i-1].charAt(0)!='^'){stack.push(arr[i-1]);}
            }
            else if (arr[i - 1].charAt(0) == '(' || stack.size() < 1 || arr[i - 1].charAt(0) == '*' || arr[i - 1].charAt(0) == '/') {
                stack.push(arr[i - 1]);
            } else {
                if ((arr[i - 1].charAt(0) == '+' || arr[i - 1].charAt(0) == '-') && !stack.peek().equals("(")) {

                    if (stack.size() > 0 && stack.peek().equals("+")) {
                        chi.push(chi.pop() + chi.pop());

                        stack.pop();
                    } else if (stack.size() > 0 && stack.peek().equals("-")) {
                        chi.push(-chi.pop() + chi.pop());
                        stack.pop();
                    } else if (stack.size() > 0 && stack.peek().equals("/")) {
                        double pack = chi.pop();
                        chi.push(chi.pop() / pack);
                        stack.pop();
                    } else if (stack.size() > 0 && stack.peek().equals("*")) {
                        chi.push(chi.pop() * chi.pop());
                        stack.pop();
                    }
                } else stack.push(arr[i - 1]);
            }

        }
        while (stack.size() > 0) {
            if (stack.size() > 0 && stack.peek().equals("^")) {
                double zam=chi.pop();
                chi.push(Math.pow(chi.pop(),zam));
                stack.pop();

            }
            if (stack.size() > 0 && stack.peek().equals("+")) {
                chi.push(chi.pop() + chi.pop());

                stack.pop();
            }
            if (stack.size() > 0 && stack.peek().equals("-")) {
                chi.push(-chi.pop() + chi.pop());
                stack.pop();
            }
            if (stack.size() > 0 && stack.peek().equals("/")) {
                double pack = chi.pop();
                chi.push(chi.pop() / pack);
                stack.pop();
            }
            if (stack.size() > 0 && stack.peek().equals("*")) {
                chi.push(chi.pop() * chi.pop());
                stack.pop();
            }
        }
        System.out.print("Результат:\n"+S+"="+chi.peek());
    }
}
