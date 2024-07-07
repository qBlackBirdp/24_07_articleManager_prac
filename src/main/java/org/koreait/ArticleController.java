package org.koreait;

import static org.koreait.App.articles;
import static org.koreait.App.sc;
import static org.koreait.App.lastId;

public class ArticleController {

    static void doModify(int id) {
        Article found = foundArticleId(id);
        if (found == null) {
            System.out.printf("%d번 게시물 없음.\n", id);
        } else {
            System.out.println("제목 : " + found.getTitle());
            System.out.println("내용 : " + found.getBody());
            System.out.print("새 제목 : ");
            String newTitle = sc.nextLine().trim();
            System.out.print("새 내용 : ");
            String newBody = sc.nextLine().trim();

            System.out.printf("%d번 게시물 수정됨.\n", id);

            found.setTitle(newTitle);
            found.setBody(newBody);
        }
    }

    static void doDelete(int id) {
        Article found = foundArticleId(id);
        if (found != null) {
            articles.remove(found);
            System.out.println("== 게시물 삭제 ==");
            System.out.printf("%d번 게시물 삭제\n", id);
        } else System.out.printf("%d번 게시물 없음.\n", id);
    }

    static Article foundArticleId(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }

    static void showList() {
        System.out.println("== 게시물 목록 ==");
        if (articles.isEmpty()) {
            System.out.println("게시물 없어.");
        } else {
            System.out.println("번호       /       제목      /       내용");
            for (int i = articles.size() - 1; i >= 0; i--) {
                Article article = articles.get(i);
                System.out.printf("%d       /       %s      /       %s\n", article.getId(), article.getTitle(), article.getBody());
            }
        }
    }

    static void doWrite() {
        System.out.println("== 게시물 작성 ==");
        System.out.print("제목 : ");
        String title = sc.nextLine().trim();
        System.out.print("내용 : ");
        String body = sc.nextLine().trim();

        int id = lastId++;

        articles.add(new Article(id, title, body));

        System.out.printf("%d번 게시물이 작성되었습니다.\n", id);
    }
}
