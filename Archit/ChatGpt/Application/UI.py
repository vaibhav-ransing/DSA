import tkinter as tk
from tkinter import filedialog
import requests
from sonarScript import sonar_script

# Dark mode theme colors
BG_COLOR = "#2E3440"  # Background color
FG_COLOR = "#F8F8F2"  # Foreground color
ENTRY_BG_COLOR = "#4C566A"  # Entry widget background color
BUTTON_BG_COLOR = "#6272A4"  # Button widget background color
HEADING_FONT = ("Arial", 18, "bold")  # Heading font

def browse_folder():
    folder_path = filedialog.askdirectory()
    if folder_path:
        entry_folder_location.delete(0, tk.END)
        entry_folder_location.insert(tk.END, folder_path)

def submit_form():
    user_id = entry_user_id.get()
    user_password = entry_user_password.get()
    component_name = entry_component_name.get()
    folder_location = entry_folder_location.get()
    branch_name = entry_branch_name.get()

    sonar_script(user_id, user_password, component_name, folder_location, branch_name)

    window.destroy()  # Close the window

# Create the main window
window = tk.Tk()
window.title("Sonar Vulnerability Fix")
window.config(bg=BG_COLOR)

# Set custom font for all widgets
custom_font = ("Arial", 12)

# Create and arrange the heading label
label_heading = tk.Label(window, text="Sonar Vulnerability Fix", bg=BG_COLOR, fg=FG_COLOR, font=HEADING_FONT)
label_heading.pack(pady=20)

# Create and arrange the user input fields
label_user_id = tk.Label(window, text="User ID:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_user_id.pack(pady=10)

entry_user_id = tk.Entry(window, bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font)
entry_user_id.pack(pady=5)

label_user_password = tk.Label(window, text="User Password:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_user_password.pack(pady=10)

entry_user_password = tk.Entry(window, show="*", bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font)
entry_user_password.pack(pady=5)

label_component_name = tk.Label(window, text="Component Name:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_component_name.pack(pady=10)

entry_component_name = tk.Entry(window, bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font)
entry_component_name.pack(pady=5)

label_folder_location = tk.Label(window, text="Folder Location:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_folder_location.pack(pady=10)

entry_folder_location = tk.Entry(window, bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font)
entry_folder_location.pack(pady=5)

label_branch_name = tk.Label(window, text="Branch Name:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_branch_name.pack(pady=10)

entry_branch_name = tk.Entry(window, bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font)
entry_branch_name.pack(pady=5)

button_browse_folder = tk.Button(window, text="Browse Folder", command=browse_folder, bg=BUTTON_BG_COLOR, fg=FG_COLOR, font=custom_font)
button_browse_folder.pack(pady=20)

button_submit = tk.Button(window, text="Submit", command=submit_form, bg=BUTTON_BG_COLOR, fg=FG_COLOR, font=custom_font, relief=tk.FLAT)
button_submit.pack(pady=10)

# Set the window dimensions and center it on the screen
window_width = 500
window_height = 600
screen_width = window.winfo_screenwidth()
screen_height = window.winfo_screenheight()
x_coordinate = int((screen_width/2) - (window_width/2))
y_coordinate = int((screen_height/2) - (window_height/2))
window.geometry(f"{window_width}x{window_height}+{x_coordinate}+{y_coordinate}")

# Configure smooth corners for the window
window.overrideredirect(True)
window.overrideredirect(False)
window.attributes('-alpha', 0.95)

# Add a drop shadow effect to the window
window_shadow = tk.Toplevel(window)
window_shadow.geometry(window.geometry())
window_shadow.configure(bg="#000000")
window_shadow.attributes("-alpha", 0.2)
window_shadow.attributes("-topmost", True)
window_shadow.overrideredirect(True)
window_shadow.lift(window)

# Update window shadow position and size when the main window is moved or resized
def update_window_shadow(event):
    window_shadow.geometry(window.geometry())
window.bind("<Configure>", update_window_shadow)

# Bring the window to the front and focus it
window.lift()
window.focus_force()

# Start the main loop
window.mainloop()
