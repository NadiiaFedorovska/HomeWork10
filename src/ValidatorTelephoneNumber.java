import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorTelephoneNumber {
    private static final String ABSOLUTE_PATH = "D:\\My_folder\\GoIT\\modul10\\resource\\file.txt";

    public static void main(String[] args) {
        File file = new File(ABSOLUTE_PATH);

        if (!file.exists()) {
            throw new RuntimeException("File with name " + file.getName() + " is not exist!");
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            Pattern pattern = Pattern.compile("^(\\d{3})-(\\d{3})-(\\d{4})$|^\\(\\d{3}\\)\\s\\d{3}\\-\\d{4}");

            while (line != null) {
                Matcher matcher = pattern.matcher(line);

                if (matcher.matches()) {
                    System.out.println(line);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
