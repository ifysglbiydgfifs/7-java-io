package com.example.task01;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Task01Main {
    public static void main(String[] args) throws IOException {
        //здесь вы можете вручную протестировать ваше решение, вызывая реализуемый метод и смотря результат
        // например вот так:

        System.out.println(checkSumOfStream(new ByteArrayInputStream(new byte[]{0x33, 0x45, 0x01})));
        System.out.println(checkSumOfStream(null));

    }

    public static final String ANSI_MAGENTA = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        try {
            int sum = 0;
            int input = inputStream.read();

            while (input != -1) {
                sum = Integer.rotateLeft(sum, 1) ^ input;
                input = inputStream.read();
            }
            return sum;
        } catch (NullPointerException exception) {
            System.out.println(ANSI_MAGENTA + "Bytes array is empty " + exception + ANSI_RESET);
            throw new IllegalArgumentException(exception);
        }
    }
}
