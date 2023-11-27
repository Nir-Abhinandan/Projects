#include <iostream>
#include <cstdlib>

using namespace std;

int generateRandomNumber(int min, int max) {
    return rand() % (max - min + 1) + min;
}

char generateRandomOperator() {
    char operators[] = {'+', '-', '*'};
    int index = rand() % 3;
    return operators[index];
}

int main() {
    int num1, num2, result, userAnswer, score = 0;
    char op;
    char playAgain;

    cout << "Welcome to the Random Math Problems Game!" << endl;

    do {
        num1 = generateRandomNumber(1, 20);
        num2 = generateRandomNumber(1, 20);
        op = generateRandomOperator();

        cout << "Question: ";
        cout << num1 << " " << op << " " << num2 << " = ?" << endl;

        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            default:
                cerr << "Error: Invalid operator." << endl;
                return 1;
        }

        cout << "Your answer: ";
        cin >> userAnswer;

        if (userAnswer == result) {
            cout << "Correct!" << endl;
            score++;
        } else {
            cout << "Wrong! The correct answer is: " << result << endl;
        }

        cout << "Do you want to continue? (y/n): ";
        cin >> playAgain;

    } while (playAgain == 'y' || playAgain == 'Y');

    
    cout << "Your final score is: " << score << " out of the questions attempted." << endl;

    return 0;
}
