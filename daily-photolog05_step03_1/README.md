# daily-photolog05_step03_1
 - daily-photolog05 포토로그(PhotoLog)
 - 포토로그 사진파일 저장
 (\org.eclipse.wst.server.core\tmp1\wtpwebapps\daily-photolog\files)
 - VO, DAO, Service_ServiceImpl 작성
 
 
 1) PhotoFileVO - PhotoFileDAO_PhotoFileMapper.xml
            - PhotoFileService_ServiceImpl
 
 2) PhotoLogController
                photoFileVO.setPhoto(newfilename);
                photoFileVO.setNo(photoFileVO.getNo()+1);
                photoFileVO.setPhotoLogNo(vo.getNo());
                // photoFileVO.setPhotoLogNo(10);
                photoFileService.insertPhotoFile(photoFileVO);
 
- 다음 step03_2 에서 PLNO, PFNO 처리
photoFileVO.setNo(photoFileVO.getNo()+1);
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