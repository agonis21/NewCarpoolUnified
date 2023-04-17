
import java.sql.*;
import java.time.LocalDateTime;

//NOT FINISHED, ISSUE WITH CONVERSION FROM DATETIME TO LOCALDATETIME
//AS WELL AS TIMESTAMP
public class JobDBAccess {

    private static Connection conn;

    public static void init() throws ClassNotFoundException {

        DBConnection.init("carpool");
    }

    public static Boolean insert(Job job) throws SQLException {

        conn = DBConnection.getMyConnection();

        String query = "INSERT INTO job(userID,jobType,jobDeadline, startTime) VALUES(?,?,?, current_timestamp());";
        PreparedStatement stmt = conn.prepareStatement(query);

        Timestamp timestamp = Timestamp.valueOf(job.getJobDeadline());
        stmt.setInt(1, job.getUserId());
        stmt.setString(2, job.getJobType());
        stmt.setTimestamp(3, timestamp);


        int result = stmt.executeUpdate();
        if(result ==0)
        {
            return false;
        }
        else {
            return true;
        }


    }


    //NOT FINISHED NEEDS WORK
    private static Vehicle buildJob(ResultSet rs)throws SQLException{
        if(rs.next()){
           /* int jobId = rs.getInt("jobID");
            int userID = rs.getInt("userID");
            String jobType = rs.getString("jobType");
            LocalDateTime jobDeadline = rs.getTimestamp("Deadline")
            Timestamp timestamp = rs.getTimestamp("created");
            */
            int userID = rs.getInt("userID");
            String make= rs.getString("make");
            String model = rs.getString("model");
            int year = rs.getInt("year");
            String plateNumber = rs.getString("plateNumber");
            String stateRegistered = rs.getString("stateRegistered");

            Vehicle vehicle = new Vehicle(userID,make,model,year,plateNumber,stateRegistered);
            return vehicle;
        }
        else return null;
    }





}
