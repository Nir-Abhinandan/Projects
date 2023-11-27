#include <iostream>

using namespace std;

class TicTacToe {
private:
    char board[3][3];
    char player;

public:
    TicTacToe() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; ++j) {
                board[i][j] = ' ';
            }
        }
        player = 'X';
    }

    void printBoard() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                cout << board[i][j];
                if (j < 2)
                    cout << " | ";
            }
            cout << endl;
            if (i < 2)
                cout << "---------" << endl;
        }
    }

    bool makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            return false;
        }

        board[row][col] = player;
        player = (player == 'X') ? 'O' : 'X';
        return true;
    }

    bool checkWin() {
  
    for (int i = 0; i < 3; ++i) {
        if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
            return true;
        }
    }

    
    for (int j = 0; j < 3; ++j) {
        if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
            return true;
        }
    }

   
    if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') ||
        (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')) {
        return true;
    }

    return false;
}

    bool isBoardFull() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    char getPlayer() {
        return player;
    }

    char doWinningMove(char x) {
        for (int i = 0; i < 3; ++i) {
            if (board[i][0] == x && board[i][0] == board[i][1] && board[i][2] == ' ') {
                return board[i][2] = x;
            }
            if (board[i][0] == x && board[i][0] == board[i][2] && board[i][1] == ' ') {
                return board[i][1] = x;
            }
            if (board[i][1] == x && board[i][1] == board[i][2] && board[i][0] == ' ') {
                return board[i][0] = x;
            }
        }

        for (int j = 0; j < 3; ++j) {
            if (board[0][j] == x && board[0][j] == board[1][j] && board[2][j] == ' ') {
                return board[2][j] = x;
            }
            if (board[0][j] == x && board[0][j] == board[2][j] && board[1][j] == ' ') {
                return board[1][j] = x;
            }
            if (board[1][j] == x && board[1][j] == board[2][j] && board[0][j] == ' ') {
                return board[0][j] = x;
            }
        }

        if (board[0][0] == x && board[0][0] == board[1][1] && board[2][2] == ' ') {
            return board[2][2] = x;
        }
        if (board[0][0] == x && board[0][0] == board[2][2] && board[1][1] == ' ') {
            return board[1][1] = x;
        }
        if (board[1][1] == x && board[1][1] == board[2][2] && board[0][0] == ' ') {
            return board[0][0] = x;
        }
        if (board[0][2] == x && board[0][2] == board[1][1] && board[2][0] == ' ') {
            return board[2][0] = x;
        }
        if (board[0][2] == x && board[0][2] == board[2][0] && board[1][1] == ' ') {
            return board[1][1] = x;
        }
        if (board[1][1] == x && board[1][1] == board[2][0] && board[0][2] == ' ') {
            return board[0][2] = x;
        }

        return ' ';
    }
};

int getRandomMove() {
    return rand() % 3;
}

int main() {
    TicTacToe game;
    int row = 0;
    int col = 0;
    int choice;

    cout << "Single player (1) or 2 players (2): ";
    cin >> choice;

    if (choice == 1) {
        while (true) {
    game.printBoard();

    if (game.getPlayer() == 'X') {
        cout << "Player " << game.getPlayer() << ", enter your move (row, space, column): ";
        int q, v;
        cin >> q >> v;
        row = q - 1;
        col = v - 1;
        if (row < 0 || row > 3 || col < 0 || col > 3 || !game.makeMove(row, col)) {
            cout << "Invalid move" << endl;
            continue;
        }
    }

    if (game.checkWin()) {
        game.printBoard();
        cout << "Player X Wins" << endl;
        break;
    } 
    else if (game.isBoardFull()) {
        game.printBoard();
        cout << "It's a tie!" << endl;
        break;
    }

    cout << "Computer's turn:" << endl;
    if (game.doWinningMove('O') == ' ') {
        while (true) {
            row = getRandomMove();
            col = getRandomMove();
            if (game.makeMove(row, col)) {
                break;
            }
        }
    }

    if (game.checkWin()) {
        game.printBoard();
        cout << "Computer Wins" << endl;
        break;
    } 
    else if (game.isBoardFull()) {
        game.printBoard();
        cout << "It's a tie!" << endl;
        break;
    }
}

} 
    else {
        while (true) {
            game.printBoard();

            if (game.getPlayer() == 'X') {
                cout << "Player " << game.getPlayer() << ", enter your move (row, space, column): ";
                int x, y;
                cin >> x >> y;
                row = x - 1;
                col = y - 1;

                if (row < 0 || row > 3 || col < 0 || col > 3) {
                    cout << "Invalid move" << endl;
                    continue;
                }

                if (!game.makeMove(row, col)) {
                    cout << "Invalid move" << endl;
                    continue;
                }
                if(game.checkWin()){
                    cout<<"Player X wins"<<endl;
                    break;
                }
            } 
            else if (game.getPlayer() == 'O') {
                cout << "Player " << game.getPlayer() << ", enter your move (row, space, column): ";
                int l, k;
                cin >> l >> k;
                row = l - 1;
                col = k - 1;

                if (row < 0 || row > 3 || col < 0 || col >3) {
                    cout << "Invalid move" << endl;
                    continue;
                }

                if (!game.makeMove(row, col)) {
                    cout << "Invalid move" << endl;
                    continue;
                }
                if(game.checkWin()){
                    cout<<"Player O wins"<<endl;
                    break;
                }
            }

            
            else if (game.isBoardFull()) {
                game.printBoard();
                cout << "It's a tie!" << endl;
                break;
            }
        }
    }

    return 0;
}
