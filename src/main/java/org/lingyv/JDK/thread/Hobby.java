package org.lingyv.JDK.thread;

public class Hobby extends Thread {
    private static String[] hobby = {"看书","电子游戏"};

    private static void speak(){
        for (String h:hobby){
            System.out.println(h);
        }
    }

    @Override
    public void run() {
        speak();
    }
}
