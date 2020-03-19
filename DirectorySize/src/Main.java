import java.io.File;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String path = "data/snes9x";
        try {
            File folder = new File(path);
            if (folder.isDirectory()) {
                System.out.println("Размер папки равен " + processSize(getSum(folder)));
            } else {
                System.out.println("По указанному пути нет папки");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static long getSum (File folder) {
        long result = 0;

        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getSum(file);
                continue;
            }
            result += file.length();
        }
        return result;
    }

    public static String processSize (long size) {
        double processedSize = (double) size;
        DecimalFormat df = new DecimalFormat("###.##");
        String result;
        int i = 0;
        String[] units = new String[]{"байт", "КБ", "МБ", "ГБ", "ТБ"};

        while (processedSize > 1024) {
            processedSize /= 1024;
            i++;
        }
        result = df.format(processedSize )+ " " + units[i];
        return result;
    }
}
