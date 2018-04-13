package CalculatorModel.CalculatorLogic;

import java.util.Arrays;
import java.util.Stack;

import CalculatorModel.FactoryPattern.CalculatorFactory;
import CalculatorModel.Interface.Calculator;

public class CalculatorLogic {
	private CalculatorFactory calF;
	public double evaluate(String exp){
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
            	calF = new CalculatorFactory();
            	int m = i;
            	m += 4;
            	String s = "";
            	while(expChar[m]!=')')
            		s += expChar[m++];
            	CalculatorLogic ca = new CalculatorLogic();
            	Calculator cc = calF.createCalculator("Geometric");
            	m++;
            	if(expChar[i]=='s')
            	{
            		double v[] = new double[]{ca.evaluate(s)*Math.PI/180};
            		//System.out.println("ssss "+Arrays.toString(v)+cc.calculate("sin",v));
            		value.push(cc.calculate("sin",v));
            	}
            	else if(expChar[i]=='c')
            	{
            		double v[] = new double[]{ca.evaluate(s)*Math.PI/180};
            		value.push(cc.calculate("cos",v));
            	}
            	else if(expChar[i]=='t')
            	{
            		double v[] = new double[]{ca.evaluate(s)*Math.PI/180};
             		value.push(cc.calculate("tan",v));
            	}
            	
            	i = --m;
            	//System.out.println("i sin = "+i+" m = "+m);
            	
            }
            else
            {
            	calF = new CalculatorFactory();
            	int m = i;
            	m += 4;
            	if(expChar[i]=='m' && expChar[i+1]=='e')
            		m++;
            	//System.out.println(i+" m = "+m);
            	String s = "";
            	while(expChar[m]!=')')
            		s += expChar[m++];
            	String y[] = s.split(",");
            	double v[] = new double[y.length];
            	int kk = 0;
            	for(String d : y)
            	{
            		v[kk++] = Double.parseDouble(d);
            	}
            	//System.out.println(s+" "+Arrays.toString(y));
            	Calculator cc = calF.createCalculator("Statistic");
            	if(expChar[i]=='m' && expChar[i+1]=='a')
            	{
            		value.push(cc.calculate("max",v));
            	}
            	else if(expChar[i]=='m' && expChar[i+1]=='i')
            	{
            		value.push(cc.calculate("min",v));
            	}
            	else if(expChar[i]=='m' && expChar[i+1]=='e')
            	{
            		value.push(cc.calculate("mean",v));
            	}
            	else if(expChar[i]=='s')
            	{
            		value.push(cc.calculate("std",v));
            	}
            	else if(expChar[i]=='v')
            	{
            		value.push(cc.calculate("var",v));
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
    	calF = new CalculatorFactory();
    	switch(op){
            case '+': return calF.createCalculator("Basic").add(a, b);
            case '-': return calF.createCalculator("Basic").subtract(a, b);
            case '*': return calF.createCalculator("Basic").multiply(a, b);
            case '/': if(b == 0)
                		return Double.POSITIVE_INFINITY; 
            		  return calF.createCalculator("Basic").divide(a, b);
        }
        return 0;
    }


}
