import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends AdminVCC implements Runnable{
    private Thread t;
    private String threadName;

	/*
	    ==============MILESTONE 5================
		This class will need to be modified in order to add requests to the cloud controller request queue
		1- method to send accept message back to client
		2- method to send reject message back to client
	 */



    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;
    static Requests recieved;
    private boolean approved;
    String messageIn = "";
    String messageOut = "";
    public Server(){
        super();
    }

    public Server( String name) {
        super();
        threadName = name;
        System.out.println("Creating " +  threadName );

        super.updateRequests("dfafdafdsafdsf");
    }

    public boolean isAccepted(Boolean approved){
        return this.approved=approved;
    }
    public  void run() {
        System.out.println("Running " +  threadName );

        try {

            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private void readMessageMethod() {
        // server reads a message message from client
        super.updateRequests("dfafdafdsafdsf");
    }

    private void writeMessageMethod() {
        // server sends a message to client

    }

    public void respond () {
        try {
            if (approved == true) {
                messageOut = "Your request has been accepted!";
            } else {
                messageOut = "Your request has been rejected.";
            }
            outputStream.writeUTF(messageOut);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

}



class ClientHandle implements Runnable {
    private Socket clientSocket;

    public ClientHandle(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

            Object inputObject;
            while ((inputObject = in.readObject()) != null) {
                System.out.println("Received message from client: " + inputObject.toString());
                out.writeObject("Server received message: " + inputObject.toString());

            }

            System.out.println("Client disconnected: " + clientSocket.getInetAddress().getHostAddress());
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


