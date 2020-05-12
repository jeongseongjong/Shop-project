-- 테이블 생성
 CREATE TABLESPACE naviya_DB
 DATAFILE 'C:/bizwork\oracle\data/naviya.dbf'
 SIZE 10M AUTOEXTEND ON NEXT 10K;
 
-- USER 생성
 CREATE USER naviya IDENTIFIED BY naviya
 DEFAULT TABLESPACE naviya_DB;

-- 권한 부여
 GRANT DBA TO naviya;




-- 1. 상품 테이블
 CREATE TABLE tbl_product(
   p_code VARCHAR2(6) PRIMARY KEY, -- 시퀀스 사용
   p_name nVARCHAR2(255) Not null, -- ( = review 상품 이름),
   p_price number,
   p_qty number,
   p_desc nVARCHAR2(1000),
   p_image nVARCHAR2(255)
    );
    
CREATE SEQUENCE SEQ_PRODUCT
START WITH 1 INCREMENT BY 1;

-- 2. 사이즈테이블    
CREATE TABLE tbl_size(
   c_p_code VARCHAR2(6) PRIMARY KEY, 
   C_Black_L number,
   C_Black_M number,
   C_Black_S number,
   C_Red_L number,
   C_Red_M number,
   C_Red_S number,
   C_White_L number,
   C_White_M number,
   C_White_S number
    );


    
-- 1-1. 상품 디테일 IMAGES(여러 이미지) 상세설명용
CREATE TABLE tbl_p_images(
   p_IMG_SEQ NUMBER PRIMARY KEY,
   p_IMG_P_CODE NUMBER, -- ( 갤러리 테이블 IMG_SEQ 참조)
   p_IMG_ORIGIN_NAME nVARCHAR2(255),
   p_IMG_UPLOAD_NAME nVARCHAR2(255)
    );
    
CREATE SEQUENCE SEQ_PRODUCT_IMAGE
START WITH 1 INCREMENT BY 1;

    
DROP TABLE tbl_users;
-- 3. 유저 테이블
CREATE TABLE tbl_users (
   u_id  NUMBER PRIMARY KEY,
   user_name VARCHAR2(64) UNIQUE NOT NULL,
   pass_word VARCHAR2(255) NOT NULL,
   email VARCHAR2(255) , 
   address nVARCHAR2(255) ,
   phone VARCHAR2(20) ,
   enabled number,
   account_non_expired number,         
   account_non_locked   number,         
   credentials_non_expired number 
    );
    
CREATE SEQUENCE SEQ_USERS_ID
START WITH 1 INCREMENT BY 1;

-- 4. Q&A 테이블
CREATE TABLE tbl_q_a(
   q_id  NUMBER PRIMARY KEY,
   q_code VARCHAR2(6) NOT NULL, --  (p_code ( 상품에 따라서 참조))
   q_title nVARCHAR2(255),
   q_text nVARCHAR2(1000),
   q_r_text nVARCHAR2(1000), -- ( 답변 내용)(관리자)
   q_auth VARCHAR2(64),
   q_date VARCHAR2(40)
);

CREATE SEQUENCE SEQ_QA
START WITH 1 INCREMENT BY 1;

-- 5. Review 테이블
CREATE TABLE tbl_review(
    r_id NUMBER PRIMARY KEY,
   r_text nVARCHAR2(1000),
   r_start int,
   r_code VARCHAR2(6) NOT NULL, -- (p_code 참조해서 p_name 가져오기)
   r_auth VARCHAR2(64),
   r_date VARCHAR2(40),
   r_image VARCHAR2(255),
    r_like NUMBER -- 추천
);

CREATE SEQUENCE SEQ_REVIEW
START WITH 1 INCREMENT BY 1;

-- 5-1. Review 테이블 이미지들
CREATE TABLE tbl_review_images(
   r_IMG_SEQ  NUMBER PRIMARY KEY,
   r_IMG_P_CODE VARCHAR2(6), -- ( 갤러리 테이블 IMG_SEQ 참조)
   r_IMG_ORIGIN_NAME nVARCHAR2(255),
   r_IMG_UPLOAD_NAME nVARCHAR2(255)
    );
    
