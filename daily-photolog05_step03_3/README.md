# daily-photolog05_step03_3
 - daily-photolog05 포토로그(PhotoLog)
 - 포토로그 사진파일 저장
 (\org.eclipse.wst.server.core\tmp1\wtpwebapps\daily-photolog\files) 
 - 기존 vo - study를 위한 project로 명확히 표기 memberVO, photoLogVO
 - daily-photolog05_step03_1, _2, _3 정리!
 - Test01, Test02, Final 나눠서 진행(코딩 할 때 단일 테스트 하면서 진행하는게 최종적으로 더 빠르다!)
        Test01 - DB(tbl_photofile)에 value 직접 넣기
        Test02 - DB(tbl_photofile)에 value 직접 넣기 - for문 활용
        Final - DB(tbl_photofile)에 value 넣기 - 1) file명 Random으로 변경
                                                2) file 저장 위치 작성 sc.getRealPath("/files/" + newfilename);
                                                3) 변경된 file명으로 photoFileVO 에 넣기 photoFileVO.setPhoto(newfilename);
                                                4) PLNO(photoLogNo) 넣기 photoFileVO.setPhotoLogNo(photoLogVO.getNo());
                                                5) photoFileService단으로 넘기기 photoFileService.insertPhotoFile(photoFileVO);  
 
 
 1) PhotoFileVO - PhotoFileDAO_PhotoFileMapper.xml
            - PhotoFileService_ServiceImpl
 
 2) PhotoLogController
~~~java
// Test01 - PhotoFile DB value 직접넣기
      photoFileVO.setPhotoLogNo(10);
      photoFileVO.setNo(100);
      photoFileVO.setPhoto("aaaa");
      photoFileService.insertPhotoFile(photoFileVO);
~~~
~~~java
// Test02 - PhotoFile DB value 직접넣기 - for문
        int a = photoLogVO.getNo();
        int b = photoFileVO.getNo(); 
        for(int i=0;i<3;i++) {
            photoFileVO.setPhotoLogNo(a+1);
            photoFileVO.setNo(b + i);
            photoFileVO.setPhoto("aaaa"+i);
            photoFileService.insertPhotoFile(photoFileVO);
        }
~~~
~~~java
// Final - PhotoFile DB value 넣기(PLNO(photoLogNo) 포함) 
    try {
        for (MultipartFile file : files) {
            if (file.isEmpty()) continue;
                String newfilename = UUID.randomUUID().toString();
                String path = sc.getRealPath("/files/" + newfilename);
                file.transferTo(new File(path));
                    photoFileVO.setPhoto(newfilename);
                    photoFileVO.setPhotoLogNo(photoLogVO.getNo());
                    photoFileService.insertPhotoFile(photoFileVO);
//              System.out.println("Controller--------------");
//              System.out.println(photoFileVO);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
~~~

