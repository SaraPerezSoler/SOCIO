package es.uam.app.main;

import java.util.ArrayList;
import java.util.List;

import io.github.lukehutch.fastclasspathscanner.matchprocessor.ClassMatchProcessor;

public class ClassMatchProcessorSuperClass<T> implements ClassMatchProcessor {

	private Class<T> superClass;
	private List<Class<? extends T>> classes = new ArrayList<Class<? extends T>>();

	public ClassMatchProcessorSuperClass(Class<T> superClass) {
		this.superClass = superClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void processMatch(Class<?> arg0) {
		Class<?> superClass1 = arg0.getSuperclass();
		if (superClass1 != null) {
			if (superClass1.equals(superClass)) {
				classes.add((Class<? extends T>) arg0);
			}
		}

	}

	public List<Class<? extends T>> getClasses() {
		return classes;
	}

}
