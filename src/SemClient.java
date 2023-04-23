import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class SemClient {
    JobRequest request;
    public SemClient(){

    }
    public SemClient(JobRequest request) throws IOException, ClassNotFoundException {
        this.request = request;

        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected to server.");

        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
//        String userInput;
//        while ((userInput = stdIn.readLine()) != null) {
//            ArrayList<String> str = new ArrayList<String>();
//
//            out.writeObject(userInput);
//            Object serverResponse = in.readObject();
//            System.out.println("Received response from server: " + serverResponse.toString());
//        }

        out.writeObject(this.request);
        Object serverResponse = in.readObject();
        System.out.println("Received response from server: " + serverResponse.toString());

        in.close();
        out.close();
        stdIn.close();
        socket.close();
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {

    }
}