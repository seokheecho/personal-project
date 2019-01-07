package com.hee.daily_photolog.web.json;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hee.daily_photolog.service.PhotoLogService;
import com.hee.daily_photolog.vo.MemberVO;
import com.hee.daily_photolog.vo.PhotoLogVO;

@RestController
@RequestMapping("/photolog")
public class PhotoLogController {

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
            HttpSession session) {
        
        MemberVO loginUser = 
                (MemberVO)session.getAttribute("loginUser");
        vo.setMemberNo(loginUser.getNo());
        
        
        photoLogService.insertPhotoLog(vo);
        
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", "success");
        
        return result;
    }


}
