package Medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Problem853 {
    private class CarCharacteristics {
        public CarCharacteristics(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
        int position;
        int speed;
    }
    public int carFleet(int target, int[] position, int[] speed) {
        List<CarCharacteristics> cars = new ArrayList<>();

        for (int i = 0; i < position.length; ++i) {
            cars.add(new CarCharacteristics(position[i], speed[i]));
        }

        cars.sort((a, b) -> b.position - a.position);

        Iterator<CarCharacteristics> iterator = cars.iterator();
        CarCharacteristics candidate = iterator.next();
        double currentTime = (double) (target - candidate.position) / candidate.speed;
        int count = 0;

        while (iterator.hasNext()) {
            candidate = iterator.next();
            while (currentTime >= (double) (target - candidate.position) / candidate.speed) {
                if (!iterator.hasNext())
                    return count + 1;
                candidate = iterator.next();
            }
            count++;
            currentTime = (double) (target - candidate.position) / candidate.speed;
        }

        return count + 1;
    }

    public static void main(String[] args) {
        Problem853 problem853 = new Problem853();
        System.out.println(problem853.carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
        System.out.println(problem853.carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,2,1,3}));
        System.out.println(problem853.carFleet(10, new int[]{3}, new int[]{3}));
    }
}
