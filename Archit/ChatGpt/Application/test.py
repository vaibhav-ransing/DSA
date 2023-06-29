import json

# Read JSON from file
with open("data.json", "r") as file:
    json_data = json.load(file)
    
print(json_data)