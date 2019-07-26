package 多线程.staticBlock;

public class AppTest {
    public static void main(String[] args) {
//        new Thread("T1"){
//            @Override
//            public void run() {
//                try {
//                    StaticSyn.testLock1();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//        new Thread("T2"){
//            @Override
//            public void run() {
//                try {
//                    StaticSyn.testLock2();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//        new Thread("T3"){
//            @Override
//            public void run() {
//                try {
//                    StaticSyn ss = new StaticSyn();
//                    ss.testLock3();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
        StaticSyn ss = new StaticSyn();
        new Thread("T4"){
            @Override
            public void run() {
                try {
//                    StaticSyn ss = new StaticSyn();
                    ss.testLock4();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

//        new Thread("T5"){
//            @Override
//            public void run() {
//                try {
//                    ss.testLock5(ss);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//
        Thread thread = new Thread("T6") {
            @Override
            public void run() {
                try {
                    ss.testLock6();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
