package com.zhoulychn.common.utils;

import org.junit.Test;

import java.text.DecimalFormat;
import java.util.Stack;

/**
 * Created by lewis on 2016/11/10.
 */
public class Algorithm {

    /**
     * dijkstra双栈算数表达式求值
     * @param expression 未省略括号的算数表达式，如(1+((2+3)*(5*4)))
     * @return 计算结果
     */
    public static int dijkstra(String expression) {
        Stack<Integer> numberStack = new Stack<Integer>();
        Stack<Character> operatorStack = new Stack<Character>();

        char[] chars = expression.toCharArray();
        for (Character c : chars) {
            switch (c) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    numberStack.push(Character.getNumericValue(c));
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    operatorStack.push(c);
                    break;
                case '(':
                    break;
                case ')': {
                    int result;
                    int x = numberStack.pop();
                    int y = numberStack.pop();
                    Character operator = operatorStack.pop();
                    switch (operator) {
                        case '+':
                            result = x + y;
                            numberStack.push(result);
                            break;
                        case '-':
                            result = x - y;
                            numberStack.push(result);
                            break;
                        case '*':
                            result = x * y;
                            numberStack.push(result);
                            break;
                        case '/':
                            result = x / y;
                            numberStack.push(result);
                            break;
                    }
                }
            }
        }
        return numberStack.pop();
    }



    @Test
    public void transform(){
        String str = new DecimalFormat("0000").format(123);
        System.out.println(str);
    }

}
