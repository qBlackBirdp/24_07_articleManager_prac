package org.koreait;

import java.util.Scanner;

public class App {
    static Scanner sc;
    static int lastId;
    public App() {
        sc = new Scanner(System.in);
        lastId = 1;
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
                    doWrite();
                    break;
                default:
                    System.out.println("그런 명령어 몰라");
                    break;
            }
        }
    }

    private static void doWrite() {
        System.out.println("== 게시물 작성 ==");
        System.out.print("제목 : ");
        String title = sc.nextLine().trim();
        System.out.print("내용 : ");
        String body = sc.nextLine().trim();

        int id = lastId++;

        System.out.printf("%d번 게시물이 작성되었습니다.\n", id);
    }
}
