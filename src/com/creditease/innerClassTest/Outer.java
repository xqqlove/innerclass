package com.creditease.innerClassTest;

/**
 *https://blog.csdn.net/zhangjg_blog/article/details/20000769?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-4.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-4.nonecase
 *
 1 编译器自动为内部类添加一个成员变量， 这个成员变量的类型和外部类的类型相同， 这个成员变量就是指向外部类对象的引用；

 2 编译器自动为内部类的构造方法添加一个参数， 参数的类型是外部类的类型， 在构造方法内部使用这个参数为1中添加的成员变量赋值；

 3 在调用内部类的构造函数初始化内部类对象时， 会默认传入外部类的引用。
 * @Author qiangqiang
 * @Date 2020/6/10 15:43
 * @Version 1.0
 */
public class Outer {
    int outerField=0;
    class Inner{
        void InnerMethod(){
            int i=outerField;
        }
    }
}
