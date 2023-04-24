import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class SemClient {
    String requestDetails;
    public SemClient(){

    }
    public SemClient(String request) throws IOException, ClassNotFoundException {
        this.requestDetails = request;

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

        out.writeObject(this.requestDetails);
        Object serverResponse = in.readObject();
        System.out.println("Received response from server: " + serverResponse.toString());

        in.close();
        out.close();
        stdIn.close();
        socket.close();
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SemClient sc1 = new SemClient("the weather");
    }
}