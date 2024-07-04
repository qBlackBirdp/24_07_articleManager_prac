package org.koreait;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static Scanner sc;
    static int lastId;

    static List<Article> articles;

    public App() {
        sc = new Scanner(System.in);
        lastId = 1;
        articles = new ArrayList<>();
    }

    public static void run() {

        System.out.println("== 프로그램 시작 ==");

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("== 프로그램 종료 ==");

            } else if (cmd.isEmpty()) {
                System.out.println("명령어 입력해");
                return;
            }
            switch (cmd) {
                case "write":
                    doWrite();
                    break;
                case "list":
                    showList();
                    break;
                case "delete":
                    doDelete();
                    break;
                case "modify":
                    doModify();
                    break;
                default:
                    System.out.println("알 수 없는 명령어");
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

        articles.add(new Article(id, title, body));

        System.out.printf("%d번 게시물이 작성되었음.\n", id);
    }

    private static void showList() {
        if (articles.isEmpty()) {
            System.out.println("게시물이 없어.");
        }
    }

    private static void doDelete() {
    }

    private static void doModify() {
    }


}
