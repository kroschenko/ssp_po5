package com.company.tcp_server;

public class Messages {
    public static class Move {
        public int x, y;
    }

    public static class Board {
        public String gameboard;
        public char your_type;
        public char move;
        public char winner;
    }
}
