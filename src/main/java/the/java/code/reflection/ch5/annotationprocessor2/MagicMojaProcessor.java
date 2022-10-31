package the.java.code.reflection.ch5.annotationprocessor2;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.util.Set;

@AutoService(Processor.class) //<--- 이런것을 ServiceProvider라고한다.
public class MagicMojaProcessor extends AbstractProcessor {
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of(Magic.class.getName());
        //나는 Magic이라는 annotation을 가진놈을 처리할것이다.
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
        //소스코드 몇버전을 지원할것인가?
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        //Magic이라는 annotation을 전부다 가지고올수있다.
        Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(Magic.class);
        //@Target(ElementType.TYPE) //이렇게하면 3군데에 붙일수있다. Interface,class,Eunm
        //근데우리는 Interface만 붙이고싶다면?
        for (Element element : elementsAnnotatedWith) {
            if(element.getKind() != ElementKind.INTERFACE){
                //런타임시 Error를하면서 오류메시지를 남긴다.
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,"Magic Annoatation Can not be User on " + element.getSimpleName());
            } else{
                //만약에 문제가없다면 단순히 Logging만 한다.
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,"Processing" + element.getSimpleName());
            }

            MethodSpec pullOut = MethodSpec.methodBuilder("pullOut")
                    .addModifiers(Modifier.PUBLIC)
                    .returns(String.class)
                    .addStatement("return $S","Rabbit!")
                    .build();

            TypeSpec MagicMoja = TypeSpec.classBuilder("MagicMoja")
                    .addModifiers(Modifier.PUBLIC)
                    .addMethod(pullOut)
                    .build();

            Filer filer = processingEnv.getFiler();
            TypeElement typeElement = (TypeElement) element;
            ClassName className = ClassName.get(typeElement);
            //위에껄 한이유는 annoation이 붙어있는 놈과
            // pacakge가 같은위치에 형성되어야 하기때문이다.
            try {
                JavaFile.builder(className.packageName(),MagicMoja)
                        .build()
                        .writeTo(filer);
            } catch (IOException e) {
                processingEnv.getMessager().
                        printMessage(Diagnostic.Kind.ERROR,"FATAL ERROR : " + e.getMessage());
            }

        }

        return true; //true를 리턴하면 다른 processor들한테 처리를해달라고 부탁하지않는다.
        //즉, 나는 Magic이라는 annotation을 이 processor에서만 return할것이기 때문이다.
    }

    //round가 spring security에 filter_chain과 비슷하게 돌아간다.

}
