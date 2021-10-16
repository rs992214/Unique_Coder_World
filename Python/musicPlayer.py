from pygame import mixer

mixer.init()

mixer.music.load("8D.mp3")
mixer.music.set_volume(1)
mixer.music.play()

while True:
    print("p to pause, r to resume,e to exit")
    print('<<<');input1 = input()


    if input1 == 'p':
        mixer.music.pause()
    elif input1 == 'r':
        mixer.music.unpause()

    elif input1 == 'e':
        mixer.music.stop()
        break
    elif input1 == 'rw':
        print("rw for rewind")
        mixer.music.rewind()
