import os
from zipfile import ZipFile

def compress_folder(folder_path, zip_path):
    with ZipFile(zip_path, 'w') as zip_file:
        for root, dirs, files in os.walk(folder_path):
            for file in files:
                file_path = os.path.join(root, file)
                arc_name = os.path.relpath(file_path, folder_path)
                zip_file.write(file_path, arcname=arc_name)

# Example usage
folder_to_compress = 'folder_to_compress'
zip_file_path = 'compressed_folder.zip'

compress_folder(folder_to_compress, zip_file_path)
