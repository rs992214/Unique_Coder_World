import random

def play_rock_paper_scissors():
    choices = ["rock", "paper", "scissors"]
    computer_choice = random.choice(choices)

    while True:
        player_choice = input("Choose rock, paper, or scissors (q to quit): ").lower()

        if player_choice == 'q':
            break

        if player_choice not in choices:
            print("Invalid choice. Please choose rock, paper, or scissors.")
            continue

        print(f"Computer chose: {computer_choice}")
        print(f"You chose: {player_choice}")

        if player_choice == computer_choice:
            print("It's a tie!")
        elif (
            (player_choice == "rock" and computer_choice == "scissors")
            or (player_choice == "scissors" and computer_choice == "paper")
            or (player_choice == "paper" and computer_choice == "rock")
        ):
            print("You win!")
        else:
            print("Computer wins!")

if __name__ == "__main__":
    print("Welcome to Rock, Paper, Scissors!")
    play_rock_paper_scissors()
