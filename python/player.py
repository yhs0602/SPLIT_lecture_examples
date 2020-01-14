import math
import struct
import wave
import re

volume = 0.5
framerate = 8000
sampwidth = 2

def tone(packed, frequency, duration):
    #packed = bytearray(b'')
    n = int(duration * framerate)
    for i in range(n) :
        t = i / framerate
        y = int(volume * math.sin(2*math.pi * frequency * t))
        packed.extend(struct.pack('<h', y))

amplitude = 0.5   # 0 to 1
maxVolume = 2**(sampwidth*8 - 1) - 1
volume = int(amplitude * maxVolume)

newwave = wave.open("out.wav","w")
newwave.setframerate(framerate)
newwave.setsampwidth(sampwidth)
newwave.setnchannels(1)
inputfile = open("test.txt","r")
result = bytearray(b'')
for line in inputfile:
    notes = line.split(' ')
    for note in notes:
        sp = note.split(':')
        dur = float(sp[1])
        ge =sp[0]
        print(ge[1:])
        
        octave = int(ge[1:])
        #octave = int(re.findall(r"\d+", ge)[0])
        name = ge[0]
        basefreq = {
            '도':262,
            '레':294,
            '미':330,
            '파':349,
            '솔':392,
            '라':440,
            '시':494
        }[name]
        freq = basefreq * (2**octave)
        tone(result,freq,dur)

newwave.writeframesraw(result)
newwave.close()
