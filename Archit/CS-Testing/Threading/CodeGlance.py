import threading
import time
import random

def javaFunction(data):
    print(data)
    t = random.randint(1,5)
    time.sleep(t)
    print(f"{t} = data = {data}")
    if data == "hello":
        return True
    elif data == "abc":
        return True
    else:
        return False

def sonarScript(arr):
    # Create a list to hold the thread objects
    threads = []

    # Create and start threads for each element in the array
    for data in arr:
        thread = threading.Thread(target=javaFunction, args=(data,))
        thread.start()
        threads.append(thread)

    # Wait for all threads to finish
    for thread in threads:
        thread.join()

    print(thread)

arr = ["hello", "No", "hello", "abc", "hello", "mc"]


sonarScript(arr)