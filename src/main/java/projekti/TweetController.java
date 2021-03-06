package projekti;

import java.security.Principal;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @Autowired
    private CommentService commentService;

    @Autowired
    LikesService likesService;


    @GetMapping("/tweets")
    public String allTweets(Model model, Principal principal, @RequestParam(defaultValue = "0") String page){
        String username = principal.getName();
        Double tweetCount = tweetService.tweetCount() * 1.0;
        Integer tweetsOnOnePage = 4;
        Long pages = (long) Math.ceil(tweetCount / tweetsOnOnePage);

        System.out.println("Current user");
        System.out.println(username);

        model.addAttribute("currentUser", username);
        model.addAttribute("tweets", tweetService.getAll(page, tweetsOnOnePage));

    
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", Integer.parseInt(page));
        
        
        return "tweets";
    }

    @PostMapping("/tweets")
    public String add(@RequestParam String text, Principal principal){
        tweetService.createTweet(text, principal);
        return "redirect:/tweets";
    }

    // @DeleteMapping("/tweets/{id}")
    // public String deleteTweet(@PathVariable Long id)
    // {   
    //     likesService.deleteLikes(id);
    //     commentService.deleteTweetComments(id);
    //     tweetService.deleteOne(id);

    //     return "tweets";
        
    // }

    @DeleteMapping("/tweets/{id}")
    public ResponseEntity<String> deleteTweet(@PathVariable Long id)
    {   
        likesService.deleteLikes(id);
        commentService.deleteTweetComments(id);
        tweetService.deleteOne(id);

        return ResponseEntity.status(HttpStatus.OK).body(String.format("Tweet succesfully deleted"));
        
    }

    
}
