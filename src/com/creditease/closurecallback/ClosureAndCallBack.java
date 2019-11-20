package com.creditease.closurecallback;



/**
 * 闭包（closure）是一个可调用的对象，它记录了一些信息，
 * 这些信息来自于创建它的作用域。通过这个定义，可以看出内部类是面向对象的闭包，
 * 因为它不仅包含外围类对象（创建内部类的作用域）的信息，还自动拥有一个指向此外围类对象的引用，
 * 在此作用域内，内部类有权操作所有的成员，包括 private 成员。
 */

interface Incrementable{
    void increment();
}
class Callee1 implements Incrementable{
    private int i=0;
    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}
class MyIncremet{
    public void increment(){
        System.out.println("other operation");
    }
    static void f(MyIncremet myIncremet){myIncremet.increment();}
}
class Callee2 extends MyIncremet{
    private int i=0;
    @Override
    public void increment(){
        super.increment();
        i++;
        System.out.println(i);
    }
    private class Closure implements Incrementable{
        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }
    Incrementable getCallbackReference(){
        return new Closure();
    }
}
class Caller{
    private Incrementable callbackReference;
    Caller(Incrementable cbh) {
        callbackReference = cbh;
    }
    void go() { callbackReference.increment(); }
}
public class ClosureAndCallBack {
    public static void main(String[] args) {
        Callee1 callee1=new Callee1();
        Callee2 callee2=new Callee2();
        MyIncremet.f(callee2);
        Caller caller1 = new Caller(callee1);
        Caller caller2 =
                new Caller(callee2.getCallbackReference());
        System.out.println("==============1==================");
        caller1.go();
        System.out.println("==============2==================");
        caller1.go();
        System.out.println("==============3==================");
        caller2.go();
        System.out.println("==============4==================");
        caller2.go();
    }
}
