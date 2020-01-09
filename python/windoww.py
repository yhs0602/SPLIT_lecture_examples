from tkinter import *
from tkinter import messagebox

root =Tk()
root.title("타이틀 1")
root.mainloop()
ans = messagebox.askquestion("h")
if ans == 'yes':
    print("Yes")

