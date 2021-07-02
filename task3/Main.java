import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static double[] interval = new double[16];

    public static void main(String[] args) throws Exception {
        readFiles(args[0]);
        getMax();
    }

    public static void readFiles(String path) throws Exception{

        File files = new File(path);
        for (File item:
             files.listFiles()) {
            if(item.toString().contains("cash") && item.toString().contains(".txt"))
            {
                try {
                    Scanner scan = new Scanner( new FileReader(item.getAbsolutePath()));
                    double[] lines = new double[0];
                    while (scan.hasNextLine()) {
                            lines = Arrays.copyOf(lines, lines.length + 1);
                            lines[lines.length - 1] = Double.parseDouble(scan.nextLine().replaceAll(",","").trim());
                    }
                    writeInterval(lines);
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void writeInterval(double[] queue){
        int i = 0;
        for (double item:
                queue) {
            interval[i]+= item;
            i++;
        }
    }

    public static void getMax(){
        int max = 0;

        for (int i =0; i< interval.length;i++){
            if(interval[i] > interval[max]){
                max = i;
            }
        }
        System.out.println(max+1);
    }
}
