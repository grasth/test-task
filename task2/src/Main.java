import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
	    String[] input = readFile(args[0]);
        String[] points = readFile(args[1]);

        List<Points> pointsList = new ArrayList<Points>();
        for (String item:
             input) {
            var temp = item.split(" ");
            pointsList.add(new Points(Double.parseDouble(temp[0]), Double.parseDouble(temp[1])));
        }

        List<Points> checkList = new ArrayList<Points>();
        for (String item:
                points) {
            var temp = item.split(" ");
            checkList.add(new Points(Double.parseDouble(temp[0]), Double.parseDouble(temp[1])));
        }

        for (var item:
             checkList) {
            System.out.println(item.getX() + " : " + item.getY());
        }

        int[][] res = new int[4][1];

        for (var main:
             pointsList) {
            int i=0;
            for (var second:
                 checkList) {
                if(second.getX() > main.getX()){
                    if(second.getY() > main.getY());
                }
            }
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
}
