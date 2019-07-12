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
    //�˿�
    private static int port;
    //�����̳߳صĴ�С
    private static int corePoolSize;
    //�ܴ�С
    private static int maximumPoolSize;
    //ʱ�����ƣ��룩
    private static int keepAliveTime;

    //��������
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
        //�̳߳�
        ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, SECONDS, new ArrayBlockingQueue<>(1000));
        Socket socket;
        try {
            while (flag) {
                //���տͻ�������
                socket = serverSocket.accept();
                //�ŵ��̳߳���ͷ
                pool.execute(new IOThread(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

