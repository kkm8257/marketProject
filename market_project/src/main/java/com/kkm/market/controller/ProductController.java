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
       if(n>0) {
    	   

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
       else {
    	   System.out.println("등록실패! 오류");
    	    mv.setViewName("home/home");
       		
       		return mv;
       }

	}
	
	@RequestMapping(value="myinfo_product_delete" , method=RequestMethod.GET )
	public String myinfo_product_delete(HttpServletRequest request) {
		
		
		String market_idx=(String)request.getParameter("idx");

		int n =productService.deleteProduct(Integer.parseInt(market_idx));
		if(n>0) {
			System.out.println("게시물 삭제 완료");
		}
		else {
			System.out.println("게시물 삭제 실패");
		}
		
		return "redirect:myInfo";
	}
	
	@RequestMapping("modifyProduct")
	public ModelAndView  modifyProduct(MultipartFile file, ModelAndView mv,HttpSession session,@RequestParam("market_idx") String market_idx,@RequestParam("item_kinds") String kinds,@RequestParam("item_title") String title,@RequestParam("item_price") String price,@RequestParam("item_desc") String desc) {

//		C:\Users\kkm\Desktop\marketProject\market_img\newItems
		
		UserVO user=loginService.getUserInfoById((String)session.getAttribute("session_id"));
		
		System.out.println("mar"+market_idx);
		
		Random random = new Random();
		int bound = 10000;
		
		//https://joalog.tistory.com/48

        String fileName = Integer.toString(random.nextInt(bound))+file.getOriginalFilename();
        File target = new File(uploadPath, fileName);
        
        ProductVO productVO= new ProductVO();
        
        productVO.setMarket_idx(Integer.parseInt(market_idx));
        productVO.setUser_idx(user.getUser_idx());
        productVO.setId(user.getId());
        productVO.setItem_title(title);
        productVO.setItem_desc(desc);
        productVO.setMarket_kinds(kinds);
        productVO.setMarket_price(Integer.parseInt(price));
        
        productVO.setMarket_img(fileName);
        
     int n =   productService.modifyProduct(productVO);
     
     
       if(n>0) {
    	   

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
           mv.setViewName("myInfo/myInfo");
   		
   		
   		return mv;
    	   
    	   
       }
       else {
    	   System.out.println("등록실패! 오류");
    	    mv.setViewName("home/home");
       		
       		return mv;
       }

	}
	
	
}
