import turtle as tur
tur.speed(5)
colors= ["brown","blue","red","green","orange"]
tur.pensize(1)
x = 0
y = 0
col = 0
tur.setposition(x,y)
for shape in range(3):
    tur.color(colors[col])
    for i in range(8):
        tur.forward(50)
        tur.left(45)
    tur.penup()
    y = y - 25
    tur.setposition(x,y)
    tur.pendown()
    col=col+1
tur.penup()
y = y - 75
tur.setposition(x,y)
tur.pendown()
for shape in range(2):
    
    tur.color(colors[col])
    for i in range(8):
        tur.forward(50)
        tur.left(45)
    tur.penup()
    y = y - 50
    tur.setposition(x,y)
    tur.pendown()
    col=col+1
x = 0
y = 30
for shape in range(2):
    
    tur.penup()
    tur.setposition(x,y)
    tur.pendown()
    tur.color("orange")
    tur.fillcolor("black")
    tur.begin_fill()
    tur.circle(5)
    tur.end_fill()
    x = x + 50
tur.ht()

    

        
   