import javafx.collections.transformation.SortedList;

import java.io.File;
import java.util.Arrays;

public class FSProcessor {
    private File dir;

    public FSProcessor(String path) {
        this.dir = new File(path);
    }

    public String getAbsolutPath() {
        return dir.getAbsolutePath();
    }

    public String[] getFilesAsString() {
        if (dir.exists()) {
            return dir.list();
        }
        return null;
    }

    public void getListOfDirs() {
        File[] curDirFiles = dir.listFiles();
//        if (curDirFiles != null) {
//            SortedList<File> filesList = Arrays.asList(curDirFiles);
//        }
        for (int i = 0; i < curDirFiles.length; i++) {
            if (curDirFiles[i].isDirectory()) {
                System.out.println(String.format("%-20s", curDirFiles[i].getName()) + " is a directory");
            } else if (curDirFiles[i].isFile()) {
                System.out.println(String.format("%-20s", curDirFiles[i].getName()) + " is a file");
            }
        }
    }
}
