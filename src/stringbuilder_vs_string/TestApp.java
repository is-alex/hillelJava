package stringbuilder_vs_string;


public abstract class TestApp {
    public static void main(String[] args) {
        String string = "AA";
        StringBuilder stringBuilder = new StringBuilder("BB");
        int numOfIterations = 100_000;

        long start = System.currentTimeMillis();
        String newString = testString(string,numOfIterations);
        System.out.println("String: " + (System.currentTimeMillis() - start) + " ms.");

        start = System.currentTimeMillis();
        String newString2 = testStringBuilder(stringBuilder,numOfIterations);
        System.out.println("StringBuilder: " + (System.currentTimeMillis() - start) + " ms.");
    }

    public static String testString(String string, int numOfIterations){
        for (int i = 0; i<numOfIterations; i++){
            string += "test";
        }
        return string;
    }

    public static String testStringBuilder(StringBuilder stringBuilder, int numOfIterations){
        for (int i = 0; i<numOfIterations; i++){
            stringBuilder.append("test");

        }
        return stringBuilder.toString();

    }
}
