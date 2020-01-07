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


        while (true) {
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

                if (waardeL > 500 && waardeR > 500 && waardeM > 500) {
                    if (rtgo > 0) {
                        draaiGraden(90, 1);
                        s1.update(1550);
                        s2.update(1450);
                        rtgo = rtgo- 1;
                    }
                    if (ltgo > 0) {
                        draaiGraden(-90, 1);
                        s1.update(1550);
                        s2.update(1450);
                        ltgo = ltgo- 1;
                    }
                    if (ftgo > 0) {
                        s1.update(1550);
                        s2.update(1450);
                        ftgo = ftgo- 1;
                    }
                    if (btgo > 0) {
                        draaiGraden(180, 1);
                        s1.update(1450);
                        s2.update(1550);
                        ynxt = ynxt+ 1;
                    }
                    BoeBot.wait(100);

                    } else {
                        s1.update(1550);
                        s2.update(1450);
                        BoeBot.wait(40);
                    }
                }
            }
        }

        public static void rem () {
            s1.update(1500);
            s2.update(1500);
        }
        public static void draaien ( int draaiSnelheid){
            int huidigeSnelheid1 = 1500 + draaiSnelheid;
            int huidigeSnelheid2 = 1500 + draaiSnelheid;
            s1.update(huidigeSnelheid1);
            s2.update(huidigeSnelheid2);
        }
        public static void draaiGraden ( int graden, int draaiSnelheid){
            int millis = 4;
            int max = 200;

            draaien(draaiSnelheid);

            double stap1 = 4.0 / draaiSnelheid;
            double stap2 = stap1 * 200.0;
            double stap3 = graden * stap2;

            System.out.println(stap3);
            BoeBot.wait((int) stap3);
            s1.update(1500);
            s2.update(1500);
        }
}