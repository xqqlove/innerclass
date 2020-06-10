package com.creditease.innerClassTest;

/**
 *
 * 那么问题又来了，为什么需要用final修饰局部变量呢?
 *
 * 按照习惯，我依旧先给出问题的答案：用final修饰实际上就是为了保护数据的一致性。
 *
 * 这里所说的数据一致性，对引用变量来说是引用地址的一致性，对基本类型来说就是值的一致性。
 *
 * 这里我插一点，final修饰符对变量来说，深层次的理解就是保障变量值的一致性。为什么这么说呢？
 * 因为引用类型变量其本质是存入的是一个引用地址，说白了还是一个值（可以理解为内存中的地址值）。
 * 用final修饰后，这个这个引用变量的地址值不能改变，所以这个引用变量就无法再指向其它对象了。
 *
 * 回到正题，为什么需要用final保护数据的一致性呢？
 *
 * 因为将数据拷贝完成后，如果不用final修饰，则原先的局部变量可以发生变化。这里到了问题的核心了，
 * 如果局部变量发生变化后，匿名内部类是不知道的（因为他只是拷贝了局不变量的值，并不是直接使用的局部变量）。
 * 这里举个栗子：原先局部变量指向的是对象A，在创建匿名内部类后，匿名内部类中的成员变量也指向A对象。
 * 但过了一段时间局部变量的值指向另外一个B对象，但此时匿名内部类中还是指向原先的A对象。
 * 那么程序再接着运行下去，可能就会导致程序运行的结果与预期不同。
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
        TestFinal testFinal=new TestFinal();
        int i=9;
        testFinal.show(i);
    }
}

/**
 * final 修饰类中的属性：
 * 表示该属性一旦被初始化便不可改变，这里不可改变的意思对基本类型来说是其值不可变，
 * 而对对象属性来说其引用不可再变。其初始化可以在两个地方：一是其定义处，也就是说在
 * final 属性定义时直接给其赋值；二是在构造函数中。这两个地方只能选其一，要么在定义时给值，要么在构造函数中给值，
 * 不能同时既在定义时赋值，又在构造函数中赋予另外的值。
 *
 * final 修饰类中的方法
 *
 * 说明这种方法提供的功能已经满足当前要求，不需要进行扩展，并且也不允许任何从此类继承的类来重写这种方法，
 * 但是继承仍然可以继承这个方法，也就是说可以直接使用。在声明类中，一个 final 方法只被实现一次。
 *
 */
class TestFinal{
    final int i;
    {
        i=10;
    }
//    public TestFinal(){}
//    public TestFinal(int j){
//        this.i=j;
//    }

    public final void show(){
        System.out.println("show");
    }
    public  void show(final int i){
        System.out.println("show1");
    }
}
class Test extends TestFinal{
}