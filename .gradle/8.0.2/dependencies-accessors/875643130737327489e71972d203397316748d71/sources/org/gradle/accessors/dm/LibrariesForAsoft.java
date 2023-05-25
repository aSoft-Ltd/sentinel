package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `asoft` extension.
*/
@NonNullApi
public class LibrariesForAsoft extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final IdentifierLibraryAccessors laccForIdentifierLibraryAccessors = new IdentifierLibraryAccessors(owner);
    private final KashLibraryAccessors laccForKashLibraryAccessors = new KashLibraryAccessors(owner);
    private final KeepLibraryAccessors laccForKeepLibraryAccessors = new KeepLibraryAccessors(owner);
    private final KommanderLibraryAccessors laccForKommanderLibraryAccessors = new KommanderLibraryAccessors(owner);
    private final KoncurrentLibraryAccessors laccForKoncurrentLibraryAccessors = new KoncurrentLibraryAccessors(owner);
    private final LiveLibraryAccessors laccForLiveLibraryAccessors = new LiveLibraryAccessors(owner);
    private final ViewmodelLibraryAccessors laccForViewmodelLibraryAccessors = new ViewmodelLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForAsoft(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Returns the group of libraries at identifier
     */
    public IdentifierLibraryAccessors getIdentifier() { return laccForIdentifierLibraryAccessors; }

    /**
     * Returns the group of libraries at kash
     */
    public KashLibraryAccessors getKash() { return laccForKashLibraryAccessors; }

    /**
     * Returns the group of libraries at keep
     */
    public KeepLibraryAccessors getKeep() { return laccForKeepLibraryAccessors; }

    /**
     * Returns the group of libraries at kommander
     */
    public KommanderLibraryAccessors getKommander() { return laccForKommanderLibraryAccessors; }

    /**
     * Returns the group of libraries at koncurrent
     */
    public KoncurrentLibraryAccessors getKoncurrent() { return laccForKoncurrentLibraryAccessors; }

    /**
     * Returns the group of libraries at live
     */
    public LiveLibraryAccessors getLive() { return laccForLiveLibraryAccessors; }

    /**
     * Returns the group of libraries at viewmodel
     */
    public ViewmodelLibraryAccessors getViewmodel() { return laccForViewmodelLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class IdentifierLibraryAccessors extends SubDependencyFactory {

        public IdentifierLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (tz.co.asoft:identifier-core)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("identifier.core"); }

            /**
             * Creates a dependency provider for generators (tz.co.asoft:identifier-generators)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getGenerators() { return create("identifier.generators"); }

    }

    public static class KashLibraryAccessors extends SubDependencyFactory {

        public KashLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for currency (tz.co.asoft:kash-currency)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getCurrency() { return create("kash.currency"); }

            /**
             * Creates a dependency provider for money (tz.co.asoft:kash-money)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getMoney() { return create("kash.money"); }

    }

    public static class KeepLibraryAccessors extends SubDependencyFactory {
        private final KeepReactLibraryAccessors laccForKeepReactLibraryAccessors = new KeepReactLibraryAccessors(owner);

        public KeepLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for api (tz.co.asoft:keep-api)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getApi() { return create("keep.api"); }

            /**
             * Creates a dependency provider for browser (tz.co.asoft:keep-browser)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getBrowser() { return create("keep.browser"); }

            /**
             * Creates a dependency provider for file (tz.co.asoft:keep-file)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getFile() { return create("keep.file"); }

            /**
             * Creates a dependency provider for mock (tz.co.asoft:keep-mock)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getMock() { return create("keep.mock"); }

        /**
         * Returns the group of libraries at keep.react
         */
        public KeepReactLibraryAccessors getReact() { return laccForKeepReactLibraryAccessors; }

    }

    public static class KeepReactLibraryAccessors extends SubDependencyFactory {

        public KeepReactLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for native (tz.co.asoft:keep-react-native)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getNative() { return create("keep.react.native"); }

    }

    public static class KommanderLibraryAccessors extends SubDependencyFactory {

        public KommanderLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (tz.co.asoft:kommander-core)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("kommander.core"); }

            /**
             * Creates a dependency provider for coroutines (tz.co.asoft:kommander-coroutines)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getCoroutines() { return create("kommander.coroutines"); }

    }

    public static class KoncurrentLibraryAccessors extends SubDependencyFactory {
        private final KoncurrentExecutorsLibraryAccessors laccForKoncurrentExecutorsLibraryAccessors = new KoncurrentExecutorsLibraryAccessors(owner);
        private final KoncurrentLaterLibraryAccessors laccForKoncurrentLaterLibraryAccessors = new KoncurrentLaterLibraryAccessors(owner);

        public KoncurrentLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at koncurrent.executors
         */
        public KoncurrentExecutorsLibraryAccessors getExecutors() { return laccForKoncurrentExecutorsLibraryAccessors; }

        /**
         * Returns the group of libraries at koncurrent.later
         */
        public KoncurrentLaterLibraryAccessors getLater() { return laccForKoncurrentLaterLibraryAccessors; }

    }

    public static class KoncurrentExecutorsLibraryAccessors extends SubDependencyFactory {

        public KoncurrentExecutorsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (tz.co.asoft:koncurrent-executors-core)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("koncurrent.executors.core"); }

            /**
             * Creates a dependency provider for coroutines (tz.co.asoft:koncurrent-executors-coroutines)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getCoroutines() { return create("koncurrent.executors.coroutines"); }

            /**
             * Creates a dependency provider for mock (tz.co.asoft:koncurrent-executors-mock)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getMock() { return create("koncurrent.executors.mock"); }

    }

    public static class KoncurrentLaterLibraryAccessors extends SubDependencyFactory {

        public KoncurrentLaterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (tz.co.asoft:koncurrent-later-core)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("koncurrent.later.core"); }

            /**
             * Creates a dependency provider for coroutines (tz.co.asoft:koncurrent-later-coroutines)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getCoroutines() { return create("koncurrent.later.coroutines"); }

            /**
             * Creates a dependency provider for test (tz.co.asoft:koncurrent-later-test)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() { return create("koncurrent.later.test"); }

    }

    public static class LiveLibraryAccessors extends SubDependencyFactory {

        public LiveLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (tz.co.asoft:live-core)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("live.core"); }

            /**
             * Creates a dependency provider for react (tz.co.asoft:live-react)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getReact() { return create("live.react"); }

            /**
             * Creates a dependency provider for test (tz.co.asoft:live-test)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getTest() { return create("live.test"); }

    }

    public static class ViewmodelLibraryAccessors extends SubDependencyFactory {

        public ViewmodelLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (tz.co.asoft:viewmodel-core)
             * This dependency was declared in catalog asoft.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("viewmodel.core"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: root (2.0.16)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog asoft.toml
             */
            public Provider<String> getRoot() { return getVersion("root"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for applikation to the plugin id 'tz.co.asoft.applikation'
             * This plugin was declared in catalog asoft.toml
             */
            public Provider<PluginDependency> getApplikation() { return createPlugin("applikation"); }

            /**
             * Creates a plugin provider for deploy to the plugin id 'tz.co.asoft.deploy'
             * This plugin was declared in catalog asoft.toml
             */
            public Provider<PluginDependency> getDeploy() { return createPlugin("deploy"); }

            /**
             * Creates a plugin provider for library to the plugin id 'tz.co.asoft.library'
             * This plugin was declared in catalog asoft.toml
             */
            public Provider<PluginDependency> getLibrary() { return createPlugin("library"); }

    }

}
