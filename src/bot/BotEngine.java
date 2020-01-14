package bot;

import static java.lang.Thread.sleep;

class BotEngine {
    static void loadingAnimation (int length, long ms) throws InterruptedException {
        long time = java.lang.System.currentTimeMillis();
        int currentLength = 0;
        while (time + ms > java.lang.System.currentTimeMillis()) {
            //If dots number = length, remove all dots
            if (currentLength == length) {
                for (int i = 0; i < length; i++) {
                    System.out.print("\b");
                }
                currentLength = 0;
            }

            System.out.print(".");
            currentLength++;
            sleep(400);
        }

        //At finish remove all dots
        for (int i = 0; i < currentLength; i++) {
            System.out.print("\b");
        }
    }
}