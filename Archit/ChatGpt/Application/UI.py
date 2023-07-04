import tkinter as tk
from tkinter import filedialog
from tkinter import messagebox
from sonarScript import sonar_script
from sonarScript import check_vulnerabilities

# Dark mode theme colors
BG_COLOR = "#2E3440"  # Background color
FG_COLOR = "#F8F8F2"  # Foreground color
ENTRY_BG_COLOR = "#4C566A"  # Entry widget background color
BUTTON_BG_COLOR = "#6272A4"  # Button widget background color
HEADING_FONT = ("Arial", 18, "bold")  # Heading font
ENTRY_BORDER_WIDTH = 0  # Border width for the entry widgets

def browse_folder():
    folder_path = filedialog.askdirectory()
    if folder_path:
        entry_folder_location.delete(0, tk.END)
        entry_folder_location.insert(tk.END, folder_path)

def show_confirmation_popup(message, user_id, user_password, component_name, folder_location, branch_name):
    response = messagebox.askquestion("Confirmation", message, icon="warning")
    if response == "yes":
        sonar_script(user_id, user_password, component_name, folder_location, branch_name)
        show_ok_popup("All the vulnerabilities are fixed")

def show_ok_popup(message):
    popup_window = tk.Toplevel(window)
    popup_window.title("Success")
    popup_window.configure(bg=BG_COLOR)
    popup_window.attributes("-topmost", True)

    # Center the popup window
    popup_window_width = 300
    popup_window_height = 150
    popup_x = window.winfo_x() + int((window_width - popup_window_width) / 2)
    popup_y = window.winfo_y() + int((window_height - popup_window_height) / 2)
    popup_window.geometry(f"{popup_window_width}x{popup_window_height}+{popup_x}+{popup_y}")

    # Set custom font for the popup window
    popup_custom_font = ("Arial", 14)

    # Create and arrange the label with the message
    label_message = tk.Label(popup_window, text=message, bg=BG_COLOR, fg=FG_COLOR, font=popup_custom_font)
    label_message.pack(pady=20)

    # Create and arrange the OK button
    def close_window():
        popup_window.destroy()
        window.destroy()

    button_ok = tk.Button(popup_window, text="OK", command=close_window, bg=BUTTON_BG_COLOR, fg=FG_COLOR, font=popup_custom_font, relief=tk.FLAT)
    button_ok.pack(pady=10)

    # Bring the popup window to the front and focus it
    popup_window.lift()
    popup_window.focus_force()

    # Make the main window inactive until the popup window is closed
    window.wait_window(popup_window)

def submit_form():
    user_id = entry_user_id.get()
    user_password = entry_user_password.get()
    branch_name = entry_branch_name.get()
    component_name = entry_component_name.get()
    folder_location = entry_folder_location.get()

    # Check if all inputs are filled
    if user_id and user_password and branch_name and component_name and folder_location:
        message = check_vulnerabilities(user_id, user_password, component_name, folder_location, branch_name)
        show_confirmation_popup(message, user_id, user_password, component_name, folder_location, branch_name)
    else:
        messagebox.showwarning("Incomplete Form", "Please fill in all the required fields.")

# Create the main window
window = tk.Tk()
window.title("Code Glance")
window.config(bg=BG_COLOR)

# Set custom font for all widgets
custom_font = ("Arial", 12)

# Create and arrange the heading label
label_heading = tk.Label(window, text="Code Glance", bg=BG_COLOR, fg=FG_COLOR, font=HEADING_FONT)
label_heading.pack(pady=20)

# Create and arrange the user input fields
label_user_id = tk.Label(window, text="User ID:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_user_id.pack(pady=10)

entry_user_id = tk.Entry(window, bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font, relief=tk.FLAT, bd=ENTRY_BORDER_WIDTH)
entry_user_id.pack(pady=5)

label_user_password = tk.Label(window, text="User Password:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_user_password.pack(pady=10)

entry_user_password = tk.Entry(window, show="*", bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font, relief=tk.FLAT, bd=ENTRY_BORDER_WIDTH)
entry_user_password.pack(pady=5)

label_branch_name = tk.Label(window, text="Branch Name:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_branch_name.pack(pady=10)

entry_branch_name = tk.Entry(window, bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font, relief=tk.FLAT, bd=ENTRY_BORDER_WIDTH)
entry_branch_name.pack(pady=5)

label_component_name = tk.Label(window, text="Component Name:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_component_name.pack(pady=10)

entry_component_name = tk.Entry(window, bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font, relief=tk.FLAT, bd=ENTRY_BORDER_WIDTH)
entry_component_name.pack(pady=5)

label_folder_location = tk.Label(window, text="Folder Location:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_folder_location.pack(pady=10)

entry_folder_location = tk.Entry(window, bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font, relief=tk.FLAT, bd=ENTRY_BORDER_WIDTH)
entry_folder_location.pack(pady=5)

button_browse_folder = tk.Button(window, text="Browse Folder", command=browse_folder, bg=BUTTON_BG_COLOR, fg=FG_COLOR, font=custom_font, relief=tk.FLAT)
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