package lw01.unguided;

public abstract class WashService implements Billable{
    private String id;
    private int days;
    private int units;

    protected WashService(String id, int days, int units) {
        this.id = id;
        this.days = days;
        this.units = units;

        if (days <=0) {
            throw new IllegalArgumentException("days must be a positive number");
        }
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    @Override 
    public abstract int calculateCharge();

    public int calculateCharge(int units) {
        if (units <=0) {
            throw new IllegalArgumentException("units must be a positive number");
        }
        return units * calculateCharge();
    }

    public String label() {
        return "Service";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge(units);
    }
}
