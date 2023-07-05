import pandas as pd

# Read the Excel template
template_file = 'vulTemp.xlsx'
df_template = pd.read_excel(template_file)

# Make a copy of the template
df_copy = df_template.copy()

# Specify the row and column to write the value
row_index = 0  # Example: row index 2 (0-based indexing)
col_index  = 2  # Example: column B

# Write a value to the specified row and column
value = 'Hello, World!'
df_copy.iat[row_index, col_index ] = value






# Append an empty row to the DataFrame
df_copy = pd.concat([df_copy, pd.DataFrame([{}])], ignore_index=True)

row_index = 11  # Example: row index 2 (0-based indexing)
col_index  = 1  # Example: column B

# Write a value to the specified row and column
value = 'C/user/test.java'
df_copy.iat[row_index, col_index ] = value


# Save the modified copy to a new Excel file
output_file = 'output.xlsx'
df_copy.to_excel(output_file, index=False)
