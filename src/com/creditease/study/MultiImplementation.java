package com.creditease.study;

/**
 * 如果没有内部类提供的、可以继承多个具体的或抽象的类的能力，
 * 一些设计与编程问题就很难解决。从这个角度看，内部类使得多重继承的解决方案变得完整。
 * 接口解决了部分问题，而内部类有效地实现了“多重继承”。
 * 也就是说，内部类允许继承多个非接口类型（译注：类或抽象类）
 */
class A{}
abstract class E{}
class Z extends A{
    E makeE(){
        return new E() {
        };
    }
}
public class MultiImplementation {
    static void takesA(A a){};
    static void takesE(E e){};

    public static void main(String[] args) {
        Z z=new Z();
        takesA(z);
        takesE(z.makeE());
    }
}
