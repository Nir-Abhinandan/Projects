import tkinter as tk


class DrawingBoard:
    def __init__(self, root):
        self.root = root
        root.title("Drawing Board")

        self.canvas = tk.Canvas(root, bg="white", width=400, height=400)
        self.canvas.pack(expand=tk.YES, fill=tk.BOTH)

        self.pen_color = "Black"

        self.canvas.bind("<B1-Motion>", self.draw)
        clear_button = tk.Button(self.root, text="Clear", command= lambda:self.canvas.delete("all"))
        clear_button.pack(side=tk.BOTTOM)




    def draw(self, pos):
        x1, y1 = (pos.x+3), (pos.y)
        x2, y2 = (pos.x), (pos.y+3)
        self.canvas.create_oval(x1, y1, x2, y2, fill=self.pen_color, width=3)






def main():
    root = tk.Tk()
    drawing_board = DrawingBoard(root)
    root.mainloop()
main()
