public class AdminMain {


    public static void main(String[] args) {
        Server server = new Server();
        AdminVCC adminVCC = new AdminVCC(server);

        adminVCC.server.run();
    }

}
