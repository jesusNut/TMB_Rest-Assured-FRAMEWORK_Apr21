package com.TMB.listeners;

import org.testng.IAnnotationTransformer;

//removed this code from the Framework.

//This allows ony those methods to run which have data providers. If we add a method which does not have a 
//data provider, then that method will not be executed.

public class AnnotationTransformer implements IAnnotationTransformer {

//	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
//
//		annotation.setDataProvider("getData");
//		annotation.setDataProviderClass(com.TMB.utils.DataProviderUtils.class);
//
//	}

}
