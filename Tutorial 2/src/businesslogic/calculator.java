package businesslogic;
import java.util.*;

public class calculator
{
	synchronized public double evaluate(String exp){
        char[] expChar = exp.toCharArray();

        Stack<Double> value = new Stack<Double>();
        Stack<Character> operations = new Stack<Character>();

        for(int i=0;i<expChar.length;i++){
            

            if(expChar[i] >= '0' && expChar[i] <= '9'){
                StringBuffer sbuf = new StringBuffer();
                while(i < expChar.length && expChar[i] >= '0' && expChar[i] <= '9' || expChar[i]=='.')
                    {
                        sbuf.append(expChar[i++]);
                        if(i>=expChar.length)
                            break;
                    }
                i--;
                value.push(Double.parseDouble(sbuf.toString()));
            }

            else if(expChar[i] == '(')
                operations.push(expChar[i]);

            else if(expChar[i] == ')'){
                while(operations.peek() != '(')
                    value.push(applyop(operations.pop(), value.pop(), value.pop()));
                operations.pop();
            }

            else if(expChar[i] == '+' || expChar[i] == '-' || expChar[i] == '*' || expChar[i] == '/'){
                while(!operations.empty() && hasPrecedence(expChar[i], operations.peek()))
                    value.push(applyop(operations.pop(), value.pop(), value.pop()));
                operations.push(expChar[i]);
            }
            //System.out.prdoubleln(i+" "+value.toString()+" "+operations.toString());
        }
        while(!operations.empty())
            value.push(applyop(operations.pop(), value.pop(), value.pop()));

        return value.pop();
    }

	synchronized public boolean hasPrecedence(char op1, char op2){
        if(op2 == '(' || op2 == ')')
            return false;
        if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    synchronized public static double applyop(char op, double b, double a){
        switch(op){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': if(b == 0)
                        throw new UnsupportedOperationException("Cannot divide by zero");
                      return a/b;
        }
        return 0;
    } 



}