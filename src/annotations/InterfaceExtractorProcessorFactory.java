package annotations;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class InterfaceExtractorProcessorFactory implements
    AnnotationProcessorFactory {

    @Override
    public Collection<String> supportedOptions() {
        // TODO Auto-generated method stub
        return Collections.emptySet();
    }

    @Override
    public Collection<String> supportedAnnotationTypes() {
        // TODO Auto-generated method stub
        return Collections.singleton("annotations.ExtractInterface");
    }

    //
    @Override
    public AnnotationProcessor getProcessorFor(
        Set<AnnotationTypeDeclaration> atds,
        AnnotationProcessorEnvironment env) {
        // TODO Auto-generated method stub
        return new InterfaceExtractorProcessor(env);
    }

}
