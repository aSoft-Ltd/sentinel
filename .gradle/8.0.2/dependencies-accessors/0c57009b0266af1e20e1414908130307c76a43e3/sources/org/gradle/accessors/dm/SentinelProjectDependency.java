package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.ProjectDependency;
import org.gradle.api.internal.artifacts.dependencies.ProjectDependencyInternal;
import org.gradle.api.internal.artifacts.DefaultProjectDependencyFactory;
import org.gradle.api.internal.artifacts.dsl.dependencies.ProjectFinder;
import org.gradle.api.internal.catalog.DelegatingProjectDependency;
import org.gradle.api.internal.catalog.TypeSafeProjectDependencyFactory;
import javax.inject.Inject;

@NonNullApi
public class SentinelProjectDependency extends DelegatingProjectDependency {

    @Inject
    public SentinelProjectDependency(TypeSafeProjectDependencyFactory factory, ProjectDependencyInternal delegate) {
        super(factory, delegate);
    }

    /**
     * Creates a project dependency on the project at path ":cinematic-live-compose"
     */
    public CinematicLiveComposeProjectDependency getCinematicLiveCompose() { return new CinematicLiveComposeProjectDependency(getFactory(), create(":cinematic-live-compose")); }

    /**
     * Creates a project dependency on the project at path ":cinematic-live-core"
     */
    public CinematicLiveCoreProjectDependency getCinematicLiveCore() { return new CinematicLiveCoreProjectDependency(getFactory(), create(":cinematic-live-core")); }

    /**
     * Creates a project dependency on the project at path ":cinematic-live-coroutines"
     */
    public CinematicLiveCoroutinesProjectDependency getCinematicLiveCoroutines() { return new CinematicLiveCoroutinesProjectDependency(getFactory(), create(":cinematic-live-coroutines")); }

    /**
     * Creates a project dependency on the project at path ":cinematic-live-kollections"
     */
    public CinematicLiveKollectionsProjectDependency getCinematicLiveKollections() { return new CinematicLiveKollectionsProjectDependency(getFactory(), create(":cinematic-live-kollections")); }

    /**
     * Creates a project dependency on the project at path ":cinematic-live-test"
     */
    public CinematicLiveTestProjectDependency getCinematicLiveTest() { return new CinematicLiveTestProjectDependency(getFactory(), create(":cinematic-live-test")); }

    /**
     * Creates a project dependency on the project at path ":functions-core"
     */
    public FunctionsCoreProjectDependency getFunctionsCore() { return new FunctionsCoreProjectDependency(getFactory(), create(":functions-core")); }

    /**
     * Creates a project dependency on the project at path ":kase-core"
     */
    public KaseCoreProjectDependency getKaseCore() { return new KaseCoreProjectDependency(getFactory(), create(":kase-core")); }

    /**
     * Creates a project dependency on the project at path ":kevlar-api"
     */
    public KevlarApiProjectDependency getKevlarApi() { return new KevlarApiProjectDependency(getFactory(), create(":kevlar-api")); }

    /**
     * Creates a project dependency on the project at path ":kevlar-core"
     */
    public KevlarCoreProjectDependency getKevlarCore() { return new KevlarCoreProjectDependency(getFactory(), create(":kevlar-core")); }

    /**
     * Creates a project dependency on the project at path ":kollections-atomic"
     */
    public KollectionsAtomicProjectDependency getKollectionsAtomic() { return new KollectionsAtomicProjectDependency(getFactory(), create(":kollections-atomic")); }

    /**
     * Creates a project dependency on the project at path ":kollections-interoperable"
     */
    public KollectionsInteroperableProjectDependency getKollectionsInteroperable() { return new KollectionsInteroperableProjectDependency(getFactory(), create(":kollections-interoperable")); }

    /**
     * Creates a project dependency on the project at path ":kommander-core"
     */
    public KommanderCoreProjectDependency getKommanderCore() { return new KommanderCoreProjectDependency(getFactory(), create(":kommander-core")); }

    /**
     * Creates a project dependency on the project at path ":kommander-coroutines"
     */
    public KommanderCoroutinesProjectDependency getKommanderCoroutines() { return new KommanderCoroutinesProjectDependency(getFactory(), create(":kommander-coroutines")); }

    /**
     * Creates a project dependency on the project at path ":koncurrent-executors-core"
     */
    public KoncurrentExecutorsCoreProjectDependency getKoncurrentExecutorsCore() { return new KoncurrentExecutorsCoreProjectDependency(getFactory(), create(":koncurrent-executors-core")); }

    /**
     * Creates a project dependency on the project at path ":koncurrent-executors-coroutines"
     */
    public KoncurrentExecutorsCoroutinesProjectDependency getKoncurrentExecutorsCoroutines() { return new KoncurrentExecutorsCoroutinesProjectDependency(getFactory(), create(":koncurrent-executors-coroutines")); }

    /**
     * Creates a project dependency on the project at path ":koncurrent-executors-mock"
     */
    public KoncurrentExecutorsMockProjectDependency getKoncurrentExecutorsMock() { return new KoncurrentExecutorsMockProjectDependency(getFactory(), create(":koncurrent-executors-mock")); }

    /**
     * Creates a project dependency on the project at path ":koncurrent-later-api"
     */
    public KoncurrentLaterApiProjectDependency getKoncurrentLaterApi() { return new KoncurrentLaterApiProjectDependency(getFactory(), create(":koncurrent-later-api")); }

    /**
     * Creates a project dependency on the project at path ":koncurrent-later-core"
     */
    public KoncurrentLaterCoreProjectDependency getKoncurrentLaterCore() { return new KoncurrentLaterCoreProjectDependency(getFactory(), create(":koncurrent-later-core")); }

    /**
     * Creates a project dependency on the project at path ":koncurrent-later-coroutines"
     */
    public KoncurrentLaterCoroutinesProjectDependency getKoncurrentLaterCoroutines() { return new KoncurrentLaterCoroutinesProjectDependency(getFactory(), create(":koncurrent-later-coroutines")); }

    /**
     * Creates a project dependency on the project at path ":koncurrent-later-test"
     */
    public KoncurrentLaterTestProjectDependency getKoncurrentLaterTest() { return new KoncurrentLaterTestProjectDependency(getFactory(), create(":koncurrent-later-test")); }

    /**
     * Creates a project dependency on the project at path ":krono-api"
     */
    public KronoApiProjectDependency getKronoApi() { return new KronoApiProjectDependency(getFactory(), create(":krono-api")); }

    /**
     * Creates a project dependency on the project at path ":krono-kotlinx"
     */
    public KronoKotlinxProjectDependency getKronoKotlinx() { return new KronoKotlinxProjectDependency(getFactory(), create(":krono-kotlinx")); }

}
