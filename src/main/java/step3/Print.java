package step3;

import java.util.List;

public class Print {
    private int count;

    public Print() {
        this.count = 0;
    }

    public int getCount() {
        return this.count;
    }

    private void counting(){
        this.count++;
    }

    public void startLap() {
        counting();
        System.out.println("\n ======== LAP : " + getCount() + " ========");
    }

    public void racing(List<Car> cars) {
        System.out.println();
        for (Car c : cars) {
            printCarPosition(c);
            System.out.print("🚘\n");
        }
    }

    private void printCarPosition(Car c) {
        for (int i = 0; i < c.getPosition(); i++) {
            System.out.print("-");
        }
    }
}