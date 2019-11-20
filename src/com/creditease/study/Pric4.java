package com.creditease.study;

class Pric {
    private class PContent implements Contents{
            private int i=10;
        @Override
        public int value() {
            return i;
        }
    }
    protected final class Pdefine implements Define{
        private String label;
        public Pdefine(String s){
            this.label=s;
        }
        @Override
        public String readLabel() {
            return label;
        }
    }
    public Contents contents(){
        return new PContent();
    }
    public Define define(){
        return new Pdefine("你说的女粉丝爱福家");
    }
}
public class Pric4 {
    public static void main(String[] args) {
        Pric pric=new Pric();
        Contents contents=pric.contents();
        Define define=pric.define();
        System.out.println(define.readLabel());
        System.out.println(contents.value());
    }
}