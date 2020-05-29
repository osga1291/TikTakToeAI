class AIPlayer {

    static class Move {
        int row, col;


    };


    private char mark = 'x';
    private char opp = 'o';

    public int evaluation(Gameboard board) {
        if (board.checkRowsForWin().getFirst()) {
            if (board.checkRowsForWin().getSecond() == mark) {
                return +10;
            } else if (board.checkRowsForWin().getSecond() == opp) {
                return -10;
            }
        }

        if (board.checkColumnsForWin().getFirst()) {
            if (board.checkColumnsForWin().getSecond() == mark) {
                return +10;
            } else if (board.checkColumnsForWin().getSecond() == opp) {
                return -10;
            }
        }
        if (board.diagonalForWin().getFirst()) {
            if (board.diagonalForWin().getSecond() == mark) {
                return +10;
            } else if (board.diagonalForWin().getSecond() == opp) {
                return -10;
            }
        }
        return 0;
    }

    public int minimax(Gameboard board, int depth, Boolean isMax, int alpha,int beta) {
        int score = evaluation(board);

        if (score == 10) {
            return score;

        }
        if (score == -10) {
            return score;
        }
        if (board.isBoardFull()) {
            return 0;
        }
        int best;
        if (isMax) {
            best = -1000;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.board[i][j] == '-') {
                        board.board[i][j] = mark;

                        best = Math.max(best, minimax(board, depth + 1, !isMax, alpha,beta));

                        alpha = Math.max(alpha, best);

                        if(beta <= alpha){
                            board.board[i][j] = '-';
                            break;
                        }

                        board.board[i][j] = '-';

                    }
                }

            }
            return best;
        }
        else {
            best = 1000;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board.board[i][j] == '-') {
                        board.board[i][j] = opp;

                        best = Math.min(best, minimax(board, depth + 1, !isMax, alpha,beta));

                        beta = Math.min(beta, best);

                        if(beta <= alpha){
                            board.board[i][j] = '-';
                            break;
                        }

                        board.board[i][j] = '-';


                    }


                }
            }

            return best;
        }

    }

    public Move findMove(Gameboard board) {
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.board[i][j] == '-') {

                    board.board[i][j] = mark;

                    int moveValue = minimax(board, 0, false, -10000,10000);

                    board.board[i][j] = '-';

                    if (moveValue > bestVal) {
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveValue;
                    }
                }
            }
        }
        return bestMove;
    }
}