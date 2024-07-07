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
            } else System.out.println("없는 명령어");

            switch (cmd) {
                case "write":
                    break;
            }
        }
    }
}
