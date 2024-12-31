BEGIN
   FOR t IN (SELECT table_name FROM user_tables) LOOP
      EXECUTE IMMEDIATE 'DROP TABLE ' || t.table_name || ' CASCADE CONSTRAINTS';
   END LOOP;
END;
/

BEGIN
   FOR t IN (SELECT trigger_name FROM user_triggers) LOOP
      EXECUTE IMMEDIATE 'DROP TRIGGER ' || t.trigger_name;
   END LOOP;
END;
/

BEGIN
   FOR s IN (SELECT sequence_name FROM user_sequences) LOOP
      EXECUTE IMMEDIATE 'DROP SEQUENCE ' || s.sequence_name;
   END LOOP;
END;
/

BEGIN
    FOR proc IN (SELECT object_name 
                 FROM user_objects 
                 WHERE object_type = 'PROCEDURE') LOOP
        EXECUTE IMMEDIATE 'DROP PROCEDURE ' || proc.object_name;
    END LOOP;
END;
/
