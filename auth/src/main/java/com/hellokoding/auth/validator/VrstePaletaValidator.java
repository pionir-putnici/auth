package com.hellokoding.auth.validator;
import com.hellokoding.auth.model.VrstePaleta;
import com.hellokoding.auth.service.VrstePaletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class VrstePaletaValidator implements Validator {
    @Autowired
    private VrstePaletaService vrstePaletaService;

    @Override
    public boolean supports(Class<?> aClass) {
        return VrstePaleta.class.equals(aClass);
    }

    
    @Override
    public void validate(Object o, Errors errors) {
        VrstePaleta vrstePaleta = (VrstePaleta) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        
//        if (vrstePaleta.getName().length() < 2 || vrstePaleta.getName().length() > 32) {
//            errors.rejectValue("name", "Size.vrstePaletaForm.name");
//        }
//        if (vrstePaletaService.findByName(vrstePaleta.getName()) != null) {
//            errors.rejectValue("name", "Duplicate.vrstePaletaForm.name");
//        }

//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
//        if (user.getPassword().length() < 2 || user.getPassword().length() > 32) {
//            errors.rejectValue("password", "Size.userForm.password");
//        }
//
//        if (!user.getPasswordConfirm().equals(user.getPassword())) {
//            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
//        }
    }
}
