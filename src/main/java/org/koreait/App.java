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
                System.out.println("명령어를 입력해");
            }

            String[] str = cmd.split(" ");
            String firstWord = str[0];
            String id = str.length > 1 ? str[1] : "";


            switch (firstWord) {
                case "write":
                    doWrite();
                    break;
                case "list":
                    showList();
                    break;
                case "delete":
                    try {
                        if (id.isEmpty()) {
                            System.out.println("게시물 번호 입력해.");
                        } else doDelete(Integer.parseInt(id));
                    } catch (NumberFormatException e) {
                        System.out.println("게시물 번호 입력해.");
                    }
                    break;
                case "modify":
                    try {
                        if (id.isEmpty()) {
                            System.out.println("게시물 번호 입력해.");
                        } else doModify(Integer.parseInt(id));
                    } catch (NumberFormatException e) {
                        System.out.println("게시물 번호 입력해.");
                    }
                    break;

                default:
                    System.out.println("알 수 없는 명령어.");
                    break;
            }
        }
    }

    private static void doModify(int id) {
        Article found = foundArticleId(id);
        if (found != null) {
            System.out.println("== 게시물 수정 ==");
            System.out.println(" 제목 : " + found.getTitle());
            System.out.println(" 내용 : " + found.getBody());
            System.out.print("새 제목 : ");
            String newTitle = sc.nextLine().trim();
            System.out.print("새 내용 : ");
            String newBody = sc.nextLine().trim();

            found.setTitle(newTitle);
            found.setBody(newBody);

            System.out.printf("%d번 게시물 수정\n", id);
        } else System.out.printf("%d번 게시물 없음\n", id);
    }

    private static void doDelete(int id) {
        Article found = foundArticleId(id);
        if (found != null) {
            articles.remove(found);
            System.out.println("== 게시물 삭제 ==");
            System.out.printf("%d번 게시물 삭제\n", id);
        } else System.out.printf("%d번 게시물 없음\n", id);
    }

    private static Article foundArticleId(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    private static void doWrite() {
        System.out.println("== 게시물 작성 ==");

        System.out.print("제목 : ");
        String title = sc.nextLine().trim();
        System.out.print("내용 : ");
        String body = sc.nextLine().trim();

        int id = lastId++;
        articles.add(new Article(id, title, body));

        System.out.printf("%d번 글이 작성되었습니다.\n", id);
    }

    private static void showList() {
        System.out.println("== 게시물 목록 ==");

        if (articles.isEmpty()) {
            System.out.println("게시물 없어");
        } else {
            System.out.println("번호      /       제목      /       내용 ");

            for (int i = articles.size() - 1; i >= 0; i--) {
                Article article = articles.get(i);

                System.out.printf("%d       /       %s      /       %s\n", article.getId(), article.getTitle(), article.getBody());

            }
        }

    }
}
