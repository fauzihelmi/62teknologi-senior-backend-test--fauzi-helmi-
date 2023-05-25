#create table

DROP TABLE IF EXISTS public.busines;
CREATE TABLE IF NOT EXISTS public.busines
(
    id character varying NOT NULL,
    name character varying(500),
    phone character varying(100),
    address1 character varying(500),
    address2 character varying(500),
    address3 character varying(500),
    city character varying(50),
    country character varying(50),
    state character varying(50),
    zip_code character varying(50),
    latitude double precision,
    longitude double precision,
    display_phone character varying(50),
    distance smallint,
    image_url character varying(500),
    is_closed boolean,
    price character varying(100),
    rating bigint,
    review_count bigint,
    url character varying(500),
    total bigint,
    transaction character varying(100),
    alias character varying(100),
    title character varying(100),
    location character varying(255),
    CONSTRAINT busines_pkey PRIMARY KEY (id)
);
