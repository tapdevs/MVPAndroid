package com.tapdevs.mvpandroid.injections.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the DataManager to be memorised in the
 * correct component.
 *
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerDataManager {
}