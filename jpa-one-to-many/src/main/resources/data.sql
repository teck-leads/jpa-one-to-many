INSERT INTO COURSE ( ID , NAME,CREATED_DATE,LAST_UPDATED  ) VALUES ( 101,'Springboot',sysdate() ,sysdate());
INSERT INTO COURSE ( ID , NAME,CREATED_DATE,LAST_UPDATED  ) VALUES ( 102,'Microservices',sysdate() ,sysdate() );
INSERT INTO COURSE ( ID , NAME,CREATED_DATE,LAST_UPDATED  ) VALUES ( 103,'Kubernetes',sysdate() ,sysdate() );

INSERT INTO REVIEW ( ID , DESCRIPTION,RATING,CREATED_DATE,LAST_UPDATED, COURSE_ID  )
 VALUES ( 200,'Good','3',sysdate() ,sysdate(),101);
INSERT INTO REVIEW ( ID , DESCRIPTION,RATING,CREATED_DATE,LAST_UPDATED, COURSE_ID  )
 VALUES ( 201,'Nice','4',sysdate() ,sysdate(),101 );
INSERT INTO REVIEW ( ID , DESCRIPTION,RATING,CREATED_DATE,LAST_UPDATED, COURSE_ID  ) 
VALUES ( 202,'Awasome','4',sysdate() ,sysdate(),102 );

