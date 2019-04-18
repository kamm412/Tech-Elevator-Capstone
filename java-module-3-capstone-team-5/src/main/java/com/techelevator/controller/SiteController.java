package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.dao.ParkDAO;
import com.techelevator.dao.WeatherDAO;
import com.techelevator.model.Park;
import com.techelevator.model.Weather;

@Controller
public class SiteController {

	
@Autowired
private ParkDAO parkdao;
// GET: /
@RequestMapping(path="/", method=RequestMethod.GET)

    public String DisplayHome(ModelMap modelHolder) {
    List<Park>parks = parkdao.getAllParks();    
    modelHolder.addAttribute("parks",parks);
    
        return "homepage"; //provide home page as the logical view name to view resolver
    }
    
    
    
   @Autowired //connecting to the dao 
    private WeatherDAO weatherdao;  
   
   
    @RequestMapping(path="/parkdetails", method=RequestMethod.GET) // 
    public String displayParkDetail(@RequestParam String parkCode, ModelMap modelHolder, HttpSession session) {
        Park park = parkdao.getParkByCode(parkCode);
        List<Weather> parkForecast = weatherdao.getParkForecast(parkCode);
        modelHolder.put("park", park);
        modelHolder.put("parkForecast", parkForecast);
        return "parkdetails"; //takes parkdetails and provide it to view resolver
    }

    //Post method for temp field 
    @RequestMapping(path="/parkdetails", method=RequestMethod.POST) 
    public String changeTempType(@RequestParam String parkCode, @RequestParam boolean tempType, HttpSession session) {
    
        Boolean isF = true;
        if(tempType == true) {
            isF = true;
        } else {
            isF = false;
        }
        
        session.setAttribute("isF", isF);
        return "redirect:/parkdetails?parkCode=" + parkCode; //redirecting back to park details get method by taking the assigned park code in the query string 
    }
}