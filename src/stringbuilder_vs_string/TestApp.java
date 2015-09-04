package stringbuilder_vs_string;


public class TestApp {
    public static void main(String[] args) {
        String string = "AA";
        StringBuilder stringBuilder = new StringBuilder("BB");
        int numOfIterations = 100_000;
        testString(string,numOfIterations);
        testStringBuilder(stringBuilder,numOfIterations);
    }

    public static void testString(String string, int numOfIterations){
        long start = System.currentTimeMillis();
        for (int i = 0; i<numOfIterations; i++){
            string += "test";
        }
        System.out.println("String: " + (System.currentTimeMillis() - start) + " ms.");
    }

    public static void testStringBuilder(StringBuilder stringBuilder, int numOfIterations){
        long start = System.currentTimeMillis();
        for (int i = 0; i<numOfIterations; i++){
            stringBuilder.append("test");
        }
        System.out.println("StringBuilder: " + (System.currentTimeMillis() - start) + " ms.");

    }
}
