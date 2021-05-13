package br.com.projetothymeleaf.loja.validation.impl;

import br.com.projetothymeleaf.loja.validation.NomeValido;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NomeValidoValidation implements ConstraintValidator<NomeValido, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.equals("guilherme");
    }
}
