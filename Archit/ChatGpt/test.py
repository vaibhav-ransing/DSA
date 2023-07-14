def show_loading_popup():
    # Create the loading popup window
    popup_window = tk.Toplevel(window)
    popup_window.title("Loading")
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

    # Create and arrange the label with the loading message
    label_loading = tk.Label(popup_window, text="Loading...", bg=BG_COLOR, fg=FG_COLOR, font=popup_custom_font)
    label_loading.pack(pady=20)

    # Disable the main window
    window.config(state="disabled")

    # Update the main window to reflect the changes
    window.update()

    # Run the sonar_script in a separate thread
    def run_sonar_script():
        # Simulate the sonar_script running for 3 seconds
        time.sleep(3)

        # Enable the main window
        window.config(state="normal")

        # Close the loading popup
        popup_window.destroy()

        # Show the success popup
        show_ok_popup("All the vulnerabilities are fixed")

    # Start a new thread for running the sonar_script
    thread = threading.Thread(target=run_sonar_script)
    thread.start()
