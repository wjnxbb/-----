package model;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Response {
    private String state;
    private String head;
    private String htmlContent;
    private Socket socket;

    public Response(Socket socket) {
        this.state = "HTTP/1.1 200 OK";
        this.head = "Content-type:text/html;charset=utf-8";
        this.socket = socket;
    }

    public String getState() {
        return state;
    }

    public Response setState(Response.STATE state) {
        switch (state) {
            case OK_200:
                this.state = "HTTP/1.1 200 OK";
                break;
            case NOT_FOUND_404:
                this.state = "HTTP/1.1 404 NOT FOUND";
                break;
            default:
                break;
        }
        return this;
    }

    public String getHead() {
        return head;
    }

    public Response setHead(String head) {
        this.head = head;
        return this;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public Response setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
        return this;
    }

    public Response addHtmlContent(String str) {
        this.htmlContent += (str + "<br/>");
        return this;
    }

    public PrintWriter getOutputStream() {
        try {
            return new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return state + "\r\n" +
                head + "\r\n\r\n" +
                htmlContent;
    }

    public enum STATE {
        OK_200,
        NOT_FOUND_404
    }
}
