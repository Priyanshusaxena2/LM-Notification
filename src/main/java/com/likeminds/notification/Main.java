package com.likeminds.notification;

import com.likeminds.notification.service.ConsoleService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        ConsoleService consoleService = new ConsoleService();
        Scanner sc = new Scanner(System.in);

        while(true){
            String commandInput = sc.nextLine();
            consoleService.processCommand(commandInput);
        }
    }

}
