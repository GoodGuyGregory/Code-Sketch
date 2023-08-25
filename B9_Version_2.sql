-- TROY the users table needs to basically be updated

--  these are the changes I intend to make to the POURS_USER table on staging.
ALTER TABLE POURS_USERS add (
    AVNET_EMP_ID VARCHAR(10),
    PHONE_NUMBER   VARCHAR(30),
    PRIMARY_ROLE   VARCHAR(50)
);