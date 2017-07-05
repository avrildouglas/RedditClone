package com.redditclone;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.redditclone.Reddit;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

@Controller
@RequestMapping(path="/posts")

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


/**@GetMapping("/login")
public String login(){
	return "login";
}*/
	

@RequestMapping("/list")
public String postSubmitForm(Model model){
	model.addAttribute("posts", reddRepository.findAll());
	return "reddLinkOut";
}
	
@GetMapping("/add")
public String addNewPost(Model model){
	model.addAttribute("post", new Reddit());
	return "postlinkHTML";
}

@PostMapping("/add")
public String processPost(@Valid Reddit post, BindingResult bindingResult) {
	if (bindingResult.hasErrors()) {
		return "postlinkHTML";
	}
		reddRepository.save(post);
		return "redirect:/posts/list";
}

	   
/**@RequestMapping("/update/{id}")
public @ResponseBody String updatePost(@RequestParam String title, @RequestParam String url,
		@RequestParam String username){
	
	Reddit r = new Reddit();
	r.setTitle(title);
	r.setUrl(url);
	r.setUsername(username);
//	r.setCurrDate(currDate);
	reddRepository.save(r);
	
	return "Save";
	
}*/

/**@GetMapping(path="/all")
public @ResponseBody Iterable<Reddit> getAllPosts() {

	return reddRepository.findAll();
	}*/
}	
	
