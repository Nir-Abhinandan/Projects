import tkinter as tk

class CircleAnimation:
    def __init__(self, master, width, height, circle_radius=20):
        self.master = master
        self.width = width
        self.height = height
        self.circle_radius = circle_radius
        self.canvas = tk.Canvas(master, width=width, height=height, bg='white')
        self.canvas.pack()
        self.create_circle()
        self.dx = 1
        self.dy = 1
        self.speed_scale = tk.Scale(master, from_=1, to=100, orient=tk.HORIZONTAL, label="Speed", command=self.update_speed)
        self.speed_scale.pack()
        self.speed_scale.set(5)
        self.speed = 5
        self.animate_circle()

    def create_circle(self):
        x0 = self.width / 2 - self.circle_radius
        y0 = self.height / 2 - self.circle_radius
        x1 = self.width / 2 + self.circle_radius
        y1 = self.height / 2 + self.circle_radius
        self.circle = self.canvas.create_oval(x0, y0, x1, y1, fill='blue')
    
    def update_speed(self, speed):
        self.speed = int(speed)

    def animate_circle(self):
        self.canvas.move(self.circle, self.dx * self.speed, self.dy * self.speed)
        x0, y0, x1, y1 = self.canvas.coords(self.circle)
        if x0 <= 0 or x1 >= self.width:
            self.dx *= -1
        if y0 <= 0 or y1 >= self.height:
            self.dy *= -1
        self.master.after(10, self.animate_circle)

def main():
    root = tk.Tk()
    root.title("Circle Animation")
    width = 400
    height = 300
    CircleAnimation(root, width, height)
    root.mainloop()

if __name__ == "__main__":
    main()
