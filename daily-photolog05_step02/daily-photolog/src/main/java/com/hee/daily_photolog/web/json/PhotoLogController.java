package com.hee.daily_photolog.web.json;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hee.daily_photolog.service.PhotoLogService;
import com.hee.daily_photolog.vo.MemberVO;
import com.hee.daily_photolog.vo.PhotoLogVO;

@RestController
@RequestMapping("/photolog")
public class PhotoLogController {

    @Autowired ServletContext sc;
//  @Autowired PhotoLogService photoLogService;
//  @Autowired 대신 아래 방법 사용 
    PhotoLogService photoLogService;
    public PhotoLogController(
            PhotoLogService photoLogService) {
        this.photoLogService = photoLogService;
    }
    
    @PostMapping("add")
    public Object add(
            PhotoLogVO vo,
            MultipartFile[] files,
            HttpSession session) {
        
        MemberVO loginUser = 
                (MemberVO)session.getAttribute("loginUser");
        vo.setMemberNo(loginUser.getNo());
        
        
        photoLogService.insertPhotoLog(vo);
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        
        ArrayList<String> filenames = new ArrayList<>();
        result.put("filenames", filenames);
        
        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) continue;
                String newfilename = UUID.randomUUID().toString();
                String path = sc.getRealPath("/files/" + newfilename);
                file.transferTo(new File(path));
                filenames.add(newfilename);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
        return result;
    }


}
