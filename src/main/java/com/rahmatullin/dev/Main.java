package com.rahmatullin.dev;

import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> programs = Deserialization.deserialize("data.txt"); // convert to ArrayList with String
        ArrayList<Program> allPrograms = ConvertDataToProgramClass.convertAllPrograms(programs); // convert to ArrayList with Programs

        ArrayList<Program> sortedOfTimePrograms = Program.sortOfTime(allPrograms);
//        System.out.println(sortedOfTimePrograms); // sort programs for time
        ArrayList<Program> getProgramsThatInCurrentTime = Program.curProgram(allPrograms, "00:00");
//        System.out.println(getProgramsThatInCurrentTime); // programs in current time
        ArrayList<Program> getProgramsWithName = Program.getProgramsWithName(allPrograms, "Музыкальный майдан");
//        System.out.println(getProgramsWithName); // programs with name
        ArrayList<Program> getProgramsWithCurrTimeAndChanelName = Program.getChanelNameAndCurTime(allPrograms, "00:00", "НТВ");
//        System.out.println(getProgramsWithCurrTimeAndChanelName); // programs with chanel name and current time
        ArrayList<Program> getProgramWithTimeBetweenAndChanel = Program.programBetween(allPrograms, "00:00", "03:00", "НТВ");
//        System.out.println(getProgramWithTimeBetweenAndChanel); // programs with timeBetween and chanel

        Serialization writer = new Serialization(sortedOfTimePrograms, "программы.xlsx");
        Serialization.saveToExcel(sortedOfTimePrograms, "программы.xlsx"); // save data to exel file
    }
}