package framework.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Convert {

	@SuppressWarnings("unchecked")
	public static <T extends Object, M extends Object> T modelConvert(
			Class<T> tClass, M entity) throws InstantiationException,
			IllegalAccessException, SecurityException, NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException, Exception {
		T t = tClass.newInstance();
		Class<M> mClass = (Class<M>) entity.getClass();
		Field[] fs = mClass.getDeclaredFields();
		Field[] tfs = tClass.getDeclaredFields();
		for (Field item : fs) {
			String fieldName = item.getName();
			fieldName = fieldName.substring(0, 1).toUpperCase()
					+ fieldName.substring(1);

			for (Field it : tfs) {
				String fn = it.getName();
				fn = fn.substring(0, 1).toUpperCase() + fn.substring(1);

				if (fn.equals(fieldName) && item.getType().equals(it.getType())) {
					Method method = mClass.getMethod("get" + fieldName);
					Object obj = method.invoke(entity);

					Method setMet = tClass.getMethod("set" + fn, it.getType());
					setMet.invoke(t, obj);
					break;
				} else {
					continue;
				}
			}
		}
		return t;
	}

	public static <T, M> List<T> modelConvert(Class<T> tClass, List<M> entities)
			throws InstantiationException, IllegalAccessException,
			SecurityException, NoSuchMethodException, IllegalArgumentException,
			InvocationTargetException, Exception {
		List<T> list = new ArrayList<T>();
		for (M item : entities) {
			T t = modelConvert(tClass, item);
			list.add(t);
		}
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
