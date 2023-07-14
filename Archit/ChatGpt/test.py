def show_loading_popup(user_id, user_password, component_name, folder_location, branch_name):
    loading_popup = tk.Toplevel(window)
    loading_popup.title("Loading")
    loading_popup.configure(bg=BG_COLOR)
    loading_popup.attributes("-topmost", True)

    loading_popup_width = 300
    loading_popup_height = 150
    loading_popup_x = window.winfo_x() + int((window_width - loading_popup_width) / 2)
    loading_popup_y = window.winfo_y() + int((window_height - loading_popup_height) / 2)
    loading_popup.geometry(f"{loading_popup_width}x{loading_popup_height}+{loading_popup_x}+{loading_popup_y}")

    loading_custom_font = ("Arial", 14)

    label_loading = tk.Label(loading_popup, text="Loading...", bg=BG_COLOR, fg=FG_COLOR, font=loading_custom_font)
    label_loading.pack(pady=20)

    window.attributes("-disabled", True)
    window.update()

    def run_sonar_script():
        try:
            # Simulating a long-running task
            sonar_script(user_id, user_password, component_name, folder_location, branch_name)
            import time
            time.sleep(5)

            window.attributes("-disabled", False)
            loading_popup.destroy()
            show_ok_popup("All the vulnerabilities are fixed\nPlease check the statistic report", False)
        except Exception as e:
            show_ok_popup("Please check your credentials", True)

    thread = threading.Thread(target=run_sonar_script)
    thread.start()
