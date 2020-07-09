package com.xyz.leesfilm.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyz.leesfilm.DAO.CategoryDAO;
import com.xyz.leesfilm.DAO.FilmsDAO;
import com.xyz.leesfilm.DTO.CategoryDTO;
import com.xyz.leesfilm.DTO.FilmsDTO;

@Controller
public class FilmsController {
   private static final Logger logger=LoggerFactory.getLogger(FilmsController.class);
   
   @Inject
   private FilmsDAO filmsDAO;
   
   @Inject
   private CategoryDAO categoryDAO;
   
   List<String> resultList;
   Set<String> comCategory;
   Set<String> photoCategory;
   
   
   @RequestMapping(value="/uploadFilms",method= {RequestMethod.GET,RequestMethod.POST})
   public String uploadVideo(Model model,
         @RequestParam("video_url") String videourl) {
         String video_id=videourl.substring(videourl.lastIndexOf("=")+1);
         System.out.println(video_id);   
         
         FilmsDTO filmsDTO = new FilmsDTO();
         filmsDTO.setF_Category("category1");
         filmsDTO.setF_Name(video_id);
         filmsDAO.insertFilms(filmsDTO);
         return "forward:/filmsselect";
      
   }
   
   @RequestMapping(value= {"/filmsselect","/films"}, method={RequestMethod.GET,RequestMethod.POST})
   public String photo(Model model) {
      resultList= new ArrayList<String>();
      comCategory = new HashSet<String>();
      photoCategory = new HashSet<String>();
      
      List<FilmsDTO> filmsList = filmsDAO.selectFilmsList();
      List<CategoryDTO> categoryList = categoryDAO.selectCategoryList();
      
      System.out.println("처음"+filmsList.size());
      
      for(int i=0;i<filmsList.size();i++) {

         System.out.println(i+"번째 photolistname3:"+filmsList.get(i).getF_Name());
         resultList.add(i, filmsList.get(i).getF_Name());
         }
      
      for(int i=0;i<categoryList.size();i++) {
         comCategory.add(categoryList.get(i).getC_Category());     
         photoCategory.add(categoryList.get(i).getP_Category()); 
      }
      
      model.addAttribute("resultList",resultList);
      model.addAttribute("photoCategory", photoCategory);
      model.addAttribute("comCategory", comCategory);
      
      return "/films";
   }
   
         
}