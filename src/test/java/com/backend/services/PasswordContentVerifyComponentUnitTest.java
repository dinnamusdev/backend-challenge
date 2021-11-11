package com.backend.services;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PasswordContentVerifyComponentUnitTest {

		
	@InjectMocks
	private PasswordContentVerifyComponent contentVerifyComponent;
		
	
	
	
	
	//checkMinimumTextSize
	@Test 
	public void checkMinimumTextSize_deveRetornarFalseParaValorNulo(){
		Assertions.assertFalse(contentVerifyComponent.checkMinimumTextSize(null));
	}
	
	@Test 
	public void checkMinimumTextSize_deveRetornarFalseParaValorVazio(){
		

		
		Assertions.assertFalse(contentVerifyComponent.checkMinimumTextSize(""));
	}
	
	
	@Test 
	public void checkMinimumTextSize_deveRetornarFalseParaValorMenorQueOMinimo(){
		
		String valorTestar = StringUtils.repeat("A", 8);
		
		Assertions.assertFalse(contentVerifyComponent.checkMinimumTextSize(valorTestar));
	}
	
	
	@Test 
	public void checkMinimumTextSize_deveRetornarTrueParaValorValido(){
		
		String valorTestar = StringUtils.repeat("A", 9);
		
		Assertions.assertTrue(contentVerifyComponent.checkMinimumTextSize(valorTestar));
	}
	
	
	
	//checkPresenceAtLessOneDigit
	@Test 
	public void checkPresenceAtLessOneDigit_deveRetornarFalseParaValorNulo(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceAtLessOneDigit(null));
	}
	
	
	@Test 
	public void checkPresenceAtLessOneDigit_deveRetornarFalseParaValorVazio(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceAtLessOneDigit(""));
	}
	
	
	@Test 
	public void checkPresenceAtLessOneDigit_deveRetornarFalseParaValorInvalido(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceAtLessOneDigit("MKKDMXJDJ"));
	}
	
	@Test 
	public void checkPresenceAtLessOneDigit_deveRetornarTrueParaValorValido(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceAtLessOneDigit("MKKDM3XJDJ"));
	}
	
	//checkPresenceAtLessOneLowerLetter
	@Test 
	public void checkPresenceAtLessOneLowerLetter_deveRetornarFalseParaValorNulo(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceAtLessOneLowerLetter(null));
	}
	
	@Test 
	public void checkPresenceAtLessOneLowerLetter_deveRetornarFalseParaValorVazio(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceAtLessOneLowerLetter(""));
	}
	
	@Test 
	public void checkPresenceAtLessOneLowerLetter_deveRetornarFalseParaValoInvalido(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceAtLessOneLowerLetter("HHHHHHSS***22"));
	}
	
	@Test 
	public void checkPresenceAtLessOneLowerLetter_deveRetornarTrueParaValorValido(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceAtLessOneLowerLetter("HHHHHaHSS***22"));
	}
	
    //checkPresenceAtLessOneUpperLetter
	@Test 
	public void checkPresenceAtLessOneUpperLetter_deveRetornarFalseParaValorNulo(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceAtLessOneUpperLetter(null));
	}
	
	@Test 
	public void checkPresenceAtLessOneUpperLetter_deveRetornarFalseParaValorVazio(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceAtLessOneUpperLetter(""));
	}
	
	@Test 
	public void checkPresenceAtLessOneUpperLetter_deveRetornarFalseParaValorInvalido(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceAtLessOneUpperLetter("22323sssdc2*&"));
	}
	
	@Test 
	public void checkPresenceAtLessOneUpperLetter_deveRetornarTrueParaValorValido(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceAtLessOneUpperLetter("22323sZssdc2*&"));
	}
	
	
	//checkPresenceAtLessOneSpecialCharacter
	@Test 
	public void checkPresenceAtLessOneSpecialCharacter_deveRetornarFalseParaValorNulo(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceAtLessOneSpecialCharacter(null));
	}
	
	@Test 
	public void checkPresenceAtLessOneSpecialCharacter_deveRetornarFalseParaValorVazio(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceAtLessOneSpecialCharacter(""));
	}
	
	@Test 
	public void checkPresenceAtLessOneSpecialCharacter_deveRetornarFalseParaValorInvalido(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceAtLessOneSpecialCharacter("11323mmnmc4454"));
	}
	
	@Test 
	public void checkPresenceAtLessOneSpecialCharacter_deveRetornarTrueParaValorValido_Mais(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceAtLessOneSpecialCharacter("11323mmn+mc4454"));
	}
	@Test 
	public void checkPresenceAtLessOneSpecialCharacter_deveRetornarTrueParaValorValido_Menos(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceAtLessOneSpecialCharacter("11323mmn-mc4454"));
	}
	
	@Test 
	public void checkPresenceAtLessOneSpecialCharacter_deveRetornarTrueParaValorValido_Exclamacao(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceAtLessOneSpecialCharacter("11323mmn!mc4454"));
	}
	
	@Test 
	public void checkPresenceAtLessOneSpecialCharacter_deveRetornarTrueParaValorValido_Cifrao(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceAtLessOneSpecialCharacter("11323mmn$mc4454"));
	}
	
	
	@Test 
	public void checkPresenceAtLessOneSpecialCharacter_deveRetornarTrueParaValorValido_Arrouba(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceAtLessOneSpecialCharacter("11323mmn@mc4454"));
	}
	
	@Test 
	public void checkPresenceAtLessOneSpecialCharacter_deveRetornarTrueParaValorValido_Cerquilha(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceAtLessOneSpecialCharacter("11323mmn#mc4454"));
	}
	
	@Test 
	public void checkPresenceAtLessOneSpecialCharacter_deveRetornarTrueParaValorValido_Percentual(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceAtLessOneSpecialCharacter("11323mmn%mc4454"));
	}
	
	@Test 
	public void checkPresenceAtLessOneSpecialCharacter_deveRetornarTrueParaValorValido_Circunflexo(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceAtLessOneSpecialCharacter("11323mmn^mc4454"));
	}
	
	@Test 
	public void checkPresenceAtLessOneSpecialCharacter_deveRetornarTrueParaValorValido_EComercial(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceAtLessOneSpecialCharacter("11323mmn&mc4454"));
	}
	
	@Test 
	public void checkPresenceAtLessOneSpecialCharacter_deveRetornarTrueParaValorValido_Asteristico(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceAtLessOneSpecialCharacter("11323mmn*mc4454"));
	}
	
	@Test 
	public void checkPresenceAtLessOneSpecialCharacter_deveRetornarTrueParaValorValido_ParentesesAbrir(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceAtLessOneSpecialCharacter("11323mmn(mc4454"));
	}
	
	
	@Test 
	public void checkPresenceAtLessOneSpecialCharacter_deveRetornarTrueParaValorValido_ParentesesFechar(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceAtLessOneSpecialCharacter("11323mmn)mc4454"));
	}
	
	//checkPresenceEmptySpaces
	@Test 
	public void checkPresenceEmptySpaces_deveRetornarFalseParaValorNulo(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceEmptySpaces(null));
	}
	
	@Test 
	public void checkPresenceEmptySpaces_deveRetornarFalseParaValorVazio(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceEmptySpaces(""));
	}
	
	@Test 
	public void checkPresenceEmptySpaces_deveRetornarFalseParaValorInvalido(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceEmptySpaces("UUJJSNS9938!@#"));
	}
	
	@Test 
	public void checkPresenceEmptySpaces_deveRetornarTrueParaValorValido(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceEmptySpaces("UUJJ SNS9938!@#"));
	}
	
	
	//checkPresenceOfRepeatedCharacters
	@Test 
	public void checkPresenceOfRepeatedCharacters_deveRetornarFalseParaValorNulo(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceOfRepeatedCharacters(null));
	}
	
	
	@Test 
	public void checkPresenceOfRepeatedCharacters_deveRetornarFalseParaValorVazio(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceOfRepeatedCharacters(""));
	}
	
	@Test 
	public void checkPresenceOfRepeatedCharacters_deveRetornarTrueParaValorTextoRepetido(){
		Assertions.assertTrue(contentVerifyComponent.checkPresenceOfRepeatedCharacters("qwertyuiopq"));
	}
	
	
	@Test 
	public void checkPresenceOfRepeatedCharacters_deveRetornarFalseParaValorTextoSemRepeticao(){
		Assertions.assertFalse(contentVerifyComponent.checkPresenceOfRepeatedCharacters("qwertyuiop"));
	}
	
	
	
	//checkMaximumTextSize
	@Test 
	public void checkMaximumTextSize_deveRetornarFalseParaValorNulo(){
		Assertions.assertFalse(contentVerifyComponent.checkMaximumTextSize(null));
	}
	
	@Test 
	public void checkMaximumTextSize_deveRetornarTrueParaValorVazio(){
		Assertions.assertTrue(contentVerifyComponent.checkMaximumTextSize(""));
	}
	
	@Test 
	public void checkMaximumTextSize_deveRetornarTrueParaValorValido(){
		
		String valorTestar = StringUtils.repeat("A", 254);;
		
		Assertions.assertTrue(contentVerifyComponent.checkMaximumTextSize(valorTestar));
	}
	
	@Test 
	public void checkMaximumTextSize_deveRetornarFalseParaValorInvalido(){
		
		String valorTestar = StringUtils.repeat("A", 256);
		
		Assertions.assertFalse(contentVerifyComponent.checkMaximumTextSize(valorTestar));
	}
	
}
