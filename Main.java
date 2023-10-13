package JavaDevelopmentKit.Lesson2.ClientServer;

import JavaDevelopmentKit.Lesson2.ClientServer.client.ClientGUI;

import JavaDevelopmentKit.Lesson2.ClientServer.server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
