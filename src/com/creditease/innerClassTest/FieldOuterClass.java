package com.creditease.innerClassTest;

/**
 * 成员内部类
 * @Author qiangqiang
 * @Date 2020/6/10 16:38
 * @Version 1.0
 */
public class FieldOuterClass {
    private static int radius=1;
    private int count=2;
    class Inner{
        public void visit(){
            System.out.println("visit outer static variable:" +radius);
            System.out.println("visit outer variable:" +count);
        }
    }

    public static void main(String[] args) {
        FieldOuterClass.Inner inner=new FieldOuterClass().new Inner();
        inner.visit();
    }
}
