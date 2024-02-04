import tkinter as tk
from tkinter import messagebox
import random
from PIL import Image, ImageTk
import requests
from io import BytesIO

def play_game(player_choice):
    choices = ["Rock", "Paper", "Scissors"]
    computer_choice = random.choice(choices)

    result = determine_winner(player_choice, computer_choice)

    messagebox.showinfo("Result", f"Computer chose {computer_choice}. {result}")

def determine_winner(player, computer):
    if player == computer:
        return "It's a tie!"
    elif (player == "Rock" and computer == "Scissors") or (player == "Paper" and computer == "Rock") or (player == "Scissors" and computer == "Paper"):
        return "You win!"
    else:
        return "Computer wins!"

def load_image(url):
    try:
        response = requests.get(url)
        img_data = BytesIO(response.content)
        return Image.open(img_data)
    except Exception as e:
        print(f"Error loading image from {url}: {e}")
        return None

def create_gui():
    window = tk.Tk()
    window.title("Rock, Paper, Scissors Game")

    frame = tk.Frame(window, padx=150, pady=100)
    frame.pack()

   
    rock_img = load_image("https://banner2.cleanpng.com/20180402/eie/kisspng-pebble-rock-boulder-clip-art-pebble-5ac205d27e8052.7574813115226649145182.jpg")
    paper_img = load_image("https://www.clker.com/cliparts/5/6/2/0/1194984467464538364carta_architetto_frances_01.svg.hi.png")
    scissors_img = load_image("https://spaces-cdn.clipsafari.com/htq77ytjo3a48o68exgzdq8b8eg3")

  
    if None in (rock_img, paper_img, scissors_img):
        messagebox.showerror("Error", "Failed to load one or more images. Check the URLs.")
        window.destroy()
        return

  
    rock_img = rock_img.resize((30, 30))
    paper_img = paper_img.resize((30, 30))
    scissors_img = scissors_img.resize((30, 30))

    
    rock_photo = ImageTk.PhotoImage(rock_img)
    paper_photo = ImageTk.PhotoImage(paper_img)
    scissors_photo = ImageTk.PhotoImage(scissors_img)

    label = tk.Label(frame, text="Select your move:")
    label.grid(row=0, column=0, columnspan=3, pady=10)

    rock_button = tk.Button(frame, text="Rock", image=rock_photo, compound=tk.TOP, width=60, height=60, command=lambda: play_game("Rock"))
    rock_button.image = rock_photo
    rock_button.grid(row=1, column=0, padx=15)

    paper_button = tk.Button(frame, text="Paper", image=paper_photo, compound=tk.TOP, width=60, height=60, command=lambda: play_game("Paper"))
    paper_button.image = paper_photo
    paper_button.grid(row=1, column=1, padx=15)

    scissors_button = tk.Button(frame, text="Scissors", image=scissors_photo, compound=tk.TOP, width=60, height=60, command=lambda: play_game("Scissors"))
    scissors_button.image = scissors_photo
    scissors_button.grid(row=1, column=2, padx=15)

    window.mainloop()

if __name__ == "__main__":
    create_gui()
