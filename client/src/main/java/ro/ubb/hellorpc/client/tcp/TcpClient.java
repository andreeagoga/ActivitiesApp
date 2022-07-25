package ro.ubb.hellorpc.client.tcp;

import ro.ubb.hellorpc.common.Service;
import ro.ubb.hellorpc.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class TcpClient {
    private ExecutorService executorService;
    private String host;
    private int port;

    public TcpClient(String host, int port, ExecutorService executorService) {
        this.host = host;
        this.port = port;
        this.executorService = executorService;
    }

    public Message sendAndReceive(Message request) {
        try (var socket = new Socket(host, port);
             var is = socket.getInputStream();
             var os = socket.getOutputStream();
        ) {
            request.writeTo(os);
            System.out.println("ClientApp: sent request: " + request);
            Message response = new Message();
            response.readFrom(is);
            System.out.println("ClientApp: received response: " + response);

            return response;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
}
    }
