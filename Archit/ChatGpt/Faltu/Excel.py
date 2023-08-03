import pandas as pd

# Create your DataFrame for Sheet1
columns = ['Column1', 'Column2', 'Column3']
dataSheet1 = {'Column1': [1, 2, 3], 'Column2': [4, 5, 6], 'Column3': [7, 8, 9]}
df = pd.DataFrame(dataSheet1, columns=columns)

# Define the Excel file location
report_location = 'your_excel_file.xlsx'

# Write the DataFrame to the Excel file (Sheet1)
df.to_excel(report_location, sheet_name='Sheet1', index=False)

# Create your DataFrame for Sheet2 ("Filtered_Data")
dataSheet2 = {'ColumnA': ['A', 'B', 'C'], 'ColumnB': ['X', 'Y', 'Z']}
df_sheet2 = pd.DataFrame(dataSheet2)

# Append the new sheet to the existing Excel file
with pd.ExcelWriter(report_location, engine='openpyxl', mode='a') as writer:
    df_sheet2.to_excel(writer, sheet_name='Filtered_Data', index=False)

# Access the new sheet ("Filtered_Data") later
xls = pd.ExcelFile(report_location)
df_filtered = pd.read_excel(xls, sheet_name='Filtered_Data')

# Now you can work with df_filtered DataFrame
