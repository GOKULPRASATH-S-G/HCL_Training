public class PlatformInfo {

    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();

        System.out.println("===== Java Platform Information =====");

        System.out.println("Java Version       : "
                + System.getProperty("java.version"));

        System.out.println("Operating System   : "
                + System.getProperty("os.name"));

        System.out.println("OS Version         : "
                + System.getProperty("os.version"));

        System.out.println("Architecture       : "
                + System.getProperty("os.arch"));

        System.out.println("Processors         : "
                + runtime.availableProcessors());

        System.out.println("Max Heap           : "
                + runtime.maxMemory() / (1024 * 1024) + " MB");

        System.out.println("Free Heap          : "
                + runtime.freeMemory() / (1024 * 1024) + " MB");

        System.out.println("Total Heap         : "
                + runtime.totalMemory() / (1024 * 1024) + " MB");
    }
}