import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*Задача 1
Перепишите алгоритм бинарного поиска элемента в отсортированном по возрастанию списке целых чисел
 (см. урок 56, задача 2) с использованием рекурсии.*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите количество элементов: ");
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> numbers = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) { // O(n) - time, O(n) - space
            numbers.add(Integer.parseInt(br.readLine()));
        }

        System.out.print("Введите число для поиска: ");
        int target = Integer.parseInt(br.readLine());

       // System.out.println("Результат: " + indexOf(numbers, target));
        System.out.println("Результат: " + indexOfRecursion(numbers, target, 0, numbers.size()));
    }

    public static int indexOfRecursion(ArrayList<Integer> numbers, int target, int left, int right) { // O(1) по памяти
//        int left = 0;
//        int right = numbers.size(); // опасность! но для библиотечных коллекций это O(1)
        while (left < right - 1) { // right - left > 1 // O(log N)
            int mid = (left + right) / 2;
            // ArrayList.get() - сложность O(1)
            // LinkedList.get() - сложность O(n)
            if (numbers.get(mid) == target) {
                return mid;
            }
            // ArrayList.get() - сложность O(1)
            // LinkedList.get() - сложность O(n)
            if (numbers.get(mid) < target) {
                left = mid + 1;
                return indexOfRecursion(numbers, target, left, right);
            } else { // не = и не <
                right = mid; // потому что right - не включая
                return indexOfRecursion(numbers, target, left, right);
            }
        }
        // после окончания цикла right - left = 0 или 1, и проверяем мы numbers[left]
        if (left < numbers.size() && numbers.get(left) == target) {
            // ArrayList.get() - сложность O(1)
            // LinkedList.get() - сложность O(n)
            return left;
        }
        return -1; // сужение области поиска не дало нам target - его нет в списке
    }
}