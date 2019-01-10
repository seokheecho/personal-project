# daily-photolog05_step03_2
 - daily-photolog05 포토로그(PhotoLog)
 - 포토로그 사진파일 저장
 (\org.eclipse.wst.server.core\tmp1\wtpwebapps\daily-photolog\files)
 - VO, DAO, Service_ServiceImpl 작성
 
 
 1) PhotoFileVO - PhotoFileDAO_PhotoFileMapper.xml
            - PhotoFileService_ServiceImpl
 
 2) PhotoLogController
                photoFileVO.setPhoto(newfilename);
                photoFileVO.setPhotoLogNo(10);
                photoFileService.insertPhotoFile(photoFileVO);
 
- 다음 step03_3 에서 PLNO 처리
photoFileVO.setPhotoLogNo(vo.getNo());


**step03_1 에서 primary key, foregin key로 잡힌 PFNO, PLNO 값을 제대로 넣지 못했다.
 - primary key(PFNO) 값이 자동으로 증가되지 않아 Duplicate 되거나 foregin key(PLNO) 값을 제대로 처리하지 못하였다.
 - 다음 step03_2 에서 PLNO, PFNO 처리를 진행하기 위해 step03 을 나눠서 진행
 
  - Error message
~~~javascript
### Error updating database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry '2' for key 'PRIMARY'
### The error may involve com.hee.daily_photolog.dao.PhotoFileDAO.insertPhotoFile-Inline
### The error occurred while setting parameters
### SQL: insert into tbl_photofile(PFNO,PLNO,PHOTO)     values(?,?,?)
### Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry '2' for key 'PRIMARY'
; SQL []; Duplicate entry '2' for key 'PRIMARY'; nested exception is com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry '2' for key 'PRIMARY'
~~~

 
 **step03_2 에서 primary key(PFNO) 값이 자동으로 증가되지 않는 부분을 재확인했다.
 - DB(MySQL)에서 auto_increment 설정이 null로 잡혀있었다. auto_increment 설정은 'auto_increment.md' 파일 참고!
 - PhotoLogController 에서 처리된 PLNO(foregin key) 값을 tbl_photofile 에 넣어줘야한다.
 
### 참고
**[MySQL] auto_increment 확인 및 초기화
http://blog.naver.com/PostView.nhn?blogId=hanajava&logNo=220554545738&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView

**[mybatis] insert 후 key값 반환
http://blog.woniper.net/192

**[MyBatis]
http://www.devkuma.com/books/pages/756
http://www.mybatis.org/mybatis-3/ko/sqlmap-xml.html
 
