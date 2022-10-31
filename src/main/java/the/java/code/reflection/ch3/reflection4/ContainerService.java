package the.java.code.reflection.ch3.reflection4;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

    public static <T> T getObject(Class<T> classType){

        //source코드는 testcode를 참조할수없으므로 어쩔수없이 reflection 기술을 사용한다.
        T instance = createInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(f ->{
            Inject annotation = f.getAnnotation(Inject.class);
            if(annotation != null){
                Object fieldInstance = createInstance(f.getType());
                f.setAccessible(true);
                try {
                    f.set(instance,fieldInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
