import threading 
import time

done = False
def worker(text):
    counter = 0
    while not done:
        time.sleep(1)
        counter += 1
        print( f"{text}: {counter}" )


workerThread = threading.Thread(target=worker, args=("ABC",))
workerThread2 = threading.Thread(target=worker, args=("xyz",))
workerThread.start()
workerThread2.start()

input("Press Enter to quit")
done = True