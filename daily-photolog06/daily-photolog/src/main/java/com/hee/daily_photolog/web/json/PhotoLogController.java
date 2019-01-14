package com.hee.daily_photolog.web.json;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        
        
        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) continue;
                String newfilename = UUID.randomUUID().toString();
                String path = sc.getRealPath("/files/" + newfilename);
                file.transferTo(new File(path));

                photoFileVO.setPhoto(newfilename);
                photoFileVO.setPhotoLogNo(photoLogVO.getNo());
                
                photoFileService.insertPhotoFile(photoFileVO);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    
    @GetMapping("list")
    public Object photolist(HttpSession session) {
        
        MemberVO loginUser = 
                (MemberVO)session.getAttribute("loginUser");
        
        List<PhotoLogVO> list = 
                photoLogService.listPhotoLog(loginUser.getNo());
        
        System.out.println("===>>>photologControllerlist");
        System.out.println(list);
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        result.put("list", list);
        return result;
        
    }
    
//    @GetMapping("list")
//    public Object photolist(HttpSession session) {
//        
//        MemberVO loginUser = 
//                (MemberVO)session.getAttribute("loginUser");
//        
//        Map<String, Object> photoLogList = 
//                photoLogService.listPhotoLog(loginUser.getNo());
//        
//        System.out.println("======>PhotoLogControllerList");
//        System.out.println(photoLogList);
//        
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("list", photoLogList);
//        result.put("status", "success");
//        
//        
//        return result;
//        
//    }
    
    
}
