package by.jd2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = new PrintWriter(
                new OutputStreamWriter(resp.getOutputStream(), "UTF8"), true);
        out.println("<html>");
        out.println("<body>");
        out.println("<form action=\"\" method=\"POST\">");
        out.println("<label for=\"text\">Введите строку:</label>");
        out.println("<input id=\"text\" name=\"stroka\" type=\"text\" required=\"\">");
        out.println("<button id=\"button\" type=\"submit\">Определить</button>");
        out.println("</form>");
        if (req.getParameter("stroka")!=null) {
            String retStr = "";
            StringType value = by.jd2.App.getTypeString(req.getParameter("stroka"));
            if (value == StringType.EMAIL) retStr = "EMail";
            else if (value == StringType.FAMILY) retStr = "Фамилия";
            else if (value == StringType.PHONE) retStr = "Телефон";
            else if (value == StringType.INSURANCE) retStr = "Страховое свидетельство";
            else retStr = "Простая строка";
            out.println(retStr);
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

}