import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.random.RandomGenerator;

public class Job {
    int jobId; // Randomized integer value between 1 to 100000
    DummyUser user;
    String jobType;
    LocalDateTime jobDeadline;
    LocalDateTime userDuration;// job duration entered by user
    LocalDateTime actualDuration; // Actual Time to be calculated for job completion
    LocalDateTime startTime; // Time starts once job is submitted
    LocalDateTime endTime; // Time ends once job is completed
    int redundancy;

    public Job(DummyUser user, String jobType, LocalDateTime deadline, LocalDateTime duration)
    {
        this.jobType = jobType;
        this.jobDeadline = deadline;
        this.userDuration= duration;

        RandomGenerator random = new RandomGenerator() {
            @Override
            public long nextLong() {
                return 0;
            }
        };

        // Generate a random integer between 1 and 100 and assign it to the jobId variable
        jobId = random.nextInt(100000) + 1;
    }

    public LocalDateTime calculateDuration(){
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

    public static List<Map<String , String>> calculateJobDurationTimes(String job_filename) throws IOException {
        ConvertTextToHashmapList jobs = new ConvertTextToHashmapList(job_filename);

        List<Map<String , String>> jobCompletionTimeList  = new ArrayList<Map<String,String>>();

        for (int i = 0; i < jobs.MapList.size(); i++){
            Map<String , String> jobEntry = jobs.MapList.get(i);

            int jobEntryCompletionTime = 0;
            if (i == 0) {
                jobEntryCompletionTime = Integer.parseInt(jobEntry.get("JobDuration"));
            } else {
                Map<String , String> previousJobEntry = jobs.MapList.get(i - 1);
                jobEntryCompletionTime = Integer.parseInt(previousJobEntry.get("JobCompletionTime"))
                        + Integer.parseInt(jobEntry.get("JobDuration"));
            }

            jobEntry.put("JobCompletionTime", "" + jobEntryCompletionTime);

            jobCompletionTimeList.add(jobs.MapList.get(i));
        }

        return jobCompletionTimeList;
    }

    void deliver(){

    }


    public static void main (String[] args) throws IOException {
        List<Map<String, String>> jobCompletionTimes = calculateJobDurationTimes("jobs.txt");


        for (Map<String, String>  job: jobCompletionTimes){
            System.out.println(job);
        }
    }

}
