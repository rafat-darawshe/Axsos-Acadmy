
package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Human {
	   @RequestMapping("/")
	    public String index(@RequestParam(value="name", required=false) String searchQuery,
	    @RequestParam(value="last_name", required=false) String searchQuery2,
	    @RequestParam(value="times", required=false) String searchQuery3)
	    		 {
	    	if (searchQuery == null){
	    		return "Hello Human";
	    	}
	    	else if (searchQuery2 == null) {
	    		return "Hello " + searchQuery;
	    	}
	    	else if (searchQuery3 == null) {
	    		return "Hello " + searchQuery+" " + searchQuery2;
	    }
	    	String str = "";
	    	for(int i=0; i< Integer.parseInt(searchQuery3); i++) {
	    		str += "Hello " + searchQuery+" " + searchQuery2;
	    		}
	    	return str;
	    	}

	}
	   