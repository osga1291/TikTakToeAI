public class Gameboard {
    static char[][] board;
    private char currentPlayerMark;

    public Gameboard(){
        board = new char[3][3];
        currentPlayerMark = 'o';
        initilizeBoard();
    }

    public char getCurrentPlayerMark(){
        return currentPlayerMark;
    }
    public void initilizeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("-----------------");

        for (int i = 0; i < 3; i++) {
            System.out.print('|');
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");

            }
            System.out.println();
            System.out.println("-----------------");
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public Tuple checkRowsForWin() {
        Tuple rowResult = new Tuple(false,' ');
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                rowResult.changeTuple(true, board[i][0]);
                return rowResult;
            }
        }
        return rowResult;
    }

    public Tuple checkColumnsForWin() {
        Tuple colResult = new Tuple(false, ' ');
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                colResult.changeTuple(true, board[0][j]);
                return colResult;
            }
        }
        return colResult;
    }


    public Tuple diagonalForWin() {
        Tuple daResult = new Tuple(false, ' ');
        if ((board[0][0] != '-'  && board[0][0] == board[1][1] && board[1][1] == board[2][2]) || (board[0][2] != '-' &&
                board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
                daResult.changeTuple(true, board[1][1]);
                return daResult;
        }
        return daResult;

    }


    public boolean isWon() {
        if (checkColumnsForWin().getFirst() || checkRowsForWin().getFirst() || diagonalForWin().getFirst()) {
            return true;
        }
        return false;
    }

    public void changePlayer() {
        if (currentPlayerMark == 'x') {
            currentPlayerMark = 'o';
        } else {
            currentPlayerMark = 'x';
        }
    }

    public boolean placeMark(int row, int column) {
        if (board[row][column] != '-') {
            System.out.println("Invalid Input");
            return false;
        } else {
            board[row][column] = currentPlayerMark;
            return true;
        }


    }



}
