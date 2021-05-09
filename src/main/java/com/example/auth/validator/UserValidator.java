package com.example.auth.validator;

import com.example.auth.model.User;
import com.example.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import javax.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;
    @Override
    public boolean suports(Class<?> aClass){
        return User.class.equals(aClass);
    }
    @Override
    public void validate(Object o, Errors errors){
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","NotEmply");
        if(user.getUsername().length() <6 || user.getUsername().length() > 32){
            errors.rejectValue("username","Duplicate.userForm.username");
        }
        if(userService.findByUsername(user.getUsername()) != null){
            errors.rejectValue("username","Duplicte.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","NotEmply");
        if(user.getPassword().length() <8 || user.getPassword().length() >32){
            errors.rejectValue("password","Size.userForm.password");
        }
        if(!user.getPasswordConfirm().equals(user.getPassword())){
            errors.rejectValue("passwordConfirm","Diff.userForm.passwordConfirm");

        }
    }
}
