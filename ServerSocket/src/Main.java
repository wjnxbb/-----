import service.IOThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.SECONDS;
import static utils.Util.loadProperties;

public class Main {
    private static Properties config;
    //端口
    private static int port;
    //单个线程池的大小
    private static int corePoolSize;
    //总大小
    private static int maximumPoolSize;
    //时间限制（秒）
    private static int keepAliveTime;

    //加载配置
    static {
        try {
            config = loadProperties("config.properties");
            String port = config.getProperty("port");
            String corePoolSize = config.getProperty("corePoolSize");
            String maximumPoolSize = config.getProperty("maximumPoolSize");
            String keepAliveTime = config.getProperty("keepAliveTime");
            Main.port = port == null ? 9999 : Integer.parseInt(port);
            Main.corePoolSize = corePoolSize == null ? 10 : Integer.parseInt(corePoolSize);
            Main.maximumPoolSize = maximumPoolSize == null ? 20 : Integer.parseInt(maximumPoolSize);
            Main.keepAliveTime = keepAliveTime == null ? 60 : Integer.parseInt(keepAliveTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        boolean flag = true;
        //线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, SECONDS, new ArrayBlockingQueue<>(1000));
        Socket socket;
        try {
            while (flag) {
                //接收客户端连接
                socket = serverSocket.accept();
                //放到线程池里头
                pool.execute(new IOThread(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

