import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class objectM{
	
	@Test
	public void execution() throws JsonProcessingException{
		User user = new User();
		user.setId(1L);
		user.setEmail("example@example.com");
		user.setName("Bazlur Rahman");
		
		Program program = new Program();
		program.setId(1L);
		program.setName("Program @# 1");
		program.setCreatedBy(user);
		program.setContents("Some contents");
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(program);
		System.out.println(json);	
	}	
}
