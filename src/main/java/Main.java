import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List numbers = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            numbers.add(random.nextInt(100));
        }
        Iterator iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int number = (int) iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(numbers);

        int min = (int) numbers.get(0);
        int max = (int) numbers.get(0);
        float sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int num = (int) numbers.get(i);
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            sum += num;
        }

        float average = sum / numbers.size();

        System.out.println("Минимальное значение: " + min);

        System.out.println("Максимальное значение: " + max);

        System.out.println("Среднее арифметическое значение: " + average);
    }
}






