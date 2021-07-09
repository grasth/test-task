import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class task1 {

    public static DecimalFormat df=new DecimalFormat("0.00");

    public static void main(String[] args) throws Exception{
        try {
            String[] lines = readFile(args[0]);
            System.out.println(String.format("%.2f", percentile(lines, 90.0)).replace(',', '.'));
            System.out.println(String.format("%.2f", percentile(lines, 50.0)).replace(',', '.'));
            System.out.println(String.format("%.2f", max(lines)).replace(',', '.'));
            System.out.println(String.format("%.2f", min(lines)).replace(',', '.'));
            System.out.println(String.format("%.2f", avg(lines)).replace(',', '.'));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String[] readFile(String fileName) throws Exception{
        String[] lines = new String[0];
        if(!fileName.contains(".txt"))
            fileName+=".txt";
        try {
            Scanner scan = new Scanner( new FileReader(fileName));
            while (scan.hasNextLine()) {
                lines = Arrays.copyOf(lines, lines.length+1);
                lines[lines.length-1] = scan.nextLine();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return lines;
    }

    public static int[] convertToInt(String[] array){
        int[] intArray = new int[array.length];
        int i = 0;

        for (String item :
                array) {
            intArray[i] = Integer.valueOf(item.trim());
            i++;
        }
        Arrays.sort(intArray);
        return intArray;
    }

    public static double percentile(String[] array, double percent) {
        int[] intArray = convertToInt(array);
        double res = (double) ((percent/100.0)*(intArray.length-1))+1.0;
        double remainder =  Math.round((res - (int)res)* 100.0) / 100.0;
        int index = (int)(res - remainder);
        if(index < intArray.length-1) {
            return (intArray[index-1]) + remainder * (intArray[index] - intArray[index-1]);
        } else {
            return (intArray[index-1]) + (remainder * (intArray[intArray.length-1] - intArray[index-1]));
        }
    }

    public static double min(String[] array){
        int[] intArray = convertToInt(array);
        return (double)intArray[0];
    }

    public static double max(String[] array){
        int[] intArray = convertToInt(array);
        return (double)intArray[intArray.length-1];
    }

    public static double avg(String[] array){
        int[] intArray = convertToInt(array);
        double sum = 0;
        for (var item:
                intArray) {
            sum+=item;
        }

        return sum/intArray.length;
    }
}
