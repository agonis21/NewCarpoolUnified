import java.io.Serializable;

public class Vehicle implements Serializable {
    public DummyUser user;
    public String userId;
    public String vehicleId;
    public String make ;
    public String model ;
    public int year;
    public String plateNumber ;
    public String stateRegistered;


    public Vehicle(DummyUser user, String vehicleId, String make, String model, int year, String plateNumber, String stateRegistered)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.plateNumber = plateNumber;
        this.stateRegistered = stateRegistered;
        this.vehicleId=vehicleId;

    }

    //DB constructor
    public Vehicle(String userID, String vehicleId, String make, String model, int year, String plateNumber, String stateRegistered)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.plateNumber = plateNumber;
        this.stateRegistered = stateRegistered;
        this.userId = userID;
        this.vehicleId=vehicleId;

    }

    public String getPlateNumber(){return this.plateNumber;}
    public String getStateRegistered(){return this.stateRegistered;}
    public String getMake(){return this.make;}
    public String getModel(){return this.model;}
    public int getYear(){return this.year;}
    public String getUserId(){return this.userId;}
    public String getVehicleId(){return this.vehicleId;}






}
