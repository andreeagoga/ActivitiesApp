package ro.ubb.hellorpc.common;

import java.io.*;

public class Message<T> implements Serializable {
    public static final String OK = "ok";
    public static final String ERROR = "error";

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private String header;
    private String body;

    public Message() {
    }

    public Message(String header, String body) {
        this.header = header;
        this.body = body;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Message{" +
                "header='" + header + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public void readFrom(InputStream is) throws IOException {
        var br = new BufferedReader(new InputStreamReader(is));
        header = br.readLine();
        body = br.readLine();
    }

    public void writeTo(OutputStream os) throws IOException {
        os.write((header + "\n" + body + "\n").getBytes());
    }
}
