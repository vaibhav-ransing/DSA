import re

def extract_class_names(log_file_path):
    class_names = set()
    
    # Define a regular expression to match class names in Java logs
    class_pattern = re.compile(r'(?<=\]\s{2}--- \[).+?(?=\])')

    with open(log_file_path, 'r') as file:
        for line in file:
            # Extract class names using the pattern
            matches = re.findall(class_pattern, line)
            if matches:
                class_names.add(matches[0])

    return class_names

# Example usage:
log_file_path = r'log_1.txt'
class_names = extract_class_names(log_file_path)
print(class_names)
