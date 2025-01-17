package io.quarkus.test.junit.mockito;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * When used on a field of a test class, the field becomes a Mockito spy,
 * that is then used to spy on the normal scoped bean which the field represents
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectSpy {

    /**
     * {@code true} will create a mock that <em>delegates</em> all calls to the real bean, instead of creating a regular Mockito
     * spy.
     * <p/>
     * You should try this mode when you get errors like "Cannot call abstract real method on java object!" when calling a
     * {@code default} interface method of a spied bean.
     *
     * @see org.mockito.AdditionalAnswers#delegatesTo(Object)
     */
    boolean delegate() default false;
}
