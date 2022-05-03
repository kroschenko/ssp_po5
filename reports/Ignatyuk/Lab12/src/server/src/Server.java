import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Server {
    public final static void main(final String[] args) throws Exception {
        final Integer PORT = 9099;
        ServerSocket acceptor = null;

        while (true) {
            try {
                acceptor = new ServerSocket(PORT);
                System.out.println("Server is Running on port " + Integer.toString(PORT) + '.');

                System.out.println("Waiting for players...");
                Player playerX = new Player(acceptor.accept(), "X", "0");
                System.out.println("Player X connected.");
                Player player0 = new Player(acceptor.accept(), "0", "X");
                System.out.println("Player 0 connected.");

                playerX.setOpponent(player0);
                player0.setOpponent(playerX);

                Game game = new Game(playerX);

                playerX.setGame(game);
                player0.setGame(game);

                playerX.start();
                player0.start();

                while (!game.isOver() && !game.isWin()) {
                }
            } finally {
                acceptor.close();
            }
        }
    }

    private static class Game {
        private Player current;

        private final Integer BOXES_COLUMNS_COUNT = 3;
        private final Integer BOXES_ROWS_COUNT = 3;
        private String[] board = new String[BOXES_COLUMNS_COUNT * BOXES_ROWS_COUNT];

        public Game(final Player current) {
            this.current = current;
        }

        public final synchronized Boolean move(final Player player, final Integer boxNumber) {
            if (this.current != player || this.board[boxNumber] != null) {
                return false;
            }

            System.out.println("Player " + this.current.getRole() + " move at index " + Integer.toString(boxNumber));

            this.board[boxNumber] = this.current.getRole();

            if (this.isWin()) {
                System.out.println("Player " + this.current.getRole() + " won!");
                System.out.println("Player " + this.current.getOpponent().getRole() + " lost!");

                this.current.reportWin(boxNumber);
                this.current.opponent.reportLose(boxNumber);
                return true;
            }

            if (this.isOver()) {
                System.out.println("Draw!");

                this.current.reportDraw(boxNumber);
                this.current.getOpponent().reportDraw(boxNumber);
                return true;
            }

            this.current.reportMove(boxNumber);

            this.current = this.current.opponent;
            return true;
        }

        public final Boolean isWin() {
            return (this.board[0] != null && this.board[0] == this.board[1] && this.board[0] == this.board[2])
                    || (this.board[3] != null && this.board[3] == this.board[4] && this.board[3] == this.board[5])
                    || (this.board[6] != null && this.board[6] == this.board[7] && this.board[6] == this.board[8])
                    || (this.board[0] != null && this.board[0] == this.board[3] && this.board[0] == this.board[6])
                    || (this.board[1] != null && this.board[1] == this.board[4] && this.board[1] == this.board[7])
                    || (this.board[2] != null && this.board[2] == this.board[5] && this.board[2] == this.board[8])
                    || (this.board[0] != null && this.board[0] == this.board[4] && this.board[0] == this.board[8])
                    || (this.board[2] != null && this.board[2] == this.board[4] && this.board[2] == this.board[6]);
        }

        public final Boolean isOver() {
            for (final String player : this.board) {
                if (player == null) {
                    return false;
                }
            }

            return true;
        }
    }

    private static class Player extends Thread {
        private final static String GREETING_REQUEST = "GREETING";
        private final static String START_REQUEST = "START";
        private final static String MOVE_REQUEST = "MOVE";

        private Socket socket;
        private String role;
        private String opponentRole;

        private BufferedReader input;
        private PrintWriter output;

        private Player opponent = null;
        private Game game = null;

        public Player(final Socket socket, final String role, final String opponentRole) {
            this.socket = socket;
            this.role = role;
            this.opponentRole = opponentRole;

            try {
                this.input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                this.output = new PrintWriter(socket.getOutputStream(), true);
                this.output.println(Player.GREETING_REQUEST + this.role + this.opponentRole);
            } catch (final IOException exception) {
                System.out.println("END");
            }
        }

        public final String getRole() {
            return this.role;
        }

        public final void setOpponent(final Player opponent) {
            this.opponent = opponent;
        }

        public final Player getOpponent() {
            return this.opponent;
        }

        public final void setGame(final Game game) {
            this.game = game;
        }

        public final void reportMove(final Integer boxNumber) {
            this.opponent.output.println("MOVE" + boxNumber);
        }

        public final void reportWin(final Integer boxNumber) {
            this.output.println("WIN" + boxNumber);
        }

        public final void reportLose(final Integer boxNumber) {
            this.output.println("LOSE" + boxNumber);
        }

        public final void reportDraw(final Integer boxNumber) {
            this.output.println("DRAW" + boxNumber);
        }

        @Override
        public final void run() {
            try {
                this.output.println(Player.START_REQUEST);

                while (true) {
                    String request = this.input.readLine();

                    if (request == null || request.equals("")) {
                        continue;
                    }

                    if (request.startsWith(MOVE_REQUEST)) {
                        Integer boxNumber = request.charAt(MOVE_REQUEST.length()) - '0';
                        this.game.move(this, boxNumber);
                    }

                    if (this.game.isOver()) {
                        return;
                    }
                }
            } catch (final IOException exception) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, exception);
            } finally {
                try {
                    socket.close();
                } catch (final IOException exception) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        }
    }
}
