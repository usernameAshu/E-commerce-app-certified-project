insert into CUSTOMER_DATA ( CUSTOMER_ID ,FIRST_NAME ,LAST_NAME, PASSWORD, USERNAME ) values ( 100, 'Ashutosh' , 'Mohanty' , '123ABC' , 'user_ashu') ;
insert into CUSTOMER_DATA ( CUSTOMER_ID ,FIRST_NAME ,LAST_NAME, PASSWORD, USERNAME ) values ( 200, 'Anuja' , 'Som' , '123ABC' , 'user_ashu') ;
insert into CUSTOMER_DATA ( CUSTOMER_ID ,FIRST_NAME ,LAST_NAME, PASSWORD, USERNAME ) values ( 300, 'Niladri' , 'Dutta' , '123ABC' , 'user_ashu') ;
insert into CUSTOMER_DATA ( CUSTOMER_ID ,FIRST_NAME ,LAST_NAME, PASSWORD, USERNAME ) values ( 400, 'Pratyay' , 'Dutta' , '123ABC' , 'user_ashu') ;
insert into CUSTOMER_DATA ( CUSTOMER_ID ,FIRST_NAME ,LAST_NAME, PASSWORD, USERNAME ) values ( 500, 'Ranit' , 'Sen' , '123ABC' , 'user_ashu') ;
insert into CUSTOMER_DATA ( CUSTOMER_ID ,FIRST_NAME ,LAST_NAME, PASSWORD, USERNAME ) values ( 600, 'Namrata' , 'Mondal' , '123ABC' , 'user_ashu') ;



insert into ORDER_DATA  ( ORDER_DATE, ORDER_STATUS, CUSTOMERID ) values ( SYSDATE , 'ORDERED' ,  100 ) ;
insert into ORDER_DATA  ( ORDER_DATE, ORDER_STATUS, CUSTOMERID ) values ( SYSDATE , 'DELIVERED' ,  100 ) ;
insert into ORDER_DATA  ( ORDER_DATE, ORDER_STATUS, CUSTOMERID ) values ( SYSDATE , 'ORDERED' ,  300 ) ;
insert into ORDER_DATA  ( ORDER_DATE, ORDER_STATUS, CUSTOMERID ) values ( SYSDATE , 'ORDERED' ,  100 ) ;
insert into ORDER_DATA  ( ORDER_DATE, ORDER_STATUS, CUSTOMERID ) values ( SYSDATE , 'CANCELLED' ,  500 ) ;
insert into ORDER_DATA  ( ORDER_DATE, ORDER_STATUS, CUSTOMERID ) values ( SYSDATE , 'SHIPPED' ,  400 ) ;