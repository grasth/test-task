import java.io.FileReader;
import java.sql.Date;
import java.sql.Time;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Quantity> visitorList = new ArrayList<>();
        String[] fileData = readFile(args[0]);
        List<long[]> timeList = new ArrayList<>();

        for (String item: fileData) {
            var temp = item.split(" ");
            var timeIn = temp[0].split(":");
            var convertToLongIn = Long.valueOf(Integer.parseInt(timeIn[0])*60*60 + Integer.parseInt(timeIn[1])*60);
            var timeOut = temp[1].split(":");
            var convertToLongOut = Long.valueOf(Integer.parseInt(timeOut[0])*60*60 + Integer.parseInt(timeOut[1])*60);

            visitorList.add(new Quantity(convertToLongIn, convertToLongOut));
        }

        for (Quantity main:
             visitorList) {
            int visitor = 0;

            long firstVisitor = 0;
            long lastVisitor = 0;

            for (Quantity second:
                    visitorList) {

                if (main.getIn() > second.getIn()) {
                    if (main.getIn() <= second.getOut()) {
                        if(firstVisitor > main.getIn()) {
                            firstVisitor = main.getIn();
                        }
                        if(firstVisitor == 0){
                            firstVisitor = main.getIn();
                        }
                        visitor++;
                    }
                } else if (main.getIn() < second.getIn()) {
                    if (main.getOut() >= second.getIn()) {
                        if(lastVisitor < main.getOut()) {
                            lastVisitor = main.getOut();
                        }
                        visitor++;
                    }
                } else {
                    if(firstVisitor > main.getIn()) {
                        firstVisitor = main.getIn();
                    }
                    if(firstVisitor == 0){
                        firstVisitor = main.getIn();
                    }
                    visitor++;}
            }
            System.out.println(timeToString(firstVisitor) + " " + timeToString(lastVisitor));
            main.setVisitorsData(firstVisitor, lastVisitor);
            main.setVisitorCount(visitor);
        }

        int max = 0;
        int index = 0;
        int i= 0;
        for (var item:
             visitorList) {
            if(item.getVisitorCount()>max){
                index = i;
                max = item.getVisitorCount();
            }
            i++;
        }
        var result = visitorList.get(index);
        System.out.println(timeToString(result.getFirstVisitorIn()) + " " + timeToString(result.getLastVisitorOut()));
    }

    public static String timeToString(long secs) {
        long hour = secs / 3600,
                min = secs / 60 % 60;
        return String.format("%02d:%02d", hour, min);
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
