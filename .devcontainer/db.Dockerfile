FROM postgres:17
COPY ./init_db docker-entrypoint-initdb.d/