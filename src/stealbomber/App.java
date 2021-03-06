package stealbomber;

import stealbomber.attack.Center;
import stealbomber.manage.GetFile;

/**
 * 程序的起点 stealbomber.app
 * 
 * @author ObcbO
 */
public final class App {
    public static final float VERSION = 1.6f;

    public static void main(String[] args) {
        System.out.print(
                "-------------------------------------------------------------------------\n" +
                        " _____ _             _   ____                  _               \n" +
                        " / ____| |           | | |  _ /                | |              \n" +
                        "| (___ | |_ ___  __ _| | | |_) | ___  _ __ ___ | |__   ___ _ __ \n" +
                        " /___ /| __/ _ // _` | | |  _ < / _ /| '_ ` _ /| '_ / / _ / '__|\n" +
                        " ____) | ||  __/ (_| | | | |_) | (_) | | | | | | |_) |  __/ |   " + " V" + VERSION + "\n" +
                        "|_____/ /__/___|/__,_|_| |____/ /___/|_| |_| |_|_.__/ /___|_|   " + " Author: ObcbO" + "\n" +
                        "-------------------------------------https://github.com/obcbo/stealbomber\n");
        if (GetFile.start(System.getProperty("file"))) {
            System.gc();
            Center.start();
        } else {
            System.exit(1);
        }
    }
}