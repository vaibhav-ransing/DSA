import os
from docx import Document

def convert_folder_to_docx(doc_folder, docx_folder):
    # Create docx folder if it doesn't exist
    if not os.path.exists(docx_folder):
        os.makedirs(docx_folder)
    
    # Loop through .doc files in doc_folder
    for filename in os.listdir(doc_folder):
        if filename.endswith('.doc'):
            doc_file = os.path.join(doc_folder, filename)
            docx_file = os.path.join(docx_folder, filename.replace('.doc', '.docx'))
            doc = Document(doc_file)
            doc.save(docx_file)

# Paths to input and output folders
doc_files_folder = 'doc_files'
docx_files_folder = 'docx_files'

# Convert .doc files to .docx
convert_folder_to_docx(doc_files_folder, docx_files_folder)
