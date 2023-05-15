import random

def generate_unique_random_number():
    numbers_seen = set()
    while True:
        random_number = random.randint(1, 9999)
        if random_number not in numbers_seen:
            numbers_seen.add(random_number)
            return random_number
