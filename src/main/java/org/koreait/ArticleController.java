package org.koreait;

public class ArticleController {

    static void doModify(int id) {
        ArticleService.doModify(id);
    }

    static void doDelete(int id) {
        ArticleService.doDelete(id);
    }

    static void showList() {
        ArticleService.showList();
    }

    static void doWrite() {
        ArticleService.doWrite();
    }
}
