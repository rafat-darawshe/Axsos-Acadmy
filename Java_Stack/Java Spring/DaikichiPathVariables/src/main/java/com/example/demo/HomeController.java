
package com.example.demo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/daikichi")
public class HomeController {
        @RequestMapping("")
        public String Welcome() {
                return "Welcome!";
        }
        @RequestMapping("/today")
        public String today() {
                return "oday you will find luck in all your endeavors!";
        }
        @RequestMapping("/tomorrow")
        public String tomorrow() {
                return "omorrow, an opportunity will arise, so be sure to be open to new ideas!";
        }
    	@RequestMapping("/travel/{city}")
    	public String travel(@PathVariable("city") String city) {
    		return "Congrats! You will soon travel to " + city;
    	}
        @RequestMapping("/lotto/{number}")
        public String lotto(@PathVariable("number") int number){
			if (number % 2==0) {
        		return "You will take a grand journey in the near future, but be weary of tempting offers";
        	}
        	else {
        		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
        	}
        	
        }
}