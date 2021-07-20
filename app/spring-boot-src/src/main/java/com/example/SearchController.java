package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SearchController {

  @GetMapping("/search/{num}/")
	public String search(@PathVariable("num") String num) {
		return num+" test";
	}

  public static void main(String[] args) {
    SpringApplication.run(SearchController.class, args);
  }

}