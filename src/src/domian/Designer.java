package domian;

import service.Status;

public class Designer extends Employee{

    private Equipment equipment;
    private Status status = Status.FREE;
    private double bonus;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary);
        this.equipment = equipment;
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + status + "\t" + bonus + "\t\t\t\t" + equipment.getDescription();
    }

}
