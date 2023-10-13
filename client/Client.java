package JavaDevelopmentKit.Lesson2.ClientServer.client;

import JavaDevelopmentKit.Lesson2.ClientServer.server.ServerWindow;
import JavaDevelopmentKit.Lesson2.ClientServer.server.ServerLogger;

public class Client {
    private String name;
    private ClientView clientView;
    private ServerWindow server;
    private boolean connected;
    private ServerLogger logger;

    public Client(ClientView clientView, ServerWindow serverWindow, ServerLogger logger) {
        this.clientView = clientView;
        this.server = serverWindow;
        this.logger = logger;
    }

    public boolean connectToServer(String name){
        this.name = name;
        if (server.connectUser(this)){
            printText("Вы успешно подключились!\n");
            connected = true;
            String log = logger.getHistory();
            if (log != null){
                printText(log);
            }
            return true;
        } else {
            printText("Подключение не удалось");
            return false;
        }
    }


    public void sendMessage(String message){
        if (connected) {
            if (!message.isEmpty()) {
                server.sendMessage(name + ": " + message);
            }
        } else {
            printText("Нет подключения к серверу");
        }
    }

    public void serverAnswer(String answer){
        printText(answer);
    }

    public void disconnect(){
        if (connected) {
            connected = false;
            clientView.disconnectFromServer();
            ServerWindow.disconnectUser(this);
            printText("Вы были отключены от сервера!");
        }
    }

    public String getName() {
        return name;
    }

    private void printText(String text){
        clientView.showMessage(text);
    }

    public void disconnectFromServer() {
    }
}