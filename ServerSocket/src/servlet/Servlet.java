package servlet;

import model.Request;
import model.Response;

public class Servlet implements IServlet {

    @Override
    public void doGet(Request request, Response response) {
        response.setHtmlContent("hello");
    }

    @Override
    public void doPost(Request request, Response response) {
        doGet(request, response);
    }
}
