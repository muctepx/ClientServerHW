package JavaDevelopmentKit.Lesson2.ClientServer.server;

import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JTextArea;

public class ServerLogger{
    public static final String LOG_PATH = "Java\\JavaDevelopmentKit\\Lesson2\\ClientServer\\server\\log.txt";
    public static JTextArea log;

    public String getHistory() {
        return readLog();
    }

    public static void saveInLog(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void appendLog(String text) {
        log.append(text + "\n");
    }

}
