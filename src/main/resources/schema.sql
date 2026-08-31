DROP TABLE IF EXISTS claim_documents CASCADE;
DROP TABLE IF EXISTS premium_payments CASCADE;
DROP TABLE IF EXISTS claims CASCADE;
DROP TABLE IF EXISTS policy_members CASCADE;
DROP TABLE IF EXISTS policies CASCADE;
DROP TABLE IF EXISTS hospitals CASCADE;
DROP TABLE IF EXISTS insurance_products CASCADE;
DROP TABLE IF EXISTS customers CASCADE;

CREATE TABLE customers (
    customer_id BIGSERIAL PRIMARY KEY,
    customer_code VARCHAR(30) NOT NULL UNIQUE,
    first_name VARCHAR(80) NOT NULL,
    last_name VARCHAR(80) NOT NULL,
    gender VARCHAR(20) NOT NULL,
    date_of_birth DATE NOT NULL,
    mobile_number VARCHAR(20),
    email VARCHAR(150),
    city VARCHAR(80),
    state VARCHAR(80),
    occupation VARCHAR(100),
    annual_income NUMERIC(15,2),
    customer_status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE insurance_products (
    product_id BIGSERIAL PRIMARY KEY,
    product_code VARCHAR(30) NOT NULL UNIQUE,
    product_name VARCHAR(150) NOT NULL,
    product_type VARCHAR(50),
    coverage_type VARCHAR(50),
    base_sum_insured NUMERIC(15,2),
    base_premium NUMERIC(15,2),
    min_age INT,
    max_age INT,
    waiting_period_months INT,
    room_rent_limit NUMERIC(15,2),
    co_payment_percent NUMERIC(5,2),
    product_status VARCHAR(30)
);

CREATE TABLE hospitals (
    hospital_id BIGSERIAL PRIMARY KEY,
    hospital_code VARCHAR(30) NOT NULL UNIQUE,
    hospital_name VARCHAR(150) NOT NULL,
    city VARCHAR(80),
    state VARCHAR(80),
    hospital_type VARCHAR(50),
    network_status VARCHAR(30),
    rating NUMERIC(3,1),
    contact_number VARCHAR(20)
);

CREATE TABLE policies (
    policy_id BIGSERIAL PRIMARY KEY,
    policy_number VARCHAR(40) NOT NULL UNIQUE,
    customer_id BIGINT NOT NULL REFERENCES customers(customer_id),
    product_id BIGINT NOT NULL REFERENCES insurance_products(product_id),
    policy_start_date DATE NOT NULL,
    policy_end_date DATE NOT NULL,
    sum_insured NUMERIC(15,2) NOT NULL,
    annual_premium NUMERIC(15,2) NOT NULL,
    payment_frequency VARCHAR(30),
    policy_status VARCHAR(30),
    renewal_status VARCHAR(30),
    agent_code VARCHAR(30),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE policy_members (
    member_id BIGSERIAL PRIMARY KEY,
    policy_id BIGINT NOT NULL REFERENCES policies(policy_id),
    member_code VARCHAR(40) NOT NULL UNIQUE,
    member_name VARCHAR(150) NOT NULL,
    relationship VARCHAR(50),
    gender VARCHAR(20),
    date_of_birth DATE,
    age INT,
    member_status VARCHAR(30)
);

CREATE TABLE claims (
    claim_id BIGSERIAL PRIMARY KEY,
    claim_number VARCHAR(40) NOT NULL UNIQUE,
    policy_id BIGINT NOT NULL REFERENCES policies(policy_id),
    member_id BIGINT NOT NULL REFERENCES policy_members(member_id),
    hospital_id BIGINT NOT NULL REFERENCES hospitals(hospital_id),
    claim_type VARCHAR(40),
    claim_status VARCHAR(40),
    admission_date DATE,
    discharge_date DATE,
    claimed_amount NUMERIC(15,2),
    approved_amount NUMERIC(15,2),
    rejected_amount NUMERIC(15,2),
    settlement_date DATE,
    settlement_mode VARCHAR(30),
    diagnosis VARCHAR(200),
    remarks VARCHAR(500),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE claim_documents (
    document_id BIGSERIAL PRIMARY KEY,
    claim_id BIGINT NOT NULL REFERENCES claims(claim_id),
    document_type VARCHAR(80),
    document_number VARCHAR(80),
    document_status VARCHAR(30),
    uploaded_date DATE,
    verified_date DATE,
    verified_by VARCHAR(100)
);

CREATE TABLE premium_payments (
    payment_id BIGSERIAL PRIMARY KEY,
    payment_reference VARCHAR(50) NOT NULL UNIQUE,
    policy_id BIGINT NOT NULL REFERENCES policies(policy_id),
    payment_date DATE,
    due_date DATE,
    amount NUMERIC(15,2),
    payment_mode VARCHAR(30),
    payment_status VARCHAR(30),
    transaction_id VARCHAR(80),
    late_fee NUMERIC(15,2)
);

CREATE INDEX idx_policy_customer ON policies(customer_id);
CREATE INDEX idx_policy_product ON policies(product_id);
CREATE INDEX idx_member_policy ON policy_members(policy_id);
CREATE INDEX idx_claim_policy ON claims(policy_id);
CREATE INDEX idx_claim_member ON claims(member_id);
CREATE INDEX idx_claim_hospital ON claims(hospital_id);
CREATE INDEX idx_document_claim ON claim_documents(claim_id);
CREATE INDEX idx_payment_policy ON premium_payments(policy_id);
