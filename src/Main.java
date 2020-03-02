import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FSProcessor curDir = new FSProcessor("./");
        String[] files = curDir.getFilesAsString();
        System.out.println(curDir.getAbsolutPath());
        System.out.println("-----------");
        try {
            curDir.recursive("./");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
