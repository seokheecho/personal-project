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
            PhotoLogVO vo,
            PhotoFileVO photoFileVO,
            MultipartFile[] files,
            HttpSession session) {
        
        System.out.println("=====================>");
        System.out.println(files);
        System.out.println(vo);
        System.out.println(photoFileVO);
        
        MemberVO loginUser = 
                (MemberVO)session.getAttribute("loginUser");
        vo.setMemberNo(loginUser.getNo());
        
        photoLogService.insertPhotoLog(vo);
        
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        
        // **테스트 PhotoFileVO photoFileVO 넣기 전 클래스 내 PhotoFileVO 객체 만들어서 함.
        // 위에 add() 안에  PhotoFileVO 넣는 방법, 아래 PhotoFileVO 객체 만드는 방법 선택가능
        // PhotoFileVO photoFileVO = new PhotoFileVO();
        
        // ArrayList<Object> photoFiles = new ArrayList<>();
        // ArrayList<PhotoFileVO> photoFiles = new ArrayList<>();
        // result.put("photo", photoFiles);
/* 포토파일 DB value 직접넣기
      photoFileVO.setPhotoLogNo(10);
      photoFileVO.setNo(100);
      photoFileVO.setPhoto("aaaa");
      photoFileService.insertPhotoFile(photoFileVO);
*/
        
        
/* 포토파일 DB value 직접넣기 - for문
        int a = vo.getNo();
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
                // ArrayList<String> photoFiles 활용 시 아래 .add(newfilename) 가능(타입을 맞춰서 진행해야 한다!) 
                // photoFiles.add(newfilename);
                photoFileVO.setPhoto(newfilename);
                photoFileVO.setNo(photoFileVO.getNo()+1);
//                photoFileVO.setPhotoLogNo(vo.getNo()+1);
                photoFileVO.setPhotoLogNo(10);
                
                photoFileService.insertPhotoFile(photoFileVO);
//                photoFiles.add(photoFileVO);
//                System.out.println("Controller--------------");
//                System.out.println(photoFileVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        return result;
    }


}
