package model;

import java.util.HashMap;

public class Request {
    private String head;

    public boolean isGet() {
        return head.startsWith("GET");
    }

    public boolean setHead(String head) {
        this.head = head;
        return head != null && !head.isEmpty();
    }

    public String getGetURL() {
        if (isGet()) {
            int begin = head.indexOf("GET ") + 4;
//            int end = head.indexOf(" HTTP/");
            int end = head.indexOf("?");
            return head.substring(begin, end);
        }
        return null;
    }

    public HashMap<String, String> getParameter() {
        int begin = head.indexOf("?") + 1;
        int end = head.indexOf(" HTTP/");
        String par = head.substring(begin, end);              // http://www.xxx.com?name=xxx&psw=xxx
        HashMap<String, String> map = null;
        if (isGet()) {
            map = new HashMap<>();
            int mid, and;
            while (par.contains("=")) {
//                System.out.println(par);
                mid = par.indexOf("=");
                and = par.indexOf("&");
                if (and == -1) {
                    map.put(par.substring(0, mid), par.substring(mid + 1));
                    par = "";
                } else {
                    map.put(par.substring(0, mid), par.substring(mid + 1, and));
//                    System.out.println(par.substring(and + 1));
                    par = par.substring(and + 1);
                }
            }
        }

        return map;
    }

    public String getHead() {
        return head;
    }
}