CREATE SEQUENCE SEQ_REVIEW_IMAGE
START WITH 1 INCREMENT BY 1;
   
   DROP TABLE tbl_authority; 
-- 6. 권한 테이블
CREATE TABLE tbl_authority(
    au_id  NUMBER PRIMARY KEY,
   username VARCHAR2(64),
   authority VARCHAR2(50)
);

INSERT INTO tbl_authority(au_id, username, authority)
VALUES(1, 'admin', 'ADMIN');
INSERT INTO tbl_authority(au_id, username, authority)
VALUES(2, 'admin', 'ROLE_ADMIN');
INSERT INTO tbl_authority(au_id, username, authority)
VALUES(3, 'user', 'USER');
INSERT INTO tbl_authority(au_id, username, authority)
VALUES(4, 'user', 'ROLE_USER');

commit;

CREATE SEQUENCE SEQ_AUTHORITY
START WITH 1 INCREMENT BY 1;

select * from tbl_users;
select * from tbl_authority;

-- 7. 장바구니 테이블
CREATE TABLE tbl_cart(
    bk_id NUMBER PRIMARY KEY,
   bk_p_code VARCHAR2(6) NOT NULL,
   bk_p_name nVARCHAR2(255),
   bk_u_username VARCHAR2(64),
   bk_p_oprice number,
   bk_p_qty number,
   bk_p_status nVARCHAR2(50)
);

 
CREATE SEQUENCE SEQ_CART
START WITH 1 INCREMENT BY 1;

-- 7-1 장바구니 전체(테이블ㄴㄴ)
--public class CartListVO {

--   private List<Long> seq;
--   private List<Integer> p_qty;
--}

-- 8. 추천 테이블(Review 아이디 중복 막기 위한)
CREATE TABLE tbl_r_like(
    r_id NUMBER PRIMARY KEY,
    r_like_username VARCHAR2(64),
    r_review_id NUMBER
);

CREATE SEQUENCE SEQ_LIKE
START WITH 1 INCREMENT BY 1;

----------------------------------------------------------------

-- FK 설정부분


-- 사이즈테이블 FK ( -> 상품 테이블 연결)
ALTER TABLE tbl_size -- 연동되는 테이블, 자식 테이블
 ADD CONSTRAINT FK_SIZE
 FOREIGN KEY (c_p_code) -- 연동되는 칼럼
 REFERENCES tbl_product(p_code); -- 참조할 테이블(칼럼), 부모 테이블
 
-- 상품 디테일 IMAGES 테이블 FK ( -> 상품 테이블 연결)
ALTER TABLE tbl_p_images -- 연동되는 테이블
 ADD CONSTRAINT FK_P_IMAGES
 FOREIGN KEY (p_img_seq) -- 연동되는 칼럼
 REFERENCES tbl_product(p_code); -- 참조할 테이블(칼럼)
 
 -- Q&A테이블 FK ( -> 상품테이블 연결)
ALTER TABLE tbl_q_a -- 연동되는 테이블
 ADD CONSTRAINT FK_Q_A
 FOREIGN KEY (q_code) -- 연동되는 칼럼
 REFERENCES tbl_product(p_code); -- 참조할 테이블(칼럼)
 
 -- 장바구니 테이블 FK (-> 상품테이블 연결)
ALTER TABLE tbl_cart -- 연동되는 테이블
 ADD CONSTRAINT FK_CART
 FOREIGN KEY (bk_p_code) -- 연동되는 칼럼
 REFERENCES tbl_product(p_code); -- 참조할 테이블(칼럼)
 
 -- Review 테이블 이미지들 FK ( -> 상품테이블 연결)
ALTER TABLE tbl_review_images -- 연동되는 테이블
 ADD CONSTRAINT FK_R_IMAGES
 FOREIGN KEY (r_img_p_code) -- 연동되는 칼럼
 REFERENCES tbl_product(p_code); -- 참조할 테이블(칼럼)
 
 
 		INSERT INTO tbl_users
		
				(u_id ,
				user_name ,
				pass_word ,
				enabled
				)
				VALUES
				(
				SEQ_USERS_ID.NEXTVAL,
				'1',
				'2',
				'true'
				);