package stealbomber.attack;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.concurrent.ThreadLocalRandom;

import stealbomber.manage.ThreadControl;

/**
 * 攻击线程和主要方法
 * 
 * @author ObcbO
 */
public class Center implements Runnable {
    /** 错误次数 */
    private static int error = 0;
    /** final长度 */
    private static final int UAL;
    private static final int NUMSEGL;
    private static final int URLL;

    static {// 初始化
        UAL = stealbomber.manage.Storage.UA.length;
        NUMSEGL = stealbomber.manage.Storage.NUMSEG.length;
        URLL = stealbomber.manage.GetFile.urls.length;
    }

    public void run() {
        // proxy
        String[] proxy = AckProxy.dispose();

        while (ThreadControl.on) {
            // System.out.println(Thread.currentThread().getName());
            // url
            String url = URLL == 1 ? stealbomber.manage.GetFile.urls[0]
                    : stealbomber.manage.GetFile.urls[ThreadLocalRandom.current().nextInt(URLL)];
            // name
            StringBuilder username = new StringBuilder();
            switch (ThreadLocalRandom.current().nextInt(2)) {
                case 2:
                    username.append(
                            stealbomber.manage.Storage.NUMSEG[ThreadLocalRandom.current().nextInt(NUMSEGL)]);
                    for (byte i = 0; i < 8; i++) {
                        username.append(ThreadLocalRandom.current().nextInt(10));
                    }
                    break;
                case 1:
                    for (byte i = 0; i < ThreadLocalRandom.current().nextInt(8, 13); i++) {
                        if (i == 0) {
                            username.append(ThreadLocalRandom.current().nextInt(1, 10));
                        } else {
                            username.append(ThreadLocalRandom.current().nextInt(10));
                        }
                    }
                    username.append("@qq.com");
                    break;
                case 0:
                default:
                    for (byte i = 0; i < ThreadLocalRandom.current().nextInt(8, 13); i++) {
                        if (i == 0) {
                            username.append(ThreadLocalRandom.current().nextInt(1, 10));
                        } else {
                            username.append(ThreadLocalRandom.current().nextInt(10));
                        }
                    }
                    break;
            }
            // rp
            go(username.toString(), Password.get(), url, proxy);
        }
    }

    private static void go(String name, String pass, String surl, String[] proxy) {
        HttpURLConnection urlConn = null;
        try {
            URL url = new URL(surl);
            if (!stealbomber.manage.GetFile.proxyswitch) {
                urlConn = (HttpURLConnection) url.openConnection();
            } else {
                if ("http".equals(proxy[0])) {
                    Proxy lp = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxy[1], Integer.valueOf(proxy[2])));
                    urlConn = (HttpURLConnection) url.openConnection(lp);
                } else if ("socks".equals(proxy[0])) {
                    Proxy lp = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(proxy[1], Integer.valueOf(proxy[2])));
                    urlConn = (HttpURLConnection) url.openConnection(lp);
                }
            }
            urlConn.setRequestMethod("POST");
            // 超时时间
            urlConn.setConnectTimeout(3000);
            // 设置是否输出
            urlConn.setDoOutput(true);
            // 设置是否读入
            urlConn.setDoInput(true);
            // 设置是否使用缓存
            urlConn.setUseCaches(false);
            // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
            urlConn.setInstanceFollowRedirects(false);
            // 设置请求头
            urlConn.setRequestProperty("Content-Length", "40");
            urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            urlConn.setRequestProperty("User-Agent",
                    stealbomber.manage.Storage.UA[ThreadLocalRandom.current().nextInt(UAL)]);
            // 连接
            urlConn.connect();
            // 写入参数到请求中
            String param = stealbomber.manage.GetFile.param.replace("$[account]", name);
            param = param.replace("$[password]", pass);
            OutputStream out = urlConn.getOutputStream();
            out.write(param.getBytes());
            out.flush();
            out.close();
            // 输出
            if (stealbomber.manage.GetFile.gps) {
                System.out.println(name + " " + pass);
            }
        } catch (IOException e) {
            if (stealbomber.manage.GetFile.gpr) {
                System.out.println(surl + " 转发出错，错误信息：" + e.getLocalizedMessage() + ";" + e.getClass());
            }
            if (error >= 100) {
                error = 0;
                ThreadControl.stop();
                new Thread(new Runnable() {
                    public void run() {
                        System.gc();
                        if (stealbomber.manage.GetFile.gpr) {
                            System.out.println("\n错误次数过多, 正在重新启动 10s\n");
                        }
                        try {
                            Thread.sleep(10000);// 1000ms=1s
                        } catch (InterruptedException e1) {
                        }
                        ThreadControl.start();
                    }
                }, "ReloadThread").start();
            } else if (!"Connect timed out".equals(e.getLocalizedMessage())) {
                error = error + 5;
            } else if ("Connect timed out".equals(e.getLocalizedMessage())) {
                error++;
            }
        } finally {
            if (null != urlConn) {
                try {
                    urlConn.disconnect();
                } catch (Exception e) {
                    System.out.println(surl + " httpURLConnection 流关闭异常：" + e.getLocalizedMessage());
                }
            }
        }
    }
}