package org.koreait;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static List<Article> articles;
    static Scanner sc;
    static int lastId;

    public App() {
        sc = new Scanner(System.in);
        articles = new ArrayList<>();
        lastId = 1;
    }


    public static void run() {
        System.out.println("==프로그램 시작==");

        while (true) {

            int id = lastId;

            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();
            if (cmd.equals("exit")) {
                System.out.println("==프로그램 종료==");
                break;
            } else if (cmd.isEmpty()){
                System.out.println("명령어 입력해");
            } else if (cmd.equals("article write")) {
                System.out.println("==게시물 작성==");

                System.out.print("제목 : ");
                String title = sc.nextLine().trim();
                System.out.print("내용 : ");
                String body = sc.nextLine().trim();

                articles.add(new Article(id, title, body));

                System.out.printf("%d 번 글이 작성 되었습니다.\n", id);

                lastId++;
            } else if (cmd.equals("article list")) {
                System.out.println("==게시물 목록==");

                System.out.println("  번호  /     제목      /       내용      /");
                for (Article article : articles) {
                    System.out.printf("  %d  /       %s      /       %s      /\n", article.getId(), article.getTitle(), article.getBody());
                }
            }
        }
    }
}
