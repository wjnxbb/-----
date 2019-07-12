package service;

import model.Request;
import model.Response;
import servlet.IServlet;
import utils.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Properties;

public class IOThread implements Runnable {
    private static Properties web;

    //º”‘ÿ≈‰÷√
    static {
        try {
            web = Util.loadProperties("web.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Socket socket;

    public IOThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintWriter pw = null;
        Request request;
        Response response;
        String url, servletName;
        Class servlet;
        IServlet instance;
        try {
            request = new Request();
            response = new Response(socket);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = response.getOutputStream();

            while ((request.setHead(br.readLine()))) {
                System.out.println(request.getHead());
                if (request.isGet()) {
                    url = request.getGetURL();
                    servletName = web.getProperty(url);
                    if (servletName != null) {
                        servlet = Class.forName(servletName);
                        instance = (IServlet) servlet.newInstance();
                        instance.doGet(request, response);
                    } else {
                        response.setState(Response.STATE.NOT_FOUND_404);
                    }
                } else {

                }
            }
            pw.println(response);
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("∂œø™");
                Objects.requireNonNull(br).close();
                Objects.requireNonNull(pw).close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
