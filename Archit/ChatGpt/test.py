import os

# Get the location of the running file
file_location = os.path.realpath(__file__)

# Extract the directory path
directory_path = os.path.dirname(file_location)

print("Parent Directory Path:", directory_path)
