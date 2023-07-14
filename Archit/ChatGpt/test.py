import threading

def show_confirmation_popup(message, user_id, user_password, component_name, folder_location, branch_name):
    response = messagebox.askquestion("Confirmation", message, icon="warning")
    if response == "yes":
        # Create the loading popup window
        loading_popup = tk.Toplevel(window)
        loading_popup.title("Loading")
        loading_popup.configure(bg=BG_COLOR)
        loading_popup.attributes("-topmost", True)

        # Center the loading popup window
        loading_popup_width = 300
        loading_popup_height = 150
        loading_popup_x = window.winfo_x() + int((window_width - loading_popup_width) / 2)
        loading_popup_y = window.winfo_y() + int((window_height - loading_popup_height) / 2)
        loading_popup.geometry(f"{loading_popup_width}x{loading_popup_height}+{loading_popup_x}+{loading_popup_y}")

        # Set custom font for the loading popup window
        loading_popup_custom_font = ("Arial", 14)

        # Create and arrange the label with the loading message
        label_loading = tk.Label(loading_popup, text="Loading...", bg=BG_COLOR, fg=FG_COLOR, font=loading_popup_custom_font)
        label_loading.pack(pady=20)

        # Update the loading popup window to reflect the changes
        loading_popup.update()

        # Disable the main window
        window.config(state="disabled")

        # Update the main window to reflect the changes
        window.update()

        # Run the sonar_script in a separate thread
        def run_sonar_script():
            try:
                sonar_script(user_id, user_password, component_name, folder_location, branch_name)
                # Enable the main window
                window.config(state="normal")

                # Close the loading popup
                loading_popup.destroy()

                # Show the success popup
                show_ok_popup("All the vulnerabilities are fixed")
            except Exception as e:
                messagebox.showerror("Error", str(e))

        # Start a new thread for running the sonar_script
        thread = threading.Thread(target=run_sonar_script)
        thread.start()
    else:
        # If the user clicks "no", close the confirmation popup
        messagebox.showinfo("Confirmation", "Action canceled")
