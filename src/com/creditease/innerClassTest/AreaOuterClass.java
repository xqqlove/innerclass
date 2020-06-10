package com.creditease.innerClassTest;

/**
 * 局部内部类
 * @Author qiangqiang
 * @Date 2020/6/10 16:48
 * @Version 1.0
 */
public class AreaOuterClass {
    private int  out_a=1;
    private static int static_b=2;

    public void testFunctionClass(){
        int inner_c=3;
        class Inner{
            private void  fun(){
                System.out.println(out_a);
                System.out.println(static_b);
                System.out.println(inner_c);
            }
        }
        Inner inner=new Inner();
        inner.fun();
    }

    public static void testStaticFunctionClass(){
        int d=3;
        class Inner{
            private void fun(){
                System.out.println(static_b);
                System.out.println(d);
            }
        }
        Inner inner =new Inner();
        inner.fun();
    }

    public static void main(String[] args) {
        AreaOuterClass areaOuterClass=new AreaOuterClass();
        areaOuterClass.testFunctionClass();
        testStaticFunctionClass();
    }
}
