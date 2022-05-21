package stealbomber.manage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class file {
    // 默认值
    public static int thnum = 16;// 线程数
    public static String[] urls;// 网址
    public static String param;// 参数

    public static boolean success = true;

    public static final Properties properties = new Properties();

    public static boolean genoutput;
    public static boolean proxyswitch;
    public static String proxyfile;

    private static boolean findthnum = true;
    private static boolean findurl = true;
    private static boolean findparameter = true;

    public static boolean start(String getfile) {
        String file;
        if (getfile == null || getfile == "" || getfile.trim() == "") {
            if (!new File("default.properties").exists()) {
                System.out.print("未发现配置文件");
                generatefile();
                System.out.println(", 现已自动生成并使用默认配置文件");
            }
            file = "default.properties";
            try {
                properties.load(new FileInputStream(System.getProperty("user.dir") + File.separator + file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            file = getfile;
            try {
                properties.load(new FileInputStream(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!new File(file).exists()) {
                System.err.println("未发现选定的配置文件");
                System.exit(1);
            }
        }
        // properties.load(file.class.getClassLoader().getResourceAsStream(file));
        properties.list(System.out);
        System.out.println("-- file readout completed --");
        manage();
        return success;
    }

    private static void generatefile() {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("default.properties"));
            out.write("""
                    # StealBomber
                    # Author: ObcbO
                    # https://github.com/obcbo/stealbomber
                    # 线程数
                    threads=16
                    # 攻击网址 可同时使用多个网址(用,来隔开)
                    URL=http://47.93.13.217/2018.php
                    # 攻击参数
                    parameter=username=$[account]&pass=$[password]
                    # 生成输出
                    genoutput=true
                    # 代理
                    # proxyswitch=false
                    # proxyfile=all.txt
                    """);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void manage() {
        find();
        String temp;
        // 一些功能开关
        booleanmanage();
        // 线程数
        if (findthnum) {
            temp = properties.getProperty("threads");
            if (temp.matches("[0-9]*")) {
                thnum = Integer.parseInt(temp);
            } else {
                success = false;
                System.err.println("ERROR: 线程数 你输入的值不是一个正整数");
            }
        }
        // URL
        if (findurl) {
            String rurl = properties.getProperty("URL");
            List<String> list = new ArrayList<String>();
            if (rurl.contains(",")) {
                String[] urlStr = rurl.split(",");
                for (String string : urlStr) {
                    int i = 0;
                    if (urlStr[i].matches("(http|https)+://[^\\s]*")) {
                        list.add(string);
                    } else {
                        success = false;
                        System.err.println("ERROR: 攻击网址 你输入的字符串不是一个网址");
                    }
                    i++;
                }
            } else if (rurl.matches("(http|https)+://[^\\s]*")) {
                list.add(rurl);
            } else {
                success = false;
                System.err.println("ERROR: 攻击网址 你输入的字符串没有包含网址");
            }
            if (success) {
                int size = list.size();
                urls = (String[]) list.toArray(new String[size]);
            }
        } else {
            System.err.println("ERROR: 攻击网址 内容异常");
        }
        // 参数
        if (findparameter) {
            param = properties.getProperty("parameter").toString();
        } else {
            System.err.println("ERROR: 参数 内容异常");
        }
    }

    private static void find() {
        Set<String> set = new HashSet<String>(properties.stringPropertyNames());
        if (!set.contains("threads")) {
            findthnum = false;
            return;
        }
        if (!set.contains("URL")) {
            findurl = false;
            return;
        }
        if (!set.contains("parameter")) {
            findparameter = false;
            return;
        }
    }

    private static void booleanmanage() {
        // 生成账号密码输出
        genoutput = judge(true, "genoutput");
        // 代理
        proxyswitch = judge(false, "proxyswitch");
        proxyfile = properties.getProperty("proxyfile", "Not Found").toString();
    }

    // 默认值 文本
    private static boolean judge(boolean udefault, String value) {
        boolean output = true;
        if (properties.getProperty(value, "Not Found").toString() == "Not Found") {
            return udefault;
        } else
            value = properties.getProperty(value).toString();
        if ("TRUE".equals(value.toUpperCase())) {
            output = true;
        } else if ("FALSE".equals(value.toUpperCase())) {
            output = false;
        } else {
            System.err.println("ERROR: 布尔参数的值为 true 或 false");
            output = true;
        }
        return output;
    }
}