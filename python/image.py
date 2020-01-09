from PIL import Image
import random

image = Image.open("untitled.png")
image2 = Image.open("untitled2.jpg")
width, height = image.size
width2, height2 = image2.size
pixels = image.load()
pixels2 = image2.load()

minwidth = min(width, width2)
minheight = min(height, height2)

newimg = Image.new("RGBA",(minwidth,minheight),0xFFFFFFFF)
pixelsnew = newimg.load()

for x in range(minwidth):
    for y in range(minheight):
        pix1 = pixels[x,y]
        pix2 = pixels2[x,y]
        pix = (int(pix1[0] * pix2[0] / 256),int(pix1[1] * pix2[1] / 256),int(pix1[2] * pix2[2] / 256),255)  #[pix1, pix2][random.getrandbits(1)]
        pixelsnew[x,y] = (pix[0],pix[1],pix[2],255)
newimg.show()
newimg.save("out2.png")