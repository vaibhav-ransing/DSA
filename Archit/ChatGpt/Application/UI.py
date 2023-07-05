import tkinter as tk
from tkinter import filedialog
from tkinter import messagebox

# Dark mode theme colors
BG_COLOR = "#2E3440"  # Background color
FG_COLOR = "#F8F8F2"  # Foreground color
ENTRY_BG_COLOR = "#4C566A"  # Entry widget background color
BUTTON_BG_COLOR = "#6272A4"  # Button widget background color
HEADING_FONT = ("Arial", 26, "bold")  # Heading font
ENTRY_BORDER_WIDTH = 0  # Border width for the entry widgets

def browse_folder():
    folder_path = filedialog.askdirectory()
    if folder_path:
        entry_folder_location.delete(0, tk.END)
        entry_folder_location.insert(tk.END, folder_path)

def browse_report():
    report_path = filedialog.askopenfilename(filetypes=[("Text Files", "*.txt"), ("All Files", "*.*")])
    if report_path:
        entry_report_location.delete(0, tk.END)
        entry_report_location.insert(tk.END, report_path)

def show_confirmation_popup(message):
    response = messagebox.showinfo("Confirmation", message)
    if response == "ok":
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
    selection = radio_var.get()
    user_id = entry_user_id.get()
    user_password = entry_user_password.get()
    branch_name = entry_branch_name.get()
    component_name = entry_component_name.get()
    folder_location = entry_folder_location.get()
    report_location = entry_report_location.get()

    # Check if all required inputs are filled
    if selection == 1:  # "Yes" is selected
        if folder_location and report_location:
            message = "All inputs are filled.\nFolder Location: {}\nReport Location: {}".format(
                folder_location, report_location)
            show_confirmation_popup(message)
        else:
            messagebox.showwarning("Incomplete Form", "Please fill in all the required fields.")
    elif selection == 2:  # "No" is selected
        if folder_location and report_location and user_id and user_password and branch_name and component_name:
            message = "All inputs are filled.\nUser ID: {}\nUser Password: {}\nBranch Name: {}\nComponent Name: {}\nFolder Location: {}\nReport Location: {}".format(
                user_id, user_password, branch_name, component_name, folder_location, report_location)
            show_confirmation_popup(message)
        else:
            messagebox.showwarning("Incomplete Form", "Please fill in all the required fields.")

def on_radio_select():
    selection = radio_var.get()
    if selection == 1:  # "Yes" is selected
        label_user_id.place_forget()
        label_user_password.place_forget()
        label_branch_name.place_forget()
        label_component_name.place_forget()
        
        entry_user_id.place_forget()
        entry_user_password.place_forget()
        entry_branch_name.place_forget()
        entry_component_name.place_forget()
        
        label_folder_location.place(relx=0.05, rely=0.45, relwidth=0.4, relheight=0.05)
        entry_folder_location.place(relx=0.5, rely=0.45, relwidth=0.4, relheight=0.05)
        button_browse_folder.place(relx=0.85, rely=0.45, relwidth=0.1, relheight=0.05)

        label_report_location.place(relx=0.05, rely=0.53, relwidth=0.4, relheight=0.05)
        entry_report_location.place(relx=0.5, rely=0.53, relwidth=0.4, relheight=0.05)
        button_browse_report.place(relx=0.85, rely=0.53, relwidth=0.1, relheight=0.05)
        
        button_submit.place(relx=0.5, rely=0.7, anchor="center")
    elif selection == 2:  # "No" is selected
        label_folder_location.place(relx=0.05, rely=0.45, relwidth=0.4, relheight=0.05)
        entry_folder_location.place(relx=0.5, rely=0.45, relwidth=0.4, relheight=0.05)
        button_browse_folder.place(relx=0.85, rely=0.45, relwidth=0.1, relheight=0.05)

        label_report_location.place(relx=0.05, rely=0.53, relwidth=0.4, relheight=0.05)
        entry_report_location.place(relx=0.5, rely=0.53, relwidth=0.4, relheight=0.05)
        button_browse_report.place(relx=0.85, rely=0.53, relwidth=0.1, relheight=0.05)

        label_user_id.place(relx=0.05, rely=0.61, relwidth=0.4, relheight=0.05)
        entry_user_id.place(relx=0.5, rely=0.61, relwidth=0.4, relheight=0.05)

        # Adjust the vertical positions of the remaining labels and entry widgets
        label_user_password.place(relx=0.05, rely=0.69, relwidth=0.4, relheight=0.05)
        entry_user_password.place(relx=0.5, rely=0.69, relwidth=0.4, relheight=0.05)
        label_branch_name.place(relx=0.05, rely=0.77, relwidth=0.4, relheight=0.05)
        entry_branch_name.place(relx=0.5, rely=0.77, relwidth=0.4, relheight=0.05)
        label_component_name.place(relx=0.05, rely=0.85, relwidth=0.4, relheight=0.05)
        entry_component_name.place(relx=0.5, rely=0.85, relwidth=0.4, relheight=0.05)

        button_submit.place(relx=0.5, rely=0.92, anchor="center")


