ALTER TABLE product
    ADD inventory_count2 INT DEFAULT 0;

UPDATE product
SET inventory_count2 = 0
WHERE inventory_count2 IS NULL;

ALTER TABLE product
    MODIFY inventory_count2 INT NOT NULL;