import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        StudentCheckerImpl checker = new StudentCheckerImpl();
        String id = request.getParameter("studentID");
//        获取学号
        String name = request.getParameter("studentName");
//        获取姓名
        ArrayList checkList = checker.check(id);
//        获取查询结果
        PrintWriter out = response.getWriter();
        if (name.equals(checkList.get(2))){
            out.print("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>查分系统</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div align=\"center\"><p>2021-2022学年第二学期期末统考</p></div>\n" +
                    "    <table align=\"center\" border=\"2px\">\n" +
                    "        <tr>\n" +
                    "            <td>班级</td>\n" +
                    "            <td>考号</td>\n" +
                    "            <td>姓名</td>\n" +
                    "            <td>类别</td>\n" +
                    "            <td>语文</td>\n" +
                    "            <td>语文名次</td>\n" +
                    "            <td>数学</td>\n" +
                    "            <td>数学名次</td>\n" +
                    "            <td>外语</td>\n" +
                    "            <td>外语名次</td>\n" +
                    "            <td>物理</td>\n" +
                    "            <td>物理名次</td>\n" +
                    "            <td>历史</td>\n" +
                    "            <td>历史名次</td>\n" +
                    "            <td>化学</td>\n" +
                    "            <td>化学名次</td>\n" +
                    "            <td>生物</td>\n" +
                    "            <td>生物名次</td>\n" +
                    "            <td>地理</td>\n" +
                    "            <td>地理名次</td>\n" +
                    "            <td>政治</td>\n" +
                    "            <td>政治名次</td>\n" +
                    "            <td>总成绩</td>\n" +
                    "            <td>年级名次</td>\n" +
                    "        </tr>\n");
//            打印原始表格
            out.println("<tr>");
            for (Object o : checkList) {

                out.println("<td>" + o.toString() + "</td>");
            }
            out.println("</tr>");
            out.print("</table>\n" +
                    "</body>\n" +
                    "</html>");
//            打印成绩单
            out.flush();
            out.close();
        }else {
            out.print("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>查询系统</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <script type=\"text/javascript\">\n" +
                    "        alert(\"学号与姓名不符！\");\n" +
                    "        window.location.href = \"/Servlet/page/queryPage.html\";\n" +
                    "    </script>\n" +
                    "</body>\n" +
                    "</html>");
//            打印查询错误的网页并跳转到查分页面
        }
    }
}
