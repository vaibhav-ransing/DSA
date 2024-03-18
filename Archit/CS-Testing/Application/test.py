import pandas as pd

# Create a sample DataFrame
data = {
    'Column1': [1, 2, 3, 4, 5],
    'Column2': ['A', 'B', 'C', 'D', 'E'],
    'Column3': [0.1, 0.2, 0.3, 0.4, 0.5]
}

df = pd.DataFrame(data)

# Generate a random sample of 3 rows from the DataFrame
sample = df.sample(n=3, random_state=42)  # Set a random_state for reproducibility

print(sample)