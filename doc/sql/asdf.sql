DROP DATABASE romatest;
DROP DATABASE roma;

-- test db with test user
CREATE DATABASE romatest;
CREATE ROLE romatest WITH PASSWORD 'romatest';
GRANT ALL ON romatest TO romatest;

-- production db with user
CREATE DATABASE roma;
CREATE ROLE roma WITH PASSWORD 'roma';
GRANT ALL ON roma TO roma;
