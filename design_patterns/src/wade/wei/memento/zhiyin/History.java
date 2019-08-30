package wade.wei.memento.zhiyin;

/**
 * @author Administrator
 * 备忘录,相当于快照
 * 文档的备忘录
 * 备忘录Memento：历史内容
 */
public class History {
    private String body;

    public History(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}
