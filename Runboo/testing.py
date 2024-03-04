from docx import Document

def read_docx(filename):
    doc = Document(filename)
    full_text_arr = []

    # Reading paragraphs
    for para in doc.paragraphs:
        full_text_arr.append(para.text)

    # Reading tables
    for table in doc.tables:
        for row in table.rows:
            for cell in row.cells:
                full_text_arr.append(cell.text)

    return full_text_arr

# Usage
text_content = read_docx('rb.docx')
for item in text_content:
    print(item)
