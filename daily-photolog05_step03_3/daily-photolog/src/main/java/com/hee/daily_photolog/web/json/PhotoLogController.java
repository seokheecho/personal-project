package com.hee.daily_photolog.web.json;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hee.daily_photolog.service.PhotoFileService;
import com.hee.daily_photolog.service.PhotoLogService;
import com.hee.daily_photolog.vo.MemberVO;
import com.hee.daily_photolog.vo.PhotoFileVO;
import com.hee.daily_photolog.vo.PhotoLogVO;

@RestController
@RequestMapping("/photolog")
public class PhotoLogController {

    @Autowired ServletContext sc;
    @Autowired PhotoFileService photoFileService;
    @Autowired PhotoLogService photoLogService;
/*
//  @Autowired PhotoLogService photoLogService; 대신 아래 방법 사용 가능
    PhotoLogService photoLogService;
    public PhotoLogController(
            PhotoLogService photoLogService) {
        this.photoLogService = photoLogService;
*/
    
    @PostMapping("add")
    public Object add(
            PhotoLogVO photoLogVO,
            PhotoFileVO photoFileVO,
            MultipartFile[] files,
            HttpSession session) {
        
        System.out.println("=====================>");
        System.out.println(files);
        System.out.println(photoLogVO);
        System.out.println(photoFileVO);
        
        MemberVO loginUser = 
                (MemberVO)session.getAttribute("loginUser");
        photoLogVO.setMemberNo(loginUser.getNo());
        
        photoLogService.insertPhotoLog(photoLogVO);
        
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        
/* PhotoFileVo 객체 생성 및 연결
        // **테스트 PhotoFileVO photoFileVO 넣기 전 클래스 내 PhotoFileVO 객체 만들어서 함.
        // (연결은 @Autowired PhotoFileService photoFileService;)
        // 위에 add(..., PhotoFileVO photoFileVO, ...) 안에  PhotoFileVO 넣는 방법, 아래 PhotoFileVO 객체 만드는 방법
        // PhotoFileVO photoFileVO = new PhotoFileVO();
*/
/* List 생성 예) ArrayList - ArrayList<Object>, ArrayList<PhotoFileVO>
        // ArrayList<Object> photoFiles = new ArrayList<>();
        //      photoFiles.add(photoFileVO)
        // ArrayList<PhotoFileVO> photoFiles = new ArrayList<>();
        //      photoFiles.add(photoFileVO)
        // ArrayList<String> photoFiles = new ArrayList<>(); 활용 시 아래 .add(newfilename) 가능(타입을 맞춰서 진행해야 한다!)
        //      photoFiles.add(newfilename);

*  Map 생성 예) HashMap - HashMap<String, Object> result = new HashMap<>();
        // try {
        //      memberService.insertMemInfo(memberVO);
        //      System.out.println(memberVO);
        //      result.put("status", "success");
        // } catch (Exception e) {
        //          result.put("status", "fail");
        //          result.put("message", e.getMessage());
        // }
*/

/* Test01 - PhotoFile DB value 직접넣기
      photoFileVO.setPhotoLogNo(10);
      photoFileVO.setNo(100);
      photoFileVO.setPhoto("aaaa");
      photoFileService.insertPhotoFile(photoFileVO);
*/
        
        
/* Test02 - PhotoFile DB value 직접넣기 - for문
        int a = photoLogVO.getNo();
        int b = photoFileVO.getNo();
        
        for(int i=0;i<3;i++) {
            photoFileVO.setPhotoLogNo(a+1);
            photoFileVO.setNo(b + i);
            photoFileVO.setPhoto("aaaa"+i);
            photoFileService.insertPhotoFile(photoFileVO);
        }
*/
        
        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) continue;
                String newfilename = UUID.randomUUID().toString();
                String path = sc.getRealPath("/files/" + newfilename);
                file.transferTo(new File(path));

                photoFileVO.setPhoto(newfilename);
                photoFileVO.setPhotoLogNo(photoLogVO.getNo());
                
                photoFileService.insertPhotoFile(photoFileVO);
//                System.out.println("Controller--------------");
//                System.out.println(photoFileVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }

}
