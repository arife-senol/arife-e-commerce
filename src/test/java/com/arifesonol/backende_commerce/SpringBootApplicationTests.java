package com.arifesonol.backende_commerce;

import com.arifesonol.backende_commerce.dto.AddressRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void willCreateAddress() throws Exception {
		AddressRequest addressRequest = new AddressRequest(
				null,
				120L,
				"Ali",
				"Yılmaz",
				"İstanbul",
				"Kadıköy",
				"Acıbadem",
				"Barış Manço Sokak No: 5 Daire: 3",
				"Ev adres",
				"+90 555 123 4567"
		);

		mockMvc.perform(post("http://localhost:8080/user/address")
						.with(httpBasic("arife@gmail.com", "123456")) // Basic Auth bilgileri burada eklenir
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(addressRequest)))
				.andExpect(status().isOk());
	}

}
