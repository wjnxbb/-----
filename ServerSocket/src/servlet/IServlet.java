package servlet;

import model.Request;
import model.Response;

public interface IServlet {
    void doGet(Request request, Response response);

    void doPost(Request request, Response response);
}
