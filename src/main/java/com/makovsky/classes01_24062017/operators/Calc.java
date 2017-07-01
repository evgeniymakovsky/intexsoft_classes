package com.makovsky.classes01_24062017.operators;

import java.util.Scanner;

public class Calc
{
	private Scanner scanner;
	private double firstNumber;
	private String sign;
	private double secondNumber;

	
	public Calc() 
	{
		super();
		this.scanner  = new Scanner(System.in);
	}
    
    public static void main(String[] args)
    {
        Calc calc = new Calc();
        calc.firstNumberInit();
        calc.signInit();
        calc.secondNumberInit();
        
        switch (calc.sign)
        {
            case "+": System.out.println(calc.firstNumber + " + " + calc.secondNumber + " = " + (calc.firstNumber + calc.secondNumber)); break;
            case "-": System.out.println(calc.firstNumber + " - " + calc.secondNumber + " = " + (calc.firstNumber - calc.secondNumber)); break;
            case "*": System.out.println(calc.firstNumber + " * " + calc.secondNumber + " = " + (calc.firstNumber * calc.secondNumber)); break;
            case "/": 
            	try 
            	{
            		if(calc.secondNumber==0) throw new DivisionByZeroException();
            		System.out.println(calc.firstNumber + " / " + calc.secondNumber + " = " + (calc.firstNumber / calc.secondNumber));
            		break;
            	} 
            	catch (DivisionByZeroException e) 
            	{
            		System.out.println("Division by zero is impossible!");
            		break;
            	}
            case "%": 
            	try 
            	{
            		if(calc.secondNumber==0) throw new DivisionByZeroException();
            		System.out.println(calc.firstNumber + " % " + calc.secondNumber + " = " + (calc.firstNumber % calc.secondNumber));
            		break;
            	} 
            	catch (DivisionByZeroException e) 
            	{
            		System.out.println("Division by zero is impossible!");
            		break;
            	}
            case "√": 
            	try 
            	{
            		if(calc.firstNumber<0) throw new NegativeNumberSQRTException();
            		System.out.println(" √ " + calc.firstNumber + " = " + Math.sqrt(calc.firstNumber));
            		break;
            	}
            	catch(NegativeNumberSQRTException e)
            	{
            		System.out.println("It's impossible to take the square root from a negative number!");
            	}
        }
        System.out.println();
        System.out.println("Do you want to calculate once again?");
        System.out.println("To calculate, press - 1");
        System.out.println("To exit, press - 0");
        if(calc.scanner.nextLine().equals("1")) main(args);
        calc.scanner.close();
    }

    private void firstNumberInit()
    {
        try
        {
            System.out.println("Please, enter correct first number:");
            firstNumber = Double.parseDouble(scanner.nextLine());
        }
        catch (NumberFormatException e)
        {
            this.firstNumberInit();
        }
    }

    private void signInit()
    {
        try
        {
        	System.out.println("Please, enter one of possible arithmetic sign: +, -, *, /, %, √");
            sign = scanner.nextLine();
            if(!sign.equals("+")&&!sign.equals("-")&&!sign.equals("*")&&!sign.equals("/")&&!sign.equals("%")&&!sign.equals("√"))
            {
                throw new ArithmeticSignException();
            }
        }
        catch (ArithmeticSignException e)
        {
            this.signInit();
        }
    }

    private void secondNumberInit()
    {
    	if(this.sign.equals("√")) return;
        try
        {
        	System.out.println("Please, enter correct second number:");
            secondNumber = Double.parseDouble(scanner.nextLine());
        }
        catch (NumberFormatException e)
        {
            
            this.secondNumberInit();
        }
    }
}