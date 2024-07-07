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
            String[] str = cmd.split(" ");
            String first = str[0];
            String id = str.length > 1 ? str[1] : "";

            switch (first) {
                case "write":
                    ArticleController.doWrite();
                    break;
                case "list":
                    ArticleController.showList();
                    break;
                case "delete":
                    try {
                        if (id.isEmpty()) {
                            System.out.println("게시물 번호 입력해");
                        } else ArticleController.doDelete(Integer.parseInt(id));
                    } catch (NumberFormatException e) {
                        System.out.println("게시물 번호 숫자로 입력해");
                    }
                    break;
                case "modify":
                    try {
                        if (id.isEmpty()) {
                            System.out.println("게시물 번호 입력해");
                        } else ArticleController.doModify(Integer.parseInt(id));
                    } catch (NumberFormatException e) {
                        System.out.println("게시물 번호 숫자로 입력해");
                    }
                    break;
                default:
                    System.out.println("그런 명령어 몰라");
                    break;
            }
        }
    }


}
