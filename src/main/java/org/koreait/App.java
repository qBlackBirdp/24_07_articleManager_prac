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

    private static void doModify(int id) {
        Article found = foundArticleId(id);
        if (found == null) {
            System.out.printf("%d번 게시물 없어\n", id);
        } else {
            System.out.println("== 게시물 수정 ==");
            System.out.println("제목 : " + found.getTitle());
            System.out.println("내용 : " + found.getBody());
            System.out.print("새 제목 :");
            String newTitle = sc.nextLine().trim();
            System.out.print("새 내용 : ");
            String newBody = sc.nextLine().trim();

            found.setTitle(newTitle);
            found.setBody(newBody);

            System.out.printf("%d번 게시물이 수정됨.\n", id);
        }
    }

    private static void doDelete(int id) {
        Article found = foundArticleId(id);
        if (found == null) {
            System.out.printf("%d번 게시물 없어\n", id);
        } else {
            System.out.println("== 게시물 삭제 ==");
            articles.remove(found);
            System.out.printf("%d번 게시물 삭제\n", id);
        }
    }

    private static Article foundArticleId(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    private static void showList() {
        if (articles.isEmpty()) {
            System.out.println("게시물 없어");
        } else {
            System.out.println("== 게시물 목록 ==");
            System.out.println("번호      /       제목      /       내용");
            for (int i = articles.size() - 1; i >= 0; i--) {
                articles.get(i);
                Article article = articles.get(i);
                System.out.printf("%d       /       %s      /       %s\n", article.getId(), article.getTitle(), article.getBody());
                System.out.println("=".repeat(50));
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

        articles.add(new Article(title, body, id));

        System.out.printf("%d번 게시물 작성\n", id);
    }
}
