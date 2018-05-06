package sample;

public class ClickThread extends Thread {

    boolean isStopped;

    private Controller controller;

    public ClickThread(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        controller.addLog("started");
        while (!isStopped) {
            String root = getClass().getClass().getResource("/").getPath();
            String adbPath = root + "/platform-tools/adb";
            click(adbPath, 150);
            click(adbPath, 150);
            swipe(adbPath, 250);
            swipe(adbPath, 250);
            swipe(adbPath, 250);

        }

        controller.addLog("stopped");
    }

    private void swipe(String adbPath,int time) {
        int x1 = (int) (0.9 * 1080);
        int y1 = (int) (0.75 * 2160);

        int x = (int) ((0.21 + Math.random() * 0.58) * 1080);
        int y = (int) ((0.21 + Math.random() * 0.58) * 2160);

        String input = String.format(" shell input swipe %d %d %d %d %d", x, y, x1, y1, 200);

        String adbCommand = adbPath + input;
        controller.addLog("划动x:" + x + ",y:" + y);
        try {
            Runtime.getRuntime().exec(adbCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void click(String adbPath,int time) {
        int x = (int) ((0.21 + Math.random() * 0.58) * 1080);
        int y = (int) ((0.21 + Math.random() * 0.58) * 2160);

        String input = String.format(" shell input tap %d %d", x, y);

        String adbCommand = adbPath + input;
        controller.addLog("点击x:" + x + ",y:" + y);
        try {
            Runtime.getRuntime().exec(adbCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
