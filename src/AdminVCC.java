import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminVCC {

    JFrame frame = new JFrame("Cloud Controller");
    private JPanel BackgroundPanel;
    private JPanel Header;
    private JToolBar Navbar;
    private JButton DiscButton;
    private JLabel logoLabel;
    private JButton AcceptButton;
    public JLabel RequestInfo;
    private JButton DeclineButton;
    private JButton VehicleButton;
    private JButton JobButton;
    private JButton UserButton;
    public JLabel TestLabel;
    public Server server;

    AdminVCC() {
        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //this.server = server;


        AcceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.isAccepted(true);
                server.respond();
            }
        });
        DeclineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.isAccepted(false);
                server.respond();
            }
        });

    }
   // @Override
    /* public void actionPerformed(ActionEvent e) {
         /*
         String messageIn = "";
         String messageOut = "";

         Object source = e.getSource();
         if (source == AcceptButton) {
             server.isAccepted(true);
             server.respond();
             Requests requests = server.recieved;
             //write to database
             //unpack();

             frame.dispose();
         }
         if (source == DeclineButton) {
             server.isAccepted(false);
             server.respond();
             frame.dispose();
         }
     }

 */
    //method for unpack
    public void write(String input) {
        String content = "";

        try {
            File myObj = new File("src/db/" + "jobs.txt");
            // Get the absolute path of file f
            String absolute = myObj.getAbsolutePath();
            System.out.println(absolute);
            Scanner myReader = new Scanner(myObj);

            int i = 0;
            String line;


            while (myReader.hasNextLine()) {
                line = myReader.nextLine();
                content += line + "\n";
                //content += "\n";

                i++;
            }


            System.out.println(content);

            myReader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //method for vehicle to be fixed
    }

    public String unpack(Requests requests){
        if (requests.jobRequest != null){
            String jobID = requests.jobRequest.jobId;
            DummyUser user = requests.jobRequest.user;
            int userID = user.getUserID();
            String jobType = requests.jobRequest.jobType;


            String jobInput = ""+jobID+userID+jobType;
            return jobInput;
            // LocalDateTime jobDeadline;
            // LocalDateTime userDuration;
        }
        if (requests.donRequest != null){
            String vehicleId = requests.donRequest.vehicle.vehicleId;
            String make = requests.donRequest.vehicle.make;
            String model = requests.donRequest.vehicle.model;
            int year = requests.donRequest.vehicle.year;
            String plateNum= requests.donRequest.vehicle.plateNumber;
            String stateRegistered= requests.donRequest.vehicle.stateRegistered;
            String donInput = ""+vehicleId+make+model+year+plateNum+stateRegistered;
            return donInput;
        }
        return null;

    }

    //@Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == UserButton)
        {
            UserLog userlog = new UserLog();
            frame.dispose();
        }
        if (source == JobButton)
        {
            JobLog joblog = new JobLog();
            frame.dispose();
        }
        if(source == VehicleButton)
        {
            VehicleLog vehiclelog = new VehicleLog();
            frame.dispose();
        }

    }

    public void updateRequests(String text)
    {
       this.TestLabel.setText(text);
       frame.setVisible(false);
       frame.setVisible(true);
    }



}
