import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathFrom = "data/dataForCopy/snes9x";
        String pathTo = "data/copiedData/";

        try {
            copyFolder(pathFrom, pathTo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void copyFolder (String from, String to) throws FileNotFoundException, IOException {
        File folderFrom = new File(from);
        File folderTo = new File(to);
        copyDirectoryTree (folderFrom, folderTo);
        copyFiles(folderFrom, folderTo);
    }

    public static void copyDirectoryTree (File folderFrom, File folderTo) {
        for (File file : folderFrom.listFiles()) {
            if(file.isDirectory() && file.listFiles().length == 0) {
                new File (file.getAbsolutePath().replace(folderFrom.getAbsolutePath(), folderTo.getAbsolutePath())).mkdir();
            } else if (file.isDirectory() && file.listFiles().length > 0) {
                File newFolder = new File (file.getAbsolutePath().replace(folderFrom.getAbsolutePath(), folderTo.getAbsolutePath()));
                newFolder.mkdir();
                copyDirectoryTree(file, newFolder);
                continue;
            }
        }
    }

    public static void copyFiles (File folderFrom, File folderTo) throws FileNotFoundException, IOException {
        for (File file : listAllFiles(folderFrom)) {
            FileInputStream is = new FileInputStream(file.getAbsolutePath());
            FileOutputStream os = new FileOutputStream(file.getAbsolutePath().replace(folderFrom.getAbsolutePath(), folderTo.getAbsolutePath()));
            byte[] buffer = new byte[is.available()];
            is.read(buffer,0, buffer.length);
            os.write(buffer,0, buffer.length);
            is.close();
            os.close();
        }
    }

    public static ArrayList<File> listAllFiles (File folder) {
        ArrayList<File> files = new ArrayList<>();
        for (File file : folder.listFiles()) {
            if (file.isDirectory() && file.listFiles().length > 0) {
                files.addAll(listAllFiles(file));
                continue;
            }
            if (file.isFile()) {
                files.add(file);
            }
        }
        return files;
    }
}
