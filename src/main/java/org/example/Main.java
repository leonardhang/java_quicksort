package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.print("请输入10个整数，以空格分开：");
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>(10);
        boolean inputValid = false;
        while (!inputValid) {
            try{
                String inputStr = scanner.nextLine();
                String[] inputNumberAres = inputStr.trim().split("\\s+");
                if(inputNumberAres.length != 10) {
                    System.out.print("输入数量有误，请输入10个整数，以空格分开：");
                    continue;
                }
                for (String numberStr : inputNumberAres) {
                    numbers.add(Integer.parseInt(numberStr.trim()));
                }
                inputValid = true;
            }catch (Exception e) {
                System.out.print("数据类型有误，请输入10个整数，以空格分开：");
            }
        }
        ListQuickSort(numbers, 0, numbers.size() -1);
        String sortedNumbers = numbers.stream().map(Objects::toString).collect(Collectors.joining(" "));
        System.out.print("排序后的结果：" + sortedNumbers);
    }

    private static void ListQuickSort(List<Integer> numbers, int start, int end) {
        if(start < end) {
            int splitIndex = SplitSwap(numbers, start, end);
            ListQuickSort(numbers, start, splitIndex - 1);
            ListQuickSort(numbers, splitIndex + 1, end);
        }
    }

    private static int SplitSwap(List<Integer> numbers, int start, int end) {
        int compareNumber = numbers.get(end);
        int swapIndex = start -1;
        for (int i = start; i < end; i++) {
            if(numbers.get(i) < compareNumber) {
                swapIndex++;
                SwapNumbers(numbers, swapIndex, i);
            }
        }
        swapIndex +=1;
        SwapNumbers(numbers, swapIndex, end);
        return swapIndex;
    }

    private static void SwapNumbers(List<Integer> numbers, int from, int to) {
        int temp = numbers.get(from);
        numbers.set(from, numbers.get(to));
        numbers.set(to, temp);
    }

}