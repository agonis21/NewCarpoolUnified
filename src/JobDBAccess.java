
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

        String query = "INSERT INTO job(userID,jobId,jobType,jobDeadline,jobDuration, timestamp) VALUES(?,?,?,?,?, current_timestamp());";
        PreparedStatement stmt = conn.prepareStatement(query);

        Timestamp timestamp = Timestamp.valueOf(String.valueOf(LocalDateTime.now()));
        stmt.setString(1, job.getUserId());
        stmt.setString(2, job.getJobId());
        stmt.setString(3, job.getJobType());
        stmt.setString(4, job.getJobDeadline());
        stmt.setString(5, job.getJobDuration());
        stmt.setTimestamp(6, timestamp);
        //stmt.setString(7, job.getJobCompletionTime());  // needs to be added and fixed


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
    private static Job buildJob(ResultSet rs)throws SQLException{
        if(rs.next()){
           String jobId = rs.getString("jobID");
            String userID = rs.getString("userID");
            String jobType = rs.getString("jobType");
            String jobDeadline = rs.getString("Deadline");
            String jobDuration = rs.getString("Duration");
            Timestamp timestamp = rs.getTimestamp("created");
            Job job = new Job(jobId,userID, jobType,jobDeadline,jobDuration,timestamp); // add completiontime
            return job;

        }
        else return null;
    }





}
