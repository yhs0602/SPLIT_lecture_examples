from tkinter import *
from tkinter import messagebox
from PIL import Image


def hello():
    messagebox.askquestion("Are you ok?")
root = Tk()
root.title("Helloo worldddd")
root.geometry("500x100")
B1 = Button(root, text = "Say Hello", command = hello)
B1.place(x = 35,y = 50)
w = Label(root, text = "Hello world")
w.pack()
messagebox.askokcancel("Hello", "DODODODOD")
root.mainloop()
