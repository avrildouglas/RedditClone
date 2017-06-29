package com.redditclone;

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

import com.redditclone.Reddit;
@Controller
@RequestMapping(path="/postlink")

public class RedditController {
	@Autowired
	private redditRepository reddRepository;
	
	/**
	
	@RequestMapping("/add")
    public String addPostNew(Model model){
        model.addAttribute("redditer", new Reddit());
        return "postLinkHTML";
	}     
	
	
    @RequestMapping("/add")
    public String addPost(@ModelAttribute Reddit redditer){     
        reddRepository.save(redditer);
        return "postlinkHTML";
    }

    
    
    **/
    
    
@RequestMapping("/add")
public @ResponseBody String addNewPost(@RequestParam String title, @RequestParam String url,
		@RequestParam String username){
	
	Reddit r = new Reddit();
	r.setTitle(title);
	r.setUrl(url);
	r.setUsername(username);
	
	reddRepository.save(r);
	
	return "Save";
	
}

@GetMapping(path="/all")
public @ResponseBody Iterable<Reddit> getAllPosts()
{
return reddRepository.findAll();
}




	
}	
