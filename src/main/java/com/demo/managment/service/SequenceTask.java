package com.demo.managment.service;

public final class SequenceTask {
    private static SequenceTask instance;
    private static Integer sequence;
    private SequenceTask(){}

    public static SequenceTask getInstance(){
        if (null==instance){
            instance = new SequenceTask();
            instance.sequence=0;
        }
        return instance;
    }

    public  Integer getNextValue() {
        sequence+=1;
        return sequence;
    }
}
