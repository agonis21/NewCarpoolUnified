import java.io.IOException;
import java.time.LocalDateTime;
import java.util.random.RandomGenerator;
import java.time.Duration;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Job {
    int jobId; // Randomized integer value between 1 to 100000
    DummyUser user;
    int userId;
    String jobType;
    LocalDateTime jobDeadline;
    //LocalDateTime userDuration;// job duration entered by user
    int duration; // Actual Time to be calculated for job completion
    LocalDateTime startTime; // Time starts once job is submitted
    LocalDateTime endTime; // Time ends once job is completed
    int redundancy;


    public int getUserId(){return this.userId;}
    public int getJobId(){return this.jobId;}
    public String getJobType(){return this.jobType;}
    public LocalDateTime getJobDeadline(){return this.jobDeadline;}
    public LocalDateTime getStartTime(){return this.startTime;}

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public int getRedundancy() {
        return redundancy;
    }

    //this constructor will be used to generate complete job objects from queries
    public Job(int jobId, int userId, String jobType, LocalDateTime jobDeadline,
               LocalDateTime startTime, LocalDateTime endTime, int duration, int redundancy){

        this.jobId=jobId;
        this.userId=userId;
        this.jobType=jobType;
        this.jobDeadline=jobDeadline;
        //this.userDuration=userDuration;
        this.startTime=startTime;
        this.endTime=endTime;
        this.duration = duration;
        this.redundancy=redundancy;
    }


    public Job(DummyUser user, String jobType, LocalDateTime deadline, LocalDateTime duration)
    {
        this.jobType = jobType;
        this.jobDeadline = deadline;
       // this.userDuration= duration;

        RandomGenerator random = new RandomGenerator() {
            @Override
            public long nextLong() {
                return 0;
            }
        };

        // Generate a random integer between 1 and 100 and assign it to the jobId variable
       // jobId = random.nextInt(100000) + 1;
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
