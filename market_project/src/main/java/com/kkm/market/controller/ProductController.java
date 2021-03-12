package com.kkm.market.controller;

import java.io.File;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kkm.market.service.LoginService;
import com.kkm.market.service.ProductService;
import com.kkm.market.vo.ProductVO;
import com.kkm.market.vo.UserVO;

@Controller
public class ProductController {
	
	@Resource(name="uploadPath")
    String uploadPath;
	
	@Autowired 
	ProductService productService;
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="getSearchList" ,produces = "application/json; charset=utf8", method=RequestMethod.POST) //application/json 이 중요
	@ResponseBody
	public List<ProductVO> getSearchList(HttpServletRequest request,Model model) {
		
		String word = request.getParameter("word");
		System.out.println("word : "+word);
		 
		List<ProductVO> list =  productService.getSearchList(word);
		
		System.out.println("list"+list);
		model.addAttribute("search_list",list);
	 
		
		return list;
		
	}

	@RequestMapping("upload")
	public ModelAndView  upload(MultipartFile file, ModelAndView mv,HttpSession session,@RequestParam("item_kinds") String kinds,@RequestParam("item_title") String title,@RequestParam("item_price") String price,@RequestParam("item_desc") String desc) {

//		C:\Users\kkm\Desktop\marketProject\market_img\newItems
		
		UserVO user=loginService.getUserInfoById((String)session.getAttribute("session_id"));
		
		
		Random random = new Random();
		int bound = 10000;
		
		//https://joalog.tistory.com/48

        String fileName = Integer.toString(random.nextInt(bound))+file.getOriginalFilename();
        File target = new File(uploadPath, fileName);
        
        ProductVO productVO= new ProductVO();
        
        
        productVO.setUser_idx(user.getUser_idx());
        productVO.setId(user.getId());
        productVO.setItem_title(title);
        productVO.setItem_desc(desc);
        productVO.setMarket_kinds(kinds);
        productVO.setMarket_price(Integer.parseInt(price));
        
        productVO.setMarket_img(fileName);
        
     int n =   productService.setNewItem(productVO);
        
//        db에 등록과정 추가코딩  //db에 저장된 폴더 경로 모두 수정 모으기
        
        ///
        //경로 생성
        if ( ! new File(uploadPath).exists()) {
            new File(uploadPath).mkdirs();
        }
        //파일 복사
        try {
            FileCopyUtils.copy(file.getBytes(), target);
            mv.addObject("file", file);
        } catch(Exception e) {
            e.printStackTrace();
            mv.addObject("file", "error");
        }
        //View 위치 설정
        mv.setViewName("home/home");
		
		
		return mv;
	}
	
	
	
}
