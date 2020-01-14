class Mbig:
    # left side of each object is the start point
    def __init__(self, x=2, v=-2, m=1, width=1):
        self.x, self.v, self.m, self.width = x, v, m, width,


    def location(self, t):
        self.x = self.v * t
        return self.x



class Msmall(Mbig):
    def location(self):
        if self.v < 0 and self.x == 0:
            self.v = -self.v

myMbig = Mbig()

for t in range(10):
    print(myMbig.location(t))

