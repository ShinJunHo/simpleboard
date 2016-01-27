DROP TABLE TB_USER CASCADE CONSTRAINTS;
DROP TABLE TB_BOARD CASCADE CONSTRAINTS;
DROP SEQUENCE USER_SEQ;
DROP SEQUENCE BOARD_SEQ;

CREATE TABLE TB_USER(
      SEQ NUMBER NOT NULL,
      USER_ID VARCHAR2(20),
      PASSWORD VARCHAR2(20),
      EMAIL VARCHAR2(30),
      PHONE VARCHAR2(15),
      AGE NUMBER(3),
	JOINDATE DATE
);

alter table TB_USER add(picture varchar2(100));
desc TB_USER;


CREATE TABLE TB_BOARD(
          SEQ NUMBER NOT NULL,
          USER_ID VARCHAR2(20),
          TITLE VARCHAR2(255),
          CONTENTS VARCHAR2(4000),   
          MODIFYDATE DATE
);

ALTER TABLE TB_USER ADD CONSTRAINT user_id_pk PRIMARY KEY(USER_ID);
ALTER TABLE TB_BOARD ADD CONSTRAINT user_id_fk FOREIGN KEY(USER_ID) REFERENCES TB_USER(USER_ID);


CREATE SEQUENCE USER_SEQ START WITH 0 INCREMENT BY 1 NOMAXVALUE MINVALUE 0;
CREATE SEQUENCE BOARD_SEQ START WITH 0 INCREMENT BY 1 NOMAXVALUE MINVALUE 0;

INSERT INTO TB_USER VALUES(USER_SEQ.NEXTVAL,'Admin','Admin','Admin@admin.com','010-1234-1234',99,sysdate);
insert into TB_USER values(USER_SEQ.nextval,'user2','user2','user2@gmail.com','010-1234-5678',32,sysdate);
insert into TB_USER values(USER_SEQ.nextval,'user3','user3','user3@gmail.com','010-1111-1111',33,sysdate);
insert into TB_USER values(USER_SEQ.nextval,'user4','user4','user4@gmail.com','010-2222-2222',34,sysdate);
insert into TB_USER values(USER_SEQ.nextval,'user5','user5','user5@gmail.com','010-3333-3333',35,sysdate);
insert into TB_USER values(USER_SEQ.nextval,'user6','user6','user6@gmail.com','010-4444-4444',36,sysdate);
insert into TB_USER values(USER_SEQ.nextval,'user7','user7','user7@gmail.com','010-5555-5555',37,sysdate);
commit;
insert into tb_board values(BOARD_SEQ.nextval,'user1','user1',' 1',sysdate);
insert into tb_board values(BOARD_SEQ.nextval,'user2','user22','2',sysdate);
insert into tb_board values(BOARD_SEQ.nextval,'user3','user333',' 3',sysdate);
insert into tb_board values(BOARD_SEQ.nextval,'user4','user4444','4',sysdate);
insert into tb_board values(BOARD_SEQ.nextval,'user5','user55555','5',sysdate);
insert into tb_board values(BOARD_SEQ.nextval,'user6','user666666',' 6',sysdate);
insert into tb_board values(BOARD_SEQ.nextval,'user7','user7777777',' 7',sysdate);
insert into tb_board values(BOARD_SEQ.nextval,'user8','user88888888',' 8',sysdate);
commit;