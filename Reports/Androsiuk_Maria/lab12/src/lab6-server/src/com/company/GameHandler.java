package com.company;

import java.util.Random;

public class GameHandler implements MessageListener {

    private PlayerThread numberGuesser;
    private PlayerThread numberPicker;
    private static final int maxGuessCount = 10;
    private short guessCount;
    private String number;

    public GameHandler(PlayerThread firstPlayer, PlayerThread secondPlayer) {
        firstPlayer.setMessageListener(this);
        secondPlayer.setMessageListener(this);
        boolean isFirstPlayerGuesser = new Random().nextBoolean();
        numberGuesser = isFirstPlayerGuesser ? firstPlayer : secondPlayer;
        numberPicker = isFirstPlayerGuesser ? secondPlayer : firstPlayer;
    }

    public void start() {
        numberGuesser.start();
        numberPicker.start();
        numberPicker.sendMessage("Выберите число");
    }

    private void restartGame() {
        guessCount = 0;
        number = null;
        PlayerThread numberGuesserTmp = numberGuesser;
        numberGuesser = numberPicker;
        numberPicker = numberGuesserTmp;
        numberPicker.sendMessage("Выберите число");
    }

    @Override
    public void processMessage(String message) {
        if (number == null) {
            number = message;
            numberGuesser.sendMessage("Угадайте число");
            return;
        }

        if (++guessCount == maxGuessCount && !message.equals(number)) {
            numberGuesser.sendMessage("Проигрыш");
            numberPicker.sendMessage("Противник проиграл");
            restartGame();
            return;
        }

        if (message.equals(number)) {
            numberGuesser.sendMessage("Победа");
            numberPicker.sendMessage("Проивник победил");
            restartGame();
            return;
        }

        int bullCount = 0;
        int cowCount = 0;

        for (int i = 0; i < message.length(); i++) {
            if (number.charAt(i) == message.charAt(i)) {
                bullCount++;
            }
            else if (number.contains(Character.toString(message.charAt(i)))) {
                cowCount++;
            }
        }

        String messageToSend = "Попытка " + guessCount + ". Быки: " + bullCount + ". Коровы: " + cowCount;
        numberGuesser.sendMessage(messageToSend);
        numberPicker.sendMessage(messageToSend);
    }
}
