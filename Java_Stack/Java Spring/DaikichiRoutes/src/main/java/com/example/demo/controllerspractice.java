
package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/daikichi")
public class controllerspractice {
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
}