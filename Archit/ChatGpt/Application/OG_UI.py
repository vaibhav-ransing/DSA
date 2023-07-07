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
    # Create a Toplevel window for the confirmation popup
    popup_window = tk.Toplevel(window)
    popup_window.title("Confirmation")
    popup_window.configure(bg="#F8F8F2")  # Light background color
    popup_window.attributes("-topmost", True)

    # Center the popup window
    popup_window_width = 300
    popup_window_height = 200
    popup_x = window.winfo_x() + int((window_width - popup_window_width) / 2)
    popup_y = window.winfo_y() + int((window_height - popup_window_height) / 2)
    popup_window.geometry(f"{popup_window_width}x{popup_window_height}+{popup_x}+{popup_y}")

    # Set custom font and size for the popup window
    popup_custom_font = ("Arial", 12)

    # Create a frame for the content
    content_frame = tk.Frame(popup_window, bg="#F8F8F2")
    content_frame.pack(pady=10)

    # Split the message into three lines
    message_lines = message.split("\n")

    # Create and arrange the labels with the message lines
    for line in message_lines:
        label_line = tk.Label(content_frame, text=line, bg="#F8F8F2", fg="#2E3440", font=popup_custom_font)
        label_line.pack(pady=1)

    # Create and arrange the buttons with reduced size and spacing
    button_frame = tk.Frame(popup_window, bg="#F8F8F2")  # Custom background color
    button_frame.pack(pady=10)

    def on_yes():
        try:
            sonar_script(user_id, user_password, component_name, folder_location, branch_name)
            popup_window.destroy()
            show_ok_popup("All the vulnerabilities are fixed \n Please check statistic report", False)
        except Exception as e:
            show_ok_popup("Please check your credentials", True)
       
    def on_no():
        popup_window.destroy()

    button_yes = tk.Button(button_frame, text="Yes", command=on_yes, bg="#6272A4", fg="#F8F8F2", font=popup_custom_font, relief=tk.FLAT, width=8, height=1)  # Custom colors, reduced size
    button_yes.pack(side=tk.LEFT, padx=10)

    button_no = tk.Button(button_frame, text="No", command=on_no, bg="#6272A4", fg="#F8F8F2", font=popup_custom_font, relief=tk.FLAT, width=8, height=1)  # Custom colors, reduced size
    button_no.pack(side=tk.LEFT, padx=10)

    # Center the content frame within the popup window
    content_frame.pack_configure(anchor=tk.CENTER)

    # Bring the popup window to the front and focus it
    popup_window.lift()
    popup_window.focus_force()

    # Make the main window inactive until the popup window is closed
    window.wait_window(popup_window)

def show_ok_popup(message, falseCreds):
    # Create a Toplevel window for the OK popup
    popup_window = tk.Toplevel(window)
    popup_window.title("Success")
    popup_window.configure(bg="#F8F8F2")  # Light background color
    popup_window.attributes("-topmost", True)

    # Center the popup window
    popup_window_width = 300
    popup_window_height = 150
    popup_x = window.winfo_x() + int((window_width - popup_window_width) / 2)
    popup_y = window.winfo_y() + int((window_height - popup_window_height) / 2)
    popup_window.geometry(f"{popup_window_width}x{popup_window_height}+{popup_x}+{popup_y}")

    # Set custom font and size for the popup window
    popup_custom_font = ("Arial", 12)

    # Create a frame for the content
    content_frame = tk.Frame(popup_window, bg="#F8F8F2")
    content_frame.pack(pady=20)

    # Split the message into multiple lines
    message_lines = message.split("\n")

    # Create and arrange the labels with the message lines
    for line in message_lines:
        label_line = tk.Label(content_frame, text=line, bg="#F8F8F2", fg="#2E3440", font=popup_custom_font, wraplength=250)
        label_line.pack()

    # Create and arrange the OK button
    button_frame = tk.Frame(popup_window, bg="#F8F8F2")  # Custom background color
    button_frame.pack(pady=10)

    def close_window():
        popup_window.destroy()
        if(falseCreds == False): window.destroy()

    button_ok = tk.Button(button_frame, text="OK", command=close_window, bg="#6272A4", fg="#F8F8F2", font=popup_custom_font, relief=tk.FLAT, width=8, height=1)  # Custom colors, reduced size
    button_ok.pack()

    # Center the content frame within the popup window
    content_frame.pack_configure(anchor=tk.CENTER)

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
        try:
            message = check_vulnerabilities(user_id, user_password, component_name, folder_location, branch_name)
            show_confirmation_popup(message, user_id, user_password, component_name, folder_location, branch_name)
        except Exception as e:
            show_ok_popup("Please check your credentials. \n", True)
    else:
        show_ok_popup("Please fill all the input fields. \n", True)
        

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