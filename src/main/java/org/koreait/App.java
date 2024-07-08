package org.koreait;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.koreait.ArticleController.*;

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
            System.out.print("명령어: ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("== 프로그램 종료 ==");
                sc.close();
                return;
            } else if (cmd.isEmpty()) System.out.println("명령어 똑바로 입력해");

            String[] strs = cmd.split(" ");
            String firstWord = strs[0];
            String secondWord = strs.length > 1 ? strs[1] : "";
            String id = strs.length > 2 ? strs[2] : "";

            switch (firstWord + " " + secondWord) {
                case "article write":
                    doWrite();
                    break;
                case "article list":
                    showList();
                    break;
                case "article delete":
                    try {
                        if (id.isEmpty()) {
                            System.out.println("삭제할 게시물 번호 입력해");
                            continue;
                        } else doDelete(Integer.parseInt(id));
                    } catch (NumberFormatException e) {
                        System.out.println("명령어에 번호 누락 확인해봐");
                        continue;
                    }
                    break;
                case "article modify":
                    try {
                        if (id.isEmpty()) {
                            System.out.println("수정할 게시물 번호 입력해");
                            continue;
                        } else doModify(Integer.parseInt(id));
                    } catch (NumberFormatException e) {
                        System.out.println("명령어에 번호 누락 확인해봐");
                        continue;
                    }
                    break;

                default:
                    System.out.println("명령어 입력 오류");
                    break;
            }
        }
    }
}
