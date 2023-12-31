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

CREATE TABLE if not exists "employee_entity"
(
    id               INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    end_to_end_id    INTEGER,
    salary           DOUBLE PRECISION                         NOT NULL,
    firstname        VARCHAR(255),
    lastname         VARCHAR(255),
    work_email       VARCHAR(255),
    personal_email   VARCHAR(255),
    cin              VARCHAR(255),
    address          VARCHAR(255),
    children         INTEGER                                  NOT NULL,
    employee_number  VARCHAR(255),
    image_base64     TEXT,
    category         category                                 not null,
    sex              sex                                      not null,
    function         function                                 not null,
    birthdate        date,
    hire_date        date,
    resignation_date date,
    CONSTRAINT pk_employeeentity PRIMARY KEY (id)
);