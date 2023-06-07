CREATE TABLE data_api_summary (
    sr_no INT UNSIGNED NOT NULL AUTO_INCREMENT,
    icto VARCHAR(100) NOT NULL,
    api_type VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    count INT UNSIGNED NOT NULL DEFAULT 1,
    PRIMARY KEY (sr_no),
    UNIQUE KEY (api_type)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TRIGGER trg_data_api_insert
AFTER INSERT ON data_api
FOR EACH ROW
BEGIN
    INSERT INTO api_table_summary (api_type, total_count)
    VALUES (NEW.api_type, 1)
    ON DUPLICATE KEY UPDATE total_count = total_count + 1;
END;

