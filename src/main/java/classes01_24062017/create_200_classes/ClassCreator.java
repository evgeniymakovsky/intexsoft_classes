package classes01_24062017.create_200_classes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ClassCreator {

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            FileOutputStream fop = null;
            File file;
            String classNumber = String.valueOf(i+1);
            String content = "public class HelloWorld_Makovsky" + classNumber + "{" +
                                "\npublic static void main(String[] args) {" +
                                "\nSystem.out.println(\"Hello World Makovsky " + classNumber + "!\");" +
                                "\n}\n}";

            try {

                file = new File("/home/mak/Test/HelloWorld_Makovsky" + classNumber + ".java");
                fop = new FileOutputStream(file);

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                // get the content in bytes
                byte[] contentInBytes = content.getBytes();

                fop.write(contentInBytes);
                fop.flush();
                fop.close();

                System.out.println("Done");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fop != null) {
                        fop.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
