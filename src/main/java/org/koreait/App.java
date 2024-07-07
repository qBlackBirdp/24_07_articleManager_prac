package org.koreait;

import java.util.Scanner;

public class App {
    static Scanner sc;
    public App() {
        sc = new Scanner(System.in);
    }

    static void run() {
        System.out.println("== 프로그램 시작 ==");

        while (true) {
            System.out.print("명령어 : ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("== 프로그램 종료 ==");
                return;
            } else if (cmd.isEmpty()) {
                System.out.println("명령어 입력해.");
                continue;
            }

            switch (cmd) {
                case "write":
//                    doWrite();
                    break;
                default:
                    System.out.println("그런 명령어 몰라");
                    break;
            }
        }
    }
}
