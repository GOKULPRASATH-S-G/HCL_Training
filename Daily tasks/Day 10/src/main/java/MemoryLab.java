
public class MemoryLab {

    public static void main(String[] args) {
        String mode = args.length > 0 ? args[0] : "all";

        switch (mode) {
            case "stack" -> demonstrateStackOverflow();
            case "heap" -> demonstrateOutOfMemory();
            case "strings" -> compareStrings();
            case "integer" -> demonstrateIntegerCache();
            case "all" -> {
                demonstrateIntegerCache();
                compareStrings();
                System.out.println("\nRun separate commands for stack, heap and GC demonstrations.");
            }
            default -> System.out.println(
                    "Use: all, stack, heap, strings, or integer");
        }
    }

    // 1. StackOverflowError demonstration
    private static void demonstrateStackOverflow() {
        System.out.println("Demonstrating StackOverflowError...");
        recursiveCall();
    }

    private static void recursiveCall() {
        recursiveCall();
    }

    // 2. OutOfMemoryError demonstration
    private static void demonstrateOutOfMemory() {
        System.out.println("Demonstrating OutOfMemoryError...");
        byte[][] blocks = new byte[200][];
        for (int i = 0; i < blocks.length; i++) {
            blocks[i] = new byte[1024 * 1024];
        }
        System.out.println("Allocated memory successfully.");
    }

    // 3. String concatenation vs StringBuilder
    private static void compareStrings() {
        int iterations = 10_000;

        long start = System.nanoTime();
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += "a";
        }
        long stringTime = System.nanoTime() - start;

        start = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            builder.append("a");
        }
        String builderResult = builder.toString();
        long builderTime = System.nanoTime() - start;

        System.out.println("\nString Concatenation Comparison");
        System.out.println("String length: " + result.length());
        System.out.println("String += time: " + stringTime + " ns");
        System.out.println("StringBuilder length: " + builderResult.length());
        System.out.println("StringBuilder time: " + builderTime + " ns");
    }

    // 4. Integer cache and reference comparison
    private static void demonstrateIntegerCache() {
        Integer a = 127;
        Integer b = 127;

        Integer x = 128;
        Integer y = 128;

        System.out.println("\nInteger Cache Demonstration");
        System.out.println("a == b: " + (a == b));
        System.out.println("x == y: " + (x == y));
        System.out.println("x.equals(y): " + x.equals(y));
    }
}
