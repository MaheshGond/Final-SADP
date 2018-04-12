package Interpreter;

import java.util.Stack;

import Composite.*;

public class ClientHandler {
    public boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }
   
    public Expression constructTree(String postfix) {
        Stack<Expression> st = new Stack();
        Expression t=null, t1, t2;
        for (int i = 0; i < postfix.length(); i++) {
            if (!isOperator(postfix.charAt(i))) {
                 t = new Constant(Double.parseDouble(Character.toString(postfix.charAt(i))));
                 st.push(t);
            } 
            else{
                t1 = st.pop();
                t2 = st.pop();
                switch(postfix.charAt(i))
                {
                case '+':
                	t = new Adder( t2, t1);
                	break;
                case '-':
                	t = new Subtracter( t2, t1);
                	break;
                case '*':
                	t = new Multiplier( t2, t1);
                	break;
                case '/':
                	t = new Divider( t2, t1);
                	break;
                }
                
                st.push(t);
            }
        }
        t = st.peek();
        st.pop();
        return t;
    }
    public double eval(String expr){
        String postfix = new InfixToPostfix().convert(expr);
        Expression root = constructTree(postfix);
        return root.calculate();
    }
}