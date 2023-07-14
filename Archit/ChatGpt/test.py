import tkinter as tk
from tkinter import ttk
import threading

def show_loading_popup(user_id, user_password, component_name, folder_location, branch_name):
    loading_popup = tk.Toplevel(window)
    loading_popup.title("Loading")
    loading_popup.configure(bg="#F8F8F2")  # Light background color
    loading_popup.attributes("-topmost", True)

    loading_popup_width = 300
    loading_popup_height = 150
    loading_popup_x = window.winfo_x() + int((window_width - loading_popup_width) / 2)
    loading_popup_y = window.winfo_y() + int((window_height - loading_popup_height) / 2)
    loading_popup.geometry(f"{loading_popup_width}x{loading_popup_height}+{loading_popup_x}+{loading_popup_y}")

    loading_custom_font = ("Arial", 14)

    # Create a frame for the content
    content_frame = tk.Frame(loading_popup, bg="#F8F8F2")  # Custom background color
    content_frame.pack(pady=10)

    # Create and place the label with the loading message
    label_loading = tk.Label(content_frame, text="Please wait, fixing vulnerabilities", bg="#F8F8F2", fg="#2E3440", font=loading_custom_font)  # Custom colors
    label_loading.pack()

    # Create a frame for the progress bar
    progress_frame = tk.Frame(loading_popup, bg="#F8F8F2")  # Custom background color
    progress_frame.pack(pady=10)

    # Create a progress bar widget
    progress = ttk.Progressbar(progress_frame, orient="horizontal", length=200, mode="indeterminate")
    progress.pack()

    # Start the progress bar animation
    progress.start()

    # Disable the main window
    window.attributes("-disabled", True)

    def simulate_loading():
        try:
            # Call the sonar_script function with the provided arguments
            sonar_script(user_id, user_password, component_name, folder_location, branch_name)
            import time
            time.sleep(5)

            # Enable the main window
            window.attributes("-disabled", False)

            # Close the loading popup
            loading_popup.destroy()

            # Show a completion message
            show_ok_popup("All the vulnerabilities are fixed\nPlease check the statistic report", False)
        except Exception as e:
            show_ok_popup("Please check your credentials", True)

    # Start a new thread for simulating the loading
    thread = threading.Thread(target=simulate_loading)
    thread.start()

# Call the show_loading_popup function where appropriate in your code, based on your application's flow,
# and provide the necessary arguments: user_id, user_password, component_name, folder_location, branch_name.



def show_ok_popup(message, is_error):
    ok_popup = tk.Toplevel(window)
    ok_popup.title("Confirmation")
    ok_popup.configure(bg="#F8F8F2")  # Light background color
    ok_popup.attributes("-topmost", True)

    ok_popup_width = 300
    ok_popup_height = 150
    ok_popup_x = window.winfo_x() + int((window_width - ok_popup_width) / 2)
    ok_popup_y = window.winfo_y() + int((window_height - ok_popup_height) / 2)
    ok_popup.geometry(f"{ok_popup_width}x{ok_popup_height}+{ok_popup_x}+{ok_popup_y}")

    ok_custom_font = ("Arial", 12)

    # Determine the background color based on error or success
    bg_color = "#FF0000" if is_error else "#00FF00"

    # Create a frame for the content
    content_frame = tk.Frame(ok_popup, bg=bg_color)  # Custom background color
    content_frame.pack(pady=10)

    # Create and place the label with the message
    label_message = tk.Label(content_frame, text=message, bg=bg_color, fg="#2E3440", font=ok_custom_font)  # Custom colors
    label_message.pack()

    # Center the content frame within the popup window
    content_frame.pack_configure(anchor=tk.CENTER)

    # Bring the popup window to the front and focus it
    ok_popup.lift()
    ok_popup.focus_force()

    # Make the main window inactive until the popup window is closed
    window.wait_window(ok_popup)

