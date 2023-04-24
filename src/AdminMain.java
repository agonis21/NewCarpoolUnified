public class AdminMain {


    public static void main(String[] args) {
        Server server = new Server("server-1");
        Server server2 = new Server("server-2");
        Server server3 = new Server("server-3");
        //AdminVCC adminVCC = new AdminVCC();


        server.start();
        //adminVCC.server.start();

        //adminVCC.updateRequests("aaaaaaaaa");



    }

}
