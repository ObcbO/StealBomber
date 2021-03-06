package stealbomber.attack;

import java.util.concurrent.ThreadLocalRandom;
import stealbomber.manage.Storage;

/**
 * 生成密码的类
 * 
 * @author ObcbO
 */
public class Password {
    private static StringBuilder pass;

    /** final长度 */
    private static final int PWL = Storage.PW.length;

    /** 密码中的所有类型 */
    private static final String[] TYPE = {
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "abcdefghijklmnopqrstuvwxyz",
            "0123456789",
            "!@#$%^&*"
    };

    /**
     * 生成社工密码
     * 
     * @author ObcbO
     * @return 8~16位数密码
     */
    protected static String get() {
        return generate();
    }

    private static String generate() {
        try {// 防止生成失败(如令我感到疑惑的数组越界问题)
            int extent = ThreadLocalRandom.current().nextInt(8, 17);
            pass = new StringBuilder(extent);
            switch (ThreadLocalRandom.current().nextInt(8)) {
                // 全随机
                case 0 -> {
                    for (byte i = 0; i < extent; i++) {
                        g(ThreadLocalRandom.current().nextInt(4), 1);
                    }
                }
                // 弱口令
                case 1 -> pass.append(Storage.PW[ThreadLocalRandom.current().nextInt(PWL)]);
                // 规则生成
                case 2 -> {
                    // AAA(AA)123
                    ms();
                    g(0, ThreadLocalRandom.current().nextInt(3, 6));
                    ms();
                    g(2, extent - 4);
                    ms();
                }
                case 3 -> {
                    // 123AAA(AA)
                    ms();
                    g(2, extent - 4);
                    ms();
                    g(0, ThreadLocalRandom.current().nextInt(3, 6));
                    ms();
                }
                case 4 -> {
                    // aaa(aa)123
                    ms();
                    g(1, ThreadLocalRandom.current().nextInt(3, 6));
                    ms();
                    g(2, extent - 4);
                    ms();
                }
                case 5 -> {
                    // 123aaa(aa)
                    ms();
                    g(2, extent - 4);
                    ms();
                    g(1, ThreadLocalRandom.current().nextInt(3, 6));
                    ms();
                }
                case 6 -> {
                    // A(A)aa(aa)123
                    ms();
                    g(0, ThreadLocalRandom.current().nextInt(1, 3));
                    ms();
                    g(1, ThreadLocalRandom.current().nextInt(2, 5));
                    ms();
                    g(2, extent - 4);
                    ms();
                }
                case 7 -> {
                    // 123A(A)aa(aa)
                    ms();
                    g(2, extent - 4);
                    ms();
                    g(0, ThreadLocalRandom.current().nextInt(1, 3));
                    ms();
                    g(1, ThreadLocalRandom.current().nextInt(2, 5));
                    ms();
                }
                default -> throw new ArrayIndexOutOfBoundsException();
            }
            return pass.toString();
        } catch (ArrayIndexOutOfBoundsException e) {
            return generate();
        }
    }

    private static void ms() {
        // 20%的概率
        if (ThreadLocalRandom.current().nextInt(19) == 0) {
            g(3, 1);
        }
    }

    private static void g(int options, int length) {
        int tlength = switch (options) {
            // 大小写
            case 0, 1 -> 26;
            // 数字
            case 2 -> 10;
            // 特殊符号
            case 3 -> 8;
            default -> throw new IllegalArgumentException("Unexpected value: " + options);
        };
        for (byte i = 0; i < length; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt(tlength);
            pass.append(TYPE[options].charAt(randomInt));
        }
    }
}