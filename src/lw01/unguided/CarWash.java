package lw01.unguided;

public class CarWash extends WashService {
    public CarWash(String id, int days, int units) {
        super(id, days, units);
    }

    @Override 
    public int calculateCharge() {
        if (getDays() <=3) {
            return getDays()*35000 +15000;
        }
        else {
            return (35000*3) + ((getDays()-3)*25000) + 15000;
        }
    }

    @Override
    public String label() {
        return "Car";
    }
}
