package wade.wei.memento.zhiyin;

/**
 * @author Administrator
 * 原发器Originator：文档
 */
public class Document {
    private String title;
    private String body;

    public Document(String title) {
        this.title = title;
        this.body = "";
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    /**
     * 创建历史记录
     * @return
     */
    public History createHistory() {
        return new History(this.body);
    }

    /**
     * 恢复历史记录
     * @param history
     */
    public void restoreHistory(History history) {
        this.body = history.getBody();
    }
}
