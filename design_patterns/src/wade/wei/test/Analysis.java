package wade.wei.test;

/**
 * @author Administrator
 * 解析字符串
 */
public class Analysis {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("一、多选题").append("\r\n");
        sb.append("1、门店改造工程承包，需要工地工人考勤表吗？( ) [ ]").append("\r\n");
        sb.append("A、需要    B、不需要   C、其他  可要可不要，都行").append("\r\n");
        sb.append("2、需要签订小工协议吗？( )  [ ]").append("\r\n");
        sb.append("A、需要    B、不需要   C、其他  可要可不要，都行").append("\r\n");
        sb.append("3、工地大宗工程材料采购需要几家以上的比价？( ) [ ]").append("\r\n");
        sb.append("A、一家报价    B、两家报价    C、三家以上").append("\r\n");

        String a="\\[([^]])*\\]";//"\\(([^}])*\\)";
        String s = sb.toString().replaceAll(a, " <input type='text' style='width: 40px;height: 30px' class='chose'/>");
        //String s1 = sb.toString().replaceAll("\\[|\\]", " <input type='text' style='width: 40px;height: 30px' class='scorePer'/>");
        System.out.println(s);

    }
}