# Create the main window
window = tk.Tk()
window.title("Code Glance")
window.config(bg=BG_COLOR)

# Set the window size
window_width = 600
window_height = 700
window.geometry(f"{window_width}x{window_height}")

# Center the window on the screen
screen_width = window.winfo_screenwidth()
screen_height = window.winfo_screenheight()
x_coordinate = int((screen_width / 2) - (window_width / 2))
y_coordinate = int((screen_height / 2) - (window_height / 2))
window.geometry(f"{window_width}x{window_height}+{x_coordinate}+{y_coordinate}")


# Set custom font for all widgets
custom_font = ("Arial", 12)

# Create and arrange the heading label
label_heading = tk.Label(window, text="Code Glance", bg=BG_COLOR, fg=FG_COLOR, font=HEADING_FONT)
label_heading.pack(pady=20)

# Create and arrange the radio button label
label_radio = tk.Label(window, text="Do you have a Sonar report?", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_radio.pack()

# Create and arrange the radio buttons
radio_var = tk.IntVar()
radio_yes = tk.Radiobutton(window, text="Yes", variable=radio_var, value=1, command=on_radio_select, bg=BG_COLOR, fg=FG_COLOR, font=custom_font, selectcolor=BG_COLOR)
radio_yes.place(relx=0.4, rely=0.2, anchor="center")

radio_no = tk.Radiobutton(window, text="No", variable=radio_var, value=2, command=on_radio_select, bg=BG_COLOR, fg=FG_COLOR, font=custom_font, selectcolor=BG_COLOR)
radio_no.place(relx=0.6, rely=0.2, anchor="center")

# Create and arrange the entry fields and labels
label_user_id = tk.Label(window, text="User ID:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_user_id.place_forget()

entry_user_id = tk.Entry(window, bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font, bd=ENTRY_BORDER_WIDTH)
entry_user_id.place_forget()

label_user_password = tk.Label(window, text="User Password:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_user_password.place_forget()

entry_user_password = tk.Entry(window, bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font, bd=ENTRY_BORDER_WIDTH)
entry_user_password.place_forget()

label_branch_name = tk.Label(window, text="Branch Name:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_branch_name.place_forget()

entry_branch_name = tk.Entry(window, bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font, bd=ENTRY_BORDER_WIDTH)
entry_branch_name.place_forget()

label_component_name = tk.Label(window, text="Component Name:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_component_name.place_forget()

entry_component_name = tk.Entry(window, bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font, bd=ENTRY_BORDER_WIDTH)
entry_component_name.place_forget()

label_folder_location = tk.Label(window, text="Folder Location:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
# label_folder_location.place(relx=0.05, rely=0.45, relwidth=0.4, relheight=0.05)
label_folder_location.place_forget()

entry_folder_location = tk.Entry(window, bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font, bd=ENTRY_BORDER_WIDTH)
entry_folder_location.place_forget()

button_browse_folder = tk.Button(window, text="Browse", command=browse_folder, bg=BUTTON_BG_COLOR, fg=FG_COLOR, font=custom_font)
button_browse_folder.place_forget()

label_report_location = tk.Label(window, text="Report Location:", bg=BG_COLOR, fg=FG_COLOR, font=custom_font)
label_report_location.place_forget()

entry_report_location = tk.Entry(window, bg=ENTRY_BG_COLOR, fg=FG_COLOR, font=custom_font, bd=ENTRY_BORDER_WIDTH)
entry_report_location.place_forget()

button_browse_report = tk.Button(window, text="Browse", command=browse_report, bg=BUTTON_BG_COLOR, fg=FG_COLOR, font=custom_font)
button_browse_report.place_forget()

button_submit = tk.Button(window, text="Submit", command=submit_form, bg=BUTTON_BG_COLOR, fg=FG_COLOR, font=custom_font)
button_submit.place(relx=0.5, rely=0.7, anchor="center")

# Run the main window's event loop
window.mainloop()
