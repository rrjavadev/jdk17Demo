package com.example.demo;

import com.example.demo.lombok.Account;
import com.example.demo.lombok.AccountMapper;
import com.example.demo.lombok.AccountTransferObject;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class DemoApplication {

	private final AccountMapper accountMapper;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping(value = "/runMapper")
	public String runMapper(){

		AccountTransferObject accountTransferObject = accountMapper.paymentToAchTransferObject(Account.builder().accountNumber("abcd").build());
		return "Mapping works ...." + accountTransferObject.getAccountNumber();
	}
}
