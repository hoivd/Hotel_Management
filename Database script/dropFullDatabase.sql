BEGIN
    -- Drop all triggers
    FOR trg IN (SELECT trigger_name FROM user_triggers) LOOP
        EXECUTE IMMEDIATE 'DROP TRIGGER ' || trg.trigger_name;
    END LOOP;

    -- Drop all procedures
    FOR proc IN (SELECT object_name FROM user_objects WHERE object_type = 'PROCEDURE') LOOP
        EXECUTE IMMEDIATE 'DROP PROCEDURE ' || proc.object_name;
    END LOOP;

    -- Drop all functions
    FOR func IN (SELECT object_name FROM user_objects WHERE object_type = 'FUNCTION') LOOP
        EXECUTE IMMEDIATE 'DROP FUNCTION ' || func.object_name;
    END LOOP;

    -- Drop all types
    FOR typ IN (SELECT type_name FROM user_types) LOOP
        EXECUTE IMMEDIATE 'DROP TYPE ' || typ.type_name || ' FORCE';
    END LOOP;

    -- Drop all sequences
    FOR seq IN (SELECT sequence_name FROM user_sequences) LOOP
        EXECUTE IMMEDIATE 'DROP SEQUENCE ' || seq.sequence_name;
    END LOOP;

    -- Drop all tables
    FOR tbl IN (SELECT table_name FROM user_tables) LOOP
        EXECUTE IMMEDIATE 'DROP TABLE ' || tbl.table_name || ' CASCADE CONSTRAINTS';
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('All objects in the current schema have been dropped successfully.');
END;
/


