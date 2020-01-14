--    Drop old databases.
DROP DATABASE IF EXISTS tracker_dev;
DROP DATABASE IF EXISTS tracker_test;

--    Create a development version of the database.
CREATE DATABASE tracker_dev;
--    Create a test version of the database.
CREATE DATABASE tracker_test;

--    Create a tracker user in the database that has access to the databases.
CREATE USER IF NOT EXISTS 'tracker'@'%'
  IDENTIFIED BY '';
GRANT ALL PRIVILEGES ON tracker_dev.* TO 'tracker' @'%';
GRANT ALL PRIVILEGES ON tracker_test.* TO 'tracker' @'%';