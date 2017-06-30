package com.redditclone;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.redditclone.Reddit;

import java.awt.print.Pageable;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path="/postlink")

public class RedditController {
	@Autowired
	private redditRepository reddRepository;

	
/**	Date d = new Date();
	private static final SimpleDateFormat formatDte = new SimpleDateFormat ("MMM dd, yyyy");
	private String currDate = formatDte.format(d);
	
	


	 Your site should have a home page that lists user supplied
	 *  links that look like:
	ProjectReddit     AddLink                  Login                                        Login

	13 Great Reasons to Learn Java
	submitted by Daylin
	May 31, 2017 

	*
	*Users should have to sign in to post a link and the links should be 
	*listed chronologically on the page. Each submission should include a 
	and the url should be clickable when displayed as a list. Further the
	links should open in a new tab when clicked.

	Logged in users should have access to a page with a list of the links
	that they have submitted.*/

	   
@RequestMapping("/add")
public @ResponseBody String addNewPost(@RequestParam String title, @RequestParam String url,
		@RequestParam String username){
	
	Reddit r = new Reddit();
	r.setTitle(title);
	r.setUrl(url);
	r.setUsername(username);
//	r.setCurrDate(currDate);
	reddRepository.save(r);
	
	return "Save";
	
}
/**@RequestMapping("/all")
public String showPosts(Model model, Iterable<Long> pageable) {

    model.addAttribute("posts", reddRepository.findAll(pageable));
    return "posts";
  }*/


@GetMapping(path="/all")
public @ResponseBody Iterable<Reddit> getAllPosts() {

	return reddRepository.findAll();
}

}	
	
