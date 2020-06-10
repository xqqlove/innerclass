package com.creditease.innerClassTest;

/**
 * @Author qiangqiang
 * @Date 2020/6/10 17:13
 * @Version 1.0
 */
public class AreaOuterClass1 {
    void method(){
        final int i=10;//jdk1.8之前必须加上final  1.8之后编译后jvm自动加上final
        class Inner{
            void  innerMethod(){
                System.out.println(i);
            }
        }
        Inner inner=new Inner();
        inner.innerMethod();
    }

    public static void main(String[] args) {
        AreaOuterClass1 outer=new AreaOuterClass1();
        outer.method();
    }
}
