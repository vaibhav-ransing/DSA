import re
import os

def extract_method_counts(log_file_path):
    method_counts = {}
    
    # Define regular expressions to match method/class names in Java logs
    method_pattern = re.compile(r'\b\w+\.\w+\(')
    class_pattern = re.compile(r'\b\w+\.\w+\b')

    with open(log_file_path, 'r') as file:
        for line in file:
            # Extract method names
            methods = re.findall(method_pattern, line)
            for method in methods:
                method_counts[method] = method_counts.get(method, 0) + 1

            # Extract class names
            classes = re.findall(class_pattern, line)
            for class_name in classes:
                method_counts[class_name] = method_counts.get(class_name, 0) + 1

    return method_counts

def process_log_files(log_folder_path):
    method_counts = {}

    # Loop through all files in the log folder
    for filename in os.listdir(log_folder_path):
        if filename.endswith(".log"):
            file_path = os.path.join(log_folder_path, filename)
            file_method_counts = extract_method_counts(file_path)

            # Merge counts from the current file into the overall counts
            for method, count in file_method_counts.items():
                method_counts[method] = method_counts.get(method, 0) + count

    return method_counts

if __name__ == "__main__":
    log_folder_path = "/path/to/your/log/folder"
    result = process_log_files(log_folder_path)

    # Print the counts
    for method, count in result.items():
        print(f"{method}: {count}")
