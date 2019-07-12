package servlet;

import model.Request;
import model.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Login implements IServlet {
    @Override
    public void doGet(Request request, Response response) {
        response.setHtmlContent("<h1>µÇÂ¼</h1>");
        HashMap<String, String> map = request.getParameter();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            response.addHtmlContent(entry.getKey() + "::" + entry.getValue());
        }
    }

    @Override
    public void doPost(Request request, Response response) {

    }
}
