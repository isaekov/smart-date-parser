package io.github.isaekov;

import io.github.isaekov.smartdate.SmartDateParser;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {

        SmartDateParser parser = SmartDateParser.defaultParser();
        System.out.println(parser.parse("today"));
        System.out.println(parser.parse("+3 days"));

    }
}