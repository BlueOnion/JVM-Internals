package pl.abaranowska.ug;

public class MyHandler {

    public static void takeTheTime(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }
}