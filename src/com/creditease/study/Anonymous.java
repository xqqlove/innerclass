package com.creditease.study;

import java.security.PublicKey;

//内部匿名类
public class Anonymous {
//============================================================
    /**
     * 匿名类
     */
    //    public Contents contents(){
//        return new Contents() {  //返回一个实现COntents的匿名类
//            private  int i=11;
//            @Override
//            public int value() {
//                return i;
//            }
//        };
//    }
// ====================================================================
//

    /**
     * 内部类
     */
    private class Mycontents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    public Contents contents(){
        return new Mycontents();
    }
//========================================================================
    public static void main(String[] args) {
        Anonymous anonymous = new Anonymous();
        Contents contents = anonymous.contents();
        System.out.println(contents.value());
    }
}
