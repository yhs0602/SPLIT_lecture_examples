import zipfile

myzip = zipfile.ZipFile('new.zip','w')
myzip.write('out.wav',compress_type=zipfile.ZIP_LZMA)
myzip.write('ls.py',compress_type=zipfile.ZIP_LZMA)
myzip.write('out.png',compress_type=zipfile.ZIP_LZMA)
myzip.close()

myzip = zipfile.ZipFile('new.zip')
for f in myzip.filelist:
    print (f)
myzip.extractall('new.zipp')
