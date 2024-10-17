import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите количество последовательных дней: ");
        Scanner numDays = new Scanner(System.in);
        int days = numDays.nextInt();

        System.out.println("Вводите температуру через пробел. Диапозон от -50 до 50");
        Scanner data = new Scanner(System.in);
        String [] dTemp = data.nextLine().split(" ");
        ArrayList <String> temperature = new ArrayList<>(List.of(dTemp));

        checkingTheInput(temperature,days);
        int thaw = calcDaysThaw(temperature);
        System.out.println("Наибольшее количество дней оттепели: " + thaw + " дней");
    }

    public static void checkingTheInput(ArrayList<String> temperature, int days) {
        if (days > temperature.size()) {
            System.out.println("Вы ввели недостаточно данных для " + days + " дней");
        } else if (days < temperature.size()) {
            System.out.println("Вы ввели большее количество данных для " + days + " дней");
        }
    }

    public static int calcDaysThaw(ArrayList<String> temperature){
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i<= temperature.size() - 1; i++){
            int number = Integer.parseInt(temperature.get(i));
             if(number > 0){
                count++;
            }
            if(count > maxCount){
                maxCount = count;
                count = 0;
            }
        }
        return maxCount;
    }
}