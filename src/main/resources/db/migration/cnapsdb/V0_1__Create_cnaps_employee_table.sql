do
$$
    begin
        if
            not exists(select from pg_type where typname = 'sex') then
            create type "sex" as enum ('M', 'F');
        end if;
        if
            not exists(select from pg_type where typname = 'function') then
            create type "function" as enum ('MANAGEMENT','HR','IT','ACCOUNTING','MARKETING','LEGAL','DESIGN','COMMUNICATION','SECURITY','CONSULTANT','TRANSPORTATION');
        end if;
        if
            not exists(select from pg_type where typname = 'category') then
            create type "category" as enum ('M1','M2','OS1','OS2','OS3');
        end if;
    end
$$;


CREATE TABLE cnaps_employee_entity
(
    id               INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    firstname        VARCHAR(255),
    lastname         VARCHAR(255),
    work_email       VARCHAR(255),
    personal_email   VARCHAR(255),
    cin              VARCHAR(255),
    address          VARCHAR(255),
    cnaps            VARCHAR(255),
    children         INTEGER,
    category         VARCHAR(255),
    sex              VARCHAR(255),
    function         VARCHAR(255),
    birthdate        TIMESTAMP WITHOUT TIME ZONE,
    hire_date        TIMESTAMP WITHOUT TIME ZONE,
    resignation_date TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_cnaps_employee_entity PRIMARY KEY (id)
);