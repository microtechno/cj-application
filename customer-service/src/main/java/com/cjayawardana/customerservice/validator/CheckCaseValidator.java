package com.cjayawardana.customerservice.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

   private CaseMode caseMode;

   @Override
   public void initialize(CheckCase constraint) {
      this.caseMode = constraint.value();

   }

   @Override
   public boolean isValid(String obj, ConstraintValidatorContext context) {
      if ( obj == null ) {
         return true;
      }

      if ( caseMode == CaseMode.UPPER ) {
         return obj.equals( obj.toUpperCase() );
      }
      else {
         return obj.equals( obj.toLowerCase() );
      }
   }
}
