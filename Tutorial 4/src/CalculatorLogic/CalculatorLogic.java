package CalculatorLogic;

import java.util.Arrays;
import java.util.Stack;

public class CalculatorLogic {
	
	private  Calculator cal;
	
	
	public double evaluate(String exp){
		cal = new Calculator();
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
                //System.out.println("i operator= "+i);
            	while(!operations.empty() && hasPrecedence(expChar[i], operations.peek()))
                    value.push(applyop(operations.pop(), value.pop(), value.pop()));
                operations.push(expChar[i]);
            }
            else if(expChar[i]!='m' && expChar[i]!='v' && (expChar[i+1]!='t'))
            {
            	int m = i;
            	m += 4;
            	String s = "";
            	while(expChar[m]!=')')
            		s += expChar[m++];
            	CalculatorLogic ca = new CalculatorLogic();
            	//System.out.println("String s = "+s);
            	//System.out.println(ca.evaluate(s));
            	m++;
            	if(expChar[i]=='s')
            	{
            		value.push(cal.sin(ca.evaluate(s)*Math.PI/180));
            	}
            	else if(expChar[i]=='c')
            	{
            		value.push(cal.cos(ca.evaluate(s)*Math.PI/180));
            	}
            	else if(expChar[i]=='t')
            	{
            		value.push(cal.tan(ca.evaluate(s)*Math.PI/180));
            	}
            	
            	i = --m;
            	//System.out.println("i sin = "+i+" m = "+m);
            	
            }
            else
            {
            	int m = i;
            	m += 4;
            	if(expChar[i]=='m' && expChar[i+1]=='e')
            		m++;
            	//System.out.println(i+" m = "+m);
            	String s = "";
            	while(expChar[m]!=')')
            		s += expChar[m++];
            	String y[] = s.split(",");
            	//System.out.println(s+" "+Arrays.toString(y));
            	cal.fill_table(y);
            	if(expChar[i]=='m' && expChar[i+1]=='a')
            	{
            		value.push(cal.max());
            	}
            	else if(expChar[i]=='m' && expChar[i+1]=='i')
            	{
            		value.push(cal.min());
            	}
            	else if(expChar[i]=='m' && expChar[i+1]=='e')
            	{
            		value.push(cal.mean());
            	}
            	else if(expChar[i]=='s')
            	{
            		value.push(cal.std());
            	}
            	else if(expChar[i]=='v')
            	{
            		value.push(cal.var());
            	}
            	//System.out.println(i+" m = "+m);
            	
            	i = m;
            	
            }
            //System.out.println("i = "+i+" "+value.toString()+" "+operations.toString());
        }
        while(!operations.empty())
            value.push(applyop(operations.pop(), value.pop(), value.pop()));

        return Math.round(value.pop()*10000.0)/10000.0;
    }

	private boolean hasPrecedence(char op1, char op2){
        if(op2 == '(' || op2 == ')')
            return false;
        if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    private double applyop(char op, Double b, Double a){
    	switch(op){
            case '+': return cal.add(a, b);
            case '-': return cal.subtract(a, b);
            case '*': return cal.multiply(a, b);
            case '/': if(b == 0)
                		return Double.POSITIVE_INFINITY; 
            		  return cal.divide(a, b);
        }
        return 0;
    }


}
