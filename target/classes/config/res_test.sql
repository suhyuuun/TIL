drop  table res_test;

create table res_test(
res varchar2(2000),
latitude varchar2(2000),
longitude varchar2(2000),
keyword varchar2(2000));



insert into res_test values('전환마을 부엌밥풀꽃','126.9160994','37.6106947', '전환마을');
insert into res_test values('본도시락 보라매점','126.9251715','37.4995991', '본도시락');
commit;

SELECT  * FROM res_test;