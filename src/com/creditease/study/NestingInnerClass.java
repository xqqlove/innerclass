package com.creditease.study;

class Nesting{
    private void f(){
        System.out.println("f()");
    }
    class A{
        private void g(){
            System.out.println("g()");
        }
        class B{
            void h(){
                f();
                g();
            }
        }
    }

}
public class NestingInnerClass{
    public static void main(String[] args) {
        Nesting nesting=new Nesting();
        Nesting.A na=nesting.new A();
        Nesting.A.B nab=na.new B();
        nab.h();
    }
}
