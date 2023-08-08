package org.example.structure.stack;

public class Main {

    public static void main(String[] args){
        var stack = new CustomStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.print();

        var top = stack.peek();
        System.out.println(top);
        stack.print();

        top = stack.pop();
        System.out.println(top);
        stack.print();
    }

}
