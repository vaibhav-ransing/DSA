import pandas as pd
from openpyxl import load_workbook

# Define the Excel file location
report_location = 'your_excel_file.xlsx'

# Load the existing Excel file
xls = pd.ExcelFile(report_location)

# Read the existing "Filtered_Data" sheet into a DataFrame
df_filtered = pd.read_excel(xls, sheet_name='Filtered_Data')

# Edit a specific cell using the iat method
row_index = 0
column_index = df_filtered.columns.get_loc('ColumnA')  # Get the index of the desired column
new_value = 'UpdatedValue'
df_filtered.iat[row_index, column_index] = new_value

# Create a new ExcelWriter object with a copy of the existing workbook
wb = load_workbook(filename=report_location)
writer = pd.ExcelWriter(report_location, engine='openpyxl')
writer.book = wb

# Save the modified DataFrame back to the "Filtered_Data" sheet using the new ExcelWriter
with writer.save():
    df_filtered.to_excel(writer, sheet_name='Filtered_Data', index=False)
