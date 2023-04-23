import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.random.RandomGenerator;
import java.time.Duration;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Job implements Serializable {
    String jobId;
    DummyUser user;
    String userId;
    String jobType;
    String jobDeadline;
    //LocalDateTime userDuration;// job duration entered by user
    String duration;
    Timestamp created;

    // jobCompletiontime needs to be added

    int redundancy;
    public String getUserId(){return this.userId;}
    public String getJobId(){return this.jobId;}
    public String getJobType(){return this.jobType;}
    public String getJobDeadline(){return this.jobDeadline;}
    public String getJobDuration(){return this.duration;}

    //public LocalDateTime getStartTime(){return this.startTime;}

    //public LocalDateTime getEndTime() {
       // return endTime;
    //}

    public int getRedundancy() {
        return redundancy;
    }

    //this constructor will be used to generate complete job objects from queries
    public Job(String jobId, String userId, String jobType, String jobDeadline, String duration, Timestamp timestamp){

        this.jobId=jobId;
        this.userId=userId;
        this.jobType=jobType;
        this.jobDeadline=jobDeadline;
        created= timestamp;
        //this.userDuration=userDuration;
       // this.startTime=startTime;
       // this.endTime=endTime;
        this.duration = duration;
        //this.redundancy=redundancy;
    }
    public Job(DummyUser user, String jobType)
    {
        this.jobType = jobType;
       // this.jobDeadline = deadline;
       // this.userDuration= duration;

        RandomGenerator random = new RandomGenerator() {
            @Override
            public long nextLong() {
                return 0;
            }
        };

        // Generate a random integer between 1 and 100 and assign it to the jobId variable
      //  jobId = random.nextInt(100000) + 1;
    }

    /*public LocalDateTime calculateDuration(){
        // Calculate the duration between the two LocalDateTime variables
        Duration duration = Duration.between(endTime, startTime);

        // Convert the duration to a period
        Period period = Period.ofDays((int) duration.toDays());

        // Print the period in the format of LocalDateTime
        actualDuration = LocalDateTime.of(1, 1, 1, 0, 0)
                .plus(period)
                .plusSeconds(duration.getSeconds());
        return actualDuration;
    }
*/
    void deliver(){

    }


}
