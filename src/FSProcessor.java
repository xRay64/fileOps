import javafx.collections.transformation.SortedList;

import java.io.File;
import java.io.IOException;

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

    public void recursive(String path) throws IOException{
        recursive(path, 0);
    }

    public void recursive(String path, int level) throws IOException{
        File curDir = new File(path);
        int lvl = level;
        String fillerPattern = "|__";
        String filler = "";
        for (int i = 1; i <= lvl; i++) {
            filler = String.format("%"+ (lvl*3) +"s",fillerPattern);
        }
        File[] fileList = curDir.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isDirectory() & !fileList[i].getName().substring(0, 1).equals(".")) {
                lvl++;
                System.out.println(filler + fileList[i].getName()); //------------
                recursive(curDir.getCanonicalPath() + "/" + fileList[i].getName(), lvl);
            } else if (fileList[i].getName().substring(0, 1).equals(".")) {
                continue;
            } else {
                System.out.println(String.format(filler + fileList[i].getCanonicalPath() + ", lvl= " + lvl));
            }
        }
    }
}
