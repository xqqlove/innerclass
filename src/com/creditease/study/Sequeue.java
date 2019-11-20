package com.creditease.study;

interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Sequeue {
    private Object[] item;
    private int next = 0;

    public Sequeue(int size) {
        item = new Object[size];
    }

    public void add(Object x) {
        if (next < item.length) {
            item[next++] = x;
        }
    }

    private class SequeueSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return (i == item.length);
        }

        @Override
        public Object current() {
            return item[i];
        }

        @Override
        public void next() {
            if (i < item.length) {
                i++;
            }
        }
    }

    public Selector selector(){
        return new SequeueSelector();
    }

    public static void main(String[] args) {
        Sequeue sequeue=new Sequeue(20);
        for(int i=0;i<20;i++){
            sequeue.add(Integer.toString(i));
        }
        Selector selector=sequeue.selector();
        while (!selector.end()){
            System.out.println(selector.current()+",");
            selector.next();
        }
    }
}
