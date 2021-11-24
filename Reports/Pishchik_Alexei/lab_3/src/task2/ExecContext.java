package task2;


import java.util.HashMap;
import java.util.Stack;

public class ExecContext {

    private Stack<Double> stack;
    private HashMap<String, Double> params;

    public ExecContext() {
        stack = new Stack<Double>();
        params = new HashMap<String,Double>();
    }

    public void pushInStack(double value){
        stack.push(value);
    }

    public double popFromStack(){
        return stack.pop();
    }

    public double peekFromStack(){
        return stack.peek();
    }

    public boolean stackIsEmpty(){
        return stack.empty();
    }

    public void setParam(String name, double value){
        params.put(name, value);
    }

    public Double getParam(String name){
        return params.get(name);
    }
}
