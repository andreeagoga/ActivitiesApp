package ro.ubb.hellorpc.server.tcp;

import ro.ubb.hellorpc.common.Service;
import ro.ubb.hellorpc.common.HelloServiceException;
import ro.ubb.hellorpc.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.function.UnaryOperator;

public class TcpServer {
    private ExecutorService executorService;
    private int port;
    private Map<String, UnaryOperator<Message>> methodHandlers;

    public TcpServer(ExecutorService executorService, int port) {
        this.executorService = executorService;
        this.port = port;
        this.methodHandlers = new HashMap<>();
    }

    public void addHandler(String methodName, UnaryOperator<Message> methodHandler) {
        this.methodHandlers.put(methodName, methodHandler);
    }

    public void startServer() {
        try (var serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("client connected");
                executorService.submit(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new HelloServiceException(e);
        }
    }

    private class ClientHandler implements Runnable {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (var is = socket.getInputStream();
                 var os = socket.getOutputStream()) {

                //get request from client
                Message request = new Message();
                request.readFrom(is);
                System.out.println("received request: " + request);

                //given a request of type Message get a response of type Message
                UnaryOperator<Message> handler = methodHandlers.get(request.getHeader());
                Message response = handler.apply(request);
                System.out.println("computed response: " + response);

                //send response (of type Message) to client
                response.writeTo(os);
                System.out.println("response sent to client");


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
