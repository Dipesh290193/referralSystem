--
-- PostgreSQL database dump
--

-- Dumped from database version 10.2
-- Dumped by pg_dump version 10.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: dipesh
--

CREATE TABLE categories (
    category_id integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE categories OWNER TO dipesh;

--
-- Name: favorite_referrals; Type: TABLE; Schema: public; Owner: dipesh
--

CREATE TABLE favorite_referrals (
    view_date date NOT NULL,
    user_id bigint NOT NULL,
    referral_id bigint NOT NULL
);


ALTER TABLE favorite_referrals OWNER TO dipesh;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: dipesh
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hibernate_sequence OWNER TO dipesh;

--
-- Name: items; Type: TABLE; Schema: public; Owner: dipesh
--

CREATE TABLE items (
    item_id bigint NOT NULL,
    description character varying(255),
    image_path character varying(255),
    name character varying(255) NOT NULL,
    status character varying(255) NOT NULL,
    category_id integer NOT NULL
);


ALTER TABLE items OWNER TO dipesh;

--
-- Name: referrals; Type: TABLE; Schema: public; Owner: dipesh
--

CREATE TABLE referrals (
    code_or_link character varying(255) NOT NULL,
    created date,
    likes integer,
    referral_description character varying(255),
    referral_id bigint NOT NULL,
    view_count bigint,
    where_to_use character varying(255) NOT NULL,
    referrer_id bigint NOT NULL,
    item_id bigint NOT NULL
);


ALTER TABLE referrals OWNER TO dipesh;

--
-- Name: users; Type: TABLE; Schema: public; Owner: dipesh
--

CREATE TABLE users (
    user_id bigint NOT NULL,
    email character varying(255) NOT NULL,
    is_active boolean NOT NULL,
    password character varying(255) NOT NULL,
    phone character varying(255) NOT NULL,
    profile_picture_path character varying(255)
);


ALTER TABLE users OWNER TO dipesh;

--
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: dipesh
--

COPY categories (category_id, name) FROM stdin;
\.


--
-- Data for Name: favorite_referrals; Type: TABLE DATA; Schema: public; Owner: dipesh
--

COPY favorite_referrals (view_date, user_id, referral_id) FROM stdin;
\.


--
-- Data for Name: items; Type: TABLE DATA; Schema: public; Owner: dipesh
--

COPY items (item_id, description, image_path, name, status, category_id) FROM stdin;
\.


--
-- Data for Name: referrals; Type: TABLE DATA; Schema: public; Owner: dipesh
--

COPY referrals (code_or_link, created, likes, referral_description, referral_id, view_count, where_to_use, referrer_id, item_id) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: dipesh
--

COPY users (user_id, email, is_active, password, phone, profile_picture_path) FROM stdin;
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: dipesh
--

SELECT pg_catalog.setval('hibernate_sequence', 1, false);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: dipesh
--

ALTER TABLE ONLY categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (category_id);


--
-- Name: favorite_referrals favorite_referrals_pkey; Type: CONSTRAINT; Schema: public; Owner: dipesh
--

ALTER TABLE ONLY favorite_referrals
    ADD CONSTRAINT favorite_referrals_pkey PRIMARY KEY (referral_id, user_id);


--
-- Name: items items_pkey; Type: CONSTRAINT; Schema: public; Owner: dipesh
--

ALTER TABLE ONLY items
    ADD CONSTRAINT items_pkey PRIMARY KEY (item_id);


--
-- Name: referrals referrals_pkey; Type: CONSTRAINT; Schema: public; Owner: dipesh
--

ALTER TABLE ONLY referrals
    ADD CONSTRAINT referrals_pkey PRIMARY KEY (item_id, referrer_id);


--
-- Name: users uk_6dotkott2kjsp8vw4d0m25fb7; Type: CONSTRAINT; Schema: public; Owner: dipesh
--

ALTER TABLE ONLY users
    ADD CONSTRAINT uk_6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email);


--
-- Name: referrals uk_qhnoyqw880kewdi02w9fgt31h; Type: CONSTRAINT; Schema: public; Owner: dipesh
--

ALTER TABLE ONLY referrals
    ADD CONSTRAINT uk_qhnoyqw880kewdi02w9fgt31h UNIQUE (referral_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: dipesh
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- Name: referrals fk4moftyij76fw0oijnwc0jur2b; Type: FK CONSTRAINT; Schema: public; Owner: dipesh
--

ALTER TABLE ONLY referrals
    ADD CONSTRAINT fk4moftyij76fw0oijnwc0jur2b FOREIGN KEY (referrer_id) REFERENCES users(user_id);


--
-- Name: items fkjcdcde7htb3tyjgouo4g9xbmr; Type: FK CONSTRAINT; Schema: public; Owner: dipesh
--

ALTER TABLE ONLY items
    ADD CONSTRAINT fkjcdcde7htb3tyjgouo4g9xbmr FOREIGN KEY (category_id) REFERENCES categories(category_id);


--
-- Name: favorite_referrals fknb6ke52htwp99dqcdtj11tlxo; Type: FK CONSTRAINT; Schema: public; Owner: dipesh
--

ALTER TABLE ONLY favorite_referrals
    ADD CONSTRAINT fknb6ke52htwp99dqcdtj11tlxo FOREIGN KEY (referral_id) REFERENCES referrals(referral_id);


--
-- Name: favorite_referrals fkphnjmyiixv2chrpcotrplqfpx; Type: FK CONSTRAINT; Schema: public; Owner: dipesh
--

ALTER TABLE ONLY favorite_referrals
    ADD CONSTRAINT fkphnjmyiixv2chrpcotrplqfpx FOREIGN KEY (user_id) REFERENCES users(user_id);


--
-- Name: referrals fkq2fq4gyfge7mu8vtyrybt02jq; Type: FK CONSTRAINT; Schema: public; Owner: dipesh
--

ALTER TABLE ONLY referrals
    ADD CONSTRAINT fkq2fq4gyfge7mu8vtyrybt02jq FOREIGN KEY (item_id) REFERENCES items(item_id);


--
-- PostgreSQL database dump complete
--

