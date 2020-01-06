//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import TI.BoeBot;
import TI.Servo;

public class RobotMain {
    public static Servo s1 = new Servo(12);
    public static Servo s2 = new Servo(13);
    public static int xcur;
    public static int ycur;
    public static int xnxt;
    public static int ynxt;
    public static int rtgo;
    public static int ltgo;
    public static int ftgo;
    public static int btgo;

    public RobotMain() {
    }

    //test comment to see if commits work


    public static void main(String[] args) {
        System.out.println("spoorzoeken...");


            while(true) {
                int waardeM = BoeBot.analogRead(0);
                int waardeR = BoeBot.analogRead(1);
                int waardeL = BoeBot.analogRead(2);

                rtgo = xnxt - xcur;
                ltgo = xcur - xnxt;
                ftgo = ynxt - ycur;
                btgo = ycur - ynxt;

                BoeBot.wait(40);
                if (waardeL > 500 && waardeR <= 500) {
                    s1.update(1500);
                    s2.update(1450);
                    BoeBot.wait(100);
                }

                if (waardeL <= 500 && waardeR > 500) {
                    s1.update(1550);
                    s2.update(1500);
                    BoeBot.wait(100);
                } else {
                    s1.update(1550);
                    s2.update(1450);
                    BoeBot.wait(40);
                }

            }
        }

    public static void rem() {
        s1.update(1500);
        s2.update(1500);
    }
}
