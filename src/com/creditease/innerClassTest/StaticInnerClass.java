package com.creditease.innerClassTest;

/**
 * 静态内部类
 * @Author qiangqiang
 * @Date 2020/6/10 16:34
 * @Version 1.0
 */
public class StaticInnerClass {
    private static int radius=1;
    static class StaticInner{
        public void visit(){
            System.out.println("visit outer static variable: "+radius);
        }
    }

    public static void main(String[] args) {
        StaticInnerClass.StaticInner inner =new StaticInnerClass.StaticInner();
        inner.visit();
    }
}
