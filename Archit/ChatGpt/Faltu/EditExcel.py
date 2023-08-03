import pandas as pd

# Define the Excel file location
report_location = 'your_excel_file.xlsx'

# Load the Excel file
xls = pd.ExcelFile(report_location)

# Read the "Filtered_Data" sheet into a DataFrame
df_filtered = pd.read_excel(xls, sheet_name='Filtered_Data')

# Edit data in the DataFrame
row_index = 0
column_index = 0
new_value = 'UpdatedValue'
df_filtered.at[row_index, column_index] = new_value

# Reopen the Excel file with the default "xlsxwriter" engine
with pd.ExcelWriter(report_location, engine='xlsxwriter') as writer:
    writer.book = xls.book
    writer.sheets = dict((ws.title, ws) for ws in xls.book.worksheets)

    # Write the modified DataFrame back to the "Filtered_Data" sheet
    df_filtered.to_excel(writer, sheet_name='Filtered_Data', index=False)
