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
            String[] str = cmd.split(" ");
            String fistWord = str[0];
            String id = str.length > 1 ? str[1] : "";

            switch (fistWord) {
                case "write":
                    doWrite();
                    break;
                case "list":
                    showList();
                    break;
                case "delete":
                    if (id.isEmpty()) {
                        System.out.println("입력오류");
                    } else doDelete(Integer.parseInt(id));
                    break;
                case "modify":
                    if (id.isEmpty()) {
                        System.out.println("입력오류");
                    } else doModify(Integer.parseInt(id));
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
            System.out.println("게시물 없어.");
        } else {
            System.out.println("== 게시물 목록 ==");
            System.out.println("번호     /       제목      /     내용");
            for (int i = articles.size() - 1; i >= 0; i--) {
                Article article = articles.get(i);
                System.out.printf("%d      /        %s       /       %s      \n", article.getId(), article.getTitle(), article.getBody());
            }
        }
    }

    private static void doDelete(int id) {
        Article found = foundArticle(id);
        if (found != null) {
            System.out.println("== 게시물삭제 ==");
            articles.remove(found);
            System.out.printf("%d번 게시물삭제\n", id);
        } else System.out.printf("%d번 게시물은 없어\n", id);
    }

    private static void doModify(int id) {
        Article found = foundArticle(id);
        if (found != null) {
            System.out.println("== 게시물수정 ==");
            System.out.print("제목 : ");
            String title = sc.nextLine().trim();
            System.out.print("내용 : ");
            String body = sc.nextLine().trim();

            found.setTitle(title);
            found.setBody(body);

            System.out.printf("%d번 게시물 수정\n", id);
        } else System.out.printf("%d번 게시물은 없어\n", id);
    }




    private static Article foundArticle(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }return null;
    }
}
