package com.rahmatullin.dev;

import java.util.ArrayList;
import java.util.Comparator;

public class Program {
    private String chanel;
    private BroadcastsTime time;
    private String name;

    public Program(String chanel, BroadcastsTime time, String name) {
        this.chanel = chanel;
        this.time = time;
        this.name = name;
    }

    public BroadcastsTime getTime() {
        return time;
    }

    public String getChanel() {
        return chanel;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Program{" +
                "chanel='" + chanel + '\'' +
                ", time=" + time +
                ", name='" + name + '\'' +
                '}';
    }

   public static ArrayList<Program> sortOfTime(ArrayList<Program> allPrograms) {
       allPrograms.sort(Comparator.comparing(Program::getTime));
       return allPrograms;
    }

    public static ArrayList<Program> getProgramsWithName(ArrayList<Program> programs, String name) {
        ArrayList<Program> programsWithName = new ArrayList<>();
        for(Program program: programs) {
            if (program.name.equals(name)) {
                programsWithName.add(program);
            }
        }
        return programsWithName;
    }
    public static ArrayList<Program> curProgram(ArrayList<Program> allProgram, String curTime){
        BroadcastsTime curBroadTome = new BroadcastsTime(curTime);
        ArrayList<Program> curProg = new ArrayList<>();
        for (int i = 0; i < allProgram.size(); i++) {
            if (allProgram.get(i).getTime().compareTo(curBroadTome) == 0){
                curProg.add(allProgram.get(i));
            }
        }
        return curProg;
    }
    public static ArrayList<Program> programBetween(ArrayList<Program> allProgram, String time1, String time2, String channel){
        BroadcastsTime broadTime1 = new BroadcastsTime(time1);
        BroadcastsTime broadTime2 = new BroadcastsTime(time2);
        ArrayList<Program> progBetween = new ArrayList<>();
        for (Program program : allProgram) {
            if (program.getTime().between(broadTime1, broadTime2) && (program.getChanel().equals(channel))){
                progBetween.add(program);
            }

        }return progBetween;
    }
    public static ArrayList<Program> getChanelNameAndCurTime(ArrayList<Program> allProgram, String curTime, String chanelName) {
        ArrayList<Program> currTimePrograms = curProgram(allProgram, curTime);
        ArrayList<Program> programsWithChanelAndCurrTime = new ArrayList<>();
        for(Program program: currTimePrograms) {
            if (program.chanel.equals(chanelName)) {
                programsWithChanelAndCurrTime.add(program);
            }
        }
        return programsWithChanelAndCurrTime;
    }
}
