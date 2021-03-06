package stealbomber.attack;

import java.util.concurrent.ThreadLocalRandom;

import stealbomber.manage.Storage;

public class UserName {
    private static final int NUMSEGL;
    static {
        NUMSEGL = Storage.NUMSEG.length;
    }

    protected static String get() {
        StringBuilder username = new StringBuilder();
        switch (ThreadLocalRandom.current().nextInt(2)) {
            case 2:
                try {
                    username.append(Storage.NUMSEG[ThreadLocalRandom.current().nextInt(NUMSEGL)]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    return get();
                }
                for (byte i = 0; i < 8; i++) {
                    username.append(ThreadLocalRandom.current().nextInt(10));
                }
                break;
            case 1:
                username.append("@qq.com");
            case 0:
            default:
                int length = ThreadLocalRandom.current().nextInt(8, 13);
                username.insert(0, ThreadLocalRandom.current().nextInt(1, 10));// 首位不为0
                for (byte i = 0; i < length - 1; i++) {
                    username.insert(1, ThreadLocalRandom.current().nextInt(10));
                }
                break;
        }
        return username.toString();
    }
}
