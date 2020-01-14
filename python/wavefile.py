import wave
import math
import struct

newwave = wave.open("out.wav","w")


framerate = 8000
sampwidth = 2

newwave.setframerate(framerate)
newwave.setsampwidth(sampwidth)
newwave.setnchannels(1)

frequency = 440   # Hz
amplitude = 0.5   # 0 to 1
duration = 3      # seconds

maxVolume = 2**(sampwidth*8 - 1) - 1
volume = int(amplitude * maxVolume)
n = int(duration * framerate)   # number of frames

packed = bytearray(b'')
for i in range(n) :
    t = i / framerate
    y = int(volume * math.sin(2*math.pi * frequency * t))
    packed.extend(struct.pack('<h', y))
newwave.writeframesraw(packed)
newwave.close()
