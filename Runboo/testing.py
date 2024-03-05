import os
from docx import Document
from win32com import client

def convert_to_docx(doc_file, docx_file):
    word = client.Dispatch("Word.Application")
    try:
        doc = word.Documents.Open(doc_file)
        doc.SaveAs(docx_file, FileFormat=16)
    except Exception as e:
        print(f"Error converting {doc_file}:", e)
    finally:
        word.Quit()

def convert_folder_to_docx(doc_folder, docx_folder):
    if not os.path.exists(docx_folder):
        os.makedirs(docx_folder)
    
    for filename in os.listdir(doc_folder):
        if filename.endswith('.doc'):
            doc_file = os.path.join(doc_folder, filename)
            docx_file = os.path.join(docx_folder, filename.replace('.doc', '.docx'))
            convert_to_docx(doc_file, docx_file)

# Paths to input and output folders
doc_files_folder = 'doc_files'
docx_files_folder = 'docx_files'

# Convert .doc files to .docx
convert_folder_to_docx(doc_files_folder, docx_files_folder)
