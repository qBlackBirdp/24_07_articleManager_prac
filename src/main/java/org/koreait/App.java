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
        System.out.println("== 프로그램 시작 ==");

        while (true) {

            int id = lastId;

            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();
            if (cmd.equals("exit")) {
                System.out.println("== 프로그램 종료 ==");
                break;
            } else if (cmd.isEmpty()) {
                System.out.println("명령어 입력해");
            } else if (cmd.equals("article write")) {
                System.out.println("== 게시물 작성 ==");

                System.out.print("제목 : ");
                String title = sc.nextLine().trim();
                System.out.print("내용 : ");
                String body = sc.nextLine().trim();

                articles.add(new Article(id, title, body));

                System.out.printf("%d 번 글이 작성 되었습니다.\n", id);

                lastId++;
            } else if (cmd.equals("article list")) {

                if (articles.size() == 0) {
                    System.out.println("게시물 없어.");
                } else {
                    System.out.println("== 게시물 목록 ==");

                    System.out.println("  번호  /     제목      /       내용      /");
                    for (int i = articles.size() - 1; i >= 0; i--) {
                        Article article = articles.get(i);
                            System.out.printf("  %d  /       %s      /       %s      /\n", article.getId(), article.getTitle(), article.getBody());
                    }
                }
            } else if (cmd.startsWith("article delete")) {

                int deleteId = Integer.parseInt(cmd.split(" ")[2]);

                Article found = getArticleId(deleteId);

                if (found == null) {
                    System.out.printf("%d번 게시물은 없어.\n", deleteId);
                } else {
                    System.out.println("== 게시물 삭제 ==");

                    System.out.printf("%d번 게시물 삭제.\n", deleteId);
                    articles.remove(found);
                }
            } else if (cmd.startsWith("article modify")) {
                int modifyId = Integer.parseInt(cmd.split(" ")[2]);
                Article found = getArticleId(modifyId);
                if (found == null) {
                    System.out.printf("%d번 게시물은 없어.\n", modifyId);
                } else {
                    System.out.println("== 게시물 수정 ==");

                    System.out.print("제목 : ");
                    String title = sc.nextLine().trim();
                    System.out.print("내용 : ");
                    String body = sc.nextLine().trim();

                    found.setTitle(title);
                    found.setBody(body);

                    System.out.printf("%d번 게시물 수정되었음.\n", modifyId);
                }
            }
        }
    }

    private static Article getArticleId(int deleteId) {
        for (Article a : articles) {
            if (a.getId() == deleteId) {
                return a;
            }
        }
        return null;
    }
}
