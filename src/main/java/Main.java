import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> newString = new ArrayList<>();
        String output = (new Main()).readRawDataToString();
        String breakPoint = "##";
        String[] var;
        String[] result = output.split(breakPoint);
        for (String sent : result) {
            String breakPointVar = ";";
            var = sent.split(breakPointVar);
            //System.out.println(Arrays.toString(var));
            for (String s : var) {
                String[] newArr = s.split("[,!*^%&@]");
                //System.out.println(Arrays.toString(newArr));
                for (String sr : newArr) {
                    String[] newerArr = sr.split(", ");
                    //System.out.println(Arrays.toString(newerArr));
                    for (String ar : newerArr) {
                        String[] newSr = ar.split(":");
                        newString.addAll(Arrays.asList(newSr));
                    }
                }
            }
        }
        System.out.println(newString);
        milkCounter(newString);
        breadCounter(newString);
        cookiesCounter(newString);
        applesCounter(newString);
    }

    public static void milkCounter(ArrayList<String> newString) {
        int counter = 0;
        int counterPrice = 0;
        Pattern p = Pattern.compile("[mM][iI][lL][kK]");
        for (String s : newString) {
            Matcher m = p.matcher(s);
            if (m.matches()) {

                counter++;
            } 
        }
        System.out.println("Milk Amount: " + counter);
    }

    public static void breadCounter(ArrayList<String> newString) {
        int counter = 0;

        Pattern p = Pattern.compile("[bB][rR][eE][aA][dD]");
        for (String s : newString) {
            Matcher m = p.matcher(s);
            if (m.matches()) {

                counter++;
            }
        }
        System.out.println("Bread Amount: " + counter);
    }

    public static void cookiesCounter(ArrayList<String> newString) {
        int counter = 0;

        Pattern p = Pattern.compile("[cC][oO][oO][kK][iI][eE][sS]");
        for (String s : newString) {
            Matcher m = p.matcher(s);
            if (m.matches()) {

                counter++;
            }
        }
        System.out.println("Cookies Amount: " + counter);
    }

    public static void applesCounter(ArrayList<String> newString) {
        int counter = 0;

        Pattern p = Pattern.compile("[aA][pP][pP][lL][eE][sS]");
        for (String s : newString) {
            Matcher m = p.matcher(s);
            if (m.matches()) {

                counter++;
            }
        }
        System.out.println("Apple Amount: " + counter);
    }


}
